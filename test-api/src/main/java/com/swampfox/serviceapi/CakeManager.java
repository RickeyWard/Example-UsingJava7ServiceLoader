package com.swampfox.serviceapi;

import java.util.List;

/**
 * CakeManager - just some top level interface that exposes your functionality
 */
public interface CakeManager {

    String getName();
    List<Cake> getCakes();
}