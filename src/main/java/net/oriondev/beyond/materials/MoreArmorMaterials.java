package net.oriondev.beyond.materials;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;
import net.oriondev.beyond.MCBeyond;

import java.util.function.Supplier;

public enum MoreArmorMaterials implements ArmorMaterial {
    GILDED_IRON("gilded_iron", 12, new int[]{2, 5, 6, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, () -> {
        return Ingredient.ofItems(MCBeyond.COPPER_INGOT);
    }),
    STEEL("steel", 17, new int[]{2, 5, 6, 2}, 7, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.5F, () -> {
        return Ingredient.ofItems(MCBeyond.STEEL_INGOT);
    });

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Lazy<Ingredient> repairMaterial;

    MoreArmorMaterials(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchantabilityIn, SoundEvent equipSoundIn, float toughness, Supplier<Ingredient> repairMaterialSupplier) {
        this.name = nameIn;
        this.maxDamageFactor = maxDamageFactorIn;
        this.damageReductionAmountArray = damageReductionAmountsIn;
        this.enchantability = enchantabilityIn;
        this.soundEvent = equipSoundIn;
        this.toughness = toughness;
        this.repairMaterial = new Lazy<>(repairMaterialSupplier);
    }

    public int getDurability(EquipmentSlot slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getEntitySlotId()] * this.maxDamageFactor;
    }

    public int getProtectionAmount(EquipmentSlot slotIn) {
        return this.damageReductionAmountArray[slotIn.getEntitySlotId()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getEquipSound() {
        return this.soundEvent;
    }

    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @Environment(EnvType.CLIENT)
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
