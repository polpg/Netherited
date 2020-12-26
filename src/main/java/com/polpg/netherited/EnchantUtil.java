package com.polpg.netherited;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.HashMap;
import java.util.Map;

public class EnchantUtil {

    public static ItemStack getFireproofBook() {
        ItemStack book = new ItemStack(Items.ENCHANTED_BOOK);
        Map<Enchantment, Integer> ench = new HashMap<Enchantment, Integer>();
        ench.put(NetheritedMod.ENCHANTMENT_FIREPROOF, 1);
        EnchantmentHelper.set(ench, book);
        return book;
    }
}
