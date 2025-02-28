package org.djunits.demo.website;

import org.djunits.value.vdouble.vector.base.DoubleVectorRel;
import org.djunits.value.vdouble.vector.data.DoubleVectorData;

/**
 * Double JerkVector, a vector of values with a JerkUnit.
 * <p>
 * Copyright (c) 2013-2025 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class JerkVector extends DoubleVectorRel<JerkUnit, Jerk, JerkVector>
{
    /** */
    private static final long serialVersionUID = 20190905L;

    /**
     * Construct an JerkVector from an internal data object.
     * @param data the internal data object for the vector data
     * @param displayUnit the display unit of the vector data
     */
    public JerkVector(final DoubleVectorData data, final JerkUnit displayUnit)
    {
        super(data, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Class<Jerk> getScalarClass()
    {
        return Jerk.class;
    }

    /** {@inheritDoc} */
    @Override
    public JerkVector instantiateVector(final DoubleVectorData dvd, final JerkUnit displayUnit)
    {
        return new JerkVector(dvd, displayUnit);
    }

    /** {@inheritDoc} */
    @Override
    public Jerk instantiateScalarSI(final double valueSI, final JerkUnit displayUnit)
    {
        Jerk result = Jerk.instantiateSI(valueSI);
        result.setDisplayUnit(displayUnit);
        return result;
    }

}
