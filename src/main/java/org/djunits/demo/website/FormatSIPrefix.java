package org.djunits.demo.website;

import org.djunits.formatter.QuantityFormat;
import org.djunits.quantity.Energy;
import org.djunits.quantity.Length;
import org.djunits.quantity.LinearObjectDensity;
import org.djunits.quantity.Mass;

/**
 * FormatSIPrefix contains the examples for automatic SI prefix formatting used in the formatting.md section of the manual.
 * <p>
 * Copyright (c) 2026-2026 Delft University of Technology, Jaffalaan 5, 2628 BX Delft, the Netherlands. All rights reserved. See
 * for project information <a href="https://djunits.org" target="_blank"> https://djutils.org</a>. The DJUNITS project is
 * distributed under a three-clause BSD-style license, which can be found at
 * <a href="https://djunits.org/docs/license.html" target="_blank"> https://djunits.org/docs/license.html</a>. <br>
 * @author Alexander Verbraeck
 */
public class FormatSIPrefix
{
    /** */
    private static void siPrefixMassNeg()
    {
        Mass weight = Mass.ONE;
        for (int i = -15; i < 9; i++)
        {
            System.out.println(weight.scaleBy(Math.pow(10.0, i))
                    .format(QuantityFormat.defaults().setFixedWithSciFallback().setDecimals(1).setAutoSiPrefix(-9, 0)));
        }
    }

    /** */
    private static void siPrefixMass()
    {
        Mass weight = Mass.ONE;
        for (int i = -9; i < 9; i++)
        {
            System.out.println(weight.scaleBy(Math.pow(10.0, i))
                    .format(QuantityFormat.defaults().setFixedWithSciFallback().setDecimals(1).setAutoSiPrefix(-3, 3)));
        }
    }

    /** */
    private static void siPrefixLength()
    {
        Length length = Length.ONE;
        for (int i = -9; i < 9; i++)
        {
            System.out.println(length.scaleBy(Math.pow(10.0, i))
                    .format(QuantityFormat.defaults().setFixedWithSciFallback().setDecimals(1).setAutoSiPrefix(-3, 3)));
        }
    }

    /** */
    private static void siPrefixEnergy()
    {
        Energy energy = Energy.ONE;
        for (int i = -36; i < 36; i++)
        {
            System.out.println(energy.scaleBy(Math.pow(10.0, i))
                    .format(QuantityFormat.defaults().setFixedWithSciFallback().setDecimals(3).setAutoSiPrefix()));
        }
    }

    /** */
    private static void siPrefixLOD()
    {
        LinearObjectDensity lod = LinearObjectDensity.ONE;
        for (int i = -36; i < 36; i++)
        {
            var scaled = lod.scaleBy(Math.pow(10.0, i));
            System.out.println(scaled.format(QuantityFormat.defaults().setScientific()) + "  " + scaled
                    .format(QuantityFormat.defaults().setFixedWithSciFallback().setDecimals(3).setAutoSiPrefix()));
        }
    }

    /** */
    private static void siPrefixPerMassAll()
    {
        PerMass pm = PerMass.ONE;
        for (int i = -40; i < 40; i++)
        {
            var scaled = pm.scaleBy(Math.pow(10.0, i));
            System.out.println(scaled.format(QuantityFormat.defaults().setScientific()) + "  " + scaled
                    .format(QuantityFormat.defaults().setFixedWithSciFallback().setDecimals(3).setAutoSiPrefix()));
        }
    }

    /** */
    private static void siPrefixDensity()
    {
        LinearObjectDensity lod = LinearObjectDensity.ONE;
        for (int i = -9; i < 12; i++)
        {
            System.out.println(lod.scaleBy(Math.pow(10.0, i))
                    .format(QuantityFormat.defaults().setFixedWithSciFallback().setDecimals(1).setAutoSiPrefix(-6, 3)));
        }
    }

    /** */
    private static void siPrefixPerMass()
    {
        PerMass pm = PerMass.ONE;
        for (int i = -9; i < 12; i++)
        {
            System.out.println(pm.scaleBy(Math.pow(10.0, i))
                    .format(QuantityFormat.defaults().setFixedWithSciFallback().setDecimals(1).setAutoSiPrefix(-6, 3)));
        }
    }

    /** */
    private static void siPrefixTranslate()
    {
        Energy energy = Energy.of(6.0, "MeV");
        System.out.println(energy.format(QuantityFormat.defaults().setAutoSiPrefix()));
    }

    /**
     * @param args not used
     */
    public static void main(final String[] args)
    {
        System.out.println("\nENERGY, min/max = default");
        siPrefixEnergy();
        System.out.println("\nLOD, min/max = default");
        siPrefixLOD();
        System.out.println("\nPER MASS, min/max = default");
        siPrefixPerMassAll();
        System.out.println("\nLENGTH, min/max = -3/3");
        siPrefixLength();
        System.out.println("\nMASS, min/max = -3/3");
        siPrefixMass();
        System.out.println("\nMASS, min/max = -9/0");
        siPrefixMassNeg();
        System.out.println("\nLINEAR OBJECT DENSITY, min/max = -6/3");
        siPrefixDensity();
        System.out.println("\nPER_MASS, min/max = -6/3");
        siPrefixPerMass();
        System.out.println("\nAUTO-TRANSLATE");
        siPrefixTranslate();
    }

}
