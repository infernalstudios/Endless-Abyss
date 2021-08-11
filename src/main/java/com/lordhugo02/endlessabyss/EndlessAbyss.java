package com.lordhugo02.endlessabyss;

import com.lordhugo02.endlessabyss.init.EABlocks;
import com.lordhugo02.endlessabyss.init.EAEntityTypes;
import com.lordhugo02.endlessabyss.init.EAItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(EndlessAbyss.MODID)
public class EndlessAbyss {
    public static final String MODID = "endlessabyss";
    private static final Logger LOGGER = LogManager.getLogger();

    public EndlessAbyss() {
        MinecraftForge.EVENT_BUS.register(this);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        LOGGER.log(Level.DEBUG, "Registering Blocks");
        EABlocks.BLOCK_REGISTRY.register(bus);
        LOGGER.log(Level.DEBUG, "Registering Items");
        EAItems.ITEM_REGISTRY.register(bus);
        LOGGER.log(Level.DEBUG, "Registering Entity Types");
        EAEntityTypes.ENTITY_TYPE_REGISTRY.register(bus);
    }
}
