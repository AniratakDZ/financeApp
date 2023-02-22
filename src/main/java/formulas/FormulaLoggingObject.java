/*  Created on 22.02.2023
 *
 *  Copyright (c) 2023
 *  RegitStudios, Hückelhoven, Germany
 *
 *  IntelliJ IDEA@financeApp/formulas/FormulaLoggingObject
 *
 *  All rights reserved
 */

package formulas;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 * On Time 14:16:59
 */

public class FormulaLoggingObject {

    private final double value;
    private String loggingOutput;

    public FormulaLoggingObject(double value, String loggingOutput) {
        this.value = value;
        this.loggingOutput = loggingOutput;

        createBaseLoggingOutput();
    }

    private void createBaseLoggingOutput() {
        this.loggingOutput += "Formula Logging Output: \n";
    }

    public double getValue() {
        return value;
    }

    public String getLoggingOutput() {
        return loggingOutput;
    }

    public void setLoggingOutput(String loggingOutput) {
        this.loggingOutput = loggingOutput;
    }
}
