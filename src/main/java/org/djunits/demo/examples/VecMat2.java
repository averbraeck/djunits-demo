package org.djunits.demo.examples;

import org.djunits.quantity.Area;
import org.djunits.quantity.Duration;
import org.djunits.quantity.Length;
import org.djunits.quantity.Speed;
import org.djunits.vecmat.d2.Matrix2x2;
import org.djunits.vecmat.dn.VectorN;
import org.djunits.vecmat.dnxm.MatrixNxM;

/** */
public class VecMat2
{
    /**
     * @param args not used
     */
    public static void main(final String[] args)
    {
        VectorN.Col<Length, Length.Unit> lv1 = VectorN.Col.of(new double[] {10, 20.0, 60, 120.0, 400.0}, Length.Unit.km);
        Duration duration = Duration.of(2.0, "h");
        VectorN.Col<Speed, Speed.Unit> sv1 = lv1.divideElements(duration).as(Speed.Unit.km_h);
        System.out.println("Length: " + lv1);
        System.out.println("Speed : " + sv1);

        MatrixNxM<Length, Length.Unit> lm4x2 = MatrixNxM.of(new double[][] {{1, 2, 3, 4}, {5, 6, 7, 8}}, Length.Unit.m);
        MatrixNxM<Length, Length.Unit> lm2x4 = MatrixNxM.of(new double[][] {{1, 2}, {3, 4}, {5, 6}, {7, 8}}, Length.Unit.m);

        var mult44 = lm4x2.multiply(lm2x4).as(Area.Unit.m2);
        System.out.println("\nMatrix1:\n" + lm4x2);
        System.out.println("Matrix2:\n" + lm2x4);
        System.out.println("Multiplication:\n" + mult44);
        
        Matrix2x2<Area, Area.Unit> mult22 = lm4x2.multiply(lm2x4).asMatrix2x2().as(Area.Unit.a);
        System.out.println("\nMatrix1:\n" + lm2x4);
        System.out.println("Matrix2:\n" + lm4x2);
        System.out.println("Multiplication:\n" + mult22);
    }

}
