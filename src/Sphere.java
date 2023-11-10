public class Sphere {

    private float X, Y, Z;

    private float R;

    private float reflectivity;
    private int[] color;

    public Sphere(float X, float Y, float Z, float R, float reflectivity, int r, int g, int b) {
        this.X = X;
        this.Y = Y;
        this.Z = Z;

        this.R = R;

        this.reflectivity = reflectivity;

        if (r > 255)
            r = 255;
        if (g > 255)
            g = 255;
        if (b > 255)
            b = 255;

        this.color = new int[]{r, g, b};
    }

    public float getX() {
        return X;
    }

    public float getY() {
        return Y;
    }

    public float getZ() {
        return Z;
    }

    public float getR() {
        return R;
    }

    public int[] getColor() {
        return color;
    }

    public float getReflectivity() {
        return reflectivity;
    }

    public float[] reflect(float x, float y, float z, float a, float b, float c) {

        float h, k, l;

        //float

    }
}
