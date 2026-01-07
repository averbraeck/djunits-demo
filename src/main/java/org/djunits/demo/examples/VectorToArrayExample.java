package org.djunits.demo.examples;

import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

import org.djunits.old.unit.SpeedUnit;
import org.djunits.old.unit.TimeUnit;
import org.djunits.old.value.ValueRuntimeException;
import org.djunits.old.value.vdouble.scalar.Speed;
import org.djunits.old.value.vdouble.scalar.Time;
import org.djunits.old.value.vdouble.vector.SpeedVector;
import org.djunits.old.value.vdouble.vector.TimeVector;
import org.djunits.old.value.vfloat.scalar.FloatSpeed;
import org.djunits.old.value.vfloat.scalar.FloatTime;
import org.djunits.old.value.vfloat.vector.FloatSpeedVector;
import org.djunits.old.value.vfloat.vector.FloatTimeVector;

/**
 * <p>
 * Copyright (c) 2013-2025 Delft University of Technology, PO Box 5, 2600 AA,
 * Delft, the Netherlands. All rights reserved. <br>
 * BSD-style license. See
 * <a href="https://djunits.org/docs/license.html">DJUNITS License</a>.
 * </p>
 * 
 * @author Alexander Verbraeck
 * @author Peter Knoppers
 */
public final class VectorToArrayExample {
	/** Utility constructor. */
	private VectorToArrayExample() {
		//
	}

	/**
	 * @param args the arguments for the main program, not used
	 * @throws ValueRuntimeException on vector error
	 */
	public static void main(final String[] args) throws ValueRuntimeException {
		showDoubleToArray();
		showFloatToArray();
	}

	/**
	 * double iterator example.
	 * 
	 * @throws ValueRuntimeException on error
	 */
	private static void showDoubleToArray() throws ValueRuntimeException {
		Speed s1 = new Speed(10.0, SpeedUnit.METER_PER_SECOND);
		Speed s2 = new Speed(12.0, SpeedUnit.METER_PER_SECOND);
		Speed s3 = new Speed(8.0, SpeedUnit.METER_PER_SECOND);
		Speed s4 = new Speed(16.0, SpeedUnit.METER_PER_SECOND);
		SpeedVector svd = new SpeedVector(new Speed[] { s1, s2, s3, s4 }, SpeedUnit.METER_PER_SECOND);
		Speed[] svdArray = svd.getScalars();
		System.out.println(
				"\nSpeed vector (Double, Rel, Dense): " + Arrays.asList(svdArray) + " of length " + svdArray.length);
		for (Speed s : svdArray) {
			System.out.println(s);
		}

		SortedMap<Integer, Speed> svsMap = new TreeMap<>();
		svsMap.put(1, s1);
		svsMap.put(3, s2);
		svsMap.put(5, s3);
		svsMap.put(7, s4);
		SpeedVector svs = new SpeedVector(svsMap, 10, SpeedUnit.METER_PER_SECOND);
		Speed[] svsArray = svs.getScalars();
		System.out.println(
				"\nSpeed vector (Double, Rel, Sparse): " + Arrays.asList(svsArray) + " of length " + svsArray.length);
		for (Speed s : svsArray) {
			System.out.println(s);
		}

		Time t1 = new Time(10.0, TimeUnit.BASE_SECOND);
		Time t2 = new Time(12.0, TimeUnit.BASE_SECOND);
		Time t3 = new Time(8.0, TimeUnit.BASE_SECOND);
		Time t4 = new Time(16.0, TimeUnit.BASE_SECOND);
		TimeVector tvd = new TimeVector(new Time[] { t1, t2, t3, t4 }, TimeUnit.BASE_SECOND);
		Time[] tvdArray = tvd.getScalars();
		System.out.println(
				"\nTime vector (Double, Abs, Dense): " + Arrays.asList(tvdArray) + " of length " + tvdArray.length);
		for (Time t : tvdArray) {
			System.out.println(t);
		}

		SortedMap<Integer, Time> tvsMap = new TreeMap<>();
		tvsMap.put(1, t1);
		tvsMap.put(3, t2);
		tvsMap.put(5, t3);
		tvsMap.put(7, t4);
		TimeVector tvs = new TimeVector(tvsMap, 10, TimeUnit.BASE_SECOND);
		Time[] tvsArray = tvs.getScalars();
		System.out.println(
				"\nTime vector (Double, Abs, Sparse): " + Arrays.asList(tvsArray) + " of length " + tvsArray.length);
		for (Time t : tvsArray) {
			System.out.println(t);
		}
	}

