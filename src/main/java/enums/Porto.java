/*  Created on 21.02.2023
 *
 *  Copyright (c) 2023
 *  RegitStudios, Hückelhoven, Germany
 *
 *  IntelliJ IDEA@financeApp/enums/Porto
 *
 *  All rights reserved
 */

package enums;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 * On Time 23:48:30
 */

public enum Porto {

    GROSSBRIEF_EINSCHREIBEN(3.95, "Großbrief mit Einschreiben"),
    MAXIBRIEF_EINSCHREIBEN(5.10, "Maxibrief mit Einschreiben"),
    PAKET_2KG(5.49, "2kg Paket"),
    PAKET_5KG(6.99, "5kg Paket"),
    PAKET_10KG(9.49, "10kg Paket"),
    PAKET_2KG_ALTERSSICHT(6.68, "2kg Paket mit Alterssichtprüfung");

    final double price;
    final String name;

    Porto(double price, String name) {
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
