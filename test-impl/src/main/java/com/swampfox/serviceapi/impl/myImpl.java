package com.swampfox.serviceapi.impl;

import java.util.ArrayList;
import java.util.List;

import com.swampfox.serviceapi.Cake;
import com.swampfox.serviceapi.CakeManager;

/**
 * myImpl - this is the actual implimentation, the reason this jar exists, as it were
 */
public class myImpl implements CakeManager {

    @Override
	public List<Cake> getCakes() {
        List<Cake> cakes = new ArrayList<Cake>();
        Cake c = new Cake();
        c.name= "Best Dynamic Cake";
        cakes.add(c);
        return cakes;
    }
    
    @Override
    public String getName(){
        return "Best Manger";
    }

    
}