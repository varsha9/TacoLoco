/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.TacoLocoAPI.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * 
 * SAMPLE POST BODY
 * CONTENT TYPE : APPLICATION/JSON
	{
	"orderID" : 1,
	"tacos": [
		{
			"id": "1",
			"item_name": "veggie Taco",
			"quantity": "1"
		},
		
		{
			"id": "2",
			"item_name": "chicken Taco",
			"quantity": "1"
		},
		
		{
			"id": "3",
			"item_name": "beef Taco",
			"quantity": "1"
		},
		
		{
			"id": "4",
			"item_name": "chorizo Taco",
			"quantity": "1"
		}
		
		]
}

 * 
 * @author SriVarshaKantheti
 */
public class Order2 {

    //variables to store the price of each tacos
    private final double VEGGIE_TACO_PRICE = 2.5;
    private final double CHICKEN_TACO_PRICE = 3.0;
    private final double BEEF_TACO_PRICE = 3.0;
    private final double CHORIZO_TACO_PRICE = 3.5;

    //variable to hold the order ID
    @JsonProperty
    private Long orderID;
    //variable to hold the array of Taco's ordered
    @JsonProperty
    private Taco[] tacos;

    //getter methods
    public Long getOrderID() {
        return orderID;
    }

    public Taco[] getTacos() {
        return tacos;
    }

    /**
     * Returns the order total of the Taco's
     * @return 
     */
    public double getOrderTotal() {
       //variable to store the order total of the taco's
        double sum = 0;
        //variable to store the total quantity of taco's ordered
        double total_qty = 0;
        
        //loops through the array of taco's and calculate the price for each taco,then adds it to the total sum of taco's
        //it also checks for the taco name to determine the price for each specified taco
        for (Taco taco : tacos) {
            double price = 0;
            
            if (taco.getItem_name().equalsIgnoreCase("veggie taco")) {
                //calculates the price of veggie taco
                price = taco.getQuantity() * VEGGIE_TACO_PRICE;
                //adds the quantity of veggie taco ordered to the sum total of taco's ordered
                total_qty+=taco.getQuantity();
            } else if (taco.getItem_name().equalsIgnoreCase("chicken taco")) {
                //calculates the price of chicken taco
                price = taco.getQuantity() * CHICKEN_TACO_PRICE;
                //adds the quantity of chicken taco ordered to the sum total of taco's ordered
                total_qty+=taco.getQuantity();
            } else if (taco.getItem_name().equalsIgnoreCase("beef taco")) {
                //calculates the price of beef taco
                price = taco.getQuantity() * BEEF_TACO_PRICE;
                //adds the quantity of beef taco ordered to the sum total of taco's ordered
                total_qty+=taco.getQuantity();
            } else if (taco.getItem_name().equalsIgnoreCase("chorizo taco")) {
                //calculates the price of chorizo taco
                price = taco.getQuantity() * CHORIZO_TACO_PRICE;
                //adds the quantity of chorizo taco ordered to the sum total of taco's ordered
                total_qty+=taco.getQuantity();
            }
            //adds the price of the taco ordered to the sum total
            sum+=price;
        }
        
        //tests if the total quantity of taco's ordered is greater or equal to 4.
        //if true, it sets the discount variable to 20%
        if(total_qty>=4){
            //20% discount
            sum-=(0.2*sum);   
        }
        return sum;
    }
}
