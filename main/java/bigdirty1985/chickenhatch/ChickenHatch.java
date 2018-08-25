
package bigdirty1985.chickenhatch;

import bigdirty1985.chickenhatch.Block.ModBlocks;
import bigdirty1985.chickenhatch.Items.ModItems;
import bigdirty1985.chickenhatch.event.ChickenHatchEventHandler;
import bigdirty1985.chickenhatch.proxy.CommonProxy;
import bigdirty1985.chickenhatch.recipes.ModRecipes;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ChickenHatch.modId, name = ChickenHatch.name, version = ChickenHatch.version, acceptedMinecraftVersions = "[1.10.2]")
public class ChickenHatch {

	public static final String modId = "chickenhatch";
	public static final String name = "Chicken Hatch";
	public static final String version = "1.10.2";

	@Mod.Instance(modId)
	public static ChickenHatch instance;

	//Tool Materials
	public static final Item.ToolMaterial flintToolMaterial = EnumHelper.addToolMaterial("FLINT", 2, 100, 3, 2, 10);
	
	
	@SidedProxy(serverSide = "bigdirty1985.chickenhatch.proxy.CommonProxy", clientSide = "bigdirty1985.chickenhatch.proxy.ClientProxy")
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	
		System.out.println(name + " is trying like super hard not to F up your game...");
		
		
		ModBlocks.init();
		ModItems.init();
		ModRecipes.init();
		FMLCommonHandler.instance().bus().register(new ChickenHatchEventHandler());

	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println(name + " No crash? Thats a good sign. Those errors probably aren't that important.");

	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

		System.out.println(name + " Wait... It actually worked? HMPH! How bout that.....");
	}

}