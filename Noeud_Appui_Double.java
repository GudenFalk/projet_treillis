/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beauquis.projet;

/**
 *
 * @author Dorian
 */
public class Noeud_Appui_Double extends Noeud_Appui {
       
    //Constructeur
    public Noeud_Appui_Double(int id, double px, double py, Vecteur2D pf) {
        super(id, px, py, pf);
    }

    //Affichage en "toString"
    @Override
    public String toString(){
        return "Appui double | ("+this.px+";"+this.py+") | "+this.pf;
    }
}