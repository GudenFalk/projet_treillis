/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beauquis.projet_treillis;

/**
 *
 * @author Dorian
 */
public class Vecteur2D {
    
    //Atributs
    private double x,y;
    
    //Constructeur
    Vecteur2D(double x,double y){
        this.x=x;
        this.y=y;
    }
    
    //Encapsulation ("Get" et "Set")
    double getX(){
        return this.x;
    }
    double getY(){
        return this.y;
    }
    void setX(double x){
        this.x=x;
    }
    void setY(double y){
        this.y=y;
    }
    
    //Affichage en "toString"
    @Override
    public String toString(){
        return "force ("+this.x+";"+this.y+")";
    }
}
