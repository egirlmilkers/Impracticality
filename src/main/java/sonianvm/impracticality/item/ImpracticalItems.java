package sonianvm.impracticality.item;

import sonianvm.impracticality.ImpracticalToolMaterials;
import sonianvm.impracticality.Impracticality;
import sonianvm.impracticality.block.ImpracticalBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import java.util.function.UnaryOperator;

public class ImpracticalItems
{
	public static final Item SPARKLIES = ImpracticalItems.register("sparklies", new Item(new Item.Settings()));
	public static final Item DEEPSLATE_SWORD = ImpracticalItems.register("deepslate_sword", new SwordItem(ImpracticalToolMaterials.DEEPSLATE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ImpracticalToolMaterials.DEEPSLATE, 3, -2.4f))));
	public static final Item DEEPSLATE_SHOVEL = ImpracticalItems.register("deepslate_shovel", new ShovelItem(ImpracticalToolMaterials.DEEPSLATE, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ImpracticalToolMaterials.DEEPSLATE, 1.5f, -3.0f))));
	public static final Item DEEPSLATE_PICKAXE = ImpracticalItems.register("deepslate_pickaxe", new PickaxeItem(ImpracticalToolMaterials.DEEPSLATE, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ImpracticalToolMaterials.DEEPSLATE, 1.0f, -2.8f))));
	public static final Item DEEPSLATE_AXE = ImpracticalItems.register("deepslate_axe", new AxeItem(ImpracticalToolMaterials.DEEPSLATE, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ImpracticalToolMaterials.DEEPSLATE, 7.0f, -3.2f))));
	public static final Item DEEPSLATE_HOE = ImpracticalItems.register("deepslate_hoe", new HoeItem(ImpracticalToolMaterials.DEEPSLATE, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ImpracticalToolMaterials.DEEPSLATE, -1.0f, -2.0f))));
	public static final Item BLACKSTONE_SWORD = ImpracticalItems.register("blackstone_sword", new SwordItem(ImpracticalToolMaterials.BLACKSTONE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ImpracticalToolMaterials.BLACKSTONE, 3, -2.4f))));
	public static final Item BLACKSTONE_SHOVEL = ImpracticalItems.register("blackstone_shovel", new ShovelItem(ImpracticalToolMaterials.BLACKSTONE, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ImpracticalToolMaterials.BLACKSTONE, 1.5f, -3.0f))));
	public static final Item BLACKSTONE_PICKAXE = ImpracticalItems.register("blackstone_pickaxe", new PickaxeItem(ImpracticalToolMaterials.BLACKSTONE, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ImpracticalToolMaterials.BLACKSTONE, 1.0f, -2.8f))));
	public static final Item BLACKSTONE_AXE = ImpracticalItems.register("blackstone_axe", new AxeItem(ImpracticalToolMaterials.BLACKSTONE, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ImpracticalToolMaterials.BLACKSTONE, 7.0f, -3.2f))));
	public static final Item BLACKSTONE_HOE = ImpracticalItems.register("blackstone_hoe", new HoeItem(ImpracticalToolMaterials.BLACKSTONE, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ImpracticalToolMaterials.BLACKSTONE, -1.0f, -2.0f))));
	public static final Item CRAFTING_BOOK = ImpracticalItems.register("crafting_book", new CraftingBookItem(new Item.Settings().maxCount(1)));
	// BLOCKS
	public static final Item FLESH_BLOCK = ImpracticalItems.register(ImpracticalBlocks.FLESH_BLOCK);
	public static final Item SPOILED_FLESH = ImpracticalItems.register(ImpracticalBlocks.SPOILED_FLESH);
	public static final Item ROTTEN_FLESH = ImpracticalItems.register(ImpracticalBlocks.ROTTEN_FLESH);
	public static final Item DECAYED_FLESH = ImpracticalItems.register(ImpracticalBlocks.DECAYED_FLESH);
	public static final Item GROUND_FLESH = ImpracticalItems.register(ImpracticalBlocks.GROUND_FLESH);
	public static final Item SPOILED_GROUND_FLESH = ImpracticalItems.register(ImpracticalBlocks.SPOILED_GROUND_FLESH);
	public static final Item ROTTEN_GROUND_FLESH = ImpracticalItems.register(ImpracticalBlocks.ROTTEN_GROUND_FLESH);
	public static final Item DECAYED_GROUND_FLESH = ImpracticalItems.register(ImpracticalBlocks.DECAYED_GROUND_FLESH);

	public static Item register(Block block) {
		return Items.register(new BlockItem(block, new Item.Settings()));
	}

	public static Item register(Block block, UnaryOperator<Item.Settings> settingsOperator) {
		return Items.register(new BlockItem(block, settingsOperator.apply(new Item.Settings())));
	}

	public static Item register(Block block, Block ... blocks) {
		BlockItem blockItem = new BlockItem(block, new Item.Settings());
		for (Block block2 : blocks) {
			Item.BLOCK_ITEMS.put(block2, blockItem);
		}
		return Items.register(blockItem);
	}

	public static Item register(BlockItem item) {
		return Items.register(item.getBlock(), item);
	}

	public static Item register(Block block, Item item) {
		return Items.register(Registries.BLOCK.getId(block), item);
	}

	public static Item register(String id, Item item) {
		return Items.register(Identifier.of(Impracticality.MOD_ID, id), item);
	}

	public static Item register(Identifier id, Item item) {
		return Items.register(RegistryKey.of(Registries.ITEM.getKey(), id), item);
	}

	public static Item register(RegistryKey<Item> key, Item item) {
		if (item instanceof BlockItem) {
			((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
		}
		return Registry.register(Registries.ITEM, key, item);
	}

	public static void itemInit() {
		Impracticality.LOGGER.info("Registering items for '" + Impracticality.MOD_ID + "'");
	}
}
