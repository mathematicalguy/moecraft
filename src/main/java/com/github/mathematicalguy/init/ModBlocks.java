package com.github.mathematicalguy.init;

import com.github.mathematicalguy.Properties.Itemprops;
import com.github.mathematicalguy.blocks.BlockBasic;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.github.mathematicalguy.MoeCraftMod.MOD_ID;


public class ModBlocks {
    public static BlockBasic CopperOre = (BlockBasic) (new BlockBasic().setRegistryName(MOD_ID, "copper_ore"));
    public static BlockItem CopperOreItem = new BlockItem(ModBlocks.CopperOre, Itemprops.OreProperties);

    public static BlockBasic AluminumOre = (BlockBasic) (new BlockBasic().setRegistryName(MOD_ID, "aluminum_ore"));
    public static BlockItem AluminumOreItem = new BlockItem(ModBlocks.AluminumOre, Itemprops.OreProperties);
}