package sonianvm.impracticality;

import sonianvm.impracticality.block.ImpracticalBlocks;
import sonianvm.impracticality.item.*;
//FABRIC
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
//MINECRAFT
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
//LOGGER
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//JAVA


public class Impracticality implements ModInitializer
{
	public static final String MOD_ID = "impracticality"; // MOD ID FOR REFERENCE

    public static final Logger LOGGER = LoggerFactory.getLogger("impracticality"); // For logging errors and warnings

	@Override
	public void onInitialize()
	{
		ImpracticalBlocks.blockInit();
		ImpracticalItems.itemInit();

		Registry.register(Registries.ITEM_GROUP, Identifier.of(MOD_ID, "main"), FabricItemGroup.builder()
			.icon(() -> new ItemStack(ImpracticalItems.SPARKLIES))
			.displayName(Text.translatable("itemGroup." + MOD_ID + ".main"))
			.entries((context, entries) -> {
				entries.add(ImpracticalItems.SPARKLIES);
				entries.add(ImpracticalBlocks.FLESH_BLOCK);
				entries.add(ImpracticalBlocks.SPOILED_FLESH);
				entries.add(ImpracticalBlocks.ROTTEN_FLESH);
				entries.add(ImpracticalBlocks.DECAYED_FLESH);
				entries.add(ImpracticalBlocks.GROUND_FLESH);
				entries.add(ImpracticalBlocks.SPOILED_GROUND_FLESH);
				entries.add(ImpracticalBlocks.ROTTEN_GROUND_FLESH);
				entries.add(ImpracticalBlocks.DECAYED_GROUND_FLESH);
				entries.add(ImpracticalItems.DEEPSLATE_SWORD);
				entries.add(ImpracticalItems.DEEPSLATE_SHOVEL);
				entries.add(ImpracticalItems.DEEPSLATE_PICKAXE);
				entries.add(ImpracticalItems.DEEPSLATE_AXE);
				entries.add(ImpracticalItems.DEEPSLATE_HOE);
				entries.add(ImpracticalItems.BLACKSTONE_SWORD);
				entries.add(ImpracticalItems.BLACKSTONE_SHOVEL);
				entries.add(ImpracticalItems.BLACKSTONE_PICKAXE);
				entries.add(ImpracticalItems.BLACKSTONE_AXE);
				entries.add(ImpracticalItems.BLACKSTONE_HOE);
				entries.add(ImpracticalItems.CRAFTING_BOOK);
			})
			.build()
		);

		LOGGER.info("Impracticality initialized!");
	}
}