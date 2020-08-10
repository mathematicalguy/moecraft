package com.github.mathematicalguy.minecraft;

import com.github.mathematicalguy.MoeCraftMod;
import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;


public class GeneratorUtil {
    public static void generate(GenerationStage.Decoration stage, ConfiguredFeature<?, ?> feature) {
        for (Biome biome : ForgeRegistries.BIOMES) {
            biome.addFeature(stage, feature);
        }
    }

    public static void generateOre(Block oreBlock, int veinSize, int chunkAmount, int maxHeight) {
        MoeCraftMod.LOGGER.debug("Generating {} into the world", oreBlock.getRegistryName());
        ConfiguredPlacement orePlacement = Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(chunkAmount, 0, 0, maxHeight));
        ConfiguredFeature oreFeature = Feature.ORE.func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, oreBlock.getDefaultState(), veinSize))
                .func_227228_a_(orePlacement);
        generate(GenerationStage.Decoration.UNDERGROUND_ORES, oreFeature);
    }
}
