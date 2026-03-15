package org.djunits.demo.examples;

import org.djunits.quantity.Duration;
import org.djunits.quantity.Length;
import org.djunits.quantity.Speed;
import org.djunits.unit.system.UnitSystem;

/** Example for adding a unit. */
public final class AddingAUnitExample
{
    /** */
    private AddingAUnitExample()
    {
        // utility constructor.
    }

    /** a new LengthUnit. */
    public static final Length.Unit fr = Length.Unit.ft.deriveUnit("fr", "Furlong", 660.0, UnitSystem.OTHER);

    /** a new DurationUnit. */
    public static final Duration.Unit fn = Duration.Unit.day.deriveUnit("fn", "Fortnight", 14.0, UnitSystem.OTHER);

    /** a new Speed.Unit based on the new Length.Unit and the new DurationUnit. */
    public static final Speed.Unit fr_fn = Speed.Unit.SI.deriveUnit("fr/fn", "Furlongs per Fortnight",
            fr.getScale().toBaseValue(1.0) / fn.getScale().toBaseValue(1.0), UnitSystem.OTHER);

    /**
     * @param args can be blank
     */
    public static void main(final String[] args)
    {
        Length oneThousandFurlong = new Length(1000.0, fr);
        System.out.println(oneThousandFurlong);
        Duration twoFortNight = new Duration(2.0, fn);
        System.out.println(twoFortNight);
        Speed speed = oneThousandFurlong.divide(twoFortNight);
        System.out.println(speed + "(should be around 0.083152 m/s)");
        System.out.println(speed.toString(fr_fn));
    }

}
