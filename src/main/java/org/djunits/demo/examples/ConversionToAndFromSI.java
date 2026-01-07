package org.djunits.demo.examples;

import java.util.Locale;

import org.djunits.old.unit.util.UNITS;
import org.djunits.quantity.Length;

/**
 * This Java code demonstrates conversions between related unit using DJUNITS.
 * <p>
 * Copyright (c) 2015-2025 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @version $Revision: 954 $, $LastChangedDate: 2022-01-10 03:42:57 +0100 (Mon, 10 Jan 2022) $, by $Author: averbraeck $,
 *          initial version 3 sep. 2015 <br>
 * @author Alexander Verbraeck
 * @author Peter Knoppers
 */
public final class ConversionToAndFromSI implements UNITS
{
    /** */
    private ConversionToAndFromSI()
    {
        // utility constructor.
    }

    /**
     * Create some scalar values to demonstrate conversion from and to related units.
     * @param args the command line arguments; not used
     */
    public static void main(final String[] args)
    {
        Locale.setDefault(Locale.US); // Ensure that floating point values are printed using a dot (".")
        Length length = new Length(123, "km"); // Construct a Relative Length
        System.out.println("length is " + length); // prints 123.000km; i.e. uses original unit
        System.out.println("length in METER is " + length.toString(Length.Unit.METER)); // prints 1.230+05m
        System.out.println("si value is " + length.si()); // prints 123000.0
        Length delta = new Length(250, "mi");
        System.out.println("delta is " + delta); // prints 250.000mi
        System.out.println("length + delta is " + length.add(delta)); // prints 525.336km
        System.out.println("length + delta in km is " + (length.add(delta)).toString(Length.Unit.METER)); 
        // prints 5.253e+05m
    }
}
