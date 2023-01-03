package com.swampfox.serviceapi;

/**
 * CakeServiceProvider
 * ServiceLoader creates instances of all the provers after you call the "load" method.
 *  this means that these should be light-weight factory objects, that can create the thing you want.
 */
public interface CakeServiceProvider {
    String getName();
    CakeManager create();
}