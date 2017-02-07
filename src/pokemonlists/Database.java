/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonlists;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author lefte
 */
public class Database {
    public Database(){
        
    }
    public void writeToDatabase(Places place){
        BufferedWriter writer = null;
        try {
            
            File logFile = new File("database.txt");

            // This will output the full path where the file will be written to...
            System.out.println(logFile.getCanonicalPath());
            writer = new BufferedWriter(new FileWriter(logFile));
            for(int i=0;i<place.Pokemon.size();i++){
                writer.write(place.name+"\n");
                writer.write(place.Pokemon.get(i).name+"\n");
                writer.write(place.Pokemon.get(i).EVs+"\n");
                writer.write(place.Pokemon.get(i).NumberEVs+"\n");
                writer.write(place.Pokemon.get(i).EVs2+"\n");
                writer.write(place.Pokemon.get(i).NumberEVs2+"\n");
            }
            
        } catch (Exception e) {
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
    }
    
    public  ArrayList <Places> readFromDatabase(){
       ArrayList <Places> placesList = new ArrayList<>();
       BufferedReader br = null;
        FileReader fr = null;
        try {
                fr = new FileReader("database.txt");
                br = new BufferedReader(fr);
                String sCurrentLine;
                br = new BufferedReader(new FileReader("database.txt"));
                int i=0;
                pokemon poke=new pokemon();
                Places place =new Places();
                while ((sCurrentLine = br.readLine()) != null) {
                    
                    if ((i % 6) == 0){
                        place.setName(sCurrentLine);
                        //System.out.println(sCurrentLine);
                    }
                    if ((i % 6) == 1){
                        poke.setName(sCurrentLine);
                        //System.out.println(sCurrentLine);
                    }
                    if ((i % 6) == 2){
                        poke.setEv1(sCurrentLine);
                       // System.out.println(sCurrentLine);
                    }
                    if ((i % 6) == 3){
                         poke.setNumberEv1(Integer.parseInt(sCurrentLine));
                         //System.out.println(Integer.parseInt(sCurrentLine));
                    }
                    if ((i % 6) == 4){
                        poke.setEv2(sCurrentLine);
                       // System.out.println(sCurrentLine);
                    }
                    if ((i % 6) == 5){
                         poke.setNumberEv2(Integer.parseInt(sCurrentLine));
                         place.Pokemon.add(poke);
                         placesList.add(place);
                         //System.out.println(Integer.parseInt(sCurrentLine));
                    }
                    i++;
                }
        } catch (IOException e) {
        } finally {
                try {
                        if (br != null)
                                br.close();
                        if (fr != null)
                                fr.close();
                } catch (IOException ex) {
                }
        }
        return placesList;
    }
    
}
