package com.polpg.netherited;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class Registration {
    
    private static final DeferredRegister<DataComponentType<?>> ENCHANTMENT_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, Constants.MOD_ID);
    
    public static void init(IEventBus eventBus) {
        ENCHANTMENT_EFFECTS.register(eventBus);
    }
    
    public static <T> Supplier<DataComponentType<T>> register(final String componentName, final DataComponentType<T> component) {
        return ENCHANTMENT_EFFECTS.register(
                componentName,
                () -> component
        );
    }
}
