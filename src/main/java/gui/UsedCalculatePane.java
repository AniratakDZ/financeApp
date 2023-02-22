/*  Created on 21.02.2023
 *
 *  Copyright (c) 2023
 *  RegitStudios, Hückelhoven, Germany
 *
 *  IntelliJ IDEA@financeApp/gui/UsedCalculatePane
 *
 *  All rights reserved
 */

package gui;

import enums.PackingPrices;
import enums.Porto;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static enums.PackingPrices.*;
import static enums.Porto.*;
import static java.lang.Double.parseDouble;
import static java.lang.String.valueOf;
import static java.util.List.of;
import static utils.CalculateUtils.*;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 * On Time 23:41:11
 */

public class UsedCalculatePane extends JPanel {

    private JLabel buyPriceLabel, sellPriceLabel, shippingFeesLabel, ebayFeesLabel, differenceLabel, vatLabel, grossProfitLabel, packingPriceLabel, netProfitLabel,
    productNameLabel, productInformationLabel;
    private JTextField buyPriceText, sellPriceText, ebayFeesText, differenceText, vatText, grossProfitText, netProfitText, shippingFeesText, packingPriceText,
    productNameText;
    private JComboBox<String> shippingFeesCombo, packingPriceCombo;
    private JButton calculateButton, clearButton, exportExcelButton;

    private final List<Porto> shippingFees = new ArrayList<>(of(GROSSBRIEF_EINSCHREIBEN, MAXIBRIEF_EINSCHREIBEN, PAKET_2KG, PAKET_5KG, PAKET_10KG, PAKET_2KG_ALTERSSICHT));
    private final List<PackingPrices> packingPrices = new ArrayList<>(of(KLEINE_VERSANDTASCHE, GROSSE_VERSANDTASCHE, KLEINER_KARTON, NORMALER_KARTON));

    public UsedCalculatePane() {
        setLayout(null);
        initialize();
        createPanel();
        addComponents();
    }

    private void initialize() {
        buyPriceLabel = new JLabel("Einkaufspreis");
        sellPriceLabel = new JLabel("Verkaufspreis");
        shippingFeesLabel = new JLabel("Versandkosten");
        ebayFeesLabel = new JLabel("Ebay-Gebühren");
        differenceLabel = new JLabel("Differenz");
        vatLabel = new JLabel("Umsatzsteuer");
        grossProfitLabel = new JLabel("Brutto-Gewinn");
        packingPriceLabel = new JLabel("Verpackungsmaterial");
        netProfitLabel = new JLabel("Netto-Gewinn");
        productInformationLabel = new JLabel("Produktinformationen");
        productNameLabel = new JLabel("Produktname");
        buyPriceText = new JTextField();
        sellPriceText = new JTextField();
        ebayFeesText = new JTextField();
        differenceText = new JTextField();
        vatText = new JTextField();
        grossProfitText = new JTextField();
        netProfitText = new JTextField();
        shippingFeesText = new JTextField();
        packingPriceText = new JTextField();
        productNameText = new JTextField();
        ebayFeesText.setEditable(false);
        differenceText.setEditable(false);
        vatText.setEditable(false);
        grossProfitText.setEditable(false);
        netProfitText.setEditable(false);
        shippingFeesText.setEditable(false);
        packingPriceText.setEditable(false);
        shippingFeesCombo = new JComboBox<>();
        for (Porto porto : shippingFees) {
            shippingFeesCombo.addItem(porto.getName());
        }
        packingPriceCombo = new JComboBox<>();
        for(PackingPrices packingPrice : packingPrices) {
            packingPriceCombo.addItem(packingPrice.getName());
        }
        calculateButton = new JButton("Calculate");
        clearButton = new JButton("Clear");
        exportExcelButton = new JButton("Zwischenablage");
        calculateButton.addActionListener(new CalculateListener());
        shippingFeesCombo.addActionListener(new ShippingFeesListener());
        packingPriceCombo.addActionListener(new PackingPriceListener());
        clearButton.addActionListener(new ClearListener());
        exportExcelButton.addActionListener(new ExportExcelListener());
    }

