/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonlists;

/**
 *
 * @author lefte
 */
public class pokemon {
    public String EVs;
    public String EVs2;
    public int NumberEVs;
    public int NumberEVs2;
    public String name;
    public pokemon(){}
    public pokemon(String name){this.name=name;}
    public pokemon(String name,int NumberEVs, String EVs, int NumberEVs2, String EVs2){
        this.name=name;
        this.NumberEVs=NumberEVs;
        this.NumberEVs2=NumberEVs2;
        this.EVs = EVs;
        this.EVs2 = EVs2;
    }
    public void setEv1(String EV){
        this.EVs= EV;
    }
    public void setEv2(String EV2){
        this.EVs2= EV2;
    }
    public void setNumberEv1(int EVs){
        NumberEVs=EVs;
    }
    public void setNumberEv2(int  EV){
        NumberEVs2=EV;
    }
    public void setName(String  EV){
        this.name=EV;
    }
      
}
