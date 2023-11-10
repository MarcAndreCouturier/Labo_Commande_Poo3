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
public class CommandeCreerFichier implements ICommande {
    
    Path _chemin;
    
    public CommandeCreerFichier(String chemin)
    {
        _chemin = Paths.get(String.format("./%s", chemin)); // faut s'assurer de ne pas mettre des fichier partout dans le systeme.
    }
    
    public void executer ()       
    {
        try {
            Files.createFile(_chemin);
        } catch (IOException ex) {
            Logger.getLogger(CommandeCreerFichier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void annuler()
    {
        try {
            Files.delete(_chemin);
        } catch (IOException ex) {
            Logger.getLogger(CommandeCreerFichier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
