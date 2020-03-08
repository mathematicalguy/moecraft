package com.github.mathematicalguy.Properties;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class Itemprops {
   public static Item.Properties OreProperties = new Item.Properties().group(ItemGroup.BUILDING_BLOCKS);  // which inventory tab?
   public static Item.Properties IngotProperties = new Item.Properties().group(ItemGroup.MATERIALS);
}
