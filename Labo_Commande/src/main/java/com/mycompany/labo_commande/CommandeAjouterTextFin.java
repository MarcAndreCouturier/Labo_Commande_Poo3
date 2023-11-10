/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.labo_commande;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Drahkor
 */
public class CommandeAjouterTextFin implements ICommande {
    
    Path _chemin;
    String _ajout;
    
    public CommandeAjouterTextFin (String chemin, String ajout)
    {
        _chemin = Paths.get(chemin);
        _ajout = ajout;
    }
    
    public void executer()
    {
        try
        {
            Files.write(_chemin, _ajout.getBytes(), StandardOpenOption.APPEND);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(CommandeAjouterTextFin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void annuler()
    {
        try 
        {
            String text = Files.readString(_chemin, StandardCharsets.UTF_8);
            Files.write(_chemin, (text.substring(0, (text.length() - _ajout.length())).getBytes()));     
        } 
        catch (IOException ex) {
            Logger.getLogger(CommandeAjouterTextFin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
