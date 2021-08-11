package com.lordhugo02.endlessabyss.events;

import com.lordhugo02.endlessabyss.EndlessAbyss;
import com.lordhugo02.endlessabyss.entities.SiroccoEntity;
import com.lordhugo02.endlessabyss.init.EAEntityTypes;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EndlessAbyss.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityEvents {

    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(EAEntityTypes.SIROCCO.get(), SiroccoEntity.setCustomAttributes().create());
    }
}
