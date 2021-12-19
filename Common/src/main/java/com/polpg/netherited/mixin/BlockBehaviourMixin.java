package com.polpg.netherited.mixin;

import com.polpg.netherited.interfaces.IBlockEntity;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Map;

@Mixin(BlockBehaviour.class)
public class BlockBehaviourMixin {
    
    @Inject(method = "getDrops", at = @At("TAIL"))
    private void setDroppedEnchants(BlockState state, LootContext.Builder builder, CallbackInfoReturnable<List<ItemStack>> cir) {
        if (state.getBlock() instanceof BaseEntityBlock) {
            List<ItemStack> stacks = cir.getReturnValue();
            
            for (ItemStack stack : stacks) {
                if (stack.is(state.getBlock().asItem())) {
                    BlockEntity blockEntity = builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
                    if (blockEntity != null) {
                        Tag enchantments = ((IBlockEntity) blockEntity).getFireproofEnchantments();
                        if(enchantments != null) {
                            Map<Enchantment, Integer> enchantmentMap = EnchantmentHelper.deserializeEnchantments((ListTag) enchantments);
                            EnchantmentHelper.setEnchantments(enchantmentMap, stack);
                        }
                    }
                }
            }
        }
    }
}
