package org.djunits.demo.examples;

import org.djunits.quantity.Length;

/**
 * Parsing values that have been formatted in different ways. <br>
 * <p>
 * Copyright (c) 2003-2026 Delft University of Technology, Jaffalaan 5, 2628 BX Delft, the Netherlands. All rights reserved.<br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * @author Alexander Verbraeck
 */
public final class Parsing
{
    /** */
    private Parsing()
    {
        // utility method
    }

    /**
     * @param args not used
     */
    public static void main(final String[] args)
    {
        Length l = new Length(100.0, Length.Unit.km);
        System.out.println(l.toString());
        System.out.println(Length.valueOf(l.toString()));

        String[] sa = new String[] {"80 mm", "+80 mm", "80.0 mm", "-80.00mm", "8E6mm", "-8E-3yd", "8.mm", "0m",
                "18.37823472346234623  mi"};
        for (String s : sa)
        {
            System.out.println(s + " -> " + Length.valueOf(s));
        }
    }

}
