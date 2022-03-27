package net.more.moremc.entity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.more.moremc.MoreMc;
import net.more.moremc.entity.custom.BuffBlazeExecutor;

public class ModEntityTypes {

    public static DeferredRegister<EntityType<?>> ENTITYS_TYPES =
            DeferredRegister.create (ForgeRegistries.ENTITIES, MoreMc.MOD_ID);

    public static final RegistryObject<EntityType<BuffBlazeExecutor>> BLAZE_EXECUTOR =
            ENTITYS_TYPES.register ("buff_executor",
                    () -> EntityType.Builder.createNothing(BuffBlazeExecutor::new,
                                    EntityClassification.MONSTER).sized(2,1)
                            .build (new ResourceLocation (MoreMc.MOD_ID, "buff_executor")
                                    .toString ()));

    public static void register(IEventBus eventBus){
        ENTITYS_TYPES.register (eventBus);
    }
}
