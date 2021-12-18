package com.polpg.netherited.mixin;

import com.polpg.netherited.platform.Services;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemEntity.class)
public class ItemEntityMixin {
    
    @Inject(at = @At("HEAD"), method = "fireImmune()Z", cancellable = true)
    private void fireImmune(CallbackInfoReturnable<Boolean> cir) {
        ItemEntity item = (ItemEntity) (Object) this;
        ItemStack stack = item.getItem();
        
        if (EnchantmentHelper.getItemEnchantmentLevel(Services.PLATFORM.getFireproofEnch(), stack) == 1) {
            cir.setReturnValue(true);
        }
        if (stack.getItem() == Items.ENCHANTED_BOOK) {
            if (EnchantmentHelper.getEnchantments(stack).containsKey(Services.PLATFORM.getFireproofEnch())) {
                cir.setReturnValue(true);
            }
        }
        
    }
}
