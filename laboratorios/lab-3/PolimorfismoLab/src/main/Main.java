package main;
import java.util.ArrayList;

import modelo.Animal;
import modelo.Circulo;
import modelo.Figura;
import modelo.Perro;
import modelo.Rectangulo;
import modelo.Gato;

public class Main {
    public static void main(String[] args) {
        Animal miAnimal = new Animal();
        Animal miPerro = new Perro();
        Animal miGato = new Gato();

        miAnimal.hacerSonido(); // El animal hace un sonido.
        miPerro.hacerSonido();  // El perro ladra
        miGato.hacerSonido();   // El gato 
        
        
        
        // Desafio :
        

        Figura circulo1 = new Circulo();
        Figura rectangulo1 = new Rectangulo();

        // aqui almacene los objetos en un Array convencional
        Figura[] figuras = new Figura[1];
        figuras[0] = circulo1;
        figuras[1] = rectangulo1;
        
        // aqui almacene los odjetos en un Arraylist.
        ArrayList<Figura> listaDeFiguras=  new ArrayList<>();
        listaDeFiguras.add(rectangulo1);
        listaDeFiguras.add(circulo1);

        for(Figura forma : listaDeFiguras){
            forma.calcularArea();
        }

    }
}


