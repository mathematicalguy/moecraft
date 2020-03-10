package com.github.mathematicalguy.init;

import com.github.mathematicalguy.Properties.ItemTeirs;
import com.github.mathematicalguy.Properties.Itemprops;
import net.minecraft.item.*;

public class ModItems {
    public static Item CopperIngot =new Item(Itemprops.IngotProperties).setRegistryName("copper_ingot");
    public static Item aluminumIngot = new Item(Itemprops.IngotProperties).setRegistryName("aluminum_ingot");

    public static Item CopperPickaxe = new PickaxeItem(ItemTeirs.aluminumcopper, 3, 2, Itemprops.tool).setRegistryName("copper_pickaxe");
    public static Item CopperAxe = new AxeItem(ItemTeirs.aluminumcopper, 4,1,Itemprops.tool).setRegistryName("copper_axe");
    public static Item CopperHoe = new HoeItem(ItemTeirs.aluminumcopper, 2, Itemprops.tool).setRegistryName("copper_hoe");
    public static Item CopperShovel = new ShovelItem(ItemTeirs.aluminumcopper, 2, 2, Itemprops.tool).setRegistryName("copper_shovel");
    public static Item CopperSword = new SwordItem(ItemTeirs.aluminumcopper, 5, 3, Itemprops.tool).setRegistryName("copper_sword");
}
