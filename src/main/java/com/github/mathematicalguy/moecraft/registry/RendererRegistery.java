package com.github.mathematicalguy.moecraft.registry;

import com.github.mathematicalguy.moecraft.init.ModEntities;
import com.github.mathematicalguy.moecraft.renderer.MrconlonRenderer;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import static com.github.mathematicalguy.moecraft.MoeCraftMod.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RendererRegistery {
    @SubscribeEvent
    public static void renderers(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.MrConlon, MrconlonRenderer::new);
    }
}
