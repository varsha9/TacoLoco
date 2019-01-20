/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.TacoLocoAPI.Controller;

import com.example.TacoLocoAPI.Model.Order;
import com.example.TacoLocoAPI.Model.Order2;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SriVarshaKantheti
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String sayHi() {
        return "Welcome to Taco Loco API Service";
    }

    @RequestMapping("/bye")
    public String sayBye() {
        return "Bye bye";
    }

    @PostMapping("/order")
    public Map<String, Double> getOrder1Total(@RequestBody Order order) {
        Assert.notNull(order, "order cannot be null");
        HashMap<String, Double> map = new HashMap<>();
        map.put("order total", order.getOrderTotal());

        return map;
    }

    @PostMapping("/order2")
    public Map<String, Double> getOrder2Total(@RequestBody Order2 order) {
        Assert.notNull(order, "order cannot be null");
        HashMap<String, Double> map = new HashMap<>();
        map.put("order total", order.getOrderTotal());

        return map;
    }
}
