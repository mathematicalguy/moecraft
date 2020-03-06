package com.github.mathematicalguy.world;

import com.github.mathematicalguy.init.ModBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;

import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGen {
    public static void setupOreGen(){
        for(Biome biome: ForgeRegistries.BIOMES)
        {
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,Feature.ORE.func_225566_b_( new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.CopperOre.getDefaultState(), 7)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(4, 1,1, 63))));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,Feature.ORE.func_225566_b_( new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.AluminumOre.getDefaultState(), 7)).func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(4, 1,1, 63))));


        }
    }
}
