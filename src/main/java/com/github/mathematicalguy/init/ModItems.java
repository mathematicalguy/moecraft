package com.github.mathematicalguy.init;

import com.github.mathematicalguy.MoeCraftMod;
import com.github.mathematicalguy.Properties.Itemprops;
import com.github.mathematicalguy.Properties.NewItemTier;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

@net.minecraftforge.registries.ObjectHolder(MoeCraftMod.MOD_ID)
public class ModItems {
    public static Item CopperIngot =new Item(Itemprops.IngotProperties).setRegistryName("copper_ingot");
    public static Item aluminumIngot = new Item(Itemprops.IngotProperties).setRegistryName("aluminum_ingot");

    public static Item CopperPickaxe = new PickaxeItem(NewItemTier.COPPER, 2, 2, Itemprops.CopperPickaxe).setRegistryName(MoeCraftMod.MOD_ID, "copper_pickaxe");

    public static Item CopperAxe =  new AxeItem(NewItemTier.COPPER, 4,1,Itemprops.CopperAxe).setRegistryName(MoeCraftMod.MOD_ID, "copper_axe");
    public static Item CopperShovel = new ShovelItem(NewItemTier.COPPER, 1, 2, Itemprops.CopperShovel).setRegistryName(MoeCraftMod.MOD_ID, "copper_shovel");;
    public static Item CopperSword = new SwordItem(NewItemTier.COPPER, 5, 3, Itemprops.CopperSword).setRegistryName(MoeCraftMod.MOD_ID, "copper_sword");;
    public static Item CopperHoe = new HoeItem(NewItemTier.COPPER, 2,Itemprops.CopperHoe).setRegistryName(MoeCraftMod.MOD_ID, "copper_hoe");;

}
