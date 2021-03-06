/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.beauquis.projet_treillis.calcul;
import fr.insa.beauquis.projet_treillis.recup.Lire;
/**
 *
 * @author Dorian
 */
public class Matrice {
    //Attributs
    public int nbrLig;
    public int nbrCol;
    public double[][] coeffs;
    
    //Constructeur
    Matrice(int nl, int nc){
        this.nbrLig= nl;
        this.nbrCol= nc;
    	this.coeffs= new double[nl][nc];
   	 
    	for (int i=0; i<nl; i++){
            for (int j=0; j<nc; j++){
                System.out.println("Rentrer le coefficient ("+(i+1)+"."+(j+1)+")");
            	coeffs[i][j]=Lire.d();
            }
    	}
    }
}
