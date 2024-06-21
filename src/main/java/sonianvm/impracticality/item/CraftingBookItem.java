package sonianvm.impracticality.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CraftingBookItem
		extends Item
{
	public CraftingBookItem(Settings settings)
	{
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);
		user.openHandledScreen(new SimpleNamedScreenHandlerFactory((syncId, inventory, player) -> new CraftingBookScreenHandler(syncId, inventory, ScreenHandlerContext.create(world, user.getBlockPos())), Text.translatable("container.crafting")));
		user.incrementStat(Stats.INTERACT_WITH_CRAFTING_TABLE);
		return TypedActionResult.success(itemStack, world.isClient());
	}
}

class CraftingBookScreenHandler
		extends CraftingScreenHandler
{
	public CraftingBookScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
		super(syncId, playerInventory, context);
	}

	@Override
	public boolean canUse(PlayerEntity player) {
		return player.getMainHandStack().isOf(ImpracticalItems.CRAFTING_BOOK);
	}
}
