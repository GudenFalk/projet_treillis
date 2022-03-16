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
