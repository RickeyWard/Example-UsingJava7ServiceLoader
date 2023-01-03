package com.swampfox.serviceapi;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ServiceLoader;

/**
 * CakeMangerFactory
 * This is for convenience, Makes it easier for your consumer to find the service providers,
 * abstracting it away from your consumer is common practice 
 */
public class CakeMangerFactory {

    private static CakeMangerFactory provider;
    private ServiceLoader<CakeServiceProvider> loader;

    private CakeMangerFactory(){
        loader = ServiceLoader.load(CakeServiceProvider.class);
    }

    public static CakeMangerFactory getInstance(){
        if(provider == null){
            provider = new CakeMangerFactory();
        }
        return provider;
    }

    public CakeServiceProvider getServiceImplProvider(){
        CakeServiceProvider service = loader.iterator().next();

        if(service != null)
            return service;
        else
            throw new NoSuchElementException("no implmentations for Cake Service Provider");
    }

    public List<CakeServiceProvider> getServiceProviders(){
        List<CakeServiceProvider> providers = new ArrayList<CakeServiceProvider>();
        ServiceLoader<CakeServiceProvider> loader = ServiceLoader.load(CakeServiceProvider.class);
        for (CakeServiceProvider p : loader) {
            providers.add(p);
        }

        return providers;
    }

    // recommended way
    public static CakeServiceProvider findServiceProvider(String name){

        ServiceLoader<CakeServiceProvider> loader = ServiceLoader.load(CakeServiceProvider.class);
        for (CakeServiceProvider p : loader) {
            if(p.getName().equalsIgnoreCase(name))
                return p;
        }

        throw new NoSuchElementException("no implmentations for Cake Manager");
    }
}