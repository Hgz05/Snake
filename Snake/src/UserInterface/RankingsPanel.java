package UserInterface;

import UserInterface.BasicComponents.BackPanel;
import UserInterface.BasicComponents.TitlePanel;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is a Class that displays the rankings
 */
public class RankingsPanel extends JPanel {

    /**
     * Display Frame
     */
    PanelManager parentFrame;
    /**
     * This panel displays the title
     */
    JPanel titlePanel;
    /**
     * This panel contains the buttons that will change the rankings table
     */
    JPanel rankingsChangerPanel;
    /**
     * This is the panel that contains the rankings table
     */
    JPanel rankingsPanel;
    /**
     * This panel contains the button to the main menu
     */
    JPanel backPanel;
    /**
     * This table contains the rankings information
     */
    ArrayList<JTable> rankingsArray;
    /**
     * This is the id of the current level rankings displayed
     */
    int currentLevel = 1;

    /**
     * @param Frame This will be the parent frame
     */
    public RankingsPanel(PanelManager Frame){

        parentFrame = Frame;
        this.setLayout(new BorderLayout());

        //Title Panel
        titlePanel = new TitlePanel("res/Placeholder.jpg", new Dimension(720,240));


        //Panel that contains Rankings Panel changer and Rankings panel

        JPanel rankingsWrapper = new JPanel(new BorderLayout());
        rankingsWrapper.setBackground(Color.black);

        //Rankings Panel Changer Title
        JPanel rpcTitle = new JPanel();
        JLabel rpcText = new JLabel("Top 20 scores of level : " + currentLevel);
        rpcTitle.add(rpcText);


        //Rankings Panel Changer

        rankingsChangerPanel = new JPanel();
        JButton goLeft = new JButton("<-");
        goLeft.addActionListener( e -> {

            if(currentLevel == 1) return;
            rankingsPanel.remove(rankingsArray.get(currentLevel-1));
            currentLevel--;
            rankingsPanel.add(rankingsArray.get(currentLevel-1));
            rpcText.setText("Top 20 scores of level : " + currentLevel);
            parentFrame.revalidate();
            parentFrame.repaint();
        });

        JButton goRight = new JButton("->");
        goRight.addActionListener( e ->{
            if(currentLevel == 10) return;
            rankingsPanel.remove(rankingsArray.get(currentLevel-1));
            currentLevel++;
            rankingsPanel.add(rankingsArray.get(currentLevel-1));
            rpcText.setText("Top 20 scores of level : " + currentLevel);
            parentFrame.revalidate();
            parentFrame.repaint();
        });

        rankingsChangerPanel.add(goLeft);
        rankingsChangerPanel.add(goRight);


        //Rankings Panel will be imported from multiple files

        rankingsPanel = new JPanel();
        rankingsArray = new ArrayList<>();

        for(int i = 0; i < 10; i++){

            try {
                BufferedReader br = new BufferedReader(new FileReader("data/LevelRankings/Level"+(i+1)+".dat"));
                ArrayList<String> list = new ArrayList<>();
                String str;
                while ((str = br.readLine()) != null){
                    list.add(str);
                }
                Object[][] data = new Object[list.size()][2];
                for(int j  = 0; j<list.size(); j++){
                    data[j] = list.get(j).split(";");
                }
                Arrays.sort(data, (x,y) -> Integer.compare(Integer.parseInt(x[1].toString()), Integer.parseInt(y[1].toString())));
                Object[][] sortedData = new Object[list.size() > 20 ? 20 : list.size()][3];
                for(int k = 0; k<list.size(); k++){
                    if(k == 20) break;
                    sortedData[k][0] = k+1;
                    sortedData[k][1] = data[k][0];
                    sortedData[k][2] = data[k][1];
                }

                String[] coulumnNames = {"Place","Name","Time"};
                JTable rankingsTable = new JTable(sortedData,coulumnNames);
                rankingsArray.add(rankingsTable);

            } catch (Exception e){
                System.out.println(e);
            }

        }

        rankingsPanel.add(rankingsArray.get(currentLevel-1));

        rankingsWrapper.add(rpcTitle, BorderLayout.NORTH);
        rankingsWrapper.add(rankingsChangerPanel, BorderLayout.SOUTH);
        rankingsWrapper.add(rankingsPanel, BorderLayout.CENTER);


        //Back Button
        backPanel = new BackPanel(parentFrame);

        //Adding panels back to the frame
        this.setPreferredSize(new Dimension(720,720));
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(rankingsWrapper, BorderLayout.CENTER);
        this.add(backPanel, BorderLayout.SOUTH);


    }

}
