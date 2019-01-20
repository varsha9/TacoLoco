/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.TacoLocoAPI.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author SriVarshaKantheti
 */
public class Order {

    /**
     * {
     * "veggieTaco" : 1,
     * "chickenTaco" : 1,
     * "beefTaco": 0,
     * "chorizoTaco": 1
     * }
     * <p>
     * RAW
     * FORMAT : JSON
     */

    //variables to store the price of each tacos
    private final double VEGGIE_TACO_PRICE = 2.5;
    private final double CHICKEN_TACO_PRICE = 3.0;
    private final double BEEF_TACO_PRICE = 3.0;
    private final double CHORIZO_TACO_PRICE = 3.5;

    //variable to store the order quantity of each tacos
    @JsonProperty
    private int veggieTaco;
    @JsonProperty
    private int chickenTaco;
    @JsonProperty
    private int beefTaco;
    @JsonProperty
    private int chorizoTaco;

    //getter methods
    public int getVeggieTaco() {
        return veggieTaco;
    }

    public int getChickenTaco() {
        return chickenTaco;
    }

    public int getBeefTaco() {
        return beefTaco;
    }

    public int getChorizoTaco() {
        return chorizoTaco;
    }

    /**
     * Returns the order total of the Taco's
     *
     * @return
     */
    public double getOrderTotal() {
        //gets the total sum of taco's ordered
        int totalOrderedTacos = veggieTaco + chickenTaco + beefTaco + chorizoTaco;
        //stores the discount price
        double discount = 0;

        //tests if the total quantity of taco's ordered is greater or equal to 4.
        //if true, it sets the discount variable to 20%
        if (totalOrderedTacos >= 4) {
            discount = 20.0 / 100;
        }

        //calculates the total price for veggie Taco
        double totalVeggie = veggieTaco * VEGGIE_TACO_PRICE;
        //calculates the total price for chicken Taco
        double totalChicken = chickenTaco * CHICKEN_TACO_PRICE;
        //calculates the total price for beef Taco
        double totalBeef = beefTaco * BEEF_TACO_PRICE;
        //calculates the total price for chorizo Taco
        double totalChorizo = chorizoTaco * CHORIZO_TACO_PRICE;

        //calculates the total sum of the taco's ordered
        double sumTotal = totalVeggie + totalChicken + totalBeef + totalChorizo;

        //calculates the discount
        double discounted_price = sumTotal - (discount * sumTotal);

        return discounted_price;
    }

    @Override
    public String toString() {
        return "Order{" + "veggieTaco=" + veggieTaco + ", chickenTaco=" + chickenTaco + ", beefTaco=" + beefTaco + ", chorizoTaco=" + chorizoTaco + '}';
    }


}
