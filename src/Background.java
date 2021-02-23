import java.awt.*;

public class Background extends Canvas {

    Image img;

    public void backGround(){

       // img =  Toolkit.getDefaultToolkit().getImage("C:/Users/Mncedisi/IdeaProjects/NewProject/burger.jpg");
    }

    public void graphics(Graphics2D g){

        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(img, 0, 0,640, 400, this);

    }


}
