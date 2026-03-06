package org.djunits.demo.website;

import org.djunits.quantity.Duration;
import org.djunits.vecmat.dn.MatrixNxN;
import org.djunits.vecmat.dn.VectorN;
import org.djunits.vecmat.storage.DenseDoubleData;

/**
 * <p>
 * Copyright (c) 2013-2026 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * @author Alexander Verbraeck
 * @author Peter Knoppers
 */
public final class JerkDemo
{
    /** */
    private JerkDemo()
    {
        // utility class
    }

    /**
     * @param args args
     */
    public static void main(final String[] args)
    {
        Jerk jerk1 = new Jerk(1.2, JerkUnit.SI);
        System.out.println("jerk1 = Jerk(1.2, JerkUnit.SI)    : " + jerk1);
        Jerk jerk2 = jerk1.scaleBy(2.0);
        System.out.println("jerk2 = jerk1.multiplyBy(2.0)     : " + jerk2);
        Jerk jerk3 = new Jerk(4.0, JerkUnit.in_s3);
        System.out.println("jerk3 = Jerk(4.0, JerkUnit.in_s3  : " + jerk3);
        System.out.println("jerk3 expressed in JerkUnit.SI    : " + jerk3.toString(JerkUnit.SI));
        System.out.println("jerk3 expressed in JerkUnit.ft_s3 : " + jerk3.toString(JerkUnit.ft_s3));

        System.out.println();

        double[] sv = new double[] {1, 2, 3, 4, 5};
        var jerkVector = new VectorN.Col<Jerk, JerkUnit>(new DenseDoubleData(sv, 5, 1), JerkUnit.SI);
        System.out.println("jerkVector: " + jerkVector);

        // multiply a JerkVector by a scalar Duration and get an Vector<Acceleration, Acceleration.Unit>
        Duration d = Duration.of(3.0, "s");
        // VectorN.Col<Acceleration, Acceleration.Unit> vAcc = jerkVector.multiplyElements(d).as(Acceleration.class);

        // fill a JerkMatrix
        double[][] data = new double[1000][1000];
        for (int i = 0; i < 1000; i++)
        {
            for (int j = 0; j < 1000; j++)
            {
                data[i][j] = 9 * i + 2 * j * 0.364;
            }
        }
        MatrixNxN<Jerk, JerkUnit> mat = new MatrixNxN<>(new DenseDoubleData(data), JerkUnit.in_s3);
        System.out.println("mean matrix value: " + mat.mean());
    }

}
