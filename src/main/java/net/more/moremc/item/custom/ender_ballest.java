package net.more.moremc.item.custom;

import net.minecraft.entity.item.EnderPearlEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.more.moremc.item.ModItemGroup;

public class ender_ballest extends Item{

    public ender_ballest(Properties p_i48487_1_) {
        super (p_i48487_1_);
    }

    public void crossbow(){

    }

    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        ItemStack itemstack = p_77659_2_.getItemInHand(p_77659_3_);
        p_77659_1_.playSound((PlayerEntity)null, p_77659_2_.getX(), p_77659_2_.getY(), p_77659_2_.getZ(), SoundEvents.ENDER_PEARL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        p_77659_2_.getCooldowns().addCooldown(this, 20);
        if (!p_77659_1_.isClientSide) {
            EnderPearlEntity enderpearlentity = new EnderPearlEntity(p_77659_1_, p_77659_2_);
            enderpearlentity.setItem(itemstack);
            enderpearlentity.shootFromRotation(p_77659_2_, p_77659_2_.xRot, p_77659_2_.yRot, 0.0F, 1.5F, 1.0F);
            p_77659_1_.addFreshEntity(enderpearlentity);
        }

        p_77659_2_.awardStat(Stats.ITEM_USED.get(this));
        if (!p_77659_2_.abilities.instabuild) {
            itemstack.shrink(1);
        }

        return ActionResult.sidedSuccess(itemstack, p_77659_1_.isClientSide());
    }
}
