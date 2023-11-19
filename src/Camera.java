import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Color;

public class Camera {

    private float X, Y, Z;

    //width and height of the canvas
    private float width;
    private float height;

    //how many pixels there are in the width and height of the image
    private int pixelWidth;
    private int pixelHeight;

    //coordinates of the center of each pixel
    private float[][] pixelGridX;
    private float[][] pixelGridY;
    private float[][] pixelGridZ;

    private int[] skybox;

    ArrayList<Sphere> visible = new ArrayList<>();
    Ground ground;

    private BufferedImage image;

    public Camera(float X, float Y, float Z, int pixelWidth, int pixelHeight, float width, ArrayList<Sphere> sean, Ground ground, int r, int g, int b) {
        this.X = X;
        this.Y = Y;
        this.Z = Z;

        this.pixelWidth = pixelWidth;
        this.pixelHeight = pixelHeight;

        this.width = width;
        this.height = pixelHeight * width / pixelWidth;

        this.image = new BufferedImage(this.pixelWidth, this.pixelHeight, BufferedImage.TYPE_INT_RGB);

        visible.addAll(sean);
        this.ground = ground;

        this.skybox = new int[]{r, g, b};

        pixelPoint();
    }

    private void pixelPoint() {
        float[][] pixelGridX = new float[pixelWidth][pixelHeight];
        float[][] pixelGridY = new float[pixelWidth][pixelHeight];
        float[][] pixelGridZ = new float[pixelWidth][pixelHeight];

        float deltaPixelX = width / pixelWidth;
        float deltaPixelY = height / pixelHeight;

        for (int pX = 0; pX < pixelWidth; pX++) {
            float xCord = (deltaPixelX / 2) - (width / 2) + (pX * deltaPixelX);

            for (int pY = 0; pY < pixelHeight; pY++) {

                pixelGridY[pX][pY] = xCord;
                pixelGridX[pX][pY] = 1;
                pixelGridZ[pX][pY] = (height / 2) - (deltaPixelY / 2) - (pY * deltaPixelY);

            }
        }

        this.pixelGridX = pixelGridX;
        this.pixelGridY = pixelGridY;
        this.pixelGridZ = pixelGridZ;

    }

    public BufferedImage makeImage() {
        for (int x = 0; x < pixelWidth; x++) {
            for (int y = 0; y < pixelWidth; y++) {
                Ray current = new Ray(3, X, Y, Z, pixelGridX[x][y], pixelGridY[x][y], pixelGridZ[x][y], visible, ground, this);
                int[] color = current.castRay();
                Color temp = new Color(color[0], color[1], color[2]);
                image.setRGB(x, y, temp.getRGB());
            }
        }

        return image;

    }

    public int[] getSkybox() {
        return skybox;
    }
}
