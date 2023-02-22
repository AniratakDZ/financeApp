/*  Created on 21.02.2023
 *
 *  Copyright (c) 2023
 *  RegitStudios, Hückelhoven, Germany
 *
 *  IntelliJ IDEA@financeApp/utils/CalculateUtils
 *
 *  All rights reserved
 */

package utils;

import java.text.NumberFormat;

import static java.lang.Double.parseDouble;
import static java.util.Locale.*;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 * On Time 20:13:01
 */

public class CalculateUtils {

    public static double EBAY_VARIABLE_FEE_UNDER_1990 = 11.0;
    public static double EBAY_VARIABLE_FEE_OVER_1990 = 2.0;
    public static double EBAY_FIX_FEE_UNDER_10 = 0.05;
    public static double EBAY_FIX_FEE_OVER_10 = 0.35;

    public static double calculateEbayFees(double sellPrice, double shippingFees) {

        final double totalSum = sellPrice + shippingFees;

        double ebayVariableFees = calculateEbayVariableFeeValue(totalSum);
        double ebayFixFees = calculateEbayFixFeeValue(totalSum);

        final double variableFees = totalSum * (ebayVariableFees / 100.0);
        return roundToTwoDecimets(variableFees + ebayFixFees);
    }

    public static double calculateDifference(double actualShippingFees, double buyPrice, double actualSum) {

        final double actualSumWithoutShippingFees = actualSum - actualShippingFees;

        return roundToTwoDecimets(actualSumWithoutShippingFees - buyPrice);
    }

    public static double calculateActualSum(double sellPrice, double shippingFees, double ebayFees) {

        final double totalSum = sellPrice + shippingFees;
        return roundToTwoDecimets(totalSum - ebayFees);
    }

    public static double calculateActualShippingFees(double shippingFees, double sellPrice) {

        final double totalSum = sellPrice + shippingFees;
        final double shippingFeesVat = shippingFees * (calculateEbayVariableFeeValue(totalSum) / 100.0);
        return roundToTwoDecimets(shippingFees - shippingFeesVat);
    }

    public static double calculateVAT(double difference, double actualShippingFees) {

        final double differenceVAT = difference * (19.0 / 100.0);
        final double shippingFeesVAT = actualShippingFees * (19.0 / 100.0);
        return roundToTwoDecimets(differenceVAT + shippingFeesVAT);
    }

    public static double calculateGrossProfit(double actualSum, double vat, double shippingFees) {

        return roundToTwoDecimets(actualSum - vat - shippingFees);
    }

    public static double calculateNetProfit(double packingPrice, double grossProfit) {

        return roundToTwoDecimets(grossProfit - packingPrice);
    }

    private static double roundToTwoDecimets(double value) {
        final NumberFormat numberFormat = NumberFormat.getNumberInstance(UK);
        numberFormat.setMaximumFractionDigits(2);
        return parseDouble(numberFormat.format(value));
    }

    private static double calculateEbayVariableFeeValue(double value) {
        if(value > 1990.0) {
            return EBAY_VARIABLE_FEE_OVER_1990;
        } else {
            return EBAY_VARIABLE_FEE_UNDER_1990;
        }
    }

    private static double calculateEbayFixFeeValue(double value) {
        if(value > 10) {
            return EBAY_FIX_FEE_OVER_10;
        } else {
            return EBAY_FIX_FEE_UNDER_10;
        }
    }
}
