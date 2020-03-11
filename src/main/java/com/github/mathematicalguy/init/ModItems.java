package com.github.mathematicalguy.init;

import com.github.mathematicalguy.Properties.ItemTeirs;
import com.github.mathematicalguy.Properties.Itemprops;
import net.minecraft.item.*;

public class ModItems {
    public static Item CopperIngot =new Item(Itemprops.IngotProperties).setRegistryName("copper_ingot");
    public static Item aluminumIngot = new Item(Itemprops.IngotProperties).setRegistryName("aluminum_ingot");

    public static Item CopperPickaxe = new PickaxeItem(ItemTeirs.aluminumcopper, 2, 2, Itemprops.StonePickaxe).setRegistryName("copper_pickaxe");
    public static Item CopperAxe = new AxeItem(ItemTeirs.aluminumcopper, 4,1,Itemprops.StoneAxe).setRegistryName("copper_axe");
    public static Item CopperShovel = new ShovelItem(ItemTeirs.aluminumcopper, 1, 2, Itemprops.StoneShovel).setRegistryName("copper_shovel");
    public static Item CopperSword = new SwordItem(ItemTeirs.aluminumcopper, 5, 3, Itemprops.StoneAxe).setRegistryName("copper_sword");
}
