package mommiissues.impracticality;

import mommiissues.impracticality.items.*;
//FABRIC
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
//MINECRAFT
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Oxidizable;
import net.minecraft.block.OxidizableBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
//LOGGER
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//JAVA
import java.util.HashMap;
import java.util.Map;


public class Impracticality implements ModInitializer
{
	public static final String MOD_ID = "impracticality"; // MOD ID FOR REFERENCE

    public static final Logger LOGGER = LoggerFactory.getLogger("impracticality"); // For logging errors and warnings

	public static Map<String, Item> ITEMS = new HashMap<>(); // ITEM DICT
	public static Map<String, Block> BLOCKS = new HashMap<>(); // BLOCK DICT

	@Override
	public void onInitialize()
	{
		BLOCKS.put("flesh_block", new OxidizableBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.create().strength(0.4f).sounds(BlockSoundGroup.HONEY)));
		BLOCKS.put("spoiled_flesh_block", new OxidizableBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.copy(BLOCKS.get("flesh_block")).strength(0.43f)));
		BLOCKS.put("rotten_flesh_block", new OxidizableBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.copy(BLOCKS.get("flesh_block")).strength(0.46f)));
		BLOCKS.put("decayed_flesh_block", new OxidizableBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.copy(BLOCKS.get("flesh_block")).strength(0.5f)));
		BLOCKS.put("ground_flesh_block", new OxidizableBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.copy(BLOCKS.get("flesh_block"))));
		BLOCKS.put("spoiled_ground_flesh_block", new OxidizableBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.copy(BLOCKS.get("spoiled_flesh_block"))));
		BLOCKS.put("rotten_ground_flesh_block", new OxidizableBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.copy(BLOCKS.get("rotten_flesh_block"))));
		BLOCKS.put("decayed_ground_flesh_block", new OxidizableBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.copy(BLOCKS.get("decayed_flesh_block"))));
		// Block loop
		for (String block_id : BLOCKS.keySet())
		{
			LOGGER.info(String.format("Registering block %s:%s", MOD_ID, block_id));
			Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, block_id), BLOCKS.get(block_id));
			Registry.register(Registries.ITEM, Identifier.of(MOD_ID, block_id), new BlockItem(BLOCKS.get(block_id), new Item.Settings()));
		}

		// Flesh Blocks
		OxidizableBlocksRegistry.registerOxidizableBlockPair(BLOCKS.get("flesh_block"), BLOCKS.get("spoiled_flesh_block"));
		OxidizableBlocksRegistry.registerOxidizableBlockPair(BLOCKS.get("spoiled_flesh_block"), BLOCKS.get("rotten_flesh_block"));
		OxidizableBlocksRegistry.registerOxidizableBlockPair(BLOCKS.get("rotten_flesh_block"), BLOCKS.get("decayed_flesh_block"));
		// Ground Flesh Blocks
		OxidizableBlocksRegistry.registerOxidizableBlockPair(BLOCKS.get("ground_flesh_block"), BLOCKS.get("spoiled_ground_flesh_block"));
		OxidizableBlocksRegistry.registerOxidizableBlockPair(BLOCKS.get("spoiled_ground_flesh_block"), BLOCKS.get("rotten_ground_flesh_block"));
		OxidizableBlocksRegistry.registerOxidizableBlockPair(BLOCKS.get("rotten_ground_flesh_block"), BLOCKS.get("decayed_ground_flesh_block"));

		ITEMS.put("sparklies", new Sparklies(new Item.Settings()));
		// Item loop
		for (String item_id : ITEMS.keySet())
		{
			LOGGER.info(String.format("Registering item %s:%s", MOD_ID, item_id));
			Registry.register(Registries.ITEM, Identifier.of(MOD_ID, item_id), ITEMS.get(item_id));
		}

		Registry.register(Registries.ITEM_GROUP, Identifier.of(MOD_ID, "main"), FabricItemGroup.builder()
			.icon(() -> new ItemStack(ITEMS.get("sparklies")))
			.displayName(Text.translatable("itemGroup." + MOD_ID + ".main"))
			.entries((context, entries) -> {
				for (Block block : BLOCKS.values()) { entries.add(block); }
				for (Item item : ITEMS.values()) { entries.add(item); }
			})
			.build()
		);

		LOGGER.info("Impracticality initialized!");
	}
}