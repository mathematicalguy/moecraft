package com.github.mathematicalguy.moecraft;

import com.github.mathematicalguy.moecraft.init.ModBlocks;
import com.github.mathematicalguy.moecraft.init.ModItems;
import com.github.mathematicalguy.moecraft.minecraft.GeneratorUtil;
import com.github.mathematicalguy.moecraft.registry.Registrations;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

import static com.github.mathematicalguy.moecraft.MoeCraftMod.MOD_ID;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MOD_ID)
@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MoeCraftMod
{
    public static final String MOD_ID = "moecraft";
    public static final ItemGroup TAB = new ItemGroup("Moecraft") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.CopperIngot);
        }
    };

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger(MoeCraftMod.class);

    public MoeCraftMod() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        Registrations.register(eventBus);

        // Register Mod Configuration Methods
        eventBus.addListener(this::setup);
        eventBus.addListener(this::enqueueIMC);
        eventBus.addListener(this::processIMC);
        eventBus.addListener(this::doClientStuff);
        eventBus.addListener(this::loadComplete);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void setup(final FMLCommonSetupEvent event)
    {
    }

    private void loadComplete(FMLLoadCompleteEvent event) {
        LOGGER.info("Generating MoeCraft ores into the world...");
        GeneratorUtil.generateOre(ModBlocks.CopperOre, 7, 16, 64);
        GeneratorUtil.generateOre(ModBlocks.AluminumOre, 7, 16, 64);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
        RenderTypeLookup.setRenderLayer(ModBlocks.CopperOre, RenderType.getSolid());
        RenderTypeLookup.setRenderLayer(ModBlocks.AluminumOre, RenderType.getSolid());
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
//       InterModComms.sendTo("moecraft", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
}
