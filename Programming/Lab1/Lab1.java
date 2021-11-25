import java.util.Random;
import java.util.Arrays;
import static java.lang.Math.*;
public class Lab1 {
    public static void main(String[] args) {
        // task 1
        int[] e = new int[15];
        for (int i = 0; i < e.length; i++) {
            e[i] = i + 4;
        }
        // task 2
        float[] x = new float[14];
        Random r = new Random();
        for (int j = 0; j < x.length; j++) {
            x[j] = -14.0f + (r.nextFloat() * (13.0f - (-14.0f)));
        }
        // task 3
        double[][] c = new double[15][14];
        int[] t = {4, 7, 10, 12, 13, 14, 18};
        for (int i = 0; i < e.length; i++) {
            for (int j = 0; j < x.length; j++) {
                if (e[i] == 6) {
                    c[i][j] = pow(tan(atan((x[j] - 0.5)/27.0)), (asin(cos(x[j])) - 1.0/3.0)/cbrt(log(abs(x[j]))));
                } else if (Arrays.binarySearch(t,e[i]) >= 0) {
                    c[i][j] = asin(pow(sin(x[j]), 2.0));
                } else {
                    c[i][j] = sin(pow(((cbrt(cbrt(x[j])) + PI)/0.25), 3.0));
                }
            }
        }
        // task 4
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 14; j++) {
                String element = String.format("%9.3f", c[i][j]);
                System.out.print(element);
            }
            System.out.println();
        }
    }
}