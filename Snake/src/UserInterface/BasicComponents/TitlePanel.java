package UserInterface.BasicComponents;

import javax.swing.*;
import java.awt.*;

/**
 * This is a class that creates a title panel that is used in menus
 */
public class TitlePanel extends JPanel {

    /**
     * @param imgPath The relative path of the image
     * @param panelSize the of the image
     */
    public TitlePanel(String imgPath, Dimension panelSize){

        this.setMaximumSize(panelSize);
        this.setBackground(Color.black);
        JLabel titleImage = new JLabel();
        titleImage.setIcon(new ImageIcon(imgPath));
        titleImage.setMaximumSize(new Dimension(432,160));
        this.add(titleImage);

    }

}
