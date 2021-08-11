package org.infernalstudios.endlessabyss.init;

import org.infernalstudios.endlessabyss.EndlessAbyss;
import org.infernalstudios.endlessabyss.entities.SiroccoEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.Level;

public class EAEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE_REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, EndlessAbyss.MODID);

    // To register an entity, please use the template below:
    //    ENTITY_TYPE_REGISTRY.register("entity_name",
    //        () -> EntityType.Builder.create(EntityClass::new, EntityClassification.AMBIENT)
    //                .size(1.0F, 1.0F) //Hitbox Size
    //                .build(new ResourceLocation(EndlessAbyss.MODID, "entity_name").toString()));

    public static RegistryObject<EntityType<SiroccoEntity>> SIROCCO = ENTITY_TYPE_REGISTRY.register("sirocco",
        () -> EntityType.Builder.create(SiroccoEntity::new, EntityClassification.AMBIENT)
            .size(1.0F, 1.5F) //Hitbox Size
            .build(new ResourceLocation(EndlessAbyss.MODID, "sirocco").toString()));

    public static void register(IEventBus eventBus) {
        EndlessAbyss.LOGGER.log(Level.DEBUG, "Registering Entity Types");
        ENTITY_TYPE_REGISTRY.register(eventBus);
    }

}
