package org.djunits.demo.examples;

import java.util.Locale;

import org.djunits.quantity.Duration;

/**
 * TestLocalize.java.
 * <br><br>
 * Copyright (c) 2024-2026 Delft University of Technology, Jaffalaan 5, 2628 BX Delft, the Netherlands. All rights reserved. See
 * for project information <a href="https://djutils.org" target="_blank"> https://djutils.org</a>. The DJUTILS project is
 * distributed under a three-clause BSD-style license, which can be found at
 * <a href="https://djutils.org/docs/license.html" target="_blank"> https://djutils.org/docs/license.html</a>.
 * <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 */
public class TestLocalize
{

    /**
     * @param args not used
     */
    public static void main(final String[] args)
    {
        Duration durUS = Duration.of(2.0, "h");
        Locale.setDefault(Locale.forLanguageTag("nl"));
        Duration durNL = Duration.of(2.0, "u");
        System.out.println("NL\n" + durUS + " =?= " + durNL + ": " + durUS.eq(durNL));
        Duration durDay = Duration.of(1.0, "dag");
        System.out.println(durDay.toString(Duration.Unit.day));
        Locale.setDefault(Locale.US);
        System.out.println("US\n" + durUS + " =?= " + durNL + ": " + durUS.eq(durNL));
        System.out.println(durDay.toString(Duration.Unit.day));
    }

}
