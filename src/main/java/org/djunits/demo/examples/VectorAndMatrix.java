package org.djunits.demo.examples;

import java.util.concurrent.TimeUnit;

import org.djunits.old.unit.AbsoluteTemperatureUnit;
import org.djunits.old.unit.DurationUnit;
import org.djunits.old.unit.LengthUnit;
import org.djunits.old.unit.TemperatureUnit;
import org.djunits.old.value.ValueRuntimeException;
import org.djunits.old.value.storage.StorageType;
import org.djunits.old.value.vdouble.matrix.LengthMatrix;
import org.djunits.old.value.vdouble.matrix.data.DoubleMatrixData;
import org.djunits.old.value.vdouble.vector.AbsoluteTemperatureVector;
import org.djunits.old.value.vdouble.vector.DurationVector;
import org.djunits.old.value.vdouble.vector.TemperatureVector;
import org.djunits.old.value.vdouble.vector.TimeVector;
import org.djunits.quantity.Duration;
import org.djunits.quantity.Length;
import org.djunits.quantity.Speed;
import org.djunits.unit.scale.IdentityScale;
import org.djunits.vecmat.dn.VectorN;
import org.djunits.vecmat.storage.DenseDoubleDataSi;

/**
 * <p>
 * Copyright (c) 2013-2026 Delft University of Technology, PO Box 5, 2600 AA,
 * Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See
 * <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * 
 * @author Alexander Verbraeck
 * @author Peter Knoppers
 */
public final class VectorAndMatrix {

    /** */
    private VectorAndMatrix() {
        //
    }

    /**
     * @param args args
     * @throws ValueRuntimeException on error
     */
    public static void main(final String[] args) throws ValueRuntimeException {
        double[] doubleValues = new double[] { 0.2, 10.0, 5.7, -100.0, 15.0 };
        TimeVector dva = new TimeVector(doubleValues, TimeUnit.EPOCH_MINUTE);
        System.out.println(dva);

        double[] doubleValues2 = new double[] { 10, 20.0, 60, 120.0, 300.0 };
        DenseDoubleDataSi ddd2 = new DenseDoubleDataSi(doubleValues2, 5, 1);
        VectorN.Col<Duration> dv1 = new VectorN.Col<>(ddd2, Duration.Unit.s);
        Speed speed = Speed.of(10.0, "km_h");
        VectorN.Col<Length> lv1 = dv1.multiplyEntries(speed).as(Length.Unit.m);
        System.out.println(dv1);
        System.out.println(lv1);

        TimeVector dva2 = dva.plus(dv1);
        System.out.println(dva2);
        TimeVector dva3 = dva.minus(dv1);
        System.out.println(dva3);
        TimeVector dva4 = dv1.plus(dva);
        System.out.println(dva4);

        double[] tempValues = new double[] { 0.0, -17.77778, -273.15, 100.0 };
        AbsoluteTemperatureVector tva = new AbsoluteTemperatureVector(tempValues,
                AbsoluteTemperatureUnit.DEGREE_CELSIUS);
        System.out.println(tva);

        double[] tempValues2 = new double[] { 32.0, 32.0, 459.67 + 32, 212.0 - 32.0 };
        TemperatureVector tvr = new TemperatureVector(tempValues2, TemperatureUnit.DEGREE_FAHRENHEIT);
        System.out.println(tvr);

        AbsoluteTemperatureVector tva2 = tva.plus(tvr);
        System.out.println(tva2);
        AbsoluteTemperatureVector tva3 = tva.minus(tvr);
        System.out.println(tva3);
        // XXX DoubleVector.Abs<TimeUnit, DurationUnit> dva4 = dvr.plus(dva);
        System.out.println();

        DurationVector dv = new DurationVector(new double[] { 1.0, 2.0, 5.0, 10.0 }, DurationUnit.MINUTE);
        Duration d = dv.get(2);
        System.out.println(d);

        double[][] data = new double[1000][1000];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                data[i][j] = 9 * i + 2 * j * 0.364;
            }
        }
        LengthMatrix lengthMatrix = new LengthMatrix(
                DoubleMatrixData.instantiateSi(data, IdentityScale.SCALE, StorageType.DENSE), LengthUnit.CENTIMETER);
    }

}
