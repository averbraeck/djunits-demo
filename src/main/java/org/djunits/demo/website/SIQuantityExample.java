package org.djunits.demo.website;

import org.djunits.quantity.AmountOfSubstance;
import org.djunits.quantity.Energy;
import org.djunits.quantity.SIQuantity;
import org.djunits.quantity.TemperatureDifference;
import org.djunits.unit.si.SIUnit;

/**
 * SIQuantityExample contains the code of the si_quantity.md documentation file.
 * <p>
 * Copyright (c) 2026-2026 Delft University of Technology, Jaffalaan 5, 2628 BX Delft, the Netherlands. All rights reserved. See
 * for project information <a href="https://djunits.org" target="_blank"> https://djutils.org</a>. The DJUNITS project is
 * distributed under a three-clause BSD-style license, which can be found at
 * <a href="https://djunits.org/docs/license.html" target="_blank"> https://djunits.org/docs/license.html</a>. <br>
 * @author Alexander Verbraeck
 */
public class SIQuantityExample
{
    /**
     * @param args not used
     */
    public static void main(final String[] args)
    {
        var entropyWater = new SIQuantity(70.0, SIUnit.of("kg.m2.s-2.K-1.mol-1"));
        System.out.println(entropyWater);
        Energy energy = entropyWater.multiply(TemperatureDifference.of(1.0, "K")).multiply(AmountOfSubstance.of(1.0, "mol"))
                .as(Energy.Unit.J);
        System.out.println(energy);
        System.out.println();

        SIUnit acc1 = new SIUnit(new int[] {0, 0, 0, 1, -2, 0, 0, 0, 0});
        SIUnit acc2 = new SIUnit(0, 0, 0, 1, -2, 0, 0, 0, 0);
        SIUnit acc3 = SIUnit.of("m/s2");

        System.out.println("acc1 = " + acc1.toArrayString());
        System.out.println("acc1 = " + acc1.format(true, true));
        System.out.println("acc1 equals acc2 : " + acc1.equals(acc2));
        System.out.println("acc1 equals acc3 : " + acc1.equals(acc3));
    }

}
