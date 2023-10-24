import java.lang.Math;
import java.util.ArrayList;

public class Ray {

    private int depth;

    //origin
    private float X;
    private float Y;
    private float Z;

    //destination
    private float A;
    private float B;
    private float C;

    private ArrayList<Sphere> scene = new ArrayList<>();

    public Ray(int depth, float X, float Y, float Z, float A, float B, float C){
        this.depth = depth;

        this.X = X;
        this.Y = Y;
        this.Z = Z;

        float abs = (float)Math.sqrt((A*A)+(B*B)+(C*C));

        this.A = A / abs;
        this.B = B / abs;
        this.C = C / abs;
    }



    public float findSphereIntersection (float h, float k, float l, float r){
        float t1;
        float t2;

        float center = -2 * (A * (X - h) + B * (Y - k) + C * (Z - l));

        float sqrA = (A * (X - h) + B * (Y - k) + C * (Z - l));
        double root = Math.sqrt((2 * (sqrA * sqrA) - 4 * (A * A + B * B + C * C) * (r * r - (X * X + Y * Y + Z * Z - 2 * (X * h + Y * k + Z * l) + h * h + k * k + l * l ))));

        float denominator = (2 * (A * A + B * B + C * C));

        double pm = root / denominator;

        t1 = (float)(center + pm);
        t2 = (float)(center - pm);

        /*
        använ det hära

        t = [-2(a(x₀ - h) + b(y₀ - k) + c(z₀ - l)) ±
            sqrt((2(a(x₀ - h) + b(y₀ - k) + c(z₀ - l))^2 - 4(a^2 + b^2 + c^2)(r^2 - (x₀^2 + y₀^2 + z₀^2 - 2(x₀h + y₀k + z₀l) + h^2 + k^2 + l^2)))
            / (2(a^2 + b^2 + c^2)]
         */
        return 0;

    }


}
