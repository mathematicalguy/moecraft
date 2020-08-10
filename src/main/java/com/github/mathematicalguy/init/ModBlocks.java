package com.github.mathematicalguy.init;

import com.github.mathematicalguy.blocks.BlockBasic;
import net.minecraft.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.github.mathematicalguy.MoeCraftMod.MOD_ID;


public class ModBlocks {

    private static final DeferredRegister<Block> BLOCK_DEFERRED_REGISTRY = new DeferredRegister(ForgeRegistries.BLOCKS, MOD_ID);

    public static final RegistryObject<Block> CopperOre = BLOCK_DEFERRED_REGISTRY.register("copper_ore", ModBlocks::basic);
    public static final RegistryObject<Block> AluminumOre = BLOCK_DEFERRED_REGISTRY.register("aluminum_ore", ModBlocks::basic);

    public static void register(IEventBus bus) {
        BLOCK_DEFERRED_REGISTRY.register(bus);
    }

    private static Block basic() {
        return new BlockBasic();
    }
}