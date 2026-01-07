package org.djunits.demo.examples;

import org.djunits.old.unit.SIUnit;
import org.djunits.old.unit.util.UnitException;
import org.djunits.old.value.vdouble.scalar.SIScalar;
import org.djunits.old.value.vdouble.vector.SIVector;
import org.djunits.old.value.vdouble.vector.data.DoubleVectorDataDense;

/**
 * NewTypes.java.
 * <p>
 * Copyright (c) 2019-2025 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author Alexander Verbraeck
 */
public final class NewTypes
{
    /** */
    private NewTypes()
    {
        // utility class
    }

    /**
     * @param args empty
     * @throws UnitException when unit cannot be created
     */
    public static void main(final String[] args) throws UnitException
    {
        SIScalar jerkScalar = new SIScalar(2.0, SIUnit.of("m/s3"));
        SIVector jerkVector = new SIVector(new DoubleVectorDataDense(new double[] {1.0, 2.0, 3.0}), SIUnit.of("ms-3"));
        SIScalar jerk2 = jerkVector.get(1);
        System.out.println("jerkVector: " + jerkVector);
        System.out.println("jerkScalar: " + jerkScalar + " ?= " + jerk2 + ": " + jerkScalar.eq(jerk2));
    }

}
