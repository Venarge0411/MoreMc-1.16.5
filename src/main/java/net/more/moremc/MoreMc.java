package net.more.moremc;

import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.block.Blocks;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.more.moremc.block.ModBlocks;
import net.more.moremc.item.ModItems;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

@Mod(MoreMc.MOD_ID)
public class MoreMc {

    public static final String MOD_ID = "moremc";

    private static final Logger LOGGER = LogManager.getLogger();

    public MoreMc(){
        IEventBus eventBus = FMLJavaModLoadingContext.get ( ).getModEventBus ( );

        ModBlocks.register (eventBus);
        ModItems.register (eventBus);

        eventBus.addListener (this::setup);
        eventBus.addListener (this::enqueueIMC);
        eventBus.addListener (this::processIMC);
        eventBus.addListener (this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event){
        LOGGER.info("WELCOME TO PREINIT");
        LOGGER.info ("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName ());
    }

    private void enqueueIMC(final InterModEnqueueEvent event){
        InterModComms.sendTo ("moremc", "helloworld", () ->{
            LOGGER.info ("Hello world from the MDK");

            return "Hello world";
        });

    }

    private void processIMC(final InterModProcessEvent event){
        LOGGER.info ("Got IMC{}", event.getIMCStream ().map (m->m.getMessageSupplier ()
                .get ()).collect (Collectors.toList ()));
    }

    private void doClientStuff(final FMLClientSetupEvent event){
        LOGGER.info ("Got game settings {}", event.getMinecraftSupplier ().get ().options);
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event){
        LOGGER.info ("HELLO to server starting");
    }


    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
