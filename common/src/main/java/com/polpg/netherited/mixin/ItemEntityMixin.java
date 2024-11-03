package com.polpg.netherited.mixin;

import com.polpg.netherited.Constants;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

import static com.polpg.netherited.CommonClass.FIREPROOF_COMPONENT;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin {
    
    @Inject(at = @At("HEAD"), method = "fireImmune()Z", cancellable = true)
    private void fireImmune(CallbackInfoReturnable<Boolean> cir) {
        final ItemStack stack = invokeGetItem();
        final List<Enchantment> fireproofEnchantments = stack
                .getOrDefault(netherited$getEnchantmentComponent(stack.getItem()), ItemEnchantments.EMPTY)
                .entrySet()
                .stream()
                .map(entry -> entry.getKey().value())
                .filter(enchantment -> enchantment.effects().has(FIREPROOF_COMPONENT.get()))
                .toList();
        
        if (!fireproofEnchantments.isEmpty()) {
            Constants.LOG.debug("Making item fireproof as it has enchantments with fireproof: {}", fireproofEnchantments);
            cir.setReturnValue(true);
        }
    }
    
    @Invoker("getItem")
    public abstract ItemStack invokeGetItem();
    
    @Unique
    private DataComponentType<ItemEnchantments> netherited$getEnchantmentComponent(final Item item) {
        return item == Items.ENCHANTED_BOOK ? DataComponents.STORED_ENCHANTMENTS : DataComponents.ENCHANTMENTS;
    }
}
