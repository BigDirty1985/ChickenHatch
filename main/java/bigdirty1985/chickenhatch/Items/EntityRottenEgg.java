package bigdirty1985.chickenhatch.Items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityRottenEgg extends EntityEgg
{
    public EntityRottenEgg(World worldIn)
    {
        super(worldIn);
    }

    public EntityRottenEgg(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
    }

    public EntityRottenEgg(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    public static void registerFixesEgg(DataFixer fixer)
    {
        EntityThrowable.registerFixesThrowable(fixer, "ThrownEgg");
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    @Override
    protected void onImpact(RayTraceResult result)
    {
        if (result.entityHit != null)
        {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
            EntityLivingBase target = (EntityLivingBase)result.entityHit;
             target.addPotionEffect(new PotionEffect(Potion.getPotionById(9),200,2));
        }

        if (!this.worldObj.isRemote && this.rand.nextInt(8) == 0)
        {
            int i = 1;

            if (this.rand.nextInt(32) == 0)
            {
                i = 4;
            }

            for (int j = 0; j < i; ++j)
            {
              /*  EntityChicken entitychicken = new EntityChicken(this.worldObj);
                entitychicken.setGrowingAge(-24000);
                entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
                this.worldObj.spawnEntityInWorld(entitychicken);*/
            }
        }

        double d0 = 0.08D;

        for (int k = 0; k < 8; ++k)
        {
            this.worldObj.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX, this.posY, this.posZ, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, new int[] {Item.getIdFromItem(Items.EGG)});
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
}