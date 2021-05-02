package com.lordhugo02.endlessabyss.registries;

import com.lordhugo02.endlessabyss.EndlessAbyss;
import com.lordhugo02.endlessabyss.entities.SiroccoEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EndlessAbyssEntityTypes
{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE_REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, EndlessAbyss.MODID);
    
    // To register an entity, please use the template below:
    //    ENTITY_TYPE_REGISTRY.register("entity_name",
    //        () -> EntityType.Builder.create(EntityClass::new, EntityClassification.AMBIENT)
    //                .size(1.0F, 1.0F) //Hitbox Size
    //                .build(new ResourceLocation(EndlessAbyss.MODID, "entity_name").toString()));

    public static RegistryObject<EntityType<SiroccoEntity>> SIROCCO = ENTITY_TYPE_REGISTRY.register("sirocco",
            () -> EntityType.Builder.<SiroccoEntity>create(SiroccoEntity::new, EntityClassification.AMBIENT)
                    .size(1.0F, 1.5F) //Hitbox Size
                    .build(new ResourceLocation(EndlessAbyss.MODID, "sirocco").toString()));
}
