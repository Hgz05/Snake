package GameEngine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Level {

    private int levelID;
    ArrayList<ArrayList<Character>> levelMap;

    public Level(int level){
        levelID = level;
        levelMap = new ArrayList<>();
        try{

            BufferedReader br = new BufferedReader(new FileReader("data/LevelData/Level"+levelID+".dat"));
            String str;
            int lineIt = 0;
            while ((str = br.readLine()) != null){
                levelMap.add(new ArrayList<>());
                for (int i = 0; i < 24; i++) {
                    levelMap.get(lineIt).add(str.charAt(i));
                }
                lineIt++;
            }


        } catch (Exception e){


        }

    }


}
