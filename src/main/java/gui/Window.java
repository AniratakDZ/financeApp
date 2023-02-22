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
        setSize(new Dimension(700, 600));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        final Container contentPane = this.getContentPane();
        final JTabbedPane tabbedPane = new JTabbedPane();
        contentPane.add(tabbedPane);
        tabbedPane.addTab("Alte Rechnung", new CalculatePane());
        tabbedPane.addTab("Gebraucht Preisrechner", new UsedCalculatePane());
    }
}
