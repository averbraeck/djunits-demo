package org.djunits.demo.website;

import org.djunits.quantity.Acceleration;
import org.djunits.quantity.Duration;
import org.djunits.quantity.Energy;
import org.djunits.quantity.Length;
import org.djunits.quantity.Mass;
import org.djunits.quantity.Speed;

/**
 * SpeedExample.java. <br>
 * <br>
 * Copyright (c) 2024-2024 Delft University of Technology, Jaffalaan 5, 2628 BX Delft, the Netherlands. All rights reserved. See
 * for project information <a href="https://djutils.org" target="_blank"> https://djutils.org</a>. The DJUTILS project is
 * distributed under a three-clause BSD-style license, which can be found at
 * <a href="https://djutils.org/docs/license.html" target="_blank"> https://djutils.org/docs/license.html</a>. <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class SpeedExample
{
    /** */
    private static void example()
    {
        Speed speed = new Speed(12, Speed.Unit.km_h);
        Length length = new Length(4, Length.Unit.mi);

        // Good:
        Duration howLongOK = length.divide(speed);

        // Does not compile; result would be a frequency:
        // Duration howLongWrong = speed.divide(length);

        // Does not compile; subtracting a length from a speed make no sense:
        // Speed other = speed.subtract(length);

        // Throws a UnitRuntimeException:
        // Acceleration acceleration = speed.multiply(speed).as(Acceleration.Unit.m_s2);

        // OK:
        Energy kineticEnergy = speed.multiply(speed).multiply(new Mass(3, Mass.Unit.kg).scaleBy(0.5)).as(Energy.Unit.J);
        System.out.println(kineticEnergy);
    }

    /** */
    private static void speed()
    {
        Speed speed1 = new Speed(30, Speed.Unit.mi_h);
        System.out.println("speed1:     " + speed1);
        Speed speed2 = new Speed(10, Speed.Unit.m_s);
        System.out.println("speed2:     " + speed2);
        Speed diff = speed1.subtract(speed2);

        // Default display unit will be SI unit for speed:
        System.out.println("difference: " + diff);

        // Change default display unit; internal SI value is unaltered:
        diff.setDisplayUnit(Speed.Unit.mi_s);
        System.out.println("difference: " + diff);

        // Works, but not mistake-safe:
        System.out.println("difference: " + diff.getInUnit(Speed.Unit.kt) + " kt");

        // Safer:
        System.out.println("difference: " + diff.toString(Speed.Unit.kt));

        // Programmer must be really sure that SI-unit is m/s:
        System.out.println("difference: " + diff.si() + " m/s (si)");

        // Safer:
        System.out.println("difference: " + diff.toString(Speed.Unit.SI) + " (si)");
        System.out.println("difference: " + diff.toString(Speed.Unit.km_h));
    }
    
    /** */
    private static void example2()
    {
        Duration s = Duration.of(20.0, "s");
        var s2 = s.multiply(s);
        var l = Length.of(10.0, "m");
        var a1 = l.divide(s2); // SIQuantity
        System.out.println("a1 = " + a1);
        System.out.println("a1.class = " + a1.getClass().getSimpleName());
        var a2 = a1.as(Acceleration.Unit.m_s2);
        System.out.println("a2 = " + a2);
        System.out.println("a2.class = " + a2.getClass().getSimpleName());
        var a3 = s2.as(Acceleration.Unit.m_s2);
    }
    
    /**
     * @param args not used
     */
    public static void main(final String[] args)
    {
        example2();
    }

}
