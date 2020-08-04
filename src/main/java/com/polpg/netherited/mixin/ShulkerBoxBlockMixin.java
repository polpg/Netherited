package com.polpg.netherited.mixin;

import com.polpg.netherited.NetheritedMod;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;

@Mixin(ShulkerBoxBlock.class)
public class ShulkerBoxBlockMixin {

    @Inject(method = "onPlaced", at = @At("HEAD"))
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack, CallbackInfo info) {
       if (EnchantmentHelper.getLevel(NetheritedMod.ENCHANTMENT_FIREPROOF, itemStack) == 1) {

           ItemStack book = new ItemStack(Items.ENCHANTED_BOOK);
           Map<Enchantment, Integer> ench = new HashMap<Enchantment, Integer>();
           ench.put(NetheritedMod.ENCHANTMENT_FIREPROOF, 1);
           EnchantmentHelper.set(ench, book);

           ItemEntity entity = new ItemEntity(world, placer.getPos().x, placer.getPos().y, placer.getPos().z, book);
           world.spawnEntity(entity);

       }
    }
}
