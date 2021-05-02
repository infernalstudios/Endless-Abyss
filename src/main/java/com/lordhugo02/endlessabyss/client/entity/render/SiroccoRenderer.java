package com.lordhugo02.endlessabyss.client.entity.render;

import com.lordhugo02.endlessabyss.EndlessAbyss;
import com.lordhugo02.endlessabyss.client.entity.model.SiroccoModel;
import com.lordhugo02.endlessabyss.entities.SiroccoEntity;
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