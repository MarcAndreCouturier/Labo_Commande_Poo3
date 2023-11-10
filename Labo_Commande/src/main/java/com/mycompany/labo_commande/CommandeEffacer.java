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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Drahkor
 */


public class CommandeEffacer implements ICommande
{
    int _ligne;
    int _colonne;
    int _longeur;
    Path _chemin;
    String _retirer = "";
    
    public CommandeEffacer(String chemin,int ligne, int colonne, int longeur)
    {
        _ligne = ligne;
        _colonne = colonne;
        _longeur = longeur; 
        _chemin = Paths.get(String.format("./%s", chemin));
      
    }
    
    public void executer()
    {
        try 
        {
            String nouveauText = effacerString(Files.readString(_chemin, StandardCharsets.UTF_8));
            Files.write(_chemin, nouveauText.getBytes());        
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(CommandeEffacer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void annuler()
    {
        
        try 
        {
            String nouveauText = reecrireString(Files.readString(_chemin, StandardCharsets.UTF_8));      
            Files.write(_chemin, nouveauText.getBytes());     
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(CommandeEffacer.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    private String effacerString(String text)
    {
        int positionLigne = trouverLigne(_ligne, text, 0);
        if(positionLigne != -1)
        {
            int position = positionLigne + _colonne;
            int fin = position + _longeur;
            if (fin < text.length() - 1 )
            {
                _retirer = text.substring(position, fin);
                return text.substring(0,position) + text.substring(fin);
            }
            
        }
        return text;
    }
    
    private String reecrireString(String text)
    {
        int position = trouverLigne(_ligne, text, 0) + _colonne;
        if(position == 0)
        {
            return _retirer  + text.substring(position);
        }
        return text.substring(0, position ) + _retirer  + text.substring(position);
    }
    
    private int trouverLigne(int ligne, String text, int positionCourrante)
    {
        if(ligne == 0)
        {
            return positionCourrante;
        }
        int position = text.indexOf("\n");
        if(position != -1)
        {
            return trouverLigne(ligne -1 , text.substring(position + 1), positionCourrante + position + 1 );
        }
        return -1;
    }
    
  
}
