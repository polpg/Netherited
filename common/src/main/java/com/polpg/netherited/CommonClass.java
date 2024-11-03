package com.polpg.netherited;

import com.polpg.netherited.platform.Services;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.util.Unit;

import java.util.function.Supplier;

public class CommonClass {
    
    public static final Supplier<DataComponentType<Unit>> FIREPROOF_COMPONENT =
            Services.PLATFORM.registerEnchantmentEffectComponent(
                    Constants.FIREPROOF_ID,
                    DataComponentType.<Unit>builder().persistent(Unit.CODEC).build()
            );
    
    public static void init() {
    }
}