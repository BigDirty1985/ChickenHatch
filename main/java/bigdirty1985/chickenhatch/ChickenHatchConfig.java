package bigdirty1985.chickenhatch;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class ChickenHatchConfig {
	
	public static Configuration config;
	
	public static void init(FMLPreInitializationEvent e){
		config = new Configuration(e.getSuggestedConfigurationFile());
		syncConfig();
	}
	
	public static int chickenHatchChance = 1;

	public static void syncConfig() { // Gets called from preInit
	    try {
	        // Load config
	        config.load();

	      // Read props from config
	        Property chickenHatchChanceProp = config.get(Configuration.CATEGORY_GENERAL, // What category will it be saved to, can be any string
	                "chickenHatchChance", // Property name
	                "25", // Default value
	                "chance out of 100 that despawned eggs spawn chicks "); // Comment

	        chickenHatchChance = chickenHatchChanceProp.getInt();
	        
	    } catch (Exception e) {
	        // Failed reading/writing, just continue
	    } finally {
	        // Save props to config IF config changed
	        if (config.hasChanged()) config.save();
	    }
	}

}
