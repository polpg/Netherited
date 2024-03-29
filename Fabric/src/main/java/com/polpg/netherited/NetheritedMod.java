package com.polpg.netherited;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

public class NetheritedMod implements ModInitializer {
    
    public static final EnchantmentFireproof FIREPROOF = new EnchantmentFireproof();
    
    @Override
    public void onInitialize() {
        
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        Constants.LOG.info("Hello Fabric world!");
    
        // Registration
        Registry.register(Registry.ENCHANTMENT, new ResourceLocation("netherited", "fireproof"), FIREPROOF);
    }
}
