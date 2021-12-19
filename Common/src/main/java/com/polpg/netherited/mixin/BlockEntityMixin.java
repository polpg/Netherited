package com.polpg.netherited.mixin;

import com.polpg.netherited.interfaces.IBlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockEntity.class)
public class BlockEntityMixin implements IBlockEntity {
    
    private Tag fireproofEnchantment;
    
    @Inject(method = "saveAdditional", at = @At("TAIL"))
    protected void saveAdditional(CompoundTag tag, CallbackInfo ci) {
        if (fireproofEnchantment != null) {
            tag.put("Enchantments", fireproofEnchantment);
        }
    }
    
    @Inject(method = "load", at= @At("TAIL"))
    public void load(CompoundTag tag, CallbackInfo ci) {
        Tag enchantments = tag.get("Enchantments");
        if (enchantments != null) {
            this.fireproofEnchantment = enchantments.copy();
        }
    }
    
    
    @Override
    public Tag getFireproofEnchantments() {
        return fireproofEnchantment;
    }
    
    @Override
    public void setFireproofEnchantments(Tag enchantments) {
        this.fireproofEnchantment = enchantments.copy();
    }
    
}
