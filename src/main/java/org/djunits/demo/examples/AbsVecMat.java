package org.djunits.demo.examples;

import org.djunits.formatter.MatrixFormat;
import org.djunits.quantity.Angle;
import org.djunits.quantity.Direction;
import org.djunits.vecmat.d2.AbsMatrix2x2;

/**
 * AbsVecMat shows the construction and printing of a 2x2 matrix with absolute quantities.
 * <p>
 * Copyright (c) 2026-2026 Delft University of Technology, Jaffalaan 5, 2628 BX Delft, the Netherlands. All rights reserved. See
 * for project information <a href="https://djunits.org" target="_blank"> https://djunits.org</a>. The DJUNITS project is
 * distributed under a three-clause BSD-style license, which can be found at
 * <a href="https://djunits.org/docs/license.html" target="_blank"> https://djunits.org/docs/license.html</a>. <br>
 * @author Alexander Verbraeck
 */
public class AbsVecMat
{
    /**
     * @param args not used
     */
    public static void main(final String[] args)
    {
        AbsMatrix2x2<Direction, Angle> dirMatrix =
                AbsMatrix2x2.of(new double[] {10, 20, 30, 40}, Angle.Unit.deg, Direction.Reference.EAST);
        System.out.println(dirMatrix);
        System.out.println();
        System.out.println(dirMatrix.format(MatrixFormat.instance().setPrintReference().setReferencePrefix(" (relative to ")));
    }

}
