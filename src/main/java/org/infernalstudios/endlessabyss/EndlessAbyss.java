package org.infernalstudios.endlessabyss;

import org.infernalstudios.endlessabyss.init.EABlocks;
import org.infernalstudios.endlessabyss.init.EAEntityTypes;
import org.infernalstudios.endlessabyss.init.EAItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(EndlessAbyss.MODID)
public class EndlessAbyss {
    public static final String MODID = "endlessabyss";
    public static final Logger LOGGER = LogManager.getLogger();

    public EndlessAbyss() {
        MinecraftForge.EVENT_BUS.register(this);

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        EABlocks.register(eventBus);
        EAItems.register(eventBus);
        EAEntityTypes.register(eventBus);
    }
}
