/*  Created on 10.02.2023
 *
 *  Copyright (c) 2023
 *  RegitStudios, Hückelhoven, Germany
 *
 *  All rights reserved
 */
package gui;

import enums.PackingPrice;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static enums.PackingPrice.*;
import static java.lang.Double.parseDouble;
import static java.lang.Math.round;
import static java.lang.String.valueOf;
import static java.util.Arrays.asList;

/**
 * @author <a href="mailto:fabian.stetter@regitstudios.de">Fabian Stetter</a>
 */
public class CalculatePane extends JPanel {

    private final List<PackingPrice> packingPrices = new ArrayList<>(asList(
            KLEINE_VERSANDTASCHE_NATIONAL, KLEINE_VERSANDTASCHE_INTERNATIONAL,
            GROSSE_VERSANDTASCHE_ALS_GROSSBRIEF_NATIONAL, GROSSE_VERSANDTASCHE_ALS_GROSSBRIEF_INTERNATINAL,
            GROSSE_VERSANDTASCHE_ALS_MAXIBRIEF_NATIONAL, GROSSE_VERSANDTASCHE_ALS_MAXIBRIEF_INTERNATIONAL,
            PAKET_2KG_NATIONAL, PAKET_2KG_INTERNATIONAL,
            PAKET_5KG_NATIONAL, PAKET_5KG_INTERNATIONAL,
            PAKET_10KG_NATIONAL, PAKET_10KG_INTERNATIONAL));

    public CalculatePane() {
        setLayout(null);
        initialize();
    }

