package com.polpg.netherited.mixin;

import com.polpg.netherited.NetheritedMod;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.ItemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemEntity.class)
public class ItemEntityMixin {

    @Inject(method = "isFireImmune", at = @At("RETURN"))
    public boolean isFireImmune(CallbackInfoReturnable info) {
        ItemEntity item = (ItemEntity) (Object) this;
        if (EnchantmentHelper.getLevel(NetheritedMod.ENCHANTMENT_FIREPROOF, item.getStack()) == 1) {
            return true;
        }
        return info.getReturnValueZ();
    }
}
