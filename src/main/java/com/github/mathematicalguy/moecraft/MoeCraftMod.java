package com.github.mathematicalguy.moecraft;

import com.github.mathematicalguy.moecraft.init.ModBlocks;
import com.github.mathematicalguy.moecraft.init.ModItems;
import com.github.mathematicalguy.moecraft.minecraft.GeneratorUtil;
import com.github.mathematicalguy.moecraft.registry.Registrations;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.AppenderRef;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;


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

    static {
        initiateMoeCraftLoggingLevel();

    }

    public MoeCraftMod() {
        LOGGER.debug("Deferring registration of MoeCraft entities");
        Registrations.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    @SubscribeEvent
    public static void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.debug("MoeCraftMod::setup");
    }

    @SubscribeEvent
    public static void loadComplete(FMLLoadCompleteEvent event) {
        LOGGER.info("Generating MoeCraft ores into the world...");
        GeneratorUtil.generateOre(ModBlocks.CopperOre, 7, 16, 64);
        GeneratorUtil.generateOre(ModBlocks.AluminumOre, 7, 16, 64);
    }

    @SubscribeEvent
    public static void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
        RenderTypeLookup.setRenderLayer(ModBlocks.CopperOre, RenderType.getSolid());
        RenderTypeLookup.setRenderLayer(ModBlocks.AluminumOre, RenderType.getSolid());
    }

    @SubscribeEvent
    public static void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
//       InterModComms.sendTo("moecraft", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    @SubscribeEvent
    public static void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // This method will look for the existence of a environment property named "moecraft.logging.level" - the value
    // of this property (if it exists) will be used to set the logging level of all loggers in the package
    // "com.github.mathematicalguy.moecreaft" - this shouldn't be this difficult to do
    // This allows us to set our MoeCraft logging to DEBUG, while setting the FML and Minecraft Loggers to INFO
    // (reducing noise in the logs)
    private static final void initiateMoeCraftLoggingLevel() {
        String moecraftLevel = System.getProperty("moecraft.logging.level");
        if ((moecraftLevel != null) && (!moecraftLevel.trim().isEmpty())) {
            Level level = Level.getLevel(moecraftLevel.toUpperCase());
            final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
            final Configuration config = ctx.getConfiguration();
            final LoggerConfig rootConfig = config.getRootLogger();

            LoggerConfig loggerConfig = LoggerConfig.createLogger("false", level, "com.github.mathematicalguy.moecraft",
                    "true", rootConfig.getAppenderRefs().toArray(new AppenderRef[0]), null, config, null );
            for(Appender a : rootConfig.getAppenders().values()) {
                loggerConfig.addAppender(a, level, null);
            }
            config.addLogger("com.github.mathematicalguy.moecraft", loggerConfig);
            ctx.updateLoggers();

            LogManager.getLogger(MoeCraftMod.class).debug("Overriding MoeCraft Log Level to: '{}'", moecraftLevel);
        }
    }
}

