package org.djunits.demo.website;

import org.djunits.quantity.Speed;

/**
 * SpeedExample for the index.md page. <br>
 * <br>
 * Copyright (c) 2024-2026 Delft University of Technology, Jaffalaan 5, 2628 BX Delft, the Netherlands. All rights reserved. See
 * for project information <a href="https://djunits.org" target="_blank"> https://djunits.org</a>. The DJUNITS project is
 * distributed under a three-clause BSD-style license, which can be found at
 * <a href="https://djunits.org/docs/license.html" target="_blank"> https://djunits.org/docs/license.html</a>. <br>
 * @author Alexander Verbraeck
 */
public class SpeedExample
{
    /** */
    private static void speed()
    {
        Speed speed1 = new Speed(30, Speed.Unit.mi_h);
        System.out.println("speed1:     " + speed1);
        Speed speed2 = new Speed(10, Speed.Unit.m_s);
        System.out.println("speed2:     " + speed2);
        Speed diff = speed1.subtract(speed2);

        // Display unit after 'subtract' will be the unit of speed1:
        System.out.println("difference: " + diff);

        // Change default display unit; internal SI value is unaltered:
        diff.setDisplayUnit(Speed.Unit.mi_s);
        System.out.println("difference: " + diff);

        // Works, but error-prone and not localizable:
        System.out.println("error-prone " + diff.getInUnit(Speed.Unit.kt) + " kt");

        // Safer, the unit is provided by the system and localizable:
        System.out.println("difference: " + diff.format(Speed.Unit.kt));
        System.out.println("difference: " + diff.format(Speed.Unit.km_h));
    }
    
    /**
     * @param args not used
     */
    public static void main(final String[] args)
    {
        speed();
    }

}
