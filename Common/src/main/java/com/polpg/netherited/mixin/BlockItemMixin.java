package com.polpg.netherited.mixin;

import com.polpg.netherited.interfaces.IBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockItem.class)
public class BlockItemMixin {
    
    
    @Inject(method = "updateCustomBlockEntityTag(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/item/ItemStack;)Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/BlockItem;getBlockEntityData(Lnet/minecraft/world/item/ItemStack;)Lnet/minecraft/nbt/CompoundTag;"), cancellable = true)
    private static void setBlockEntityEnchantments(Level level, Player player, BlockPos pos, ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity == null) return;
        if (!level.isClientSide && blockEntity.onlyOpCanSetNbt() && (player == null || !player.isCreative())) {
            cir.setReturnValue(false);
        } else if (stack.isEnchanted()) {
            ((IBlockEntity) blockEntity).setFireproofEnchantments(stack.getEnchantmentTags());
        }
    }
    
    
}
