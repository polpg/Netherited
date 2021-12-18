package com.polpg.netherited.platform;

import com.polpg.netherited.EnchantmentFireproof;
import com.polpg.netherited.NetheritedMod;

public class FabricPlatformHelper implements IPlatformHelper {
    
    @Override
    public EnchantmentFireproof getFireproofEnch() {
        return NetheritedMod.FIREPROOF;
    }
    
}
