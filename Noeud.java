/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beauquis.projet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Dorian
 */
public abstract class  Noeud {
    
    //Attributs
    private int id;
    int type;
    double px;
    double py;
    Vecteur2D pf;
    ArrayList<Barre> barresDepart,barresArrivee;

    //Constructeur (Attributs fixes sauf id)
    Noeud(int id,double px,double py,Vecteur2D pf){
        this.id=id;
        this.px=px;
        this.py=py;
        this.pf=pf;
        this.barresDepart = new ArrayList<> ();
        this.barresArrivee = new ArrayList<> ();
    }
    
    //Encapsulation ("Get" et "Set")
    int getId(){
        return this.id;
    }
    int getType(){
        return this.type;
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
    ArrayList<Barre> getBarresDepart(){
        return this.barresDepart;
    }
    ArrayList<Barre> getBarresArrivee(){
        return this.barresArrivee;
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
    void setBarresDepart(ArrayList<Barre> barresDepart){
        this.barresDepart=barresDepart;
    }
    void setBarresArrivee(ArrayList<Barre> barresArrivee){
        this.barresArrivee=barresArrivee;
    }

    //Méthode entreeNoeud
    public static Noeud entreeNoeud(){
        double x,y,px,py;
        int type;
        Vecteur2D pf;
        int id=-1;
        System.out.println("Entrer le type de noeud, 1 pour un simple, 2 pour un appui simple et 3 pour un appui double.");
        type=Lire.i();
        System.out.println("Entrer la composante en x de F:");
        x=Lire.d();
        System.out.println("Entrer la composante en y de F:");
        y=Lire.d();
        System.out.println("Entrer la coordonnée en x du noeud:");
        px=Lire.d();
        System.out.println("Entrer la coordonnée en y du noeud:");
        py=Lire.d();
        pf= new Vecteur2D(x,y);
        switch (type) {
            case 1 -> {
                Noeud_Simple n= new Noeud_Simple(id,px,py,pf);
                System.out.println(n.toString());
                return n;
            }
            case 2 -> {
                Noeud_Appui_Simple n= new Noeud_Appui_Simple(id,px,py,pf);
                System.out.println(n.toString());
                return n;
            }
            case 3 -> {
                Noeud_Appui_Double n= new Noeud_Appui_Double(id,px,py,pf);
                System.out.println(n.toString());
                return n;
            }
            default -> {
            }
        }
        throw new Error("Ce type de noeud n'existe pas.");
    }
    
    //Méthode comparaison type
    public static int TypeNoeud(Noeud n){
        int type;
        
        if(n instanceof Noeud_Simple){
            type=0;
            return type;    
        } else if(n instanceof Noeud_Appui_Simple){
            type=1;
            return type; 
        } else if(n instanceof Noeud_Appui_Double){
            type=2;
            return type;  
        }else{
            throw new Error("Erreur");
        }
    }    
        
    //Méthode nbrInconnues
    public static Noeud nbrInconnues(Noeud n){

        int type=Noeud.TypeNoeud(n);
        
        switch (type) {
            case 0 -> {
                System.out.println("Ce noeud possède 0 inconnue.");
                return n;
            }
            case 1 -> {
                System.out.println("Ce noeud possède 1 inconnue.");
                return n;
            }
            case 2 -> {
                System.out.println("Ce noeud possède 2 inconnue.");
                return n;
            }
            default -> {
                    return null;
            }
        }
    }
    
    //Méthode principale
    public static Noeud mainNoeud(){
        Noeud n=Noeud.entreeNoeud();
        n=Noeud.nbrInconnues(n);
        ArrayList<Barre> b=Noeud.barresIncidentes(n.getBarresDepart(), n.getBarresArrivee());
        return n;
    }
    
    //Méthode liste de barres incidentes
    public static ArrayList<Barre> barresIncidentes(ArrayList<Barre> barresDepart, ArrayList<Barre> barresArrivee){
        ArrayList<Barre> barresIncidentesBase = Noeud.fussionerListeBarres(barresDepart,barresArrivee);
        ArrayList<Barre> barresIncidentes = Noeud.eliminationDoublonsListeBarres(barresIncidentesBase);
        ArrayList<Barre> Affichage = Noeud.affichageListeBarresIncidentes(barresIncidentes);
        return Affichage;
    }
    
    //Méthode pour fussioner deux liste de barres
    public static ArrayList<Barre> fussionerListeBarres(ArrayList<Barre> barresDepart, ArrayList<Barre> barresArrivee){
        ArrayList barresIncidentesBase= new ArrayList<>();
        barresIncidentesBase.addAll(barresDepart);
        barresIncidentesBase.addAll(barresArrivee);
        return barresIncidentesBase;
    }
    
    //Méthode pour effacer les doublons de la liste de barres
    public static ArrayList<Barre> eliminationDoublonsListeBarres(ArrayList<Barre> barresIncidentesBase){
        Set<Barre> set  = new HashSet<>(barresIncidentesBase);
        ArrayList<Barre> barresIncidentes = new ArrayList<>();
        barresIncidentes.addAll(set);
        return barresIncidentes;
    }
    
    //Méthode pour afficher la liste de barres
    public static ArrayList<Barre> affichageListeBarresIncidentes(ArrayList<Barre> barresIncidentes){
        System.out.println("\nBarres incidentes au noeud:");
        for (int i=0; i<barresIncidentes.size(); i++){
            System.out.println(barresIncidentes.get(i));
        }
        return barresIncidentes;
    }
}