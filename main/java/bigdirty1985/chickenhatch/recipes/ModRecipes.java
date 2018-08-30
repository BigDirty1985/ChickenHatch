package bigdirty1985.chickenhatch.recipes;

import bigdirty1985.chickenhatch.Items.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

	public static void init() {

		GameRegistry.addShapelessRecipe(new ItemStack(Items.DYE,1, EnumDyeColor.WHITE.getDyeDamage()), ModItems.eggShell,ModItems.eggShell,ModItems.eggShell,ModItems.eggShell);
		// test Shapeless Recipe
		//GameRegistry.addShapelessRecipe(new ItemStack(ModItems.leatherCured, 4), Items.LEATHER);
		// Shaped Recipe
		//GameRegistry.addShapedRecipe(new ItemStack(ModItems.papyrusSheet), "SS ", "SS ", 'S', ModItems.soakedPapyrus);
		// FurnaceRecipe
		//GameRegistry.addSmelting(Items.LEATHER, new ItemStack(ModItems.leatherCured), 0.7f);

	}

}