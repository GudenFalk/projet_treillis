/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.gudenfalk.pivot_de_gauss;

/**
 *
 * @author Dorian
 */
public class Pivot_de_Gauss {

    public static void main(String[] args) {
        System.out.println("La matrice est:");
    	Matrice m;
    	int nl=Lire.i();
        int nc=Lire.i();
        
    	m=new Matrice(nl,nc);
    	for (int i=0; i<nl; i++){
            for (int j=0; j<nc; j++){
            	System.out.print(+m.coeffs[i][j]+" ");
            }
    	System.out.println();
    	}
    }
 }
