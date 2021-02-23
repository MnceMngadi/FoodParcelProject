import javax.swing.*;
import java.awt.*;

public class RunFood {



    public static void main(String [] args){


        JFrame f = new JFrame();
        Menu myGui = new Menu();
        myGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myGui.setVisible(true);
        //f

        Background b = new Background();
        f.add(b);

    }

}
