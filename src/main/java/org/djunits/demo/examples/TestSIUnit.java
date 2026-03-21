package org.djunits.demo.examples;

import org.djunits.unit.si.SIUnit;

/**
 * TestSIUnit.java.
 * <br><br>
 * Copyright (c) 2024-2026 Delft University of Technology, Jaffalaan 5, 2628 BX Delft, the Netherlands. All rights reserved. See
 * for project information <a href="https://djutils.org" target="_blank"> https://djutils.org</a>. The DJUTILS project is
 * distributed under a three-clause BSD-style license, which can be found at
 * <a href="https://djutils.org/docs/license.html" target="_blank"> https://djutils.org/docs/license.html</a>.
 * <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class TestSIUnit
{

    /**
     * @param args not used
     */
    public static void main(final String[] args)
    {
        SIUnit acc1 = new SIUnit(new int[] {0, 0, 0, 1, -2, 0, 0, 0, 0});
        SIUnit acc2 = new SIUnit(0, 0, 0, 1, -2, 0, 0, 0, 0);
        SIUnit acc3 = SIUnit.of("m/s2");
        
        System.out.println("acc1 = " + acc1);
        System.out.println("acc1 = " + acc1.toString(true, true));
        System.out.println("acc1 == acc2 : " + acc1.equals(acc2));
        System.out.println("acc1 == acc3 : " + acc1.equals(acc3));
    }

}
