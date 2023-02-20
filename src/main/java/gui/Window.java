package gui;/*  Created on 10.02.2023
 *
 *  Copyright (c) 2023
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class Window extends JFrame {

    public Window() {
        setSize(new Dimension(700, 300));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
