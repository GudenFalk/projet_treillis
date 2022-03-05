/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.gudenfalk.matrice;

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
                coeffs[i][j]=0;
            }
    	}
    }
    
    public static void main(String[] args){
    	Matrice m;
    	int nl=3;
    	int nc=2;
    	m=new Matrice(nl,nc);
    	for (int i=0; i<nl; i++){
            for (int j=0; j<nc; j++){
            	System.out.print(m.coeffs[i][j]+" ");
            }
    	System.out.println();
    	}
    }
}
