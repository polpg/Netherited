package com.polpg.netherited.platform;

import com.polpg.netherited.Registration;
import com.polpg.netherited.platform.services.IPlatformHelper;
import net.minecraft.core.component.DataComponentType;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;

import java.util.function.Supplier;

public class NeoForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.getCurrent().isProduction();
    }
    
    @Override
    public <T> Supplier<DataComponentType<T>> registerEnchantmentEffectComponent(String componentName, DataComponentType<T> component) {
        return Registration.register(componentName, component);
    }
}
