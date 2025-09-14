package org.djunits.demo.examples;

import org.djunits.unit.DimensionlessUnit;
import org.djunits.unit.SIUnit;
import org.djunits.unit.util.UnitException;
import org.djunits.value.vdouble.scalar.Dimensionless;
import org.djunits.value.vdouble.scalar.Duration;
import org.djunits.value.vdouble.scalar.Energy;
import org.djunits.value.vdouble.scalar.Frequency;
import org.djunits.value.vdouble.scalar.SIScalar;
import org.djunits.value.vdouble.scalar.Torque;
import org.djunits.value.vdouble.vector.DimensionlessVector;
import org.djunits.value.vdouble.vector.EnergyVector;
import org.djunits.value.vdouble.vector.SIVector;
import org.djunits.value.vdouble.vector.TorqueVector;
import org.djunits.value.vfloat.scalar.FloatDimensionless;
import org.djunits.value.vfloat.scalar.FloatDuration;
import org.djunits.value.vfloat.scalar.FloatEnergy;
import org.djunits.value.vfloat.scalar.FloatFrequency;
import org.djunits.value.vfloat.scalar.FloatSIScalar;
import org.djunits.value.vfloat.scalar.FloatTorque;
import org.djunits.value.vfloat.vector.FloatDimensionlessVector;
import org.djunits.value.vfloat.vector.FloatEnergyVector;
import org.djunits.value.vfloat.vector.FloatSIVector;
import org.djunits.value.vfloat.vector.FloatTorqueVector;

/**
 * DimensionlessExample to show the use of a Dimensionless quantity.
 * <p>
 * Copyright (c) 2020-2020 Delft University of Technology, PO Box 5, 2600 AA, Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See <a href="https://opentrafficsim.org/docs/current/license.html">OpenTrafficSim License</a>.
 * </p>
 * @author <a href="https://www.tudelft.nl/averbraeck">Alexander Verbraeck</a>
 * @author <a href="https://www.tudelft.nl/pknoppers">Peter Knoppers</a>
 * @author <a href="https://www.transport.citg.tudelft.nl">Wouter Schakel</a>
 */
public class DimensionlessExample
{

    /**
     * Show the use of a Dimensionless quantity, without a unit to print.
     * @throws UnitException on error
     */
    public DimensionlessExample() throws UnitException
    {
        scalars();
        floatScalars();
        vectors();
        floatVectors();
    }

    /** */
    public void scalars()
    {
        // regular Dimensionless values
        System.out.println("\nScalars");
        Dimensionless d1 = new Dimensionless(3.14, DimensionlessUnit.SI);
        System.out.println("|" + d1 + "|");
        Dimensionless d2 = Dimensionless.of(2.7818, "");
        System.out.println("|" + d2 + "|");
        Dimensionless d2s = Dimensionless.of(2.7818, " ");
        System.out.println("|" + d2s + "|");
        
        try
        {
            Dimensionless.of(2.7818, "unit");
        }
        catch (Exception e)
        {
            System.out.println("Cannot instantiate Dimensionless.of(2.7818, \"unit\")");
        }

        try
        {
            Dimensionless.of(2.7818, "1");
        }
        catch (Exception e)
        {
            System.out.println("Cannot instantiate Dimensionless.of(2.7818, \"1\")");
        }

        Dimensionless d3 = Dimensionless.valueOf("1.44");
        System.out.println("|" + d3 + "|");
        Dimensionless d3a = Dimensionless.valueOf("1.44 ");
        System.out.println("|" + d3a + "|");

        // Dimensionless as a result of division or multiplication
        Dimensionless m1 = Frequency.of(10.0, "Hz").times(Duration.valueOf("1.0 min"));
        System.out.println("|" + m1 + "|");
        Dimensionless t2 = Torque.of(1.33, "N.m").divide(Torque.ONE);
        System.out.println("|" + t2 + "|");

        // SIScalar values that are Dimensionless
        SIScalar s1 = Torque.of(1.33, "N.m").divide(Energy.valueOf("2.1 J"));
        System.out.println("|" + s1 + "|");
        SIScalar s2 = SIScalar.of(1.2, "");
        System.out.println("|" + s2 + "|");
        SIScalar s3 = SIScalar.valueOf("3.4");
        System.out.println("|" + s3 + "|");
    }

