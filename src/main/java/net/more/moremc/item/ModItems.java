package net.more.moremc.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.more.moremc.MoreMc;
import net.more.moremc.item.custom.ender_ballest;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create (ForgeRegistries.ITEMS, MoreMc.MOD_ID);

    public static final RegistryObject<Item> ENDER_BALLEST = ITEMS.register ("ender_ballest",
            () -> new ender_ballest (new Item.Properties ().tab (ModItemGroup.MOREMCTAB).durability (500)
                    .stacksTo (1)));

    public static void register(IEventBus eventBus){
        ITEMS.register (eventBus);
    }

}
