package com.github.mathematicalguy.moecraft.minecraft;

import com.github.mathematicalguy.moecraft.MoeCraftMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.BlockBlobConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
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
        ConfiguredPlacement orePlacement = Placement.COUNT_RANGE.configure(new CountRangeConfig(chunkAmount, 0, 0, maxHeight));
        ConfiguredFeature oreFeature = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, oreBlock.getDefaultState(), veinSize))
                .withPlacement(orePlacement);
        generate(GenerationStage.Decoration.UNDERGROUND_ORES, oreFeature);
    }
    public static void generateblobbiome(Block block, Biome biomes, GenerationStage.Decoration stage){
      ConfiguredFeature blobFeature = Feature.FOREST_ROCK
              .withConfiguration(new BlockBlobConfig(block.getDefaultState(), 0))
              .withPlacement(Placement.FOREST_ROCK.configure(new FrequencyConfig(3)));
        biomes.addFeature(stage, blobFeature);
    }
}
