package com.github.mathematicalguy.moecraft.renderer;




import com.github.mathematicalguy.moecraft.MoeCraftMod;
import com.github.mathematicalguy.moecraft.entity.Mrconlon;
import com.github.mathematicalguy.moecraft.model.Conlon_model;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.VillagerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class MrconlonRenderer extends VillagerRenderer<Mrconlon, EntityModel<Mrconlon>>
{
    private static final ResourceLocation CONLON_TEXTURE = new ResourceLocation(MoeCraftMod.MOD_ID + ":textures/entity/conlon_texture.png");

    public MrconlonRenderer(EntityRendererManager manager)
    {
        super(manager, new Conlon_model(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(Mrconlon arg0)
    {
        return CONLON_TEXTURE;
    }

    public static class RenderFactory implements IRenderFactory<Mrconlon>
    {
        @Override
        public EntityRenderer<? super Mrconlon> createRenderFor(EntityRendererManager manager)
        {
            return new MrconlonRenderer(manager);
        }
    }
}