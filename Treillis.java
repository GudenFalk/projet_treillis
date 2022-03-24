/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beauquis.projet_treillis.classes;

import fr.insa.beauquis.projet_treillis.recup.Lire;
import java.util.ArrayList;

/**
 *
 * @author Dorian
 */
public class Treillis {
    
    //Attributs
    ArrayList<Noeud> noeudTreillis;
    ArrayList<Barre> barreTreillis;
    
    //Constructeur
    Treillis(ArrayList<Noeud> noeudTreillis,ArrayList<Barre> barreTreillis){
        this.noeudTreillis = new ArrayList<> ();
        this.barreTreillis = new ArrayList<> ();
    }
    
    //Encapsulation ("Get" et "Set")
    ArrayList<Noeud> getNoeudTreillis(){
        return this.noeudTreillis;
    }
    ArrayList<Barre> getbarreTreillis(){
        return this.barreTreillis;
    }
    void setNoeudTreillis(ArrayList<Noeud> noeudTreillis){
        this.noeudTreillis=noeudTreillis;
    }
    void setBarreTreillis(ArrayList<Barre> barreTreillis){
        this.barreTreillis=barreTreillis;
    }
    
    //Méthode de création de treillis
    public static Treillis creerTreillis(){
        ArrayList<Noeud> noeudTreillis;
        ArrayList<Barre> barreTreillis;
        
        noeudTreillis = new ArrayList<> ();
        barreTreillis = new ArrayList<> ();
        
        Treillis t= new Treillis(noeudTreillis,barreTreillis);
        return t;
    }
    
    //Affichage toString
    @Override
    public String toString(){
        return ""+this.affichageListeNoeud(noeudTreillis)+
               ""+this.affichageListeBarre(barreTreillis);
    }

    //Méthode pour afficher la liste de noeuds
    public ArrayList<Noeud> affichageListeNoeud(ArrayList<Noeud> noeudTreillis){
        System.out.println("\nNoeud.s du treillis:");
        System.out.println("Noeud id: Type | Coordonnées | Force");
        for (int i=0; i<noeudTreillis.size(); i++){
            System.out.println("Noeud "+(i+1)+":"+noeudTreillis.get(i));
        }
        return noeudTreillis;
    }
    
    //Méthode pour afficher la liste de barres
    public ArrayList<Barre> affichageListeBarre(ArrayList<Barre> barreTreillis){
        System.out.println("\nBarre.s du treillis:");
        System.out.println("Barre id: Noeud de départ | Noeud d'arrivée | Traction maximale | Compression maximale | Coût");
        for (int i=0; i<barreTreillis.size(); i++){
            System.out.println("Barre "+(i+1)+":"+barreTreillis.get(i));
        }
        return barreTreillis;
    }
    
    //Méthode qui renvoie le plus grand identificateurs des nœuds actuellement dans le treillis
    public static int maxIdNoeud(ArrayList<Noeud> noeudTreillis){
        int nbrNoeud = noeudTreillis.size();
        return nbrNoeud;
    }
    
    //Méthode qui renvoie le plus grand identificateurs des barres actuellement dans le treillis
    public static int maxIdBarre(ArrayList<Barre> barreTreillis){
        int nbrBarre = barreTreillis.size();
        return nbrBarre;
    }
    
    //Méthode qui ajoute un noeud au treillis et lui donne un identificateur
    public Noeud ajouteNoeud(Noeud n){
        if (noeudTreillis.contains(n)){
            throw new Error("Ce noeud est déjà dans le treillis.");
        } else{
            n.setId(Treillis.maxIdNoeud(noeudTreillis)+1);
            noeudTreillis.add(n); 
            return n;
        }
    }
    
    //Méthode qui ajoute une barre au treillis et lui donne un identificateur
    public Barre ajouteBarre(Barre b){
        if (barreTreillis.contains(b)){
            throw new Error("Cette barre est déjà dans le treillis.");
        } else{
            b.setId(Treillis.maxIdBarre(barreTreillis)+1);
            Noeud nd=this.ajouteNoeud(b.getNoeud_depart());
            Noeud na=this.ajouteNoeud(b.getNoeud_arrive());
            barreTreillis.add(b); 
            return b;
        }
    }
    