    private void initialize() {
        final JLabel buyPrice = new JLabel("Kaufpreis: ");
        final JTextField buyPriceText = new JTextField();
        final JLabel packingPricesLabel = new JLabel("Versandpreis: ");
        final JComboBox<String> packingPriceCombo = new JComboBox<>();
        for(PackingPrice packingPrice : packingPrices) {
            packingPriceCombo.addItem(packingPrice.getName() + " - " + packingPrice.getPrice());
        }
        final JLabel manufacturCost = new JLabel("Herstellungskosten: ");
        final JTextField manufacturCostText = new JTextField();
        final JLabel profit = new JLabel("Gewinnspanne: ");
        final JTextField profitText = new JTextField();
        final JTextField actProfitText = new JTextField();
        final JLabel tax = new JLabel("Umsatzsteuer: ");
        final JTextField taxText = new JTextField("19");
        final JTextField actTaxText = new JTextField();
        final JLabel ebayTax = new JLabel("Ebay Gebühren: ");
        final JTextField ebayTaxText = new JTextField("11");
        final JTextField actEbayTax = new JTextField();
        final JLabel total = new JLabel("Summe: ");
        final JTextField totalText = new JTextField();
        final JLabel withoutShipping = new JLabel("Ohne Versand: ");
        final JTextField withoutShippingText = new JTextField();
        buyPrice.setBounds(5, 5, 150, 20);
        add(buyPrice);
        buyPriceText.setBounds(160, 5, 300, 20);
        add(buyPriceText);
        packingPricesLabel.setBounds(5, 30, 150, 20);
        add(packingPricesLabel);
        packingPriceCombo.setBounds(160, 30, 300, 20);
        add(packingPriceCombo);
        manufacturCost.setBounds(5, 55, 150, 20);
        add(manufacturCost);
        manufacturCostText.setBounds(160, 55, 300, 20);
        add(manufacturCostText);
        profit.setBounds(5, 80, 150, 20);
        add(profit);
        profitText.setBounds(160, 80, 145, 20);
        add(profitText);
        actProfitText.setBounds(310, 80, 150, 20);
        add(actProfitText);
        tax.setBounds(5, 105, 150, 20);
        add(tax);
        taxText.setBounds(160, 105, 145, 20);
        add(taxText);
        actTaxText.setBounds(310, 105, 150, 20);
        add(actTaxText);
        ebayTax.setBounds(5, 130, 150, 20);
        add(ebayTax);
        ebayTaxText.setBounds(160, 130, 145, 20);
        add(ebayTaxText);
        actEbayTax.setBounds(310, 130, 150, 20);
        add(actEbayTax);
        total.setBounds(5, 155, 150, 20);
        add(total);
        totalText.setBounds(160, 155, 150, 20);
        add(totalText);
        withoutShipping.setBounds(5, 180, 150, 20);
        add(withoutShipping);
        withoutShippingText.setBounds(160, 180, 150, 20);
        add(withoutShippingText);

        final JButton calculate = new JButton("Calculate");

        calculate.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double tempTotal;
                double tempBuyPrice = parseDouble(buyPriceText.getText());
                String tempShipping = (String) packingPriceCombo.getSelectedItem();
                String[] tempShipping2 = tempShipping.split("-");
                String tempShipping3 = tempShipping2[1].replace(" ", "");
                double tempShippingPrice = parseDouble(tempShipping3);
                double tempManufacturerCost = round((tempBuyPrice + tempShippingPrice) * 100.0) / 100.0;
                tempTotal = tempManufacturerCost;
                manufacturCostText.setText(valueOf(tempTotal));
                double tempProfitMargin = parseDouble(profitText.getText()) / 100;
                double tempProfit = round((tempTotal * tempProfitMargin) * 100.0) / 100.0;
                actProfitText.setText(valueOf(tempProfit));
                tempTotal += tempProfit;
                double tempTaxMargin = parseDouble(taxText.getText()) / 100;
                double tempTax = round((tempTotal * tempTaxMargin) * 100.0) / 100.0;
                actTaxText.setText(valueOf(tempTax));
                tempTotal += tempTax;
                double tempEbayTaxMargin = parseDouble(ebayTaxText.getText()) / 100;
                double tempEbayTax = round((tempTotal * tempEbayTaxMargin) * 100.0) / 100.0;
                actEbayTax.setText(valueOf(tempEbayTax));
                tempTotal += tempEbayTax;
                tempTotal = round(tempTotal * 100.0) / 100.0;
                totalText.setText(valueOf(tempTotal));
                withoutShippingText.setText(valueOf(tempTotal - tempShippingPrice));
            }
        });

        calculate.setBounds(5, 205, 150, 20);
        add(calculate);

        final JButton clear = new JButton("Clear");

        clear.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buyPriceText.setText("");
                manufacturCostText.setText("");
                actProfitText.setText("");
                actTaxText.setText("");
                actEbayTax.setText("");
                totalText.setText("");
                withoutShippingText.setText("");
            }
        });

        clear.setBounds(160, 205, 150, 20);
        add(clear);

        final JButton profitButton = new JButton("Profit");
        profitButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double profit;
                double tempWithoutFees = parseDouble(withoutShippingText.getText());
                String tempShipping = (String) packingPriceCombo.getSelectedItem();
                String[] tempShipping2 = tempShipping.split("-");
                String tempShipping3 = tempShipping2[1].replace(" ", "");
                double tempShippingPrice = parseDouble(tempShipping3);
                double sum = round((tempWithoutFees + tempShippingPrice) * 100.0) / 100.0;
                totalText.setText(valueOf(sum));
                double tempEbayVar = 100 + parseDouble(ebayTaxText.getText());
                double tempEbayVar2 = sum / tempEbayVar;
                double tempEbayVar3 = round((tempEbayVar2 * (tempEbayVar - 100)) * 100.0) / 100.0;
                double tempEbayTax = sum - tempEbayVar3;
                actEbayTax.setText(valueOf(tempEbayVar3));
                profit = tempEbayTax;
                double tempTaxVar = 100 + parseDouble(taxText.getText());
                double tempTaxVar2 = profit / tempTaxVar;
                double tempTaxVar3 = round((tempTaxVar2 * (tempTaxVar - 100)) * 100.0) / 100.0;
                double tempTax = profit - tempTaxVar3;
                actTaxText.setText(valueOf(tempTaxVar3));
                profit = tempTax;
                double buyPrice = parseDouble(buyPriceText.getText());
                double manufacturerCost = tempShippingPrice + buyPrice;
                manufacturCostText.setText(valueOf(round(manufacturerCost * 100.0) / 100.0));
                profit -= manufacturerCost;
                actProfitText.setText(valueOf(round(profit * 100.0) / 100.0));
            }
        });

        profitButton.setBounds(315, 205, 150, 20);
        add(profitButton);
    }
}

