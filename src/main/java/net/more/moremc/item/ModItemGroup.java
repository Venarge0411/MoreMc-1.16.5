package net.more.moremc.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.more.moremc.block.ModBlocks;

public class ModItemGroup{

    public static final ItemGroup MOREMCTAB = new ItemGroup ("more_mc_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack (ModBlocks.MUD_BRICKS.get ());
        }
    };
}
