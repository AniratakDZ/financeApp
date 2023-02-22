/*  Created on 22.02.2023
 *
 *  Copyright (c) 2023
 *  RegitStudios, Hückelhoven, Germany
 *
 *  IntelliJ IDEA@financeApp/utils/EbayFeeUtils
 *
 *  All rights reserved
 */

package utils;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 * On Time 14:22:37
 */

public class EbayFeeUtils {

    public static double EBAY_VARIABLE_FEE_UNDER_1990 = 11.0;
    public static double EBAY_VARIABLE_FEE_OVER_1990 = 2.0;
    public static double EBAY_FIX_FEE_UNDER_10 = 0.05;
    public static double EBAY_FIX_FEE_OVER_10 = 0.35;

    public static double calculateEbayVariableFeeValue(double value) {
        if(value > 1990.0) {
            return EBAY_VARIABLE_FEE_OVER_1990;
        } else {
            return EBAY_VARIABLE_FEE_UNDER_1990;
        }
    }

    public static double calculateEbayFixFeeValue(double value) {
        if(value > 10) {
            return EBAY_FIX_FEE_OVER_10;
        } else {
            return EBAY_FIX_FEE_UNDER_10;
        }
    }

}
