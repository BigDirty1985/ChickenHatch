package bigdirty1985.chickenhatch.Items;


import bigdirty1985.chickenhatch.Block.ItemModelProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

	/*public static ItemBase pliers,saw,hammer,leatherCured,rawPapyrus,soakedPapyrus,papyrusSheet,driedPapyrusSheet;
	
	public static Item honeyDewSeed;
	public static Item honeyDewSlice; */
	public static Item eggShell,rottenEgg;
	public static void init() {
		
		eggShell = register(new ItemBase("eggShell").setCreativeTab(CreativeTabs.MATERIALS));
		rottenEgg = register(new ItemRottenEgg("rottenEgg").setCreativeTab(CreativeTabs.MISC));
	} 
	
	/*{
		//Materials
		
		soakedPapyrus = register(new ItemBase("soakedPapyrus").setCreativeTab(CreativeTabs.MATERIALS));
		papyrusSheet = register(new ItemBase("papyrusSheet").setCreativeTab(CreativeTabs.MATERIALS));
		driedPapyrusSheet = register(new ItemBase("driedPapyrusSheet").setCreativeTab(CreativeTabs.MATERIALS));
		leatherCured= register(new ItemBase("leatherCured").setCreativeTab(CreativeTabs.MATERIALS));
		
		//Tools
		saw = register(new ItemBase("saw").setCreativeTab(CreativeTabs.TOOLS));
		pliers = register(new ItemBase("pliers").setCreativeTab(CreativeTabs.TOOLS));
		hammer = register(new ItemBase("hammer").setCreativeTab(CreativeTabs.TOOLS));
	}
*/
	private static <T extends Item> T register(T item) {
		GameRegistry.register(item);

		if (item instanceof ItemModelProvider) {
			((ItemModelProvider)item).registerItemModel(item);
		}

		return item;
	}

}