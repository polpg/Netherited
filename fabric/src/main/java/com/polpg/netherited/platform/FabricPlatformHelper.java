package com.polpg.netherited.platform;

import com.polpg.netherited.Constants;
import com.polpg.netherited.platform.services.IPlatformHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

import java.util.function.Supplier;

public class FabricPlatformHelper implements IPlatformHelper {
    
    @Override
    public String getPlatformName() {
        return "Fabric";
    }
    
    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }
    
    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }
    
    @Override
    public <T> Supplier<DataComponentType<T>> registerEnchantmentEffectComponent(String componentName, DataComponentType<T> component) {
        final DataComponentType<T> registeredComponent = Registry.register(
                BuiltInRegistries.ENCHANTMENT_EFFECT_COMPONENT_TYPE,
                Identifier.fromNamespaceAndPath(Constants.MOD_ID, componentName),
                component
        );
        return () -> registeredComponent;
    }
}
