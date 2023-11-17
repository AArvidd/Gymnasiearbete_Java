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

    public float[] reflect(float X, float Y, float Z, float a, float b, float c) {

        float h, k, l;

        h = X - this.X;
        k = Y - this.Y;
        l = Z - this.Z;

        float abs = (float) Math.sqrt((h * h) + (k * k) + (l * l));

        h = h / abs;
        k = k / abs;
        l = l / abs;

        float dot = (a * h) + (b * k) + (c * l);
        float x = a - (2 * dot * h);
        float y = b - (2 * dot * k);
        float z = c - (2 * dot * l);

        return new float[]{x, y, z};
    }
}
