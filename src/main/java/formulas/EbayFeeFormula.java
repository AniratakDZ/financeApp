/*  Created on 22.02.2023
 *
 *  Copyright (c) 2023
 *  RegitStudios, Hückelhoven, Germany
 *
 *  IntelliJ IDEA@financeApp/formulas/EbayFeeFormula
 *
 *  All rights reserved
 */

package formulas;

import utils.EbayFeeUtils;
import utils.RoundUtils;

import static utils.EbayFeeUtils.calculateEbayFixFeeValue;
import static utils.EbayFeeUtils.calculateEbayVariableFeeValue;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 * On Time 14:18:53
 */

public class EbayFeeFormula implements BaseFormula {

    private final double actualSellPrice, actualShippingFees;

    public EbayFeeFormula(double actualSellPrice, double actualShippingFees) {
        this.actualSellPrice = actualSellPrice;
        this.actualShippingFees = actualShippingFees;
    }

    @Override
    public FormulaLoggingObject calculate() {

        final double totalSum = getActualSellPrice() + getActualShippingFees();

        double ebayVariableFees = calculateEbayVariableFeeValue(totalSum);
        double ebayFixFees = calculateEbayFixFeeValue(totalSum);

        final double variableFees = totalSum * (ebayVariableFees / 100.0);

        return new FormulaLoggingObject(RoundUtils.roundToTwoDigits(variableFees + ebayFixFees), "");
    }

    public double getActualSellPrice() {
        return actualSellPrice;
    }

    public double getActualShippingFees() {
        return actualShippingFees;
    }
}
