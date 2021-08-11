package org.infernalstudios.endlessabyss.client.entity.render;

import org.infernalstudios.endlessabyss.EndlessAbyss;
import org.infernalstudios.endlessabyss.client.entity.model.SiroccoModel;
import org.infernalstudios.endlessabyss.entities.SiroccoEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class SiroccoRenderer extends MobRenderer<SiroccoEntity, SiroccoModel<SiroccoEntity>> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(EndlessAbyss.MODID, "textures/entity/sirocco.png");

    public SiroccoRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new SiroccoModel<>(), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(SiroccoEntity entity) {
        return TEXTURE;
    }
}
