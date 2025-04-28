import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Agenda {
    private HashMap<String, Contact> contacts;

    public Agenda() {
        this.contacts = new HashMap<>();
    }

    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getEmail())) {
            System.out.println("A contact with this email already exists.");
        } else {
            contacts.put(contact.getEmail(), contact);
            System.out.println("Contact added successfully.");
        }
    }

    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("The address book is empty.");
            return;
        }
        for (Contact contact : this.contacts.values()) {
            //System.out.println(contact);
            System.out.println(contact.print());
        }
    }

    public void searchContact(String email) {
        if (contacts.containsKey(email)) {
            //System.out.println(contacts.get(email));

            Contact cont = contacts.get(email);
            System.out.println(cont.print());
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void deleteContact(String email) {
        if (contacts.containsKey(email)) {
            contacts.remove(email);
            System.out.println("Contact deleted.");
        } else {
            System.out.println("No contact found with the provided email.");
        }
    }
    public void storeContact() {
    	try {
            FileOutputStream file = new FileOutputStream("contact1"
            		+ "s.ser");
            ObjectOutputStream oos = new ObjectOutputStream(file);
            oos.writeObject(contacts);
            oos.close();
            file.close();
            System.out.println("The list of contacts has been saved in the'contacts.ser'folder");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void loadContact() {
    	try {
            FileInputStream file = new FileInputStream("contacts.ser");
            ObjectInputStream ois = new ObjectInputStream(file);
            HashMap<String, Contact> savedContats = (HashMap<String, Contact>) ois.readObject();
            ois.close();
            file.close();
            System.out.println("Contact list previously saved: " + savedContats);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}