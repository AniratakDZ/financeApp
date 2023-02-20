/*  Created on 10.02.2023
 *
 *  Copyright (c) 2023
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */

import gui.CalculatePane;
import gui.Window;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class Main {

    public static void main(String[] args) {
        final Window window = new Window();
        final CalculatePane calculatePane = new CalculatePane();
        window.add(calculatePane);
        window.setVisible(true);
    }
}
