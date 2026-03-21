package org.djunits.demo.examples;

import org.djunits.quantity.Length;
import org.djunits.vecmat.d2.Matrix2x2;

/**
 * TestCopy.java. <br>
 * <br>
 * Copyright (c) 2024-2026 Delft University of Technology, Jaffalaan 5, 2628 BX Delft, the Netherlands. All rights reserved. See
 * for project information <a href="https://djutils.org" target="_blank"> https://djutils.org</a>. The DJUTILS project is
 * distributed under a three-clause BSD-style license, which can be found at
 * <a href="https://djutils.org/docs/license.html" target="_blank"> https://djutils.org/docs/license.html</a>. <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class TestCopy
{
    /** */
    private static void testM2x2()
    {
        var da = new double[] {1, 2, 3, 4};
        var m = Matrix2x2.of(da, Length.Unit.m);
        da[3] = 6;
        System.out.println(m);
    }

    /**
     * @param args not used
     */
    public static void main(final String[] args)
    {
        testM2x2();
    }

}
