package org.djunits.demo.website;

import org.djunits.quantity.def.Quantity;

/**
 * Test for building a new Jerk quantity.
 * <p>
 * Copyright (c) 2013-2026 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * @author Alexander Verbraeck
 * @author Peter Knoppers
 */
public class Jerk extends Quantity<Jerk, JerkUnit>
{
    /** */
    private static final long serialVersionUID = 1L;

    /**
     * Construct Jerk scalar.
     * @param value the double value
     * @param unit unit for the double value
     */
    public Jerk(final double value, final JerkUnit unit)
    {
        super(value, unit);
    }

    @Override
    public Jerk instantiate(final double siValue)
    {
        return new Jerk(siValue, JerkUnit.SI);
    }
}
