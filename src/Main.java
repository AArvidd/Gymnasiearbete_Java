import javax.imageio.ImageIO;
import java.io.File;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) throws Exception {

        ArrayList<Sphere> sean = new ArrayList<Sphere>();
        sean.add(new Sphere(20, 100, 0, 15, 0, 0, 0, 255));
        sean.add(new Sphere(20, -100, 5, 15, 0, 0, 0, 255));

        Ground ground = new Ground(-10, 0.25f, new int[]{0, 0, 0}, new int[]{255, 255, 255});

        Camera main = new Camera(0, 0, 5, 1000, 1000, 50, sean, ground, 0, 0, 0);


        /*

        Ray test = new Ray(0, 0, 0, 0, 10, 6, 0, sean, ground, main);
        float[] num = test.findIntersection();
        System.out.println("t: " + num[0] + " index: " + num[1]);

        */
        //*
        BufferedImage image = main.makeImage();
        File output = new File("output.png");
        ImageIO.write(image, "png", output);

        //*/


    }
}