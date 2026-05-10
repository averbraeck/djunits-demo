package org.djunits.demo.website;

import org.djunits.quantity.Duration;
import org.djunits.quantity.Length;
import org.djunits.quantity.Speed;
import org.djunits.vecmat.dn.VectorN;

/**
 * VectorExample provides the examples on the vector.md documentation .
 * <p>
 * Copyright (c) 2026-2026 Delft University of Technology, Jaffalaan 5, 2628 BX Delft, the Netherlands. All rights reserved. See
 * for project information <a href="https://djunits.org" target="_blank"> https://djutils.org</a>. The DJUNITS project is
 * distributed under a three-clause BSD-style license, which can be found at
 * <a href="https://djunits.org/docs/license.html" target="_blank"> https://djunits.org/docs/license.html</a>. <br>
 * @author Alexander Verbraeck
 */
public class VectorExample
{
    /**
     * @param args not used
     */
    public static void main(final String[] args)
    {
        VectorN.Row<Length> lv1 = VectorN.Row.of(new double[] {10, 20.0, 60, 120.0, 400.0}, Length.Unit.km);
        Duration duration = Duration.of(2.0, "h");
        VectorN.Row<Speed> sv1 = lv1.divideEntries(duration).as(Speed.Unit.km_h);
        System.out.println("Length: " + lv1);
        System.out.println("Speed : " + sv1);
    }

}
