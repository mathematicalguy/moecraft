package com.github.mathematicalguy.init;

import com.github.mathematicalguy.Properties.ItemTeirs;
import com.github.mathematicalguy.Properties.Itemprops;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;

public class ModItems {
    public static Item CopperIngot =new Item(Itemprops.IngotProperties).setRegistryName("copper_ingot");
    public static Item aluminumIngot = new Item(Itemprops.IngotProperties).setRegistryName("aluminum_ingot");
    public static PickaxeItem CopperPickaxe = new PickaxeItem(ItemTeirs.aluminumcopper, 3, 2, Itemprops.Pickaxe);
}
