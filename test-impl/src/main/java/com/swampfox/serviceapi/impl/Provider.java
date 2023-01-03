package com.swampfox.serviceapi.impl;

import com.google.auto.service.AutoService;
import com.swampfox.serviceapi.CakeManager;
import com.swampfox.serviceapi.CakeServiceProvider;

/**
 * provider
 * this is what will be "found" by the service loader, it provides identification, and a way to create the implimentation.
 */
@AutoService(CakeServiceProvider.class)
public class Provider implements CakeServiceProvider {

	@Override
	public String getName() {
		return "Provider 1 - testy provider";
	}

	@Override
	public CakeManager create() {
		return new myImpl();
	}

}