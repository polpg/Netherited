package com.polpg.netherited.platform;

import com.polpg.netherited.EnchantmentFireproof;

public interface IPlatformHelper {

    default EnchantmentFireproof getFireproofEnch(){
        return new EnchantmentFireproof();
    }
}
