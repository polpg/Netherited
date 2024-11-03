package com.polpg.netherited;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class NeoForgeNetheritedMod {

    public NeoForgeNetheritedMod(IEventBus eventBus) {
        CommonClass.init();
        Registration.init(eventBus);
    }
}