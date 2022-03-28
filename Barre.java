/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beauquis.projet;

import java.util.ArrayList;

/**
 *
 * @author Dorian
 */
public class Barre {
     //Attributs
    private int id;
    private Noeud noeud_depart,noeud_arrive;
    private double traction_max,compression_max,cout;
    
    //Constructeur
    Barre(int id,double traction_max,double compression_max,double cout,Noeud noeud_depart,Noeud noeud_arrive){
        this.id=-1;
        this.noeud_depart=noeud_depart;
        this.noeud_arrive=noeud_arrive;
        this.traction_max=traction_max;
        this.compression_max=compression_max;
        this.cout=cout;
    }
    
    //Encapsulation ("Get" et "Set")
    int getId(){
        return this.id;
    }
    double getTraction_max(){
        return this.traction_max;
    }
    double getCompression_max(){
        return this.compression_max;
    }
    double getCout(){
        return this.cout;
    }
    Noeud getNoeud_depart(){
        return this.noeud_depart;
    }
    Noeud getNoeud_arrive(){
        return this.noeud_arrive;
    }
    void setId(int id){
        this.id=id;
    }
    void setTraction_max(double traction_max){
        this.traction_max=traction_max;
    }
    void setCompression_max(double compression_max){
        this.compression_max=compression_max;
    }
    void setCout(double cout){
        this.cout=cout;
    }
    void setNoeud_depart(Noeud noeud_depart){
        this.noeud_depart=noeud_depart;
    }
    void setNoeud_arrive(Noeud noeud_arrive){
        this.noeud_arrive=noeud_arrive;
    }
    
    //Affichage en "toString"
    @Override
    public String toString(){
        return "Noeud "+this.noeud_depart.getId()+" | Noeud "+this.noeud_arrive.getId()+" | "+this.traction_max+" | "+this.compression_max+" | "+this.cout; 
    }
    
    //Méthode pour créer une barre
    public static Barre entreeBarre(){
        double traction_max,compression_max;
        double cout;
        int id=-1;
        Barre b;
        
        System.out.println("Entrer les données du noeud de départ:");
        Noeud noeud_depart=Noeud.entreeNoeud();
        System.out.println("Entrer les données du noeud d'arrivée:");
        Noeud noeud_arrive=Noeud.entreeNoeud();
        System.out.println("Entrer la traction maximale:");
        traction_max=Lire.d();
        System.out.println("Entrer la compression maximale:");
        compression_max=Lire.d();
        System.out.println("Entrer le coût de la barre:");
        cout=Lire.d();
        
        b= new Barre(id,traction_max,compression_max,cout,noeud_depart,noeud_arrive);
        return b;
    }
    
    //Méthode pour donner le noeud opposé sur la barre au noeud rentré
    public Noeud noeudOppose(Noeud n){
        Noeud m;
        System.out.println("Entrer les données du noeud appartenant à la barre.");
        if (n.getPx()==this.noeud_depart.getPx()&&n.getPy()==this.noeud_depart.getPy()){
            //System.out.println("La noeud opposé est le noeud ");
            m=this.noeud_arrive;
            return m;
        } else if(n.getPx()==this.noeud_arrive.getPx()&&n.getPy()==this.noeud_arrive.getPy()){
            //System.out.println("La noeud opposé est le noeud ");
            m=this.noeud_depart;
            return m;
        } else{
            throw new Error("Ce noeud n'appartient pas à la barre.");
        }
    }
    
    //Méthode pour calculer l'angle entre un vecteur quelconque et le vecteur horizontal
    public static double angleHoriz(double x_n, double y_n, double x_m, double y_m){
        double x_nm=x_m-x_n;
        double y_nm=y_m-y_n;
        return Math.atan2(y_m, x_m);
    }
    
    //Méthode pour donner l'angle entre une barre et le vecteur horizontal
    public double angle(Noeud n){
        Noeud m=this.noeudOppose(n);
        double angle=(angleHoriz(n.getPx(),n.getPy(),m.getPx(),m.getPy()))/(Math.PI/180);
        System.out.println("Il y a un angle de "+angle+"° entre la barre et l'axe horizontal.");
        return angle;
    }
    
    //public static ArrayList<Barre> Noeuds_Barres(Barre b){
      //  noeud
    //}
}