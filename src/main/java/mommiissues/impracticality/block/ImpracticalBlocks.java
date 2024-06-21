package mommiissues.impracticality.block;

import mommiissues.impracticality.Impracticality;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Oxidizable;
import net.minecraft.block.OxidizableBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ImpracticalBlocks
{
	// Flesh blocks
	public static final Block FLESH_BLOCK = ImpracticalBlocks.register(
			"flesh_block",
			new OxidizableBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.create()
					.strength(0.4f)
					.sounds(BlockSoundGroup.HONEY)
			)
	);
	public static final Block SPOILED_FLESH = ImpracticalBlocks.register(
			"spoiled_flesh_block",
			new OxidizableBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings
					.copy(FLESH_BLOCK)
			)
	);
	public static final Block ROTTEN_FLESH = ImpracticalBlocks.register(
			"rotten_flesh_block",
			new OxidizableBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings
					.copy(FLESH_BLOCK)
			)
	);
	public static final Block DECAYED_FLESH = ImpracticalBlocks.register(
			"decayed_flesh_block",
			new OxidizableBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings
					.copy(FLESH_BLOCK)
			)
	);
	// Ground flesh blocks
	public static final Block GROUND_FLESH = ImpracticalBlocks.register(
			"ground_flesh_block",
			new OxidizableBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings
					.copy(FLESH_BLOCK)
			)
	);
	public static final Block SPOILED_GROUND_FLESH = ImpracticalBlocks.register(
			"spoiled_ground_flesh_block",
			new OxidizableBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings
					.copy(SPOILED_FLESH)
			)
	);
	public static final Block ROTTEN_GROUND_FLESH = ImpracticalBlocks.register(
			"rotten_ground_flesh_block",
			new OxidizableBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings
					.copy(ROTTEN_FLESH)
			)
	);
	public static final Block DECAYED_GROUND_FLESH = ImpracticalBlocks.register(
			"decayed_ground_flesh_block",
			new OxidizableBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings
					.copy(DECAYED_FLESH)
			)
	);

	static {
		// Flesh Blocks
		OxidizableBlocksRegistry.registerOxidizableBlockPair(FLESH_BLOCK, SPOILED_FLESH);
		OxidizableBlocksRegistry.registerOxidizableBlockPair(SPOILED_FLESH, ROTTEN_FLESH);
		OxidizableBlocksRegistry.registerOxidizableBlockPair(ROTTEN_FLESH, DECAYED_FLESH);
		// Ground Flesh Blocks
		OxidizableBlocksRegistry.registerOxidizableBlockPair(GROUND_FLESH, SPOILED_GROUND_FLESH);
		OxidizableBlocksRegistry.registerOxidizableBlockPair(SPOILED_GROUND_FLESH, ROTTEN_GROUND_FLESH);
		OxidizableBlocksRegistry.registerOxidizableBlockPair(ROTTEN_GROUND_FLESH, DECAYED_GROUND_FLESH);
	}

	public static Block register(String id, Block block) {
		return Registry.register(Registries.BLOCK, Identifier.of(Impracticality.MOD_ID, id), block);
	}

	public static Block register(RegistryKey<Block> key, Block block) {
		return Registry.register(Registries.BLOCK, key, block);
	}

	public static void blockInit() {
		Impracticality.LOGGER.info("Registering blocks for '" + Impracticality.MOD_ID + "'");
	}
}
