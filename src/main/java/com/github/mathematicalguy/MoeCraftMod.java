package com.github.mathematicalguy;

import com.github.mathematicalguy.Properties.Itemprops;
import com.github.mathematicalguy.init.ModBlocks;
import com.github.mathematicalguy.minecraft.GeneratorUtil;
import com.github.mathematicalguy.minecraft. RenderTypeUtil;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.github.mathematicalguy.Properties.Itemprops;
import java.util.stream.Collectors;

import static com.github.mathematicalguy.MoeCraftMod.MOD_ID;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MOD_ID)
public class MoeCraftMod
{
    public static final String MOD_ID = "moecraft";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public MoeCraftMod() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void setup(final FMLCommonSetupEvent event)
    {
        GeneratorUtil.generateOres(ModBlocks.CopperOre.getDefaultState(), 7, 10, 64);
        GeneratorUtil.generateOres(ModBlocks.AluminumOre.getDefaultState(), 7, 10, 64);
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
        RenderTypeLookup.setRenderLayer(ModBlocks.CopperOre, RenderTypeUtil.solid());

    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
       InterModComms.sendTo("moecraft", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
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

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD, modid = MOD_ID)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {
            ModBlocks.CopperOreItem.setRegistryName(ModBlocks.CopperOre.getRegistryName());
            itemRegisterEvent.getRegistry().register(ModBlocks.CopperOreItem);

            ModBlocks.AluminumOreItem.setRegistryName(ModBlocks.AluminumOre.getRegistryName());
            itemRegisterEvent.getRegistry().register(ModBlocks.AluminumOreItem);
        }
        @SubscribeEvent
        public static void onBlocksRegistration(final RegistryEvent.Register<Block> blockRegisterEvent) {
            LOGGER.debug("Registering {} blocks", MOD_ID);
            blockRegisterEvent.getRegistry().register(ModBlocks.CopperOre);
            blockRegisterEvent.getRegistry().register(ModBlocks.AluminumOre);
        }


    }

}

