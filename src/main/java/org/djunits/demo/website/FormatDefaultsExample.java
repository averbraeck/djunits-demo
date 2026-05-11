package org.djunits.demo.website;

import org.djunits.formatter.VectorFormat;
import org.djunits.quantity.Mass;
import org.djunits.vecmat.d3.Vector3;

/**
 * FormatDefaultsExample shows how to change defaults for the formatting.md documentation page.
 * <p>
 * Copyright (c) 2026-2026 Delft University of Technology, Jaffalaan 5, 2628 BX Delft, the Netherlands. All rights reserved. See
 * for project information <a href="https://djunits.org" target="_blank"> https://djutils.org</a>. The DJUNITS project is
 * distributed under a three-clause BSD-style license, which can be found at
 * <a href="https://djunits.org/docs/license.html" target="_blank"> https://djunits.org/docs/license.html</a>. <br>
 * @author Alexander Verbraeck
 */
public class FormatDefaultsExample
{
    /**
     * @param args not used
     */
    public static void main(final String[] args)
    {
        VectorFormat.Col.changeDefaults().setVectorPrefix("C").setCellSeparator(", ").setStartSymbol("[").setVariableLength();
        VectorFormat.Row.changeDefaults().setVectorPrefix("R");
        test();
    }

    /** show that it works. */
    private static void test()
    {
        var mvc = Vector3.Col.of(1, 2, 3, Mass.Unit.kg);
        var mvr = Vector3.Row.of(4, 5, 6, Mass.Unit.kg);
        System.out.println("mvc = " + mvc);
        System.out.println("mvr = " + mvr);
    }

}
