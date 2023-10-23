import java.awt.image.BufferedImage;

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

    private BufferedImage image;

    public Camera(float X, float Y, float Z, int pixelWidth, int pixelHeight,  float width){
        this.X = X;
        this.Y = Y;
        this.Z = Z;

        this.pixelWidth = pixelWidth;
        this.pixelHeight = pixelHeight;

        this.width = width;
        this.height = pixelHeight * width / pixelWidth;

        this.image = new BufferedImage(this.pixelWidth, this.pixelHeight, BufferedImage.TYPE_INT_RGB);

        pixelPoint();
    }

    private void pixelPoint(){
        float[][] pixelGridX = new float[pixelHeight][pixelWidth];
        float[][] pixelGridY = new float[pixelHeight][pixelWidth];
        float[][] pixelGridZ = new float[pixelHeight][pixelWidth];

        float deltaPixelX = width / pixelWidth;
        float deltaPixelY = height / pixelHeight;

        for (int pX = 0; pX < pixelWidth; pX++){
            float xCord = (deltaPixelX / 2) - (width / 2) + (pX * deltaPixelX);

            for (int pY = 0; pY < pixelHeight; pY++){

                pixelGridX[pX][pY] = xCord + this.X;
                pixelGridY[pX][pY] = 1 + this.Y;
                pixelGridZ[pX][pY] = (height  /2) - (deltaPixelY / 2) + (pY * deltaPixelY) + this.Y;

            }
        }

    }

    public void makeImage(){
        for (int x = 0; x < pixelWidth; x++){
            for (int y = 0; x < pixelWidth; y++){

            }
        }
    }


}
