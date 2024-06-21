package mommiissues.impracticality;

import com.google.common.base.Suppliers;

import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;


public enum ImpracticalToolMaterials implements ToolMaterial
{
    DEEPSLATE(BlockTags.INCORRECT_FOR_STONE_TOOL, 262, 4.5f, 1.1f, 9, () -> Ingredient.fromTag(TagKey.of(RegistryKeys.ITEM, Identifier.of(Impracticality.MOD_ID, "deepslate_tool_materials"))));

    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    private ImpracticalToolMaterials(TagKey<Block> inverseTag, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient)
    {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getDurability()
    {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier()
    {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage()
    {
        return this.attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag()
    {
        return this.inverseTag;
    }

    @Override
    public int getEnchantability()
    {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() { return this.repairIngredient.get(); }
}