	/**
	 * float iterator example.
	 * 
	 * @throws ValueRuntimeException on error
	 */
	private static void showFloatToArray() throws ValueRuntimeException {
		FloatSpeed s1 = new FloatSpeed(10.0, SpeedUnit.METER_PER_SECOND);
		FloatSpeed s2 = new FloatSpeed(12.0, SpeedUnit.METER_PER_SECOND);
		FloatSpeed s3 = new FloatSpeed(8.0, SpeedUnit.METER_PER_SECOND);
		FloatSpeed s4 = new FloatSpeed(16.0, SpeedUnit.METER_PER_SECOND);
		FloatSpeedVector svd = new FloatSpeedVector(new FloatSpeed[] { s1, s2, s3, s4 }, SpeedUnit.METER_PER_SECOND);
		FloatSpeed[] svdArray = svd.getScalars();
		System.out.println(
				"\nSpeed vector (Float, Rel, Dense): " + Arrays.asList(svdArray) + " of length " + svdArray.length);
		for (FloatSpeed s : svdArray) {
			System.out.println(s);
		}

		SortedMap<Integer, FloatSpeed> svsMap = new TreeMap<>();
		svsMap.put(1, s1);
		svsMap.put(3, s2);
		svsMap.put(5, s3);
		svsMap.put(7, s4);
		FloatSpeedVector svs = new FloatSpeedVector(svsMap, 10, SpeedUnit.METER_PER_SECOND);
		FloatSpeed[] svsArray = svs.getScalars();
		System.out.println(
				"\nSpeed vector (Float, Rel, Sparse): " + Arrays.asList(svsArray) + " of length " + svsArray.length);
		for (FloatSpeed s : svsArray) {
			System.out.println(s);
		}

		FloatTime t1 = new FloatTime(10.0f, TimeUnit.BASE_SECOND);
		FloatTime t2 = new FloatTime(12.0f, TimeUnit.BASE_SECOND);
		FloatTime t3 = new FloatTime(8.0f, TimeUnit.BASE_SECOND);
		FloatTime t4 = new FloatTime(16.0f, TimeUnit.BASE_SECOND);
		FloatTimeVector tvd = new FloatTimeVector(new FloatTime[] { t1, t2, t3, t4 }, TimeUnit.BASE_SECOND);
		FloatTime[] tvdArray = tvd.getScalars();
		System.out.println(
				"\nTime vector (Float, Abs, Dense): " + Arrays.asList(tvdArray) + " of length " + tvdArray.length);
		for (FloatTime t : tvdArray) {
			System.out.println(t);
		}

		SortedMap<Integer, FloatTime> tvsMap = new TreeMap<>();
		tvsMap.put(1, t1);
		tvsMap.put(3, t2);
		tvsMap.put(5, t3);
		tvsMap.put(7, t4);
		FloatTimeVector tvs = new FloatTimeVector(tvsMap, 10, TimeUnit.BASE_SECOND);
		FloatTime[] tvsArray = tvs.getScalars();
		System.out.println(
				"\nTime vector (Float, Abs, Sparse): " + Arrays.asList(tvsArray) + " of length " + tvsArray.length);
		for (FloatTime t : tvsArray) {
			System.out.println(t);
		}

	}

}
