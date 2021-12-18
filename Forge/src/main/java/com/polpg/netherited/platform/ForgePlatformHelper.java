package com.polpg.netherited.platform;

import com.polpg.netherited.EnchantmentFireproof;

import static com.polpg.netherited.Registration.FIREPROOF;

public class ForgePlatformHelper implements IPlatformHelper{
    
    @Override
    public EnchantmentFireproof getFireproofEnch() {
        return (EnchantmentFireproof) FIREPROOF.get();
    }
    
}
