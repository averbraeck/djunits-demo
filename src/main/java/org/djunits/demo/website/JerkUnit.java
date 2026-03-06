package org.djunits.demo.website;

import org.djunits.quantity.Length;
import org.djunits.unit.AbstractUnit;
import org.djunits.unit.scale.IdentityScale;
import org.djunits.unit.scale.LinearScale;
import org.djunits.unit.scale.Scale;
import org.djunits.unit.si.SIUnit;
import org.djunits.unit.system.UnitSystem;

/**
 * Test for building a new JerkUnit for the Jerk quantity.
 * <p>
 * Copyright (c) 2013-2026 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * @author Alexander Verbraeck
 * @author Peter Knoppers
 */
public class JerkUnit extends AbstractUnit<JerkUnit, Jerk>
{
    /** The SI unit for jerk is m/s^3. */
    public static final JerkUnit SI =
            new JerkUnit("m/s3", "meter per second cubed", IdentityScale.SCALE, UnitSystem.SI_DERIVED);

    /** m/s3. */
    public static final JerkUnit m_s3 = SI;

    /** cm/s3. */
    public static final JerkUnit cm_s3 = SI.deriveUnit("cm/s3", "centimeter per second cubed", 0.01, UnitSystem.SI_DERIVED);

    /** mm/s3. */
    public static final JerkUnit mm_s3 = SI.deriveUnit("mm/s3", "millimeter per second cubed", 0.001, UnitSystem.SI_DERIVED);

    /** ft/s3. */
    public static final JerkUnit ft_s3 =
            SI.deriveUnit("ft/s3", "foot per second cubed", Length.Unit.CONST_FT, UnitSystem.IMPERIAL);

    /** in/s3. */
    public static final JerkUnit in_s3 =
            SI.deriveUnit("in/s3", "inch per second cubed", Length.Unit.CONST_IN, UnitSystem.IMPERIAL);

    /**
     * Generate a new Jerk unit.
     * @param textualAbbreviation the textual abbreviation to use
     * @param name the name of the unit
     * @param scale the scale to use
     * @param unitSystem the unit system
     */
    public JerkUnit(final String textualAbbreviation, final String name, final Scale scale, final UnitSystem unitSystem)
    {
        super(textualAbbreviation, name, scale, unitSystem);
    }

    /**
     * Generate a new Jerk unit.
     * @param textualAbbreviation the textual abbreviation to use
     * @param displayAbbreviation the display abbreviation to use
     * @param name the name of the unit
     * @param scale the scale to use
     * @param unitSystem the unit system
     */
    public JerkUnit(final String textualAbbreviation, final String displayAbbreviation, final String name, final Scale scale, final UnitSystem unitSystem)
    {
        super(textualAbbreviation, displayAbbreviation, name, scale, unitSystem);
    }

    @Override
    public SIUnit siUnit()
    {
        return SIUnit.of("m/s3");
    }

    @Override
    public JerkUnit getBaseUnit()
    {
        return SI;
    }

    @Override
    public Jerk ofSi(final double si)
    {
        return new Jerk(si, SI);
    }

    @Override
    public JerkUnit deriveUnit(final String textualAbbreviation, final String displayAbbreviation, final String name,
            final double scaleFactor, final UnitSystem unitSystem)
    {
        return new JerkUnit(textualAbbreviation, displayAbbreviation, name, new LinearScale(scaleFactor), unitSystem);
    }

}
