/*  Created on 22.02.2023
 *
 *  Copyright (c) 2023
 *  RegitStudios, Hückelhoven, Germany
 *
 *  IntelliJ IDEA@financeApp/utils/RoundUtils
 *
 *  All rights reserved
 */

package utils;

import java.text.NumberFormat;

import static java.lang.Double.parseDouble;
import static java.util.Locale.UK;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 * On Time 14:20:52
 */

public class RoundUtils {

    public static double roundToTwoDigits(double value) {
        final NumberFormat numberFormat = NumberFormat.getNumberInstance(UK);
        numberFormat.setMaximumFractionDigits(2);
        return parseDouble(numberFormat.format(value));
    }
}
