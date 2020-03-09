package com.github.mathematicalguy.datagen;

import com.google.common.eventbus.Subscribe;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus= Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void  gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
            generator.addProvider(new Recipes(generator));
    }
}
