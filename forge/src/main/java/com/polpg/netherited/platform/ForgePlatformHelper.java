package com.polpg.netherited.platform;

import com.polpg.netherited.Registration;
import com.polpg.netherited.platform.services.IPlatformHelper;
import net.minecraft.core.component.DataComponentType;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;

import java.util.function.Supplier;

public class ForgePlatformHelper implements IPlatformHelper {
    
    @Override
    public String getPlatformName() {
        return "Forge";
    }
    
    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }
    
    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.isProduction();
    }
    
    @Override
    public <T> Supplier<DataComponentType<T>> registerEnchantmentEffectComponent(String componentName, DataComponentType<T> component) {
        return Registration.register(componentName, component);
    }
}
