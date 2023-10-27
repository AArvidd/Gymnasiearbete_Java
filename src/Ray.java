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


        float a = (A * A + B * B + C * C);
        float b = 2 * (A * (X - h) + B * (Y - k) + C * (X - l));
        float c = -(r * r - (X * X + Y * Y + Z * Z - 2 * (X * h + Y * k + Z * l) + h * h + k * k + l * l));

        float center = -(b / (2 * a));
        double pm = Math.sqrt(b*b - 4 * a * c)/(2 * a);

        t1 = (float)(center + pm);
        t2 = (float)(center - pm);

        if(Double.isNaN(t1) && Double.isNaN(t2))
            return -1;

        if(t1 < t2)
            return t1;
        else
            return t2;



    }


}
