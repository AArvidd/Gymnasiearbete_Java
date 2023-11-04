import java.lang.Math;
import java.util.ArrayList;

public class Ray {

    private int depth;

    //origin
    private float X, Y, Z;

    //destination
    private float A, B, C;

    private ArrayList<Sphere> scene = new ArrayList<>();
    private Ground ground;

    public Ray(int depth, float X, float Y, float Z, float A, float B, float C, ArrayList<Sphere> scene, Ground ground) {
        this.depth = depth;

        this.X = X;
        this.Y = Y;
        this.Z = Z;

        float abs = (float) Math.sqrt((A * A) + (B * B) + (C * C));

        this.A = A / abs;
        this.B = B / abs;
        this.C = C / abs;

        this.scene = scene;
        this.ground = ground;
    }


    public float[] findIntersection() {
        ArrayList<Float> intersectionLength = new ArrayList<>();

        for (int i = 0; i < scene.toArray().length; i++) {
            Sphere current = scene.get(i);
            intersectionLength.add(findSphereIntersection(current.getX(), current.getY(), current.getZ(), current.getR()));
        }

        float shortest = -1;
        int shortestIndex = -1;

        for (int i = 0; i < intersectionLength.toArray().length; i++) {
            float test = intersectionLength.get(i);
            if (test == -1) {
                continue;
            }
            if (test < shortest) {
                shortest = test;
                shortestIndex = i;
            }
        }

        if (shortest == -1)
            shortest = groundIntersection();


        if (shortest == -1)
            shortest = -2;

    }


    public float findSphereIntersection(float h, float k, float l, float r) {
        float t1;
        float t2;


        float a = (A * A + B * B + C * C);
        float b = 2 * (A * (X - h) + B * (Y - k) + C * (X - l));
        float c = -(r * r - (X * X + Y * Y + Z * Z - 2 * (X * h + Y * k + Z * l) + h * h + k * k + l * l));

        float center = -(b / (2 * a));
        double pm = Math.sqrt(b * b - 4 * a * c) / (2 * a);

        t1 = (float) (center + pm);
        t2 = (float) (center - pm);

        if (Double.isNaN(t1) && Double.isNaN(t2))
            return -1;

        if (t1 < 0 || t2 < 0)
            return -1;


        return Math.min(t1, t2);

    }

    public float groundIntersection() {
        float t = (ground.getGround() - Z) / C;
        if (t < 0)
            t = -1;
        return t;
    }


}
