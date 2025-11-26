package UserInterface.BasicComponents;

import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel {

    public TitlePanel(String imgPath, Dimension panelSize){

        this.setMaximumSize(panelSize);
        this.setBackground(Color.black);
        JLabel titleImage = new JLabel();
        titleImage.setIcon(new ImageIcon(imgPath));
        titleImage.setMaximumSize(new Dimension(432,160));
        this.add(titleImage);

    }

}
