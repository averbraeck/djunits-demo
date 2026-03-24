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
        VectorN.Col<Length> lv1 = VectorN.Col.of(new double[] {10, 20.0, 60, 120.0, 400.0}, Length.Unit.km);
        Duration duration = Duration.of(2.0, "h");
        VectorN.Col<Speed> sv1 = lv1.divideEntries(duration).as(Speed.Unit.km_h);
        System.out.println("Length: " + lv1);
        System.out.println("Speed : " + sv1);

        MatrixNxM<Length> lm2x4 = MatrixNxM.of(new double[][] {{1, 2, 3, 4}, {5, 6, 7, 8}}, Length.Unit.m);
        MatrixNxM<Length> lm4x2 = MatrixNxM.of(new double[][] {{1, 2}, {3, 4}, {5, 6}, {7, 8}}, Length.Unit.m);

        var mult44 = lm4x2.multiply(lm2x4).as(Area.Unit.m2);
        System.out.println("\nMatrix1 (4x2):\n" + lm4x2);
        System.out.println("Matrix2 (2x4):\n" + lm2x4);
        System.out.println("Multiplication (4x4):\n" + mult44);
        
        Matrix2x2<Area> mult22 = lm2x4.multiply(lm4x2).asMatrix2x2().as(Area.Unit.a);
        System.out.println("\nMatrix1 (2x4):\n" + lm2x4);
        System.out.println("Matrix2 (4x2):\n" + lm4x2);
        System.out.println("Multiplication (2x2):\n" + mult22);
    }

}
