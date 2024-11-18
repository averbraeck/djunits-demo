package org.djunits.demo.website;

import java.text.NumberFormat;
import java.util.Locale;

import org.djunits.unit.AccelerationUnit;
import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.FrequencyUnit;
import org.djunits.value.vdouble.scalar.Acceleration;
import org.djunits.value.vdouble.scalar.Dimensionless;
import org.djunits.value.vdouble.scalar.Duration;
import org.djunits.value.vdouble.scalar.Frequency;
import org.djunits.value.vdouble.scalar.SIScalar;
import org.djunits.value.vdouble.scalar.base.DoubleScalarRel;
import org.djunits.value.vdouble.scalar.base.DoubleScalar;
import org.djutils.exceptions.Throw;

/**
 * <p>
 * Copyright (c) 2013-2024 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/staff/p.knoppers/">Peter Knoppers</a>
 */
public class Jerk extends DoubleScalarRel<JerkUnit, Jerk>
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

    /**
     * Construct Jerk scalar.
     * @param value Scalar from which to construct this instance
     */
    public Jerk(final Jerk value)
    {
        super(value);
    }

    /** {@inheritDoc} */
    @Override
    public final Jerk instantiateRel(final double value, final JerkUnit unit)
    {
        return new Jerk(value, unit);
    }

    /**
     * Construct Jerk scalar.
     * @param value the double value in SI units
     * @return the new scalar with the SI value
     */
    public static final Jerk instantiateSI(final double value)
    {
        return new Jerk(value, JerkUnit.SI);
    }

    /**
     * Interpolate between two values.
     * @param zero the low value
     * @param one the high value
     * @param ratio the ratio between 0 and 1, inclusive
     * @return a Scalar at the ratio between
     */
    public static Jerk interpolate(final Jerk zero, final Jerk one, final double ratio)
    {
        return new Jerk(zero.getInUnit() * (1 - ratio) + one.getInUnit(zero.getDisplayUnit()) * ratio, zero.getDisplayUnit());
    }

    /**
     * Return the maximum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the maximum value of two relative scalars
     */
    public static Jerk max(final Jerk r1, final Jerk r2)
    {
        return (r1.gt(r2)) ? r1 : r2;
    }

    /**
     * Return the maximum value of more than two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @param rn the other scalars
     * @return the maximum value of more than two relative scalars
     */
    public static Jerk max(final Jerk r1, final Jerk r2, final Jerk... rn)
    {
        Jerk maxr = (r1.gt(r2)) ? r1 : r2;
        for (Jerk r : rn)
        {
            if (r.gt(maxr))
            {
                maxr = r;
            }
        }
        return maxr;
    }

    /**
     * Return the minimum value of two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @return the minimum value of two relative scalars
     */
    public static Jerk min(final Jerk r1, final Jerk r2)
    {
        return r1.lt(r2) ? r1 : r2;
    }

    /**
     * Return the minimum value of more than two relative scalars.
     * @param r1 the first scalar
     * @param r2 the second scalar
     * @param rn the other scalars
     * @return the minimum value of more than two relative scalars
     */
    public static Jerk min(final Jerk r1, final Jerk r2, final Jerk... rn)
    {
        Jerk minr = r1.lt(r2) ? r1 : r2;
        for (Jerk r : rn)
        {
            if (r.lt(minr))
            {
                minr = r;
            }
        }
        return minr;
    }

    /**
     * Returns a Jerk representation of a textual representation of a value with a unit. The String representation that can be
     * parsed is the double value in the unit, followed by the official abbreviation of the unit. Spaces are allowed, but not
     * required, between the value and the unit.
     * @param text the textual representation to parse into a Jerk
     * @return the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the text cannot be parsed
     * @throws NullPointerException when the text argument is null
     */
    public static Jerk valueOf(final String text)
    {
        try
        {
            NumberFormat formatter = NumberFormat.getInstance();
            int index = 0;
            while (index < text.length() && "0123456789,._eE+-".contains(text.substring(index, index + 1)))
                index++;
            String unitString = text.substring(index).trim();
            String valueString = text.substring(0, index).trim();
            JerkUnit unit = JerkUnit.BASE.getUnitByAbbreviation(unitString);
            if (unit == null)
                throw new IllegalArgumentException("Unit " + unitString + " not found");
            double d = formatter.parse(valueString).doubleValue();
            return new Jerk(d, unit);
        }
        catch (Exception exception)
        {
            throw new IllegalArgumentException(
					"Error parsing Jerk from " + text + " using Locale " + Locale.getDefault(Locale.Category.FORMAT),
                    exception);
        }
    }

    /**
     * Returns a Jerk based on a value and the textual representation of the unit.
     * @param value the value to use
     * @param unitString the textual representation of the unit
     * @return the Scalar representation of the value in its unit
     * @throws IllegalArgumentException when the unit cannot be parsed or is incorrect
     * @throws NullPointerException when the unitString argument is null
     */
    public static Jerk of(final double value, final String unitString)
    {
        Throw.whenNull(unitString, "Error parsing Jerk: unitString is null");
        Throw.when(unitString.length() == 0, IllegalArgumentException.class, "Error parsing Jerk: empty unitString");
        JerkUnit unit = JerkUnit.BASE.getUnitByAbbreviation(unitString);
        if (unit != null)
        {
            return new Jerk(value, unit);
        }
        throw new IllegalArgumentException("Error parsing Jerk with unit " + unitString);
    }

    /**
     * Calculate the division of Jerk and Jerk, which results in a Dimensionless scalar.
     * @param v Jerk scalar
     * @return Dimensionless scalar as a division of Jerk and Jerk
     */
    public final Dimensionless divide(final Jerk v)
    {
        return new Dimensionless(this.si / v.si, DimensionlessUnit.SI);
    }

    /**
     * Calculate the multiplication of Jerk and Duration, which results in an Acceleration scalar.
     * @param v Duration scalar
     * @return Acceleration scalar as a multiplication of Jerk and Duration
     */
    public final Acceleration times(final Duration v)
    {
        return new Acceleration(this.si * v.si, AccelerationUnit.SI);
    }

    /**
     * Calculate the division of Jerk and Acceleration, which results in a Frequency scalar.
     * @param v Acceleration scalar
     * @return Frequency scalar as a division of Jerk and Accelration
     */
    public final Frequency times(final Acceleration v)
    {
        return new Frequency(this.si * v.si, FrequencyUnit.SI);
    }

    /** {@inheritDoc} */
    @Override
    public SIScalar reciprocal()
    {
        return DoubleScalar.divide(Dimensionless.ONE, this);
    }

}
