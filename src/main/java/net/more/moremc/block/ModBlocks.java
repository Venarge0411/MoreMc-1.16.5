package net.more.moremc.block;

import net.minecraft.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.more.moremc.MoreMc;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create (ForgeRegistries.BLOCKS, MoreMc.MOD_ID);



    public static void register(IEventBus eventBus){
        BLOCKS.register (eventBus);
    }
}
