package pokemonlists;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author lefte
 */
public class bossesInfos {
    public String  Name;
    public String Region;
    public String requireMent;
    public int consecutiveWins;
    public int maxConsecutiveWins;
    public int totalWins;
    public int totalLoses;
    public int coolDown;
    public Calendar respawnDate;
    public String location;
    public ArrayList<String> usedToWin;
    public ArrayList<String> bossesPokemon;
    public ArrayList<String> rewards;
    public ArrayList<String> rewardsTaken;
    public ArrayList<String> extraRewards;
    public bossesInfos(String name,int maxConsecutiveWins, int coolDown,ArrayList<String> bossesPokemon,
            ArrayList<String> rewards,String location){
        this.Name=name;
        this.maxConsecutiveWins=maxConsecutiveWins;
        this.bossesPokemon=bossesPokemon;
        this.rewards=rewards;
        this.location=location;
    }
    
    public bossesInfos(String bossName){
        this.totalLoses=0;
        this.totalWins=0;
        this.consecutiveWins=0;
        this.maxConsecutiveWins=3;
        this.bossesPokemon= new ArrayList<>();
         this.rewards= new ArrayList<>();
         this.extraRewards= new ArrayList<>();
         this.readDatabase(bossName);
    }
    
    public void winBoss(){
        Date dateInstance = new Date(); 
        Calendar cal = Calendar.getInstance();
        //System.out.println(cal.getTime());
        cal.setTime(dateInstance);
        cal.add(Calendar.DATE, 12);
        this.respawnDate=cal;
        this.totalWins++;
        //System.out.println(cal.getTime());
    }
    public void loseToBoss(){
         Date dateInstance = new Date(); 
        Calendar cal = Calendar.getInstance();
        //System.out.println(sdf.format(cal.getTime()));
        cal.setTime(dateInstance);
        cal.add(Calendar.DATE, 12);
        this.respawnDate=cal;
        this.totalLoses++;
        //System.out.println(cal.getTime());
    }
    
    public void readDatabase(String bossName){
        BufferedReader br = null;
        FileReader fr = null;
        try {
                String path="BossesDatabase/";
                fr = new FileReader(path+bossName);
                //System.out.println(path+bossName+".txt");
                br = new BufferedReader(fr);
                String sCurrentLine;
                br = new BufferedReader(new FileReader(path+bossName));
                int i=0;
                while ((sCurrentLine = br.readLine()) != null) {
                    if(sCurrentLine.equalsIgnoreCase("---"))
                    {
                        this.Name=bossName;
                        sCurrentLine = br.readLine();
                        i++;
                    }
                    if (i == 1){
                        //System.out.println(sCurrentLine);
                        this.location=sCurrentLine;
                    }
                    if (i == 2){
                        //System.out.println(sCurrentLine);
                        this.Region=sCurrentLine;
                    }
                    if (i == 3){
                        //System.out.println(sCurrentLine);
                        if(sCurrentLine.equalsIgnoreCase("---"))
                           continue;
                        this.bossesPokemon.add(sCurrentLine);
                    }
                    if (i == 4){
                        //System.out.println(sCurrentLine);
                        if(sCurrentLine.equalsIgnoreCase("---"))
                           continue;
                        this.rewards.add(sCurrentLine);
                    }
                    if (i == 5){
                        //System.out.println(sCurrentLine);
                       if(sCurrentLine.equalsIgnoreCase("---"))
                           continue;
                        this.extraRewards.add(sCurrentLine);
                    }
                    if (i == 6){
                        //System.out.println(sCurrentLine);
                        this.requireMent=sCurrentLine;
                    }
                    if (i == 7){
                        //System.out.println(sCurrentLine);
                        this.coolDown=Integer.parseInt(sCurrentLine);
                        i=0;
                    }
                }
        } 
        catch (IOException e) {
        } finally {
                try {
                        if (br != null)
                                br.close();
                        if (fr != null)
                                fr.close();
                } catch (IOException ex) {
                }
        }
    }
    
    @Override
    public String toString(){
        System.out.println(this.Name);
        System.out.println("--------------REGION");
        System.out.println(this.Region);
        System.out.println("--------------REQUIREMENT");
        System.out.println(this.requireMent);
        System.out.println("--------------LOCATION");
        System.out.println(this.location);
        System.out.println("--------------POKEMON");
        for ( int i=0;i<this.bossesPokemon.size();i++){
            System.out.println(this.bossesPokemon.get(i));
        }
        System.out.println("--------------REWARDS");
        for (int i=0;i<this.rewards.size();i++){
            System.out.println(this.rewards.get(i));
        }
        System.out.println("--------------EXTRA REWARDS");
        for (int i=0;i<this.extraRewards.size();i++){
            System.out.println(this.extraRewards.get(i));
        }
        System.out.println("--------------COOLDOWN");
        System.out.println(this.coolDown+" days");
        return "";
    }
    
    
}
