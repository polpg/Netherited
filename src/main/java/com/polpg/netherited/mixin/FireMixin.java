package com.polpg.netherited.mixin;

import com.polpg.netherited.NetheritedMod;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractFireBlock.class)
public class FireMixin {

    @Inject(at = @At("INVOKE"), method = "onEntityCollision", cancellable = true)
    private void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, CallbackInfo info) {
        if (entity.getType() == EntityType.ITEM) {
            ItemEntity item = (ItemEntity) entity;
           if (EnchantmentHelper.getLevel(NetheritedMod.ENCHANTMENT_FIREPROOF, item.getStack()) == 1) {
               info.cancel();
           }
        }
    }
}
