import javax.imageio.ImageIO;
import java.io.File;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) throws Exception {

        float start = System.nanoTime();

        ArrayList<Sphere> sean = new ArrayList<Sphere>();
        sean.add(new Sphere(50, 0, 10, 40, 0.5f, 255, 0, 255));
        sean.add(new Sphere(50, -200, 10, 40, 0, 0, 0, 255));


        Ground ground = new Ground(-20, 0.5f, new int[]{0, 0, 0}, new int[]{255, 255, 255});

        Camera main = new Camera(0, 0, -19, 3000, 3000, 50, sean, ground, 0, 0, 0);

        BufferedImage image = main.makeImage();
        File output = new File("output.png");
        ImageIO.write(image, "png", output);


        float end = System.nanoTime();

        float dif = end - start;

        System.out.println(dif);


    }
}