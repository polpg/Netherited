package com.polpg.netherited.mixin;


import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(ShulkerBoxBlock.class)
public class ShulkerBoxBlockMixin {
    
    @Inject(at = @At(value = "TAIL"), method = "getDrops")
    private void getDrops(BlockState state, LootParams.Builder builder, CallbackInfoReturnable<List<ItemStack>> cir) {
        BlockEntity blockEntity = builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (blockEntity != null) {
            final ItemEnchantments enchantments = blockEntity.collectComponents()
                    .getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
            if (!enchantments.isEmpty()) {
                cir.getReturnValue().stream()
                        .filter(stack -> stack.is(state.getBlock().asItem()))
                        .forEach(stack -> netherited$updateStackEnchantments(stack, enchantments));
            }
        }
    }
    
    @Unique
    private void netherited$updateStackEnchantments(ItemStack stack, ItemEnchantments enchantments) {
        stack.applyComponents(DataComponentMap.builder().set(DataComponents.ENCHANTMENTS, enchantments).build());
    }
}