    /** */
    public void floatScalars()
    {
        // regular FloatDimensionless values
        System.out.println("\nScalars");
        FloatDimensionless d1 = new FloatDimensionless(3.14f, DimensionlessUnit.SI);
        System.out.println("|" + d1 + "|");
        FloatDimensionless d2 = FloatDimensionless.of(2.7818f, "");
        System.out.println("|" + d2 + "|");
        FloatDimensionless d2s = FloatDimensionless.of(2.7818f, " ");
        System.out.println("|" + d2s + "|");
        try
        {
            FloatDimensionless.of(2.7818f, "unit");
        }
        catch (Exception e)
        {
            System.out.println("Cannot instantiate FloatDimensionless.of(2.7818, \"unit\")");
        }
        FloatDimensionless d3 = FloatDimensionless.valueOf("1.44");
        System.out.println("|" + d3 + "|");
        FloatDimensionless d3a = FloatDimensionless.valueOf("1.44 ");
        System.out.println("|" + d3a + "|");

        // FloatDimensionless as a result of division or multiplication
        FloatDimensionless m1 = FloatFrequency.of(10.0f, "Hz").times(FloatDuration.valueOf("1.0 min"));
        System.out.println("|" + m1 + "|");
        FloatDimensionless t2 = FloatTorque.of(1.33f, "N.m").divide(FloatTorque.ONE);
        System.out.println("|" + t2 + "|");

        // FloatSIScalar values that are FloatDimensionless
        FloatSIScalar s1 = FloatTorque.of(1.33f, "N.m").divide(FloatEnergy.valueOf("2.1 J"));
        System.out.println("|" + s1 + "|");
        FloatSIScalar s2 = FloatSIScalar.of(1.2f, "");
        System.out.println("|" + s2 + "|");
        FloatSIScalar s3 = FloatSIScalar.valueOf("3.4");
        System.out.println("|" + s3 + "|");
    }

    /**
     * @throws UnitException on error
     */
    public void vectors() throws UnitException
    {
        System.out.println("\nVectors");
        double[] da = {1, 2, 3, 4};
        DimensionlessVector dv1 = new DimensionlessVector(da);
        System.out.println("|" + dv1 + "|");
        Dimensionless[] dd = new Dimensionless[] {Dimensionless.valueOf("5"), Dimensionless.valueOf("6"),
                Dimensionless.valueOf("7"), Dimensionless.valueOf("8")};
        DimensionlessVector dv2 = new DimensionlessVector(dd);
        System.out.println("|" + dv2 + "|");
        DimensionlessVector dv3 = new DimensionlessVector(da, DimensionlessUnit.SI);
        System.out.println("|" + dv3 + "|");
        DimensionlessVector dv4 = new DimensionlessVector(dd, DimensionlessUnit.SI);
        System.out.println("|" + dv4 + "|");

        // FloatSIVector that are or become dimensionless
        SIVector si1 = new SIVector(da, SIUnit.of(""));
        System.out.println("|" + si1 + "|");
        SIVector si2 = new SIVector(da, SIUnit.of(DimensionlessUnit.SI.getQuantity().getSiDimensions()));
        System.out.println("|" + si2 + "|");
        TorqueVector tv = new TorqueVector(da);
        EnergyVector ev = new EnergyVector(da).times(2.0);
        SIVector si3 = tv.divide(ev);
        System.out.println("|" + tv + "| / |" + ev + "| = |" + si3 + "|");
    }

    /**
     * @throws UnitException on error
     */
    public void floatVectors() throws UnitException
    {
        System.out.println("\nFloatVectors");
        float[] da = {1, 2, 3, 4};
        FloatDimensionlessVector dv1 = new FloatDimensionlessVector(da);
        System.out.println("|" + dv1 + "|");
        FloatDimensionless[] dd = new FloatDimensionless[] {FloatDimensionless.valueOf("5"), FloatDimensionless.valueOf("6"),
                FloatDimensionless.valueOf("7"), FloatDimensionless.valueOf("8")};
        FloatDimensionlessVector dv2 = new FloatDimensionlessVector(dd);
        System.out.println("|" + dv2 + "|");
        FloatDimensionlessVector dv3 = new FloatDimensionlessVector(da, DimensionlessUnit.SI);
        System.out.println("|" + dv3 + "|");
        FloatDimensionlessVector dv4 = new FloatDimensionlessVector(dd, DimensionlessUnit.SI);
        System.out.println("|" + dv4 + "|");

        // FloatSIVectors that are or become dimensionless
        FloatSIVector si1 = new FloatSIVector(da, SIUnit.of(""));
        System.out.println("|" + si1 + "|");
        FloatSIVector si2 = new FloatSIVector(da, SIUnit.of(DimensionlessUnit.SI.getQuantity().getSiDimensions()));
        System.out.println("|" + si2 + "|");
        FloatTorqueVector tv = new FloatTorqueVector(da);
        FloatEnergyVector ev = new FloatEnergyVector(da).times(2.0f);
        FloatSIVector si3 = tv.divide(ev);
        System.out.println("|" + tv + "| / |" + ev + "| = |" + si3 + "|");
    }

    /**
     * Main program to show the use of a Dimensionless quantity.
     * @param args not used
     * @throws UnitException on error
     */
    public static void main(final String[] args) throws UnitException
    {
        new DimensionlessExample();
    }

}
