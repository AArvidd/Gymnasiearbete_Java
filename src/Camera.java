import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Camera {

    private float X;
    private float Y;
    private float Z;

    private float width;
    private float height;

    private int pixelWidth;
    private int pixelHeight;

    private float[][] pixelGridX;
    private float[][] pixelGridY;
    private float[][] pixelGridZ;

    ArrayList<Sphere> visible = new ArrayList<>();

    private BufferedImage image;

    public Camera(float X, float Y, float Z, int pixelWidth, int pixelHeight,  float width, ArrayList<Sphere> sean){
        this.X = X;
        this.Y = Y;
        this.Z = Z;

        this.pixelWidth = pixelWidth;
        this.pixelHeight = pixelHeight;

        this.width = width;
        this.height = pixelHeight * width / pixelWidth;

        this.image = new BufferedImage(this.pixelWidth, this.pixelHeight, BufferedImage.TYPE_INT_RGB);

        visible.addAll(sean);

        pixelPoint();
    }

    private void pixelPoint(){
        float[][] pixelGridX = new float[pixelWidth][pixelHeight];
        float[][] pixelGridY = new float[pixelWidth][pixelHeight];
        float[][] pixelGridZ = new float[pixelWidth][pixelHeight];

        float deltaPixelX = width / pixelWidth;
        float deltaPixelY = height / pixelHeight;

        for (int pX = 0; pX < pixelWidth; pX++){
            float xCord = (deltaPixelX / 2) - (width / 2) + (pX * deltaPixelX);

            for (int pY = 0; pY < pixelHeight; pY++){

                pixelGridX[pX][pY] = xCord + this.X;
                pixelGridY[pX][pY] = 1 + this.Y;
                pixelGridZ[pX][pY] = (height  /2) - (deltaPixelY / 2) + (pY * deltaPixelY) + this.Z;

            }
        }

        this.pixelGridX = pixelGridX;
        this.pixelGridY = pixelGridY;
        this.pixelGridZ = pixelGridZ;

    }

    public void makeImage(){
        for (int x = 0; x < pixelWidth; x++){
            for (int y = 0; x < pixelWidth; y++){

            }
        }
    }


}
