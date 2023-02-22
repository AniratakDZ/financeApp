/*  Created on 22.02.2023
 *
 *  Copyright (c) 2023
 *  RegitStudios, Hückelhoven, Germany
 *
 *  IntelliJ IDEA@financeApp/enums/PackingPrices
 *
 *  All rights reserved
 */

package enums;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 * On Time 01:51:08
 */

public enum PackingPrices {

    KLEINE_VERSANDTASCHE(0.08, "Kleine Versandtasche"),
    GROSSE_VERSANDTASCHE(0.18, "Große Versandtasche"),
    KLEINER_KARTON(0.20, "Kleiner Karton"),
    NORMALER_KARTON(1.20, "Normaler Karton");

    final double price;
    final String name;

    PackingPrices(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
