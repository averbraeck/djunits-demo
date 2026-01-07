package org.djunits.demo.examples;

import org.djunits.old.unit.LengthUnit;
import org.djunits.old.value.vdouble.scalar.Length;

/**
 * <p>
 * Copyright (c) 2013-2017 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author Alexander Verbraeck
 * @author Peter Knoppers
 */
public final class ShowDisplayUnit
{
    /** */
    private ShowDisplayUnit()
    {
        // Utility class
    }

    /**
     * @param args args (blank)
     */
    public static void main(final String[] args)
    {
        Length length = new Length(10.00, LengthUnit.KILOMETER);
        System.out.println("original len: " + length);
        System.out.println("original si : " + length.si);
        length.setDisplayUnit(LengthUnit.METER);
        System.out.println("changed len: " + length);
        System.out.println("[not] changed si : " + length.si);
        // not possible: length.setDisplayUnit(MassUnit.KILOGRAM);
    }

}
