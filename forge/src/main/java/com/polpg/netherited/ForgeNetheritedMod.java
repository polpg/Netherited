package com.polpg.netherited;

import net.minecraftforge.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class ForgeNetheritedMod {
    
    public ForgeNetheritedMod() {
        CommonClass.init();
        Registration.init();
    }
}