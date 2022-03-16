/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.beauquis.tpinfo.tpinfo;

/**
 *
 * @author dbeauquis01
 */
public class Vecteur2D {
    
    //Attributs
    private double x,y;
    
    //Constructeur
    Vecteur2D(double x,double y){
       this.x=x;
       this.y=y;
    }
    
    //Encapsulation (Get et Set)
    double getX(){
        return(this.x);
    }
    double getY(){
        return(this.y);
    }
    void setX(double x){
        this.x=x;
    }
    void setY(double y){
        this.y=y;
    }
    
    //Affichage ToString
    @Override
    public String toString(){
        return("force F("+this.x+";"+this.y+").");
    }
}
