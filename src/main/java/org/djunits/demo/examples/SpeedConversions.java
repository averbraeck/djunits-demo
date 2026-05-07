package org.djunits.demo.examples;

import org.djunits.quantity.Duration;
import org.djunits.quantity.Energy;
import org.djunits.quantity.Length;
import org.djunits.quantity.Mass;
import org.djunits.quantity.Speed;

/** demo for conversions. */
public final class SpeedConversions
{
    /** */
    private SpeedConversions()
    {
        // utility constructor.
    }

    /**
     * @param args not used
     */
    public static void main(final String[] args)
    {
        example1();
        System.out.println();
        example2();
    }

    /** example 1. */
    public static void example1()
    {
        Speed speed1 = new Speed(30, Speed.Unit.mi_h);
        System.out.println("speed1:     " + speed1);
        Speed speed2 = new Speed(10, Speed.Unit.m_s);
        System.out.println("speed2:     " + speed2);
        Speed diff = speed1.subtract(speed2);
        System.out.println("difference: " + diff); // Default display unit will be SI unit for speed
        diff.setDisplayUnit(Speed.Unit.mi_h); // Change default display unit; internal SI value is unaltered
        System.out.println("difference: " + diff);
        System.out.println("difference: " + diff.getInUnit(Speed.Unit.kt) + " kt"); // Works, but not mistake-safe
        System.out.println("difference: " + diff.format(Speed.Unit.kt)); // Safer
        System.out.println("difference: " + diff.si + " m/s (si)"); // Programmer must be really sure that SI-unit is m/s
        System.out.println("difference: " + diff.si() + " m/s (si)"); // Same as previous
        System.out.println("difference: " + diff.format(Speed.Unit.SI) + " (si)"); // Safer
        System.out.println("difference: " + diff.format(Speed.Unit.km_h));
    }

    /** example 2. */
    public static void example2()
    {
        Speed speed = new Speed(12, Speed.Unit.km_h);
        Length length = new Length(4, Length.Unit.mi);
        Duration howLongOK = length.divide(speed); // Good
        System.out.println(howLongOK);

        // Duration howLongWrong = speed.divide(length);
        // Does not compile; result would be a frequency

        // Speed other = speed.minus(length);
        // Does not compile; subtracting a length from a speed makes no sense

        // Acceleration acceleration = speed.times(speed).asAcceleration();
        // Throws a UnitRuntimeException

        Energy kineticEnergy = speed.multiply(speed).multiply(new Mass(3, Mass.Unit.kg).scaleBy(0.5)).as(Energy.Unit.J); // OK
        System.out.println(kineticEnergy);
    }

}
