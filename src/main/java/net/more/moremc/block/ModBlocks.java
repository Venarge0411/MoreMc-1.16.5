package net.more.moremc.block;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.more.moremc.MoreMc;
import net.more.moremc.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create (ForgeRegistries.BLOCKS, MoreMc.MOD_ID);

    public static<T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toreturn = BLOCKS.register (name, block);

        registerBlockItem (name,toreturn);

        return toreturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register (name, () -> new BlockItem (block.get (),
                new Item.Properties ()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register (eventBus);
    }
}
