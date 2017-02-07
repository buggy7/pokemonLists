/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonlists;

import java.util.ArrayList;

/**
 *
 * @author lefte
 */
public class Places {
    public String name;
    public ArrayList<pokemon> Pokemon;
    public Places( String place){
        this.Pokemon= new ArrayList<>();
        this.name=place;
    }

    Places() {
        this.Pokemon= new ArrayList<>();
    }
    public void addPokemonIntoPlace(pokemon Pokemon){
        this.Pokemon.add(Pokemon);
    }
    public void setName(String name){
        this.name=name;
    }

   
}
