package org.djunits.demo.website;

import org.djunits.quantity.Acceleration;
import org.djunits.quantity.Duration;
import org.djunits.quantity.Frequency;
import org.djunits.quantity.Length;
import org.djunits.quantity.def.Quantity;
import org.djunits.unit.AbstractUnit;
import org.djunits.unit.scale.IdentityScale;
import org.djunits.unit.scale.LinearScale;
import org.djunits.unit.scale.Scale;
import org.djunits.unit.si.SIUnit;
import org.djunits.unit.system.UnitSystem;

/**
 * Test for building a new Jerk quantity.
 * <p>
 * Copyright (c) 2013-2026 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * @author Alexander Verbraeck
 * @author Peter Knoppers
 */
public class Jerk extends Quantity<Jerk>
{
    /** */
    private static final long serialVersionUID = 1L;

    /**
     * Construct Jerk scalar.
     * @param value the double value
     * @param unit unit for the double value
     */
    public Jerk(final double value, final Jerk.Unit unit)
    {
        super(value, unit);
    }

    @Override
    public Jerk instantiate(final double siValue)
    {
        return new Jerk(siValue, Jerk.Unit.SI);
    }

    /**
     * Multiply by duration to get an acceleration.
     * @param v the duration
     * @return the acceleration
     */
    public Acceleration multiply(final Duration v)
    {
        return Acceleration.ofSi(this.si() * v.si());
    }

    /**
     * Divide by acceleration to get a frequency.
     * @param v the acceleration
     * @return the frequency
     */
    public Frequency divide(final Acceleration v)
    {
        return Frequency.ofSi(this.si() / v.si());
    }

    /**
     * Test for building a new Jerk.Unit for the Jerk quantity.
     * <p>
     * Copyright (c) 2013-2026 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved.
     * <br>
     * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
     * @author Alexander Verbraeck
     * @author Peter Knoppers
     */
    public static class Unit extends AbstractUnit<Jerk.Unit, Jerk>
    {
        /** The SI unit for jerk is m/s^3. */
        public static final Jerk.Unit SI =
                new Jerk.Unit("m/s3", "meter per second cubed", IdentityScale.SCALE, UnitSystem.SI_DERIVED);

        /** m/s3. */
        public static final Jerk.Unit m_s3 = SI;

        /** cm/s3. */
        public static final Jerk.Unit cm_s3 =
                SI.deriveUnit("cm/s3", "centimeter per second cubed", 0.01, UnitSystem.SI_DERIVED);

        /** mm/s3. */
        public static final Jerk.Unit mm_s3 =
                SI.deriveUnit("mm/s3", "millimeter per second cubed", 0.001, UnitSystem.SI_DERIVED);

        /** ft/s3. */
        public static final Jerk.Unit ft_s3 =
                SI.deriveUnit("ft/s3", "foot per second cubed", Length.Unit.CONST_FT, UnitSystem.IMPERIAL);

        /** in/s3. */
        public static final Jerk.Unit in_s3 =
                SI.deriveUnit("in/s3", "inch per second cubed", Length.Unit.CONST_IN, UnitSystem.IMPERIAL);

        /**
         * Generate a new Jerk unit.
         * @param textualAbbreviation the textual abbreviation to use
         * @param name the name of the unit
         * @param scale the scale to use
         * @param unitSystem the unit system
         */
        public Unit(final String textualAbbreviation, final String name, final Scale scale, final UnitSystem unitSystem)
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
        public Unit(final String textualAbbreviation, final String displayAbbreviation, final String name, final Scale scale,
                final UnitSystem unitSystem)
        {
            super(textualAbbreviation, displayAbbreviation, name, scale, unitSystem);
        }

        @Override
        public SIUnit siUnit()
        {
            return SIUnit.of("m/s3");
        }

        @Override
        public Jerk.Unit getBaseUnit()
        {
            return SI;
        }

        @Override
        public Jerk ofSi(final double si)
        {
            return new Jerk(si, SI);
        }

        @Override
        public Jerk.Unit deriveUnit(final String textualAbbreviation, final String displayAbbreviation, final String name,
                final double scaleFactor, final UnitSystem unitSystem)
        {
            return new Jerk.Unit(textualAbbreviation, displayAbbreviation, name, new LinearScale(scaleFactor), unitSystem);
        }

    }
}
