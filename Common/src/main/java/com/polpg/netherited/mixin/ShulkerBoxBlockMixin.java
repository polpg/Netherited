package com.polpg.netherited.mixin;


import com.polpg.netherited.interfaces.IBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Map;

@Mixin(ShulkerBoxBlock.class)
public class ShulkerBoxBlockMixin {
    
    @Inject(method = "playerWillDestroy", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/item/ItemEntity;<init>(Lnet/minecraft/world/level/Level;DDDLnet/minecraft/world/item/ItemStack;)V"), locals = LocalCapture.CAPTURE_FAILSOFT)
    private void setDroppedEnchants(Level level, BlockPos pos, BlockState state, Player player, CallbackInfo ci, BlockEntity blockEntity, ShulkerBoxBlockEntity shulkerBoxBlockEntity, ItemStack stack) {
        Tag enchantments = ((IBlockEntity) blockEntity).getFireproofEnchantments();
        if (enchantments != null) {
            Map<Enchantment, Integer> enchantmentMap = EnchantmentHelper.deserializeEnchantments((ListTag) enchantments);
            EnchantmentHelper.setEnchantments(enchantmentMap, stack);
        }
    }

}
