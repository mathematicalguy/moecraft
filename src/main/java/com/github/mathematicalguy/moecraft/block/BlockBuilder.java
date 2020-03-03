package com.github.mathematicalguy.moecraft.block;

import com.github.mathematicalguy.MoeCraftMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.DyeColor;
import net.minecraftforge.common.ToolType;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BlockBuilder<T extends Block> {
    private final Constructor<T> constructor;

    public BlockBuilder(Class<T> clzz) {
        super();
        try {
            constructor = clzz.getConstructor(Block.Properties.class);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("No matching constructor found for block class:" + clzz.getName(), e);
        }
    }

    public WithProperties withMaterial(Material material) {
        return new WithProperties(Block.Properties.create(material));
    }
    public WithProperties withMaterial(Material material, MaterialColor color) {
        return new WithProperties(Block.Properties.create(material, color));
    }
    public WithProperties withMaterial(Material material, DyeColor color) {
        return new WithProperties(Block.Properties.create(material, color));
    }

    public class WithProperties {
        private final Block.Properties properties;
        private String blockName;
        private String modId = MoeCraftMod.MOD_ID;
        
        private WithProperties(Block.Properties properties) {
            super();
            this.properties = properties;
        }

        public WithProperties withBlockName(String name) {
            this.blockName = name;
            return this;
        }

        public WithProperties withModId(String modId) {
            this.modId = modId;
            return this;
        }

        public WithProperties doesNotBlockMovement() {
            properties.doesNotBlockMovement();
            return this;
        }

        public WithProperties func_226896_b_() {
            properties.func_226896_b_();
            return this;
        }

        public WithProperties slipperiness(float slipperinessIn) {
            properties.slipperiness(slipperinessIn);
            return this;
        }

        public WithProperties func_226897_b_(float p_226897_1_) {
            properties.func_226897_b_(p_226897_1_);
            return this;
        }

        public WithProperties func_226898_c_(float p_226898_1_) {
            properties.func_226898_c_(p_226898_1_);
            return this;
        }

        public WithProperties sound(SoundType soundTypeIn) {
            properties.sound(soundTypeIn);
            return this;
        }

        public WithProperties lightValue(int lightValueIn) {
            properties.lightValue(lightValueIn);
            return this;
        }

        public WithProperties hardnessAndResistance(float hardnessIn, float resistanceIn) {
            properties.hardnessAndResistance(hardnessIn, resistanceIn);
            return this;
        }

        public WithProperties hardnessAndResistance(float hardnessAndResistance) {
            properties.hardnessAndResistance(hardnessAndResistance);
            return this;
        }

        public WithProperties tickRandomly() {
            properties.tickRandomly();
            return this;
        }

        public WithProperties variableOpacity() {
            properties.variableOpacity();
            return this;
        }

        public WithProperties harvestLevel(int harvestLevel) {
            properties.harvestLevel(harvestLevel);
            return this;
        }

        public WithProperties harvestTool(ToolType harvestTool) {
            properties.harvestTool(harvestTool);
            return this;
        }

        public WithProperties noDrops() {
            properties.noDrops();
            return this;
        }

        public WithProperties lootFrom(Block blockIn) {
            properties.lootFrom(blockIn);
            return this;
        }

        public T build(String blockName) {
            return this.withBlockName(blockName).build();
        }

        public T build() {
            if ((blockName != null) && (blockName.trim().length() > 0)) {
                try {
                    T block = constructor.newInstance(properties);
                    block.setRegistryName(modId, blockName);
                    return block;
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    throw new IllegalStateException(e);
                }
            } else {
                throw new IllegalStateException("A blockName must be configured");
            }
        }
    }
}
