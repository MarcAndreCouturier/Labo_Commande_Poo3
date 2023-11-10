/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.labo_commande;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Drahkor
 */
public class Labo_Commande {

    public static void main(String[] args) throws IOException 
    {
        ICommande commande1 = new CommandeEffacer("fichier.txt", 2, 10, 1);
        //commande1.annuler();
        //ICommande commande2 = new CommandeRenommerFichier("dossier/fichier.txt", "renommer.txt" );
        commande1.executer();
        //commande2.executer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        commande1.annuler();
        
    }
}
