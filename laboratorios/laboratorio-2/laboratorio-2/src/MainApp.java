import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Agenda addressBook = new Agenda();
        Scanner scanner = new Scanner(System.in);
        Integer option;
        addressBook.loadContact();

        do {
            System.out.println("\n*** Contact Address Book ***");
            System.out.println("1. Add contact");
            System.out.println("2. View contacts");
            System.out.println("3. Search for contact");
            System.out.println("4. Delete contact");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (option) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    Contact contact = new Contact(name, email, age, phone);
                    addressBook.addContact(contact);
                    addressBook.storeContact();
                    break;
                case 2:
                    addressBook.viewContacts();
                    addressBook.loadContact();
                    break;
                case 3:
                    System.out.print("Enter the email of the contact to search: ");
                    email = scanner.nextLine();
                    addressBook.searchContact(email);
                    break;
                case 4:
                    System.out.print("Enter the email of the contact to delete: ");
                    email = scanner.nextLine();
                    addressBook.deleteContact(email);
                    addressBook.storeContact();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 5);
    }
}

