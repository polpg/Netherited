package com.polpg.netherited.platform.services;

import net.minecraft.core.component.DataComponentType;

import java.util.function.Supplier;

public interface IPlatformHelper {
    
    String getPlatformName();
    
    boolean isModLoaded(String modId);
    
    boolean isDevelopmentEnvironment();
    
    default String getEnvironmentName() {
        return isDevelopmentEnvironment() ? "development" : "production";
    }
    
    <T> Supplier<DataComponentType<T>> registerEnchantmentEffectComponent(String componentName, DataComponentType<T> component);
}
