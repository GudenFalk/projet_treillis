/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package fr.insa.beauquis.projet_treillis;

/**
 *
 * @author Dorian
 */
public class Projet_Treillis {

    public static void main(String[] args) {
        Barre b=Barre.entreeBarre();
        System.out.println(b.toString());
        System.out.println("");
        System.out.println("Entrer les données du noeud appartenant à la barre.");
        Noeud n=Noeud.entreeNoeud();
        Noeud m=Barre.noeudOppose(b,n);
        System.out.print(m.toString());
    }
}
