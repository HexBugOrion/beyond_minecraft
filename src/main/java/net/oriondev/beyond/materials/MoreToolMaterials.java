package net.oriondev.beyond.materials;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;
import net.oriondev.beyond.MCBeyond;

import java.util.function.Supplier;

public enum  MoreToolMaterials implements ToolMaterial {
    COPPER(2, 210, 6.0F, 2.0F, 22, () -> {
        return Ingredient.ofItems(MCBeyond.COPPER_INGOT);
    }),
    STEEL(3, 300, 6.0F, 2.5F, 8, () -> {
        return Ingredient.ofItems(MCBeyond.STEEL_INGOT);
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairMaterial;

    MoreToolMaterials(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = new Lazy<>(repairMaterialIn);
    }

    public int getDurability() {
        return this.maxUses;
    }

    public float getMiningSpeedMultiplier() {
        return this.efficiency;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.harvestLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }
}
