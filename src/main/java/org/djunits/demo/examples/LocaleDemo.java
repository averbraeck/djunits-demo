package org.djunits.demo.examples;

import java.util.Locale;

import org.djunits.unit.DurationUnit;
import org.djunits.unit.SpeedUnit;
import org.djunits.unit.util.UNITS;
import org.djunits.value.vdouble.scalar.Duration;
import org.djunits.value.vdouble.scalar.Length;
import org.djunits.value.vdouble.scalar.SIScalar;
import org.djunits.value.vdouble.scalar.Speed;

/**
 * This Java code demonstrates conversions between related unit using DJUNITS.
 * <p>
 * Copyright (c) 2015-2025 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @version $Revision: 672 $, $LastChangedDate: 2019-10-18 14:32:01 +0200 (Fri, 18 Oct 2019) $, by $Author: averbraeck $,
 *          initial version 3 sep. 2015 <br>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public final class LocaleDemo implements UNITS
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
        Duration hour = new Duration(3.0, DurationUnit.HOUR);
        System.out.println(hour.toTextualString());
        System.out.println(hour);

        System.out.println("\nPrinting NL");
        Locale.setDefault(Locale.forLanguageTag("NL"));
        System.out.println(hour.toTextualString());
        System.out.println(hour);

        System.out.println("\nParsing UK");
        Locale.setDefault(new Locale("en", "UK"));
        Speed speed = Speed.valueOf("14.2 km/h");
        System.out.println(speed.toTextualString());
        System.out.println(speed.toDisplayString());
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
        System.out.println(speed.toTextualString());
        System.out.println(speed.toDisplayString());
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
            System.out.println("Correctly parsed 18.99 km/h using fallback locale as " + speed.toDisplayString());
        }
        catch (Exception e)
        {
            System.err.println("WRONG, should not be fail on parsing 18.99 km/h in NL locale -- fallback should be ok");
        }

        System.out.println("\nPrinting NL");
        Locale.setDefault(Locale.forLanguageTag("NL"));
        System.out.println(new Speed(1234455466787.0, SpeedUnit.MILE_PER_HOUR).toDisplayString());
        System.out.println(new Speed(1230000000000.0, SpeedUnit.MILE_PER_HOUR).toDisplayString());
        System.out.println(new Speed(0.112, SpeedUnit.MILE_PER_HOUR).toDisplayString());
        System.out.println(new Speed(0.000112, SpeedUnit.KNOT).toTextualString());
        System.out.println(new Speed(1E40, SpeedUnit.MILE_PER_HOUR).toDisplayString());

        System.out.println("\nPrinting US");
        Locale.setDefault(Locale.US);
        System.out.println(new Speed(1234455466787.0, SpeedUnit.MILE_PER_HOUR).toDisplayString());
        System.out.println(new Speed(1230000000000.0, SpeedUnit.MILE_PER_HOUR).toDisplayString());
        System.out.println(new Speed(0.112, SpeedUnit.MILE_PER_HOUR).toDisplayString());
        System.out.println(new Speed(0.000112, SpeedUnit.KNOT).toTextualString());
        System.out.println(new Speed(1E40, SpeedUnit.MILE_PER_HOUR).toDisplayString());

        System.out.println("\nPrinting SI value NL");
        Locale.setDefault(Locale.forLanguageTag("NL"));
        Duration d = Duration.valueOf("10,0 uur");
        Length l = Length.valueOf("5,0 km");
        SIScalar pace = SIScalar.divide(d, l);
        System.out.println("pace has as unit " + pace.getDisplayUnit().toString());
        System.out.println("pace = " + pace.toString());

        System.out.println("\nPrinting SI value US");
        Locale.setDefault(Locale.US);
        System.out.println("pace has as unit " + pace.getDisplayUnit().toString());
        System.out.println("pace = " + pace.toString());

    }
}
