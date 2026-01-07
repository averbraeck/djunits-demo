package org.djunits.demo.examples;

import org.djunits.old.unit.LengthUnit;
import org.djunits.old.unit.scale.Scale;
import org.djunits.old.value.vdouble.function.DoubleFunction;
import org.djunits.old.value.vdouble.vector.LengthVector;

/** Demo for Vector. */
public final class VectorExample {
	/** */
	private VectorExample() {
		// just a main method
	}

	/**
	 * @param args not used
	 */
	public static void main(final String[] args) {
		double[] data = new double[10];
		for (int i = 0; i < data.length; i++) {
			data[i] = i * 0.8;
		}
		LengthVector lengthVector = new LengthVector(data, LengthUnit.FOOT);
		lengthVector = lengthVector.mutable();
		System.out.println(lengthVector);
		lengthVector.rint();
		System.out.println(lengthVector);

		lengthVector = new LengthVector(data, LengthUnit.FOOT);
		lengthVector = lengthVector.mutable();
		final Scale scale = lengthVector.getDisplayUnit().getScale();
		lengthVector.assign(new DoubleFunction() {
			@Override
			public double apply(final double value) {
				return scale.toStandardUnit(Math.rint(scale.fromStandardUnit(value)));
			}
		});
		System.out.println(lengthVector);
	}
}