    private void createPanel() {
        buyPriceLabel.setBounds(5, 5, 150, 20);
        buyPriceText.setBounds(160, 5, 300, 20);
        sellPriceLabel.setBounds(5, 30, 150, 20);
        sellPriceText.setBounds(160, 30, 300, 20);
        shippingFeesLabel.setBounds(5, 55, 150, 20);
        shippingFeesCombo.setBounds(160, 55, 300, 20);
        shippingFeesText.setBounds(465, 55, 150, 20);
        ebayFeesLabel.setBounds(5, 80, 150, 20);
        ebayFeesText.setBounds(160, 80, 300, 20);
        differenceLabel.setBounds(5, 105, 150, 20);
        differenceText.setBounds(160, 105, 300, 20);
        vatLabel.setBounds(5, 130, 150, 20);
        vatText.setBounds(160, 130, 300, 20);
        grossProfitLabel.setBounds(5, 155, 150, 20);
        grossProfitText.setBounds(160, 155, 300, 20);
        packingPriceLabel.setBounds(5, 180, 150, 20);
        packingPriceCombo.setBounds(160, 180, 300, 20);
        packingPriceText.setBounds(465, 180, 150, 20);
        netProfitLabel.setBounds(5, 205, 150, 20);
        netProfitText.setBounds(160, 205, 300, 20);
        productInformationLabel.setBounds(5, 255, 150, 20);
        productNameLabel.setBounds(5, 280, 150, 20);
        productNameText.setBounds(160, 280, 300, 20);
        clearButton.setBounds(230, 480, 220, 20);
        calculateButton.setBounds(5, 480, 220, 20);
        exportExcelButton.setBounds(455, 480, 220, 20);

        shippingFeesText.setText(valueOf(getShippingFees() + "€"));
        packingPriceText.setText(valueOf(getPackingPrices() + "€"));
    }

    private void addComponents() {
        add(buyPriceLabel);
        add(buyPriceText);
        add(sellPriceLabel);
        add(sellPriceText);
        add(shippingFeesLabel);
        add(shippingFeesCombo);
        add(shippingFeesText);
        add(ebayFeesLabel);
        add(ebayFeesText);
        add(differenceLabel);
        add(differenceText);
        add(vatLabel);
        add(vatText);
        add(grossProfitLabel);
        add(grossProfitText);
        add(packingPriceLabel);
        add(packingPriceCombo);
        add(packingPriceText);
        add(netProfitLabel);
        add(netProfitText);
        add(productInformationLabel);
        add(productNameLabel);
        add(productNameText);
        add(calculateButton);
        add(clearButton);
        add(exportExcelButton);
    }

    private double getShippingFees() {
        return shippingFees.stream().filter(e -> e.getName().equals(shippingFeesCombo.getSelectedItem())).toList().get(0).getPrice();
    }

    private double getPackingPrices() {
        return packingPrices.stream().filter(e -> e.getName().equals(packingPriceCombo.getSelectedItem())).toList().get(0).getPrice();
    }

    private class CalculateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            final double ebayFees = calculateEbayFees(parseDouble(sellPriceText.getText()), getShippingFees());
            ebayFeesText.setText(valueOf(ebayFees + "€"));

            final double actualShippingFees = calculateActualShippingFees(getShippingFees(), parseDouble(sellPriceText.getText()));
            final double actualSum = calculateActualSum(parseDouble(sellPriceText.getText()), getShippingFees(), ebayFees);
            final double difference = calculateDifference(actualShippingFees, parseDouble(buyPriceText.getText()), actualSum);
            differenceText.setText(valueOf(difference) + "€");

            final double vat = calculateVAT(difference, actualShippingFees);
            vatText.setText(valueOf(vat) + "€");

            final double grossProfit = calculateGrossProfit(actualSum, vat, getShippingFees());
            grossProfitText.setText(valueOf(grossProfit) + "€");

            final double netProfit = calculateNetProfit(getPackingPrices(), grossProfit);
            netProfitText.setText(valueOf(netProfit) + "€");
        }
    }

    private class ShippingFeesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            shippingFeesText.setText(valueOf(getShippingFees() + "€"));
        }
    }

    private class PackingPriceListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            packingPriceText.setText(valueOf(getPackingPrices() + "€"));
        }
    }

    private class ClearListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            buyPriceText.setText("");
            sellPriceText.setText("");
            shippingFeesCombo.setSelectedIndex(0);
            shippingFeesText.setText(valueOf(getShippingFees() + "€"));
            ebayFeesText.setText("");
            differenceText.setText("");
            vatText.setText("");
            grossProfitText.setText("");
            packingPriceCombo.setSelectedIndex(0);
            packingPriceText.setText(valueOf(getPackingPrices() + "€"));
            netProfitText.setText("");
        }
    }

    private class ExportExcelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String excelOutput = "";
            excelOutput += productNameText.getText() + ";";
            excelOutput += format(valueOf((parseDouble(sellPriceText.getText()) + getShippingFees())));
            excelOutput += format(sellPriceText.getText());
            excelOutput += format(valueOf(getShippingFees()));
            excelOutput += format(vatText.getText());
            excelOutput += format(ebayFeesText.getText());
            excelOutput += format(netProfitText.getText()).replace(";", "");

            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
                    new StringSelection(excelOutput), null
            );
        }
    }

    private String format(String value) {
        value = value.replace(".", ",");
        if(!value.contains("€")) {
            value += "€";
        }
        value += ";";
        return value;
    }
}