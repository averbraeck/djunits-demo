package org.djunits.demo.website;

import java.util.Locale;

import org.djunits.formatter.QuantityFormat;
import org.djunits.formatter.VectorFormat;
import org.djunits.quantity.Energy;
import org.djunits.quantity.Length;
import org.djunits.quantity.Mass;
import org.djunits.quantity.Temperature;
import org.djunits.vecmat.d3.Vector3;

/**
 * FormatExample contains the examples used in the formatting.md section of the manual.
 * <p>
 * Copyright (c) 2026-2026 Delft University of Technology, Jaffalaan 5, 2628 BX Delft, the Netherlands. All rights reserved. See
 * for project information <a href="https://djunits.org" target="_blank"> https://djutils.org</a>. The DJUNITS project is
 * distributed under a three-clause BSD-style license, which can be found at
 * <a href="https://djunits.org/docs/license.html" target="_blank"> https://djunits.org/docs/license.html</a>. <br>
 * @author Alexander Verbraeck
 */
public class FormatExample
{
    /** */
    private static void len()
    {
        Length l = Length.of(12.43, "mi");
        String s = l.format(QuantityFormat.defaults().setDisplayUnit("m").setGroupingSeparator(true));
        System.out.println(s);
    }

    /** */
    private static void loc()
    {
        Locale.setDefault(Locale.GERMANY);
        Length l = Length.of(12.43, "mi");
        String sDE = l.format(QuantityFormat.defaults().setDisplayUnit("m").setGroupingSeparator(true));
        System.out.println(sDE);
        String sUS = l.format(QuantityFormat.defaults().setLocale(Locale.US).setDisplayUnit("m").setGroupingSeparator(true));
        System.out.println(sUS);
        Locale.setDefault(Locale.US);
    }

    /** */
    private static void si()
    {
        var q = Energy.of(1.23, "kJ");
        var s = q.format(QuantityFormat.defaults().setSiUnits().setDotSeparator("&sdot;").setPowerPrefix("<sup>")
                .setPowerPostfix("</sup>").setDivider(false));
        System.out.println(s);
    }

    /** */
    private static void temp()
    {
        Temperature t = new Temperature(0.0, Temperature.Unit.degF);
        System.out.println(t.relativeTo(Temperature.Reference.CELSIUS).format(
                QuantityFormat.defaults().setDisplayUnit("K").setPrintReference().setReferencePrefix(" (relative to 0 ")));
    }

    /** */
    private static void qf()
    {
        Energy energy = new Energy(13.34, "GeV");
        System.out.println(energy.as(Energy.Unit.J).format(QuantityFormat.defaults().setAutoSiPrefix()));
    }

    /** col format. */
    public static final VectorFormat.Row COLFORMAT = VectorFormat.Row.defaults().setVectorPrefix("Col");

    /** row format. */
    public static final VectorFormat.Row ROWFORMAT = VectorFormat.Row.defaults().setVectorPrefix("Row");

    /** */
    private static void store()
    {
        var mvc = Vector3.Col.of(1, 2, 3, Mass.Unit.kg);
        var mvr = Vector3.Row.of(4, 5, 6, Mass.Unit.kg);
        System.out.println("mvc = " + mvc.format(COLFORMAT));
        System.out.println("mvr = " + mvr.format(ROWFORMAT));
    }

    /**
     * @param args not used
     */
    public static void main(final String[] args)
    {
        len();
        System.out.println();
        si();
        System.out.println();
        loc();
        System.out.println();
        temp();
        System.out.println();
        qf();
        System.out.println();
        store();
    }

}
