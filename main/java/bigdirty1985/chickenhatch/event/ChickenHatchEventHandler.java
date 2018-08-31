package bigdirty1985.chickenhatch.event;

import com.google.common.eventbus.Subscribe;

import bigdirty1985.chickenhatch.ChickenHatch;
import bigdirty1985.chickenhatch.ChickenHatchConfig;
import bigdirty1985.chickenhatch.Items.ModItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.ThrowableImpactEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.LootTableLoadEvent;
import scala.util.Random;

public class ChickenHatchEventHandler {

	EntityChicken newChick;
	Random r = new Random();
	int hatchChance = 0;

	@SubscribeEvent
	public void initHatchChance(LootTableLoadEvent e) {
		hatchChance = ChickenHatchConfig.chickenHatchChance;
	}

	@SubscribeEvent
	public void hatch(ItemExpireEvent e) {
		if (e.getEntityItem().getItem().getItem() == Items.EGG) {
			int stack = e.getEntityItem().getItem().getCount();
			System.out.println("egg " + stack + " Despawn");

			for (int i = 1; i <= stack; i++) {
				if (hatchChance == 0) {
					hatchChance = 25;
				}
				if (r.nextInt(100) <= hatchChance) {
					System.out.println("Chick spawn" + (stack + 1));
					newChick = new EntityChicken(e.getEntityItem().world);
					newChick.setLocationAndAngles(e.getEntity().posX, e.getEntity().posY, e.getEntity().posZ,
							e.getEntity().rotationYaw, 0.0F);
					// newChick.setPosition(e.getEntity().posX, e.getEntity().posY,
					// e.getEntity().posZ);
					newChick.setGrowingAge(-23000);
					e.getEntity().world.spawnEntity(newChick);
					System.out.println("Spawned at" + newChick.posX + newChick.posX + newChick.posX + ".");
					e.getEntity().world.spawnEntity(new EntityItem(e.getEntity().world, e.getEntity().posX,
							e.getEntity().posY, e.getEntity().posZ, new ItemStack(ModItems.eggShell, 1)));
				} else {
					e.getEntity().world.spawnEntity(new EntityItem(e.getEntity().world, e.getEntity().posX,
							e.getEntity().posY, e.getEntity().posZ, new ItemStack(ModItems.rottenEgg, 1)));
				}
				System.out.println("Hatch chance = "+ hatchChance);

			}
		}
	}

	@SubscribeEvent
	public void eggHit(ThrowableImpactEvent e) {
		if (e.getEntityThrowable() instanceof EntityEgg && !e.getEntity().world.isRemote) {

			e.getEntityThrowable().getEntityWorld().spawnEntity(new EntityItem(e.getEntity().world, e.getEntity().posX,
					e.getEntity().posY, e.getEntity().posZ, new ItemStack(ModItems.eggShell, 1)));

		}
	}

}
