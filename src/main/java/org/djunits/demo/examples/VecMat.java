package org.djunits.demo.examples;

import org.djunits.quantity.Area;
import org.djunits.quantity.Duration;
import org.djunits.quantity.Frequency;
import org.djunits.quantity.Length;
import org.djunits.quantity.Mass;
import org.djunits.quantity.Speed;
import org.djunits.quantity.Time;
import org.djunits.quantity.Time.Reference;
import org.djunits.vecmat.d2.Matrix2x2;
import org.djunits.vecmat.d2.Vector2;
import org.djunits.vecmat.d3.Matrix3x3;
import org.djunits.vecmat.dn.VectorN;
import org.djunits.vecmat.storage.DenseDoubleDataSi;

/**
 * VecMat.java.<p>
 * Copyright (c) 2025-2026 Delft University of Technology, Jaffalaan 5, 2628 BX Delft, the Netherlands. All rights reserved. See
 * for project information <a href="https://djunits.org" target="_blank">https://djunits.org</a>. The DJUNITS project is
 * distributed under a <a href="https://djunits.org/docs/license.html" target="_blank">three-clause BSD-style license</a>.
 * @author Alexander Verbraeck
 */
public class VecMat
{
    /** */
    private static void as1()
    {
        var l1 = Length.of(1.0, "km");
        var m1 = Mass.of(1.0, "kg");
        System.out.println(l1 + " * " + m1 + " = " + l1.multiply(m1));
        System.out.println(l1 + " / " + m1 + " = " + l1.divide(m1));
        var q = Duration.of(1.0, "h").divide(l1).reciprocal();
        var speed = q.as(Speed.Unit.m_s);
        System.out.format("Speed = %s, class = %s%n", speed, speed.getClass().getSimpleName());
    }

    /** */
    private static void as2()
    {
        var l1 = Length.of(1.0, "km");
        var q = Duration.of(1.0, "h").divide(l1);
        // var speed = q.as(Speed.Unit.METER_PER_SECOND);
        var speed = q.reciprocal().as(Speed.Unit.m_s);
        System.out.format("Speed = %s, class = %s%n", speed, speed.getClass().getSimpleName());
    }

    /** */
    private static void time()
    {
        var t1 = Time.of(520.0, "wk", Reference.UNIX);
        var t2 = Time.of(520.0, "wk", Reference.GPS);
        System.out.println("t1 = " + t1);
        System.out.println("t2 = " + t2);
        System.out.println("t1.eq(t2)  : " + t1.eq(t2));
        System.out.println(
                "t1.getQuantity().si().eq(t2.getQuantity().si())  : " + (t1.getQuantity().si() == t2.getQuantity().si()));
        // RTE: System.out.println(t1.gt(t2));
        // RTE: System.out.println(t1.compareTo(t2));
    }

    /**
     * @param args not used
     */
    public static void main(final String[] args)
    {
        as1();
        as2();
        time();

        Vector2.Col<Frequency> f =
                Vector2.Col.of(10.0, 5.0, Duration.Unit.ms).invertEntries().as(Frequency.Unit.kHz);
        System.out.println(f.x() + " type=" + f.x().getClass().getSimpleName());

        var v2 = Vector2.Col.of(10, 20, Length.Unit.m);
        var v3 = Vector2.Col.of(20, 30, Length.Unit.ft);
        System.out.println("\n" + v2);
        System.out.println(v3);
        System.out.println(v2.add(v3));
        var v4 = Vector2.Col.of(10, 20, Mass.Unit.g);
        // This does not compile: System.out.println(v2.plus(v4));
        var v5 = Vector2.Row.of(10, 20, Mass.Unit.lb);
        // This does not compile: System.out.println(v4.plus(v5));
        System.out.println(v4.add(v5.transpose()));
        System.out.format("%nnorm L1 of %s is %s%n", v4, v4.normL1());
        System.out.format("norm L2 of %s is %s%n", v4, v4.normL2());
        System.out.format("norm Lp=2 of %s is %s%n", v4, v4.normLp(2));
        System.out.format("norm Linf of %s is %s%n", v4, v4.normLinf());

        System.out.println("\n\nMatrices");
        var mat = Matrix2x2.of(new double[][] {{1.0, 2.0}, {5.0, 4.0}}, Duration.Unit.s);
        System.out.println("matrix:\n" + mat);
        System.out.println("\nmatrix + matrix:\n" + mat.add(mat));
        System.out.println("\nmatrix + 1 day:\n" + mat.add(Duration.of(1.0, "day")));
        System.out.println("\ndeterminant: " + mat.determinant());
        try
        {
            System.out.println("\ninverse:\n" + mat.inverse());
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        System.out.println("\ntrace: " + mat.trace());
        System.out.println("\nadjugate:\n" + mat.adjugate());
        
        var mat3 = Matrix3x3.of(new double[][] {{1,2,3}, {4,5,6}, {7,8,9}}, Area.Unit.m2);
        System.out.println(mat3);
        
        double[] sv = new double[] {10, 20, 30, 40, 50};
        var v1 = VectorN.Col.ofSi(new DenseDoubleDataSi(sv, 5, 1), Speed.Unit.km_h);
        System.out.println("speed vector 1: " + v1);
        
        double[] doubleValues2 = new double[] { 10, 20.0, 60, 120.0, 300.0 };
        DenseDoubleDataSi ddd2 = new DenseDoubleDataSi(doubleValues2, 5, 1);
        VectorN.Col<Duration> dv1 = VectorN.Col.ofSi(ddd2, Duration.Unit.s);
        Speed speed = Speed.of(10.0, "km/h");
        VectorN.Col<Length> lv1 = dv1.multiplyEntries(speed).as(Length.Unit.m);
        System.out.println(dv1);
        System.out.println(lv1);
    }
}
