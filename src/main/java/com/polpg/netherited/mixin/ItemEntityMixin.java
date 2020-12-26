package com.polpg.netherited.mixin;

import com.polpg.netherited.NetheritedMod;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.item.EnchantedBookItem.getEnchantmentTag;

@Mixin(ItemEntity.class)
public class ItemEntityMixin {

    @Inject(method = "isFireImmune", at = @At("RETURN"))
    public boolean isFireImmune(CallbackInfoReturnable info) {
        ItemEntity item = (ItemEntity) (Object) this;
        ItemStack stack = item.getStack();

        if (EnchantmentHelper.getLevel(NetheritedMod.ENCHANTMENT_FIREPROOF, stack) == 1) {
            return true;
        }
        if (stack.getItem() == Items.ENCHANTED_BOOK) {
            if (EnchantmentHelper.fromTag(getEnchantmentTag(stack)).containsKey(NetheritedMod.ENCHANTMENT_FIREPROOF)) {
                return true;
            }
        }
        return info.getReturnValueZ();
    }
}
