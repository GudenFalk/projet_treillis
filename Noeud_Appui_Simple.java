/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beauquis.projet_treillis.classes;

/**
 *
 * @author Dorian
 */
public class Noeud_Appui_Simple extends Noeud_Appui {
    
    //Constructeur
    public Noeud_Appui_Simple(int id, int type, double px, double py, Vecteur2D pf) {
        super(id,type, px, py, pf);
    }
    
    //Affichage en "toString"
    @Override
    public String toString(){
        return "Noeud appui simple: n("+this.px+";"+this.py+"). On y applique une "+this.pf;
    }
}
