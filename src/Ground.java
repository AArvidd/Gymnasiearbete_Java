public class Ground {
    private float groundZ;
    private float reflectivity;

    private int[] color1;
    private int[] color2;

    public Ground(float ground, float reflectivity, int[] color1, int[] color2) {
        this.groundZ = ground;
        this.reflectivity = reflectivity;

        for (int i = 0; i < color1.length; i++) {
            if (color1[i] > 255)
                color1[i] = 255;
        }
        for (int i = 0; i < color2.length; i++) {
            if (color2[i] > 255)
                color2[i] = 255;
        }

        this.color1 = color1;
        this.color2 = color2;

    }

    public float getGroundZ() {
        return groundZ;
    }

    public float getReflectivity() {
        return reflectivity;
    }

    public int[] getColor(float x, float y) {

        int size = 5;
        if (x < 0)
            x = x * -1 + size - 1;
        if (y < 0)
            y = y * -1 + size - 1;

        boolean X = ((x % (size * 2)) - size) < 0;
        boolean Y = ((y % (size * 2)) - size) < 0;

        if (X == Y)
            return color1;
        else return color2;
    }

    public float[] reflect(float a, float b, float c) {

        float h, k, l;
        h = k = 0;
        l = 1;

        float dot = (a * h) + (b * k) + (c * l);
        float x = a - (2 * dot * h);
        float y = b - (2 * dot * k);
        float z = c - (2 * dot * l);

        return new float[]{x, y, z};
    }

}
