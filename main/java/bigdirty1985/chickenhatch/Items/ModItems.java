package bigdirty1985.chickenhatch.Items;


import bigdirty1985.chickenhatch.Block.ItemModelProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

	/*public static ItemBase pliers,saw,hammer,leatherCured,rawPapyrus,soakedPapyrus,papyrusSheet,driedPapyrusSheet;
	


}
	public static Item honeyDewSeed;
	public static Item honeyDewSlice; */
	public static ItemBase eggShell = new ItemBase("eggshell").setCreativeTab(CreativeTabs.MATERIALS);
	public static ItemBase rottenEgg = new ItemRottenEgg("rottenegg").setCreativeTab(CreativeTabs.MATERIALS);

	public static void init() {
		
	//	rottenEgg = register(new ItemRottenEgg("rottenEgg").setCreativeTab(CreativeTabs.MISC));
	} 
	

	
	public static void register(IForgeRegistry<Item> registry) {
		registry.registerAll(
				eggShell,rottenEgg
		);
	}

	public static void registerModels() {
		eggShell.registerItemModel();
		rottenEgg.registerItemModel();
}}