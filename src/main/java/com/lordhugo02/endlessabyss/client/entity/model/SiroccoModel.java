package com.lordhugo02.endlessabyss.client.entity.model;

import com.lordhugo02.endlessabyss.entities.SiroccoEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class SiroccoModel<T extends SiroccoEntity> extends EntityModel<T> {
    private final ModelRenderer body;
    private final ModelRenderer head;
    private final ModelRenderer beak;
    private final ModelRenderer front_legs;
    private final ModelRenderer right2;
    private final ModelRenderer left2;
    private final ModelRenderer back_legs;
    private final ModelRenderer right;
    private final ModelRenderer left;

    public SiroccoModel() {
        textureWidth = 128;
        textureHeight = 128;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 19.0F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-5.0F, -5.25F, -16.0F, 10.0F, 10.0F, 32.0F, 0.0F, false);
        body.setTextureOffset(84, 107).addBox(0.0F, -11.25F, -16.0F, 0.0F, 6.0F, 15.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, -0.25F, -16.25F);
        body.addChild(head);
        head.setTextureOffset(0, 0).addBox(-3.0F, -3.0F, -4.75F, 6.0F, 6.0F, 5.0F, 0.0F, false);

        beak = new ModelRenderer(this);
        beak.setRotationPoint(0.0F, 3.0F, 0.25F);
        head.addChild(beak);
        beak.setTextureOffset(53, 21).addBox(-3.0F, -1.0F, -5.0F, 6.0F, 2.0F, 5.0F, -0.01F, false);

        front_legs = new ModelRenderer(this);
        front_legs.setRotationPoint(0.0F, 3.75F, -10.0F);
        body.addChild(front_legs);
        

        right2 = new ModelRenderer(this);
        right2.setRotationPoint(-5.0F, -1.0F, 0.0F);
        front_legs.addChild(right2);
        setRotationAngle(right2, 0.0F, 0.0F, 1.5708F);
        right2.setTextureOffset(0, 12).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, 0.0F, false);
        right2.setTextureOffset(17, 0).addBox(-2.0F, 8.0F, 2.0F, 4.0F, 1.0F, 3.0F, 0.0F, false);
        right2.setTextureOffset(22, 6).addBox(-2.0F, 7.0F, 4.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);

        left2 = new ModelRenderer(this);
        left2.setRotationPoint(5.0F, -1.0F, 0.0F);
        front_legs.addChild(left2);
        setRotationAngle(left2, 0.0F, 0.0F, -1.5708F);
        left2.setTextureOffset(0, 12).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, 0.0F, false);
        left2.setTextureOffset(12, 12).addBox(-2.0F, 8.0F, 2.0F, 4.0F, 1.0F, 3.0F, 0.0F, false);
        left2.setTextureOffset(22, 4).addBox(-2.0F, 7.0F, 4.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);

        back_legs = new ModelRenderer(this);
        back_legs.setRotationPoint(0.0F, 3.75F, 10.0F);
        body.addChild(back_legs);
        

        right = new ModelRenderer(this);
        right.setRotationPoint(-5.0F, -1.0F, 0.0F);
        back_legs.addChild(right);
        setRotationAngle(right, 0.0F, 0.0F, 1.5708F);
        right.setTextureOffset(16, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, 0.0F, false);

        left = new ModelRenderer(this);
        left.setRotationPoint(5.0F, -1.0F, 0.0F);
        back_legs.addChild(left);
        setRotationAngle(left, 0.0F, 0.0F, -1.5708F);
        left.setTextureOffset(16, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        // TODO add animations
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}