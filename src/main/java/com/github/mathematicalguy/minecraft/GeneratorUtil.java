package com.github.mathematicalguy.minecraft;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;


public class GeneratorUtil {
    public static  void generate(GenerationStage.Decoration stage, ConfiguredFeature<?, ?> feature){
       for (Biome biome : ForgeRegistries.BIOMES) {biome.addFeature(stage, feature);}
       }
       public static void generateOres(BlockState state, int vein_size, int chunk_amount, int max_height){
        generate(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, state,vein_size )).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(chunk_amount, 0, 0,max_height))));
       }

}
