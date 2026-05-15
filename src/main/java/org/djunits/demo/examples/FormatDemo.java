package org.djunits.demo.examples;

import java.util.Locale;

import org.djunits.formatter.QuantityFormat;
import org.djunits.formatter.VectorFormat;
import org.djunits.quantity.Area;
import org.djunits.quantity.Energy;
import org.djunits.quantity.LinearObjectDensity;
import org.djunits.quantity.Mass;
import org.djunits.quantity.Pressure;
import org.djunits.quantity.Temperature;
import org.djunits.vecmat.d3.Vector3;

/**
 * Demonstrate different formatting options for quantities, absolute quantities and vectors.
 * <p>
 * Copyright (c) 2026-2026 Delft University of Technology, Jaffalaan 5, 2628 BX Delft, the Netherlands. All rights reserved. See
 * for project information <a href="https://djunits.org" target="_blank"> https://djunits.org</a>. The DJUNITS project is
 * distributed under a three-clause BSD-style license, which can be found at
 * <a href="https://djunits.org/docs/license.html" target="_blank"> https://djunits.org/docs/license.html</a>. <br>
 * @author Alexander Verbraeck
 */
public class FormatDemo
{

    /**
     * @param args not used
     */
    public static void main(final String[] args)
    {
        var l = new Energy(998_432.123, Energy.Unit.MJ);
        System.out.println(l);
        System.out.println(l.format(QuantityFormat.instance().setWidth(10).setGroupingSeparator(true)));
        System.out.println(l.format(QuantityFormat.instance().setWidth(10).setGroupingSeparator(false)));
        System.out.println(l.format(QuantityFormat.instance().setLocale(Locale.FRANCE).setDisplayUnit(Energy.Unit.kWh)));
        System.out.println(l.format(QuantityFormat.instance().setSiUnits().setDotSeparator(".").setPowerPrefix("^")));
        System.out.println(l.format(QuantityFormat.instance().setAutoSiPrefix()));

        System.out.println();

        System.out.println(l.format(QuantityFormat.instance().setWidth(12).setGroupingSeparator(true)));
        System.out.println(l.format(QuantityFormat.instance().setWidth(12).setGroupingSeparator(false)));
        System.out.println(
                l.format(QuantityFormat.instance().setWidth(12).setLocale(Locale.FRANCE).setDisplayUnit(Energy.Unit.kWh)));
        System.out.println(
                l.format(QuantityFormat.instance().setWidth(12).setSiUnits().setDotSeparator(".").setPowerPrefix("^")));
        System.out.println(l.format(QuantityFormat.instance().setWidth(12).setAutoSiPrefix()));

        System.out.println();

        var p = new Pressure(145.008723, Pressure.Unit.hPa);
        System.out.println(p);
        System.out.println(p.format(QuantityFormat.instance().setAutoSiPrefix()));

        System.out.println();

        var m = new Mass(0.000864, Mass.Unit.kg);
        System.out.println(m);
        System.out.println(m.format(QuantityFormat.instance().setAutoSiPrefix()));

        System.out.println();

        var m2 = new Mass(0.864, Mass.Unit.g);
        System.out.println(m2);
        System.out.println(m2.format(QuantityFormat.instance().setAutoSiPrefix()));

        System.out.println();

        var od = new LinearObjectDensity(0.5, "/mm");
        System.out.println(od);
        System.out.println(od.format(QuantityFormat.instance().setAutoSiPrefix()));

        System.out.println();

        var v3 = Vector3.Col.of(3, 4, 5, Area.Unit.in2);
        System.out.println(v3.format(VectorFormat.Col.instance()));

        System.out.println();
        var v4 = v3.transpose();
        System.out.println(v4
                .format(VectorFormat.Row.instance().setDisplayUnit(Area.Unit.cm2).setFixedFloat().setWidth(1).setDecimals(3)));

        System.out.println();

        var t = new Temperature(20.0, "degC");
        System.out.println(t.format(QuantityFormat.instance().setDisplay()));
        System.out.println(t.format(QuantityFormat.instance().setTextual()));
        System.out.println(t.format(QuantityFormat.instance().setDisplay().setPrintReference()
                .setReferencePrefix(" (relative to 0 ").setReferencePostfix(")")));
    }
}
