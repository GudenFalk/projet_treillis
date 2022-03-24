/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beauquis.projet_treillis.classes;

/**
 *
 * @author Dorian
 */
public class Noeud_Simple extends Noeud {
    
    //Constructeur
    public Noeud_Simple(int id,double px, double py, Vecteur2D pf) {
        super(id, px, py, pf);
    }

    //Affichage en "toString"
    @Override
    public String toString(){
        return "Simple | ("+this.px+";"+this.py+") | "+this.pf;
    }
}