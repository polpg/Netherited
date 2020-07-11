package com.polpg.netherited.mixin;

import com.polpg.netherited.NetheritedMod;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class EntityMixin {

    @Inject(method = "setOnFireFromLava", at = @At("INVOKE"), cancellable = true)
    protected void setOnFireFromLava(CallbackInfo info) {
        Entity entity = (Entity) (Object) this;
        if (entity.getType() == EntityType.ITEM) {
            ItemEntity item = (ItemEntity) (Object) entity;
            if (EnchantmentHelper.getLevel(NetheritedMod.ENCHANTMENT_FIREPROOF, item.getStack()) == 1) {
                info.cancel();
            }
        }

    }

}
