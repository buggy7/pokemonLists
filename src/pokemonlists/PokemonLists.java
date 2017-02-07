/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonlists;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author lefte
 */
public class PokemonLists {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        
        File folder = new File("BossesDatabase/");
        File[] listOfFiles = folder.listFiles();
        ArrayList <bossesInfos> allBosses= new ArrayList <>();
        
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                //System.out.println("File " + listOfFiles[i].getName());
                allBosses.add( new bossesInfos(listOfFiles[i].getName()));
            } 
    //        else if (listOfFiles[i].isDirectory()) {
    //            System.out.println("Directory " + listOfFiles[i].getName());
    //        }
        }
        
        //sortWithRegion(allBosses);  //if not sorted at all, it is sorted alphabetically cuz of winddows files are read like this
        //printAllBossesInfos(allBosses);
        //allBosses.get(0).winBoss();
        while(true){
            String prompt= ">\n\t";
            System.out.println(prompt);
            Scanner keyboard = new Scanner(System.in);
            System.out.println("enter an command");
            //String command = keyboard.next;
        }
        
        
       
    }
    public static void sortWithRegion( ArrayList <bossesInfos> allBosses){
        Collections.sort(allBosses, new Comparator<bossesInfos>() {
            @Override
            public int compare(bossesInfos boss1, bossesInfos boss2)
            {

                return  boss1.Region.compareTo(boss2.Region);
            }
        });
    }
    
     public static void sortWithRespawnDate( ArrayList <bossesInfos> allBosses){
        Collections.sort(allBosses, new Comparator<bossesInfos>() {
            @Override
            public int compare(bossesInfos boss1, bossesInfos boss2)
            {
                return  boss1.respawnDate.compareTo(boss2.respawnDate);
            }
        });
    }
    
    
    public static void printAllBossesInfos(ArrayList <bossesInfos> allBosses){
        for(int i=0;i<allBosses.size();i++){
            System.out.println("----------BOSS");
            allBosses.get(i).toString();
        }
    }
    
    public static void printList(   ArrayList <Places> placesList){
        if(!placesList.isEmpty())
            for (int i=0;i<placesList.size();i++){
                System.out.println(placesList.get(i).name);
                for (int y=0;y<placesList.get(i).Pokemon.size();y++){
                    System.out.println(placesList.get(i).Pokemon.get(y).name);
                    System.out.println(placesList.get(i).Pokemon.get(y).EVs);
                    System.out.println(placesList.get(i).Pokemon.get(y).NumberEVs);
                    System.out.println(placesList.get(i).Pokemon.get(y).EVs2);
                    System.out.println(placesList.get(i).Pokemon.get(y).NumberEVs2);
                }
            
        }
    }
}
