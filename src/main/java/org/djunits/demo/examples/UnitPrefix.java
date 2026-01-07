package org.djunits.demo.examples;

import java.util.Map;

import org.djunits.old.unit.AreaUnit;
import org.djunits.old.unit.ElectricalChargeUnit;
import org.djunits.old.unit.FrequencyUnit;
import org.djunits.old.unit.LengthUnit;
import org.djunits.old.unit.LinearDensityUnit;
import org.djunits.old.unit.MassUnit;
import org.djunits.old.unit.Unit;
import org.djunits.old.unit.VolumeUnit;

/**
 * UnitPrefix.java.
 * <p>
 * Copyright (c) 2019-2025 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author Alexander Verbraeck
 */
public final class UnitPrefix
{
    /** */
    private UnitPrefix()
    {
        // utility class
    }

    /**
     * @param args not used
     */
    public static void main(final String[] args)
    {
        print(LengthUnit.BASE.getUnitsByAbbreviation());
        print(AreaUnit.BASE.getUnitsByAbbreviation());
        print(VolumeUnit.BASE.getUnitsByAbbreviation());
        print(ElectricalChargeUnit.BASE.getUnitsByAbbreviation());
        print(MassUnit.BASE.getUnitsByAbbreviation());
        print(LinearDensityUnit.BASE.getUnitsByAbbreviation());
        print(FrequencyUnit.BASE.getUnitsByAbbreviation());
    }

    /**
     * @param unitMap the map to print
     */
    private static void print(final Map<String, ? extends Unit<?>> unitMap)
    {
        System.out.println();
        for (String ab : unitMap.keySet())
        {
            Unit<?> unit = unitMap.get(ab);
            System.out.println((ab + "        ").substring(0, 8) + (unit.getId() + "        ").substring(0, 8) + "  "
                    + (unit.getName() + "                        ").substring(0, 24) + "   "
                    + unit.getScale().toStandardUnit(1.0) + "   " + unit.getDefaultAbbreviations());
        }
    }
}
