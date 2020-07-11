package com.polpg.netherited;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class NetheritedMod implements ModInitializer {

	public static final EnchantmentFireproof ENCHANTMENT_FIREPROOF = new EnchantmentFireproof();

	@Override
	public void onInitialize() {
		Registry.register(Registry.ENCHANTMENT, new Identifier("netherited", "fireproof"), ENCHANTMENT_FIREPROOF);
	}
}
