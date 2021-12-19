package com.polpg.netherited.interfaces;

import net.minecraft.nbt.Tag;

public interface IBlockEntity {
    
    Tag getFireproofEnchantments();
    
    void setFireproofEnchantments(Tag enchantments);
}
