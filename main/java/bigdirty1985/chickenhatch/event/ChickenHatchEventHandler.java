package bigdirty1985.chickenhatch.event;

import org.fusesource.jansi.Ansi.Color;

import com.google.common.eventbus.Subscribe;

import bigdirty1985.chickenhatch.ChickenHatch;
import bigdirty1985.chickenhatch.ChickenHatchConfig;
import bigdirty1985.chickenhatch.Items.ModItems;
import jline.internal.Log;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.ThrowableImpactEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.FMLCommonHandler;
import scala.util.Random;

public class ChickenHatchEventHandler {

	EntityAgeable newChick;
	Random r = new Random();
	int hatchChance =ChickenHatchConfig.chickenHatchChance;

	@SubscribeEvent
	public void hatch(ItemExpireEvent e) {
		if (e.getEntityItem().getEntityItem().getItem() == Items.EGG) {
			// System.out.println("egg Despawn");
			int stack = e.getEntityItem().getEntityItem().stackSize;
			for (int i = 1; i <= stack; i++) {
				if (r.nextInt(100) <= hatchChance) {
					// System.out.println("Chick spawn" + (stack + 1));
					newChick = new EntityChicken(e.getEntity().worldObj);
					newChick.setPosition(e.getEntity().posX, e.getEntity().posY, e.getEntity().posZ);
					newChick.setGrowingAge(-23000);
					e.getEntity().worldObj.spawnEntityInWorld(newChick);
					e.getEntity().worldObj.spawnEntityInWorld(new EntityItem(e.getEntity().worldObj, e.getEntity().posX, e.getEntity().posY, e.getEntity().posZ, new ItemStack(ModItems.eggShell,1)));
				}
			}
		}
	}

	
	@SubscribeEvent
	public void eggHit(ThrowableImpactEvent e) {
		if (e.getEntityThrowable() instanceof EntityEgg && !e.getEntity().worldObj.isRemote) {

			e.getEntityThrowable().getEntityWorld().spawnEntityInWorld(new EntityItem(e.getEntity().worldObj, e.getEntity().posX, e.getEntity().posY, e.getEntity().posZ, new ItemStack(ModItems.eggShell,1)));

		}
	}

}
