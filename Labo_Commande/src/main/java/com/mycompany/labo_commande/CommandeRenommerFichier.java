/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.labo_commande;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Drahkor
 */
public class CommandeRenommerFichier implements ICommande
{
    
    Path _chemin;
    Path _nouveauNom;
    
    public CommandeRenommerFichier(String chemin, String nouveauNom)
    {
        _chemin = Paths.get(String.format("./%s", chemin));
        _nouveauNom = Paths.get(nouveauNom);
    }
    
    public void executer()
    {
        Path enfantTemp = _chemin.getFileName();
        Path nouveauChemin = _chemin.getParent().resolve(_nouveauNom);
        try {
            Files.move(_chemin, nouveauChemin);
            _chemin = nouveauChemin;
            _nouveauNom = enfantTemp;
        } catch (IOException ex) {
            Logger.getLogger(CommandeRenommerFichier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void annuler()
    {
        this.executer(); // lol tu me diras si c'est une mauvaise idee.
    }
}
