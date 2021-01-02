package net.oriondev.beyond;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MCBeyond implements ModInitializer {

	//armor

	//tools

	//materials
	public static final Item COPPER_INGOT = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
	public static final Item STEEL_INGOT = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

	@Override
	public void onInitialize() {

		Registry.register(Registry.ITEM, new Identifier("beyondmaterials", "copper"), COPPER_INGOT);
		Registry.register(Registry.ITEM, new Identifier("beyondmaterials", "steel"), STEEL_INGOT);

	}
}
