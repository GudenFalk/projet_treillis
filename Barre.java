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
public class Barre {
     //Attributs
    int id;
    Noeud noeud_depart,noeud_arrive;
    double traction_max,compression_max,cout;
    
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
        return "La barre est défini par les noeuds de départ"+this.noeud_depart+", et d'arrivé"+this.noeud_arrive+".Elle a un cout de "+this.cout+"€, une traction max de "+this.traction_max+" et une compression max de "+this.compression_max+"."; 
    }
    
    //Méthode
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
    
    public Noeud noeudOppose(Noeud n){
        Noeud m;
        System.out.println("Entrer les données du noeud appartenant à la barre.");
        if (n.getPx()==this.noeud_depart.getPx()&&n.getPy()==this.noeud_depart.getPy()){
            System.out.println("La noeud opposé est le noeud ");
            m=this.noeud_arrive;
            return m;
        } else if(n.getPx()==this.noeud_arrive.getPx()&&n.getPy()==this.noeud_arrive.getPy()){
            System.out.println("La noeud opposé est le noeud ");
            m=this.noeud_depart;
            return m;
        } else{
            throw new Error("Ce noeud n'appartient pas à la barre.");
        }
    }
    
    public double angle(Noeud n,Barre b){
        double x_nm,y_nm,x_Ox,y_Ox,Norme_nm,Norme_Ox,Scalaire,cosinus,angle;
        Vecteur2D nm, Ox;
        Noeud m=b.noeudOppose(n);
        
        x_nm=n.getPx()-m.getPx();
        y_nm=n.getPy()-m.getPy();
        x_Ox=1;
        y_Ox=0;
        
        nm= new Vecteur2D(x_nm,y_nm);
        Ox= new Vecteur2D(x_Ox,y_Ox);
        
        Norme_nm=Math.sqrt(Math.pow(x_nm, 2)+Math.pow(y_nm, 2));
        Norme_Ox=Math.sqrt(Math.pow(x_Ox, 2)+Math.pow(y_Ox, 2));
        Scalaire=x_nm*x_Ox+y_nm*y_Ox;
        
        cosinus=Scalaire/(Norme_nm*Norme_Ox);
        angle=Math.acos(cosinus);
        return angle;
    }
}