    //Méthode pour choisir un noeud
    public Noeud choisiNoeud(){
        int id;
        noeudTreillis=this.affichageListeNoeud(noeudTreillis);
        System.out.println("Rentrer l'identificateur du noeud voulu.");
        id=Lire.i();
        while (id>(noeudTreillis.size()+1) || id<=0){
            System.out.println("Ce noeud n'existe pas, rentrer l'identificateur du noeud voulu appartenant au treillis.");
            id=Lire.i();
        }
        Noeud n=noeudTreillis.get(id);
        return n;
    }
    
    //Méthode pour choisir une barre
    public Barre choisiBarre(){
        int id;
        barreTreillis=this.affichageListeBarre(barreTreillis);
        System.out.println("Rentrer l'identificateur de la barre voulue.");
        id=Lire.i();
        while (id>(barreTreillis.size()+1) || id<=0){
            System.out.println("Cette barre n'existe pas, rentrer l'identificateur de la barre voulue appartenant au treillis.");
            id=Lire.i();
        }
        Barre b=barreTreillis.get(id);
        return b;
    }
    
    //Méthode pour créer une barre en choisissant les noeuds de départ et d'arrivé
    public Barre entreeBarreAvecNoeudsChoisis(){
        double traction_max,compression_max;
        double cout;
        int id=-1;
        Barre b;
        
        System.out.println("Choisir le noeud de départ");
        Noeud noeud_depart=this.choisiNoeud();
        System.out.println("Choisir le noeud d'arrivée:");
        Noeud noeud_arrive=this.choisiNoeud();
        while (noeud_depart==noeud_arrive){
            System.out.println("Les noeuds de départ et d'arrivée ne doivent pas être les mêmes.");
            noeud_arrive=this.choisiNoeud();
        }
        System.out.println("Entrer la traction maximale:");
        traction_max=Lire.d();
        System.out.println("Entrer la compression maximale:");
        compression_max=Lire.d();
        System.out.println("Entrer le coût de la barre:");
        cout=Lire.d();
        
        b= new Barre(id,traction_max,compression_max,cout,noeud_depart,noeud_arrive);
        return b;
    }
    
    /*Méthode pour supprimer des barresIncidentes à un noeud du treillis
    public ArrayList<Barre> SupBarres(ArrayList<Barre> barres){
        for (int i=0; i<barres.size(); i++){
            Barre b=barres.get(i));
            
        }
        return barres;
    }
    */
    
    //Méthode pour une interface textuelle
    public Treillis menuTexte(){
        int action=6;
        Treillis t=Treillis.creerTreillis();
        String choix="Non";
        while (action!=0&&"Oui".equals(choix)){
            System.out.println("\nRentrer le numéro correspnd à l'action à effectuer.");
            System.out.println("Afficher le treillis -> 1");
            System.out.println("Ajouter un noeud -> 2");
            System.out.println("Supprimer une barre -> 3");
            //System.out.println("Supprimer un noeud -> 4");
            System.out.println("\nStopper les modifications -> 0");
            action=Lire.i();
            switch (action) {
                case 0 -> {
                    System.out.println("\nVoulez-vous stopper les modifications?");
                    System.out.println("Rentrer 'Oui' ou 'Non'");
                    choix=Lire.S();
                }
                case 1 -> {
                    System.out.println(t.toString());
                }
                case 2 -> {
                    Noeud n=Noeud.entreeNoeud();
                    Noeud m=this.ajouteNoeud(n);
                }
                case 3 -> {
                    while (t.getNoeudTreillis().size()<2){
                        System.out.println("\nIl n'y a pas assez de noeuds pour créer une barre.");
                        Noeud n=Noeud.entreeNoeud();
                        Noeud m=this.ajouteNoeud(n);
                    }
                    Barre b=this.entreeBarreAvecNoeudsChoisis();
                    Barre d=this.ajouteBarre(b);
                }
                default -> {
                    throw new Error("Le nombre rentré ne correspond pas à une action possible");
                }
            }
        }
        return t;
    }

}
