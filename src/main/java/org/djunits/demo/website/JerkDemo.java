package org.djunits.demo.website;

import org.djunits.quantity.Acceleration;
import org.djunits.quantity.Duration;
import org.djunits.vecmat.d2.Matrix2x2;

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
        Jerk jerk1 = new Jerk(1.2, Jerk.Unit.SI);
        System.out.println("jerk1 = Jerk(1.2, Jerk.Unit.SI)    : " + jerk1);
        Jerk jerk2 = jerk1.scaleBy(2.0);
        System.out.println("jerk2 = jerk1.scaleBy(2.0)         : " + jerk2);
        Jerk jerk3 = new Jerk(4.0, Jerk.Unit.in_s3);
        System.out.println("jerk3 = Jerk(4.0, Jerk.Unit.in_s3  : " + jerk3);
        System.out.println("jerk3 expressed in Jerk.Unit.SI    : " + jerk3.toString(Jerk.Unit.SI));
        System.out.println("jerk3 expressed in Jerk.Unit.ft_s3 : " + jerk3.toString(Jerk.Unit.ft_s3));

        double[][] jmd = new double[][] {{1, 2}, {3, 4}};
        Matrix2x2<Jerk> jerkMatrix2 = Matrix2x2.of(jmd, Jerk.Unit.in_s3);
        System.out.println("\nJerk matrix:\n" + jerkMatrix2);

        // multiply the JerkMatrix by a scalar Duration and get an Matrix2x2<Acceleration, Acceleration.Unit>
        Duration d = Duration.of(3.0, "s");
        Matrix2x2<Acceleration> mAcc = jerkMatrix2.multiplyEntries(d).as(Acceleration.Unit.ft_s2);
        System.out.println("Acceleration matrix:\n" + mAcc);
    }

}
