package GameEngine;

import GameEngine.GameObjects.Apple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Level {

    private int levelID;
    ArrayList<ArrayList<GameObject>> levelMap;

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
                    if(str.charAt(i) == 'o'){
                    continue;
                    } else if(str.charAt(i) == 'x'){


                    } else if(str.charAt(i) == 'b'){


                    } else if(str.charAt(i) == 'w'){


                    } else if(str.charAt(i) == 'p'){


                    } else if(str.charAt(i) == 'a'){
                        levelMap.get(lineIt).add(new Apple(lineIt,i));
                    }
                }
                lineIt++;
            }


        } catch (Exception e){

        }

    }

    public ArrayList<ArrayList<GameObject>> getLevelMap(){
        return levelMap;
    }


}
