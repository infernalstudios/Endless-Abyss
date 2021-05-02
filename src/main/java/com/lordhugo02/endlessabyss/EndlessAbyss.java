package com.lordhugo02.endlessabyss;

import com.lordhugo02.endlessabyss.registries.EndlessAbyssBlocks;
import com.lordhugo02.endlessabyss.registries.EndlessAbyssEntityTypes;
import com.lordhugo02.endlessabyss.registries.EndlessAbyssItems;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(EndlessAbyss.MODID)
public class EndlessAbyss
{
    public static final String MODID = "endlessabyss";
    private static final Logger LOGGER = LogManager.getLogger();

    public EndlessAbyss()
    {
        MinecraftForge.EVENT_BUS.register(this);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        LOGGER.log(Level.DEBUG, "Registering Blocks");
        EndlessAbyssBlocks.BLOCK_REGISTRY.register(bus);
        LOGGER.log(Level.DEBUG, "Registering Items");
        EndlessAbyssItems.ITEM_REGISTRY.register(bus);
        LOGGER.log(Level.DEBUG, "Registering Entity Types");
        EndlessAbyssEntityTypes.ENTITY_TYPE_REGISTRY.register(bus);
    }
}
