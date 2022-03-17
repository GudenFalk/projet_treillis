/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beauquis.projet_treillis.classes;
import fr.insa.beauquis.projet_treillis.recup.Lire;

/**
 *
 * @author Dorian
 */
public abstract class  Noeud {
    
    //Atributs
    private int id,type;
    double px;
    double py;
    Vecteur2D pf;
    
    /*Constructeur (Attributs fixes)
    Noeud(int id,double px,double py,Vecteur2D pf){
        this.id=id;
        this.px=px;
        this.py=py;
        this.pf=pf;
    }
    */
    
    //Constructeur (Attributs fixes sauf id)
    Noeud(int id,int type,double px,double py,Vecteur2D pf){
        this.id=-1;
        this.px=px;
        this.py=py;
        this.pf=pf;
        this.type=type;
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
    void setId(int id){
        this.id=id;
    }
    void setType(int type){
        this.type=type;
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
                Noeud_Simple n= new Noeud_Simple(id,type,px,py,pf);
                System.out.println(n.toString());
                return n;
            }
            case 2 -> {
                Noeud_Appui_Simple n= new Noeud_Appui_Simple(id,type,px,py,pf);
                System.out.println(n.toString());
                return n;
            }
            case 3 -> {
                Noeud_Appui_Double n= new Noeud_Appui_Double(id,type,px,py,pf);
                System.out.println(n.toString());
                return n;
            }
            default -> {
            }
        }
        return null;
    }
    //Méthode nbrInconnues
    public static Noeud nbrInconnues(){
        Noeud n=Noeud.entreeNoeud();
        switch (n.getType()) {
            case 1 -> {
                System.out.println("Ce noeud possède 0 inconnue.");
                return n;
            }
            case 2 -> {
                System.out.println("Ce noeud possède 1 inconnue.");
                return n;
            }
            case 3 -> {
                System.out.println("Ce noeud possède 2 inconnues.");
                return n;
            }
            default -> {
            }
        }
        return null;
    }
}
