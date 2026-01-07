package org.djunits.demo.examples;

import org.djunits.quantity.Angle;

/**
 * Normalization of angles.
 * <p>
 * Copyright (c) 2013-2025 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @version $Revision$, $LastChangedDate$, by $Author$, initial version Oct 28, 2015 <br>
 * @author Alexander Verbraeck
 * @author Peter Knoppers
 */
public final class Angles
{
    /** */
    private Angles()
    {
        // utility class
    }

    /**
     * Create some Angle values to demonstrate conversion from and to related units, including the non-linear
     * Angle.Unit.PERCENT.
     * @param args the command line arguments; not used
     */
    public static void main(final String[] args)
    {
        System.out.println("Normalization of an angle adds or subtracts a multiple of 2\u03c0. For linear angle units "
                + "the result is a value between 0 and +2\u03c0.");
        System.out.println("Angles not between -90\u00b0 and +90\u00b0, -\u03c0/2 and +\u03c0/2 cannot properly be "
                + "expressed as percentage.");
        Angle a1 = new Angle(3 * Math.PI, Angle.Unit.RADIAN);
        Angle normA1 = Angle.normalize(a1);
        System.out.println("3 * \u03c0: " + a1 + " (" + a1.toString(Angle.Unit.DEGREE) + ", " + a1.toString(Angle.Unit.PERCENT)
                + ") -> " + normA1 + " (" + normA1.toString(Angle.Unit.DEGREE) + ", " + normA1.toString(Angle.Unit.PERCENT)
                + ") Note: percentage almost 0");
        Angle a2 = new Angle(-Math.PI, Angle.Unit.RADIAN);
        Angle normA2 = Angle.normalize(a2);
        System.out.println("   -\u03c0: " + a2 + " (" + a2.toString(Angle.Unit.DEGREE) + ", " + a2.toString(Angle.Unit.PERCENT)
                + ") -> " + normA2 + " (" + normA2.toString(Angle.Unit.DEGREE) + ", " + normA2.toString(Angle.Unit.PERCENT)
                + ") Note: percentage almost 0");
        Angle a3 = new Angle(-45, Angle.Unit.DEGREE);
        Angle normA3 = Angle.normalize(a3);
        System.out.println("  -45\u0090: " + a3 + " (" + a3.toString(Angle.Unit.RADIAN) + ", " + a3.toString(Angle.Unit.PERCENT)
                + ") -> " + normA3 + " (" + normA3.toString(Angle.Unit.RADIAN) + ", " + normA3.toString(Angle.Unit.PERCENT)
                + ")");
        System.out.println("");
        System.out.println("Angles expressed as percentage are always between -inf and +inf (-90\u00b0 and +90\u00b0, "
                + "-\u03c0/2 and +\u03c0/2); even after normalization.");
        Angle a4 = new Angle(-100, Angle.Unit.PERCENT);
        Angle normA4 = Angle.normalize(a4);
        System.out.println(
                "-100%: " + a4 + " (" + a4.toString(Angle.Unit.DEGREE) + ", " + a4.toString(Angle.Unit.RADIAN) + ") -> "
                        + normA4 + " (" + normA4.toString(Angle.Unit.DEGREE) + ", " + normA4.toString(Angle.Unit.RADIAN) + ")");
        Angle a5 = new Angle(100, Angle.Unit.PERCENT);
        Angle normA5 = Angle.normalize(a5);
        System.out.println(
                " 100%: " + a5 + " (" + a5.toString(Angle.Unit.DEGREE) + ", " + a5.toString(Angle.Unit.RADIAN) + ") -> "
                        + normA5 + " (" + normA5.toString(Angle.Unit.DEGREE) + ", " + normA5.toString(Angle.Unit.RADIAN) + ")");
        Angle a6 = new Angle(1000, Angle.Unit.PERCENT);
        Angle normA6 = Angle.normalize(a6);
        System.out.println(
                "1000%: " + a6 + " (" + a6.toString(Angle.Unit.DEGREE) + ", " + a6.toString(Angle.Unit.RADIAN) + ") -> "
                        + normA6 + " (" + normA6.toString(Angle.Unit.DEGREE) + ", " + normA6.toString(Angle.Unit.RADIAN) + ")");
    }

}
