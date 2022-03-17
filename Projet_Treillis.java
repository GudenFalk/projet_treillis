/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package fr.insa.beauquis.projet_treillis.classes;

/**
 *
 * @author Dorian
 */
public class Projet_Treillis {

    public static void main(String[] args) {
        Barre b=Barre.entreeBarre();
        System.out.println(b.toString());
        System.out.println("");
        Noeud n=Noeud.entreeNoeud();
        Noeud m=b.noeudOppose(n);
        System.out.print(m.toString());
        double angle=angle(b,n);
        //Noeud p=Noeud.nbrInconnues();
    }
}
