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

	@SubscribeEvent
	public void hatch(ItemExpireEvent e) {
		if (e.getEntityItem().getEntityItem().getItem() == Items.EGG) {
			// System.out.println("egg Despawn");
			int stack = e.getEntityItem().getEntityItem().stackSize;
			for (int i = 1; i <= stack; i++) {
				if (r.nextInt(4) == 0) {
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
	/*
	 * 
	 * @SubscribeEvent public void pigSpawn(LivingSpawnEvent e) {
	 * 
	 * if (e.getEntity() instanceof EntityPig) { EntityPig ep = (EntityPig)
	 * e.getEntity(); if (ep.getGrowingAge() < 50) { Log.info("Pig Spawned!");
	 * makePigsHungry(ep); if (ep.getGrowingAge() <= -23000) {
	 * Log.info("Its a Baby!" + ep.getGrowingAge()); if (ep.getGrowingAge() >=
	 * -24000) { Log.info("Twins!"); newPig = new EntityPig(ep.getEntityWorld());
	 * newPig.setPosition(ep.posX, ep.posY, ep.posZ); // newPig.setHealth(8);
	 * newPig.setGrowingAge(-23000); // makePigsHungry(newPig);
	 * ep.getEntityWorld().spawnEntityInWorld(newPig); // That spawns the Entity } }
	 * } } }
	 * 
	 * 
	 * @SubscribeEvent public void updatePigAI(EntityJoinWorldEvent e){ if
	 * (e.getEntity() instanceof EntityPig) {
	 * makePigsHungry((EntityPig)e.getEntity()); System.out.println("ejw hungry"); }
	 * }
	 * 
	 * @SubscribeEvent public void updatePigAI(LivingSpawnEvent e){ if
	 * (e.getEntity() instanceof EntityPig) {
	 * makePigsHungry((EntityPig)e.getEntity()); System.out.println("lse hungry"); }
	 * }
	 * 
	 * @SubscribeEvent public void spawnTwins(BabyEntitySpawnEvent b) { if
	 * (b.getChild() instanceof EntityPig) { System.out.println("Piglet born");
	 * makePigsHungry((EntityPig) b.getChild());
	 * 
	 * for (int i = ChickenHatchConfig.extraPiglets, x = 0; x < i; x++) { newPig =
	 * new EntityPig(b.getParentA().worldObj);
	 * newPig.setPosition(b.getParentA().posX, b.getParentA().posY,
	 * b.getParentA().posZ); newPig.setGrowingAge(-23000);
	 * makePigsHungry((EntityPig) newPig);
	 * b.getParentA().worldObj.spawnEntityInWorld(newPig);
	 * //System.out.println("Twin Born"); }
	 * 
	 * } }
	 * 
	 * @SubscribeEvent public void deadPig(LivingDropsEvent event) { if
	 * (event.getEntity() instanceof EntityPig) { // DEBUG
	 * System.out.println("EntityPig drops event"); ItemStack itemStackToDrop = new
	 * ItemStack(ModItems.bacon, new Random().nextInt(3)); event.getDrops().add(new
	 * EntityItem(event.getEntity().worldObj, event.getEntity().posX,
	 * 
	 * event.getEntity().posY, event.getEntity().posZ, itemStackToDrop));
	 * 
	 * }
	 * 
	 * }
	 * 
	 * private void makePigsHungry(EntityPig e) { if
	 * (ChickenHatchConfig.isRootingEnabled) { e.tasks.addTask(5, new
	 * EntityAIRoot(e)); Log.info("Pig is hungry!"); } else {
	 * //Log.info("Pig is not hungry...."); } }
	 */
}