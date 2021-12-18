package com.polpg.netherited;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class EnchantmentFireproof extends Enchantment {
    
    public EnchantmentFireproof() {
        super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.BREAKABLE, EquipmentSlot.values());
    }
    
    @Override
    public boolean isTreasureOnly() {
        return true;
    }
    
    @Override
    public int getMaxLevel() {
        return 1;
    }
    
    @Override
    public boolean canEnchant(ItemStack stack) {
        if (stack.getItem() == Items.BOOK) return false;
        if (stack.getItem() instanceof BlockItem) return false;
        return !stack.getItem().isFireResistant();
    }
    
    
}
