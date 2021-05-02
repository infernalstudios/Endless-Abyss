package com.lordhugo02.endlessabyss.util;

import com.lordhugo02.endlessabyss.EndlessAbyss;
import com.lordhugo02.endlessabyss.entities.SiroccoEntity;
import com.lordhugo02.endlessabyss.registries.EndlessAbyssEntityTypes;

import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

@Mod.EventBusSubscriber(modid = EndlessAbyss.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntitySpawns {
    @SubscribeEvent
    public static void spawnEntities(FMLLoadCompleteEvent event) {
        GlobalEntityTypeAttributes.put(EndlessAbyssEntityTypes.SIROCCO.get(), SiroccoEntity.setCustomAttributes().create());
    }
}
