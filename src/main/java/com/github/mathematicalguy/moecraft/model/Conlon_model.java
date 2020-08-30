package com.github.mathematicalguy.moecraft.model;

import com.github.mathematicalguy.moecraft.entity.Mrconlon;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.VillagerModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;


public class Conlon_model<T extends Mrconlon> extends VillagerModel<T> {
    private final ModelRenderer rightleg;
    private final ModelRenderer leftleg;
    private final ModelRenderer body;
    private final ModelRenderer leftarm;
    private final ModelRenderer rightarm;
    private final ModelRenderer head;

    public Conlon_model() {
        super(0.0f);
        textureWidth = 64;
        textureHeight = 64;

        rightleg = new ModelRenderer(this);
        rightleg.setRotationPoint(0.0F, 24.0F, 0.0F);
        rightleg.setTextureOffset(0, 28).addBox(-4.0F, -10.0F, -2.0F, 4.0F, 10.0F, 3.0F, 0.0F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setRotationPoint(0.0F, 24.0F, 0.0F);
        leftleg.setTextureOffset(22, 22).addBox(0.0F, -10.0F, -2.0F, 4.0F, 10.0F, 3.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 24.0F, 0.0F);
        body.setTextureOffset(0, 15).addBox(-4.0F, -20.0F, -2.0F, 8.0F, 10.0F, 3.0F, 0.0F, false);

        leftarm = new ModelRenderer(this);
        leftarm.setRotationPoint(0.0F, 24.0F, 0.0F);
        leftarm.setTextureOffset(30, 11).addBox(-7.0F, -20.0F, -2.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);

        rightarm = new ModelRenderer(this);
        rightarm.setRotationPoint(0.0F, 24.0F, 0.0F);
        rightarm.setTextureOffset(30, 0).addBox(4.0F, -20.0F, -2.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 24.0F, 0.0F);
        head.setTextureOffset(0, 0).addBox(-4.0F, -28.0F, -4.0F, 8.0F, 8.0F, 7.0F, 0.0F, false);
        head.setTextureOffset(32, 35).addBox(-4.0F, -27.0F, 3.0F, 8.0F, 3.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(14, 35).addBox(-4.0F, -27.0F, -5.0F, 8.0F, 3.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(0, 0).addBox(-1.0F, -23.0F, -5.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
    }

//    @Override
//    public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
//        //previously the render function, render code was moved to a method below
//    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
        leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        leftarm.render(matrixStack, buffer, packedLight, packedOverlay);
        rightarm.render(matrixStack, buffer, packedLight, packedOverlay);
        head.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
