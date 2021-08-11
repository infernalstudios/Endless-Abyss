package org.infernalstudios.endlessabyss.events;

import org.infernalstudios.endlessabyss.EndlessAbyss;
import org.infernalstudios.endlessabyss.entities.SiroccoEntity;
import org.infernalstudios.endlessabyss.init.EAEntityTypes;
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
