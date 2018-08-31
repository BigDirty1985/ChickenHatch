package bigdirty1985.chickenhatch.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import bigdirty1985.chickenhatch.ChickenHatch;
import bigdirty1985.chickenhatch.Block.ItemModelProvider;

public class ItemBase extends Item {


	protected String name;

	public ItemBase(String name) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	public void registerItemModel() {
		ChickenHatch.proxy.registerItemRenderer(this, 0, name);
	}
	
	@Override
	public ItemBase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

	


}