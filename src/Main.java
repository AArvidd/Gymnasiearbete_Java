import javax.imageio.ImageIO;
import java.io.File;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) throws Exception {

        float start = System.nanoTime();

        ArrayList<Sphere> sean = new ArrayList<Sphere>();
        sean.add(new Sphere(30, 0, 0, 10, 0.5f, 255, 0, 255));
        sean.add(new Sphere(20, -20, 0, 5, 0.25f, 0, 0, 255));
        sean.add(new Sphere(50, 0, 20, 10, 0.5f, 255, 0, 0));
        sean.add(new Sphere(100, 100, 10, 40, 1, 255, 255, 255));
        sean.add(new Sphere(10, 0, 10, 5, 0.5f, 0, 255, 0));
        sean.add(new Sphere(-10, 0, 0, 5, 0, 255, 255, 255));
        sean.add(new Sphere(0, 20, 0, 5, 0, 0, 255, 255));
        sean.add(new Sphere(100, 100, 100, 10, 0.1f, 255, 255, 0));
        sean.add(new Sphere(-100, -100, 0, 10, 0, 0, 0, 255));
        sean.add(new Sphere(100, -100, 100, 10, 0, 128, 128, 128));


        Ground ground = new Ground(-20, 0.25f, new int[]{0, 0, 0}, new int[]{255, 255, 255});

        Camera main = new Camera(0, 0, 0, 5000, 5000, 2, sean, ground, 0, 0, 0);

        BufferedImage image = main.makeImage();
        File output = new File("outputJava.png");
        ImageIO.write(image, "png", output);


        float end = System.nanoTime();

        float dif = end - start;

        System.out.println(dif / 1000000000);


    }
}