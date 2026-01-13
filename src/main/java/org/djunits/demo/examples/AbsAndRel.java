package org.djunits.demo.examples;

import org.djunits.quantity.Temperature;
import org.djunits.quantity.TemperatureDifference;

/**
 * Small demo of absolute and relative quantities.
 * <p>
 * Copyright (c) 2013-2025 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author Alexander Verbraeck
 */
public final class AbsAndRel
{
    /** */
    private AbsAndRel()
    {
        //
    }

    /**
     * @param args args
     */
    public static void main(final String[] args)
    {
        Temperature t = new Temperature(0.0, Temperature.Unit.degF);
        System.out.println("Temperature t  = " + t + ", si = " + t.si());
        System.out.println("t in Kelvin    = " + t.toString(Temperature.Unit.K));
        System.out.println("t in Celsius   = " + t.toString(Temperature.Unit.degC));

        // add 32 degrees Fahrenheit - should be 0 Celsius
        System.out.println("\nadd 32 degrees Fahrenheit - should be 0 Celsius");
        TemperatureDifference t32 = new TemperatureDifference(32.0, Temperature.Unit.degF);
        Temperature t2 = t.add(t32);
        System.out.println("Temperature t2 = " + t2);
        System.out.println("t2 in Kelvin   = " + t2.relativeTo(Temperature.Reference.KELVIN).toString(Temperature.Unit.K));
        System.out.println("t2 in Celsius  = " + t2.relativeTo(Temperature.Reference.CELSIUS).toString(Temperature.Unit.degC));

        // The other way around to add 32 degrees Fahrenheit should also be 0 Celsius
        System.out.println("\nThe other way around to add 32 degrees Fahrenheit should also be 0 Celsius");
        Temperature t3 = t32.add(t);
        System.out.println("Temperature t3 = " + t3);
        System.out.println("t3 in Kelvin   = " + t3.relativeTo(Temperature.Reference.KELVIN).toString(Temperature.Unit.K));
        System.out.println("t3 in Celsius  = " + t3.relativeTo(Temperature.Reference.CELSIUS).toString(Temperature.Unit.degC));

        // Subtraction - should yield a difference of 32 degrees Fahrenheit (17.78 K/Celcius)
        System.out.println("\nSubtraction - should yield a difference of 32 degrees Fahrenheit (17.78 K/Celcius)");
        TemperatureDifference t4 = t3.subtract(t);
        System.out.println("Temperature t4 = " + t4);
        System.out.println("t4 in Kelvin   = " + t4.toString(Temperature.Unit.K));
        System.out.println("t4 in Celsius  = " + t4.toString(Temperature.Unit.degC));

    }

}
