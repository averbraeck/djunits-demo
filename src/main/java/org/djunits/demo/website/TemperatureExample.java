package org.djunits.demo.website;

import org.djunits.formatter.QuantityFormat;
import org.djunits.quantity.Temperature;
import org.djunits.quantity.TemperatureDifference;

/**
 * TemperatureExample for the absolute_quantity.md page.
 * <p>
 * Copyright (c) 2026-2026 Delft University of Technology, Jaffalaan 5, 2628 BX Delft, the Netherlands. All rights reserved. See
 * for project information <a href="https://djunits.org" target="_blank"> https://djutils.org</a>. The DJUNITS project is
 * distributed under a three-clause BSD-style license, which can be found at
 * <a href="https://djunits.org/docs/license.html" target="_blank"> https://djunits.org/docs/license.html</a>. <br>
 * @author Alexander Verbraeck
 */
public class TemperatureExample
{
    /**
     * @param args not used
     */
    public static void main(final String[] args)
    {
        Temperature t = new Temperature(0.0, Temperature.Unit.degF);
        System.out.println("Temperature t = " + t);
        
        // add 32 degrees Fahrenheit - should be 0 Celsius
        System.out.println("\nAdd 32 degrees Fahrenheit - should be 0 Celsius");
        TemperatureDifference t32 = new TemperatureDifference(32.0, Temperature.Unit.degF);
        Temperature t2 = t.add(t32);
        System.out.println("Temperature t2 = " + t2);
        System.out.println("t2 in Kelvin   = " + t2.relativeTo(Temperature.Reference.KELVIN).format(Temperature.Unit.K));
        System.out.println("t2 in Celsius  = " + t2.relativeTo(Temperature.Reference.CELSIUS).format(Temperature.Unit.degC));

        // show that absolute values can be shown relative to different reference points
        System.out.println("\nTemperature t  = " + t + ", si = " + t.si());
        System.out.println("t in Kelvin    = " + t.format(QuantityFormat.instance().setDisplayUnit(Temperature.Unit.K)
                .setPrintReference().setReferencePrefix(" (relative to 0 ")));
        System.out.println("t in Celsius   = " + t.format(QuantityFormat.instance().setDisplayUnit(Temperature.Unit.degC)
                .setPrintReference().setReferencePrefix(" (relative to 0 ")));
    }

}
