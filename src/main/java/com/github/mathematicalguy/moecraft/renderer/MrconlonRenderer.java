package com.github.mathematicalguy.moecraft.renderer;




import com.github.mathematicalguy.moecraft.MoeCraftMod;
import com.github.mathematicalguy.moecraft.entity.MrConlon;
import com.github.mathematicalguy.moecraft.model.MrConlonModel;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.VillagerModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class MrconlonRenderer extends MobRenderer<MrConlon, VillagerModel<MrConlon>>
{
    private static final ResourceLocation CONLON_TEXTURE = new ResourceLocation(MoeCraftMod.MOD_ID + ":textures/entity/conlon_texture.png");

    public MrconlonRenderer(EntityRendererManager manager)
    {
        super(manager, new MrConlonModel(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(MrConlon arg0)
    {
        return CONLON_TEXTURE;
    }

    public static class RenderFactory implements IRenderFactory<MrConlon>
    {
        @Override
        public EntityRenderer<? super MrConlon> createRenderFor(EntityRendererManager manager)
        {
            return new MrconlonRenderer(manager);
        }
    }
}