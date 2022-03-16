/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beauquis.projet_treillis;

/**
 *
 * @author Dorian
 */
public class Noeud {
    //Atributs
    private int id;
    private double px,py;
    private Vecteur2D pf;
    
    /*Constructeur (Attributs fixes)
    Noeud(int id,double px,double py,Vecteur2D pf){
        this.id=id;
        this.px=px;
        this.py=py;
        this.pf=pf;
    }
    */
    
    //Constructeur (Attributs fixes sauf id)
    Noeud(int id,double px,double py,Vecteur2D pf){
        this.id=-1;
        this.px=px;
        this.py=py;
        this.pf=pf;
    }
    
    /*Constructeur (Attributs libres sauf px,py)
    Noeud(int id,double px,double py,Vecteur2D pf){
        this.id=-1;
        this.px=px;
        this.py=py;
        this.pf=new Vecteur2D(0,0);
    }
    */
    
    //Encapsulation ("Get" et "Set")
    int getId(){
        return this.id;
    }
    double getPx(){
        return this.px;
    }
    double getPy(){
        return this.py;
    }
    Vecteur2D getPf(){
        return this.pf;
    }
    
    void setId(int id){
        this.id=id;
    }
    void setPx(double px){
        this.px=px;
    }
    void setPy(double py){
        this.py=py;
    }
    void setPf(Vecteur2D pf){
        this.pf=pf;
    }
    
    //Affichage en "toString"
    @Override
    public String toString(){
        return "("+this.px+";"+this.py+"), avec une "+this.pf;
    }
    
    //Méthode entreeNoeud
    public static Noeud entreeNoeud(){
        double x,y,px,py;
        Vecteur2D pf;
        Noeud n;
        int id=-1;
        
        System.out.println("Entrer la composante en x de F:");
        x=Lire.d();
        System.out.println("Entrer la composante en y de F:");
        y=Lire.d();
        System.out.println("Entrer la coordonnée en x du noeud:");
        px=Lire.d();
        System.out.println("Entrer la coordonnée en y du noeud:");
        py=Lire.d();
        
        pf= new Vecteur2D(x,y);
        n= new Noeud(id,px,py,pf);
        return n;
    }
}
