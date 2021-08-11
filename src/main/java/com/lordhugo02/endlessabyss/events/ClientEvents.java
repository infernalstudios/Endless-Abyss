package com.lordhugo02.endlessabyss.events;

import com.lordhugo02.endlessabyss.EndlessAbyss;
import com.lordhugo02.endlessabyss.client.entity.render.SiroccoRenderer;
import com.lordhugo02.endlessabyss.item.ModSpawnEggItem;
import com.lordhugo02.endlessabyss.init.EAEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = EndlessAbyss.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EAEntityTypes.SIROCCO.get(), SiroccoRenderer::new);
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onPostRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItem.initUnaddedEggs();
    }
}
