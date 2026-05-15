package org.djunits.demo.examples;

import java.util.Locale;

import org.djunits.formatter.QuantityFormat;
import org.djunits.quantity.Duration;
import org.djunits.quantity.Length;
import org.djunits.quantity.SIQuantity;
import org.djunits.quantity.Speed;

/**
 * This Java code demonstrates conversions between related unit using DJUNITS.
 * <p>
 * Copyright (c) 2015-2026 Delft University of Technology, Jaffalaan 5, 2628 BX Delft, the Netherlands. All rights reserved. See
 * for project information <a href="https://djunits.org" target="_blank"> https://djutils.org</a>. The DJUNITS project is
 * distributed under a three-clause BSD-style license, which can be found at
 * <a href="https://djunits.org/docs/license.html" target="_blank"> https://djunits.org/docs/license.html</a>.
 * <br>
 * @author Alexander Verbraeck
 * @author Peter Knoppers
 */
public final class LocaleDemo
{
    /** */
    private LocaleDemo()
    {
        // utility constructor.
    }

    /**
     * Create some scalar values to demonstrate conversion from and to related units.
     * @param args the command line arguments; not used
     */
    public static void main(final String[] args)
    {
        System.out.println("\nPrinting US");
        Locale.setDefault(Locale.US);
        Duration hour = new Duration(3.0, Duration.Unit.h);
        System.out.println(hour.format(QuantityFormat.instance().setTextual()));
        System.out.println(hour);

        System.out.println("\nPrinting NL");
        Locale.setDefault(Locale.forLanguageTag("NL"));
        System.out.println(hour.format(QuantityFormat.instance().setTextual()));
        System.out.println(hour);

        System.out.println("\nParsing UK");
        Locale.setDefault(new Locale("en", "UK"));
        Speed speed = Speed.valueOf("14.2 km/h");
        System.out.println(speed.format(QuantityFormat.instance().setTextual()));
        System.out.println(speed.format(QuantityFormat.instance().setDisplay()));
        System.out.println(speed);

        try
        {
            speed = Speed.valueOf("14.2 km/u");
            System.err.println("WRONG, should not be able to parse 14.2 km/u in UK locale");
        }
        catch (Exception e)
        {
            System.out.println("Correctly failed to parse 14.2 km/u in UK locale");
        }

        System.out.println("\nParsing NL");
        Locale.setDefault(new Locale("nl", "NL"));
        speed = Speed.valueOf("14,2 km/u");
        System.out.println(speed.format(QuantityFormat.instance().setTextual()));
        System.out.println(speed.format(QuantityFormat.instance().setDisplay()));
        System.out.println(speed);

        try
        {
            speed = Speed.valueOf("14.2 km/z");
            System.err.println("WRONG, should not be able to parse 14.2 km/z in NL locale");
        }
        catch (Exception e)
        {
            System.out.println("Correctly failed to parse 14.2 km/z in NL locale");
        }

        try
        {
            speed = Speed.valueOf("14,2 km/z");
            System.err.println("WRONG, should not be able to parse 14,2 km/z in NL locale");
        }
        catch (Exception e)
        {
            System.out.println("Correctly failed to parse 14,2 km/z in NL locale");
        }

        try
        {
            speed = Speed.valueOf("18,99 km/h");
            System.out.println("Correctly parsed 18.99 km/h using fallback locale as "
                    + speed.format(QuantityFormat.instance().setDisplay()));
        }
        catch (Exception e)
        {
            System.err.println("WRONG, should not be fail on parsing 18.99 km/h in NL locale -- fallback should be ok");
        }

        System.out.println("\nPrinting NL");
        Locale.setDefault(Locale.forLanguageTag("NL"));
        System.out.println(new Speed(1234455466787.0, Speed.Unit.mi_h).format(QuantityFormat.instance().setDisplay()));
        System.out.println(new Speed(1230000000000.0, Speed.Unit.mi_h).format(QuantityFormat.instance().setDisplay()));
        System.out.println(new Speed(0.112, Speed.Unit.mi_h).format(QuantityFormat.instance().setDisplay()));
        System.out.println(new Speed(0.000112, Speed.Unit.kt).format(QuantityFormat.instance().setTextual()));
        System.out.println(new Speed(1E40, Speed.Unit.mi_h).format(QuantityFormat.instance().setDisplay()));

        System.out.println("\nPrinting US");
        Locale.setDefault(Locale.US);
        System.out.println(new Speed(1234455466787.0, Speed.Unit.mi_h).format(QuantityFormat.instance().setDisplay()));
        System.out.println(new Speed(1230000000000.0, Speed.Unit.mi_h).format(QuantityFormat.instance().setDisplay()));
        System.out.println(new Speed(0.112, Speed.Unit.mi_h).format(QuantityFormat.instance().setDisplay()));
        System.out.println(new Speed(0.000112, Speed.Unit.kt).format(QuantityFormat.instance().setTextual()));
        System.out.println(new Speed(1E40, Speed.Unit.mi_h).format(QuantityFormat.instance().setDisplay()));

        System.out.println("\nPrinting SI value NL");
        Locale.setDefault(Locale.forLanguageTag("NL"));
        Duration d = Duration.valueOf("10,0 u");
        Length l = Length.valueOf("5,0 km");
        SIQuantity pace = d.divide(l);
        System.out.println("pace has as unit " + pace.getDisplayUnit().toString());
        System.out.println("pace = " + pace.toString());

        System.out.println("\nPrinting SI value US");
        Locale.setDefault(Locale.US);
        System.out.println("pace has as unit " + pace.getDisplayUnit().toString());
        System.out.println("pace = " + pace.toString());

        // check the no-NO locale
        System.out.println("\nPrinting SI value no-NO");
        Locale.setDefault(Locale.forLanguageTag("no-NO"));
        Duration dNo = Duration.valueOf("10,0 h");
        Length lNo = Length.valueOf("5,0 km");
        pace = dNo.divide(lNo);
        System.out.println("pace has as unit " + pace.getDisplayUnit().toString());
        System.out.println("pace = " + pace.toString());
    }
}
