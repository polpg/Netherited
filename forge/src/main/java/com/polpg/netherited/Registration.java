package com.polpg.netherited;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class Registration {
    
    private static final DeferredRegister<DataComponentType<?>> ENCHANTMENT_EFFECTS =
            DeferredRegister.create(Registries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, Constants.MOD_ID);
    
    public static void init() {
        ENCHANTMENT_EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    
    public static <T> Supplier<DataComponentType<T>> register(final String componentName, final DataComponentType<T> component) {
        return ENCHANTMENT_EFFECTS.register(
                componentName,
                () -> component
        );
    }
}
