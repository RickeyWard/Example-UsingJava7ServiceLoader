package com.swampfox.serviceapi.consumer;

import java.util.List;

import com.swampfox.serviceapi.CakeManager;
import com.swampfox.serviceapi.CakeMangerFactory;
import com.swampfox.serviceapi.CakeServiceProvider;

/**
 * find all CakeServiceProviders
 * list them, and then read off all the cakes they are providing
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            List<CakeServiceProvider> cms = CakeMangerFactory.getInstance().getServiceProviders();
            
            for (CakeServiceProvider cmp : cms){
                System.out.println("CakeServiceProvide: " + cmp.getName());
                CakeManager cm = cmp.create();
                cm.getCakes().forEach(cake -> {
                    System.out.println(cake.name);
                });
            }
        } catch (Exception e) {
            System.out.println("No Cake Managers Found");
        }
    }
}
