package com.github.mathematicalguy.moecraft.properties;

import com.github.mathematicalguy.moecraft.MoeCraftMod;
import net.minecraft.item.Item;

public class Itemprops {
   public static Item.Properties OreProperties = new Item.Properties().group(MoeCraftMod.TAB);  // which inventory tab?
   public static Item.Properties IngotProperties = new Item.Properties().group(MoeCraftMod.TAB);
   public static Item.Properties CopperAxe= new Item.Properties().group(MoeCraftMod.TAB).maxStackSize(1);
   public static Item.Properties CopperShovel = new Item.Properties().group(MoeCraftMod.TAB).maxStackSize(1);
   public static Item.Properties CopperHoe = new Item.Properties().group(MoeCraftMod.TAB).maxStackSize(1);
   public static Item.Properties CopperPickaxe = new Item.Properties().group(MoeCraftMod.TAB).maxStackSize(1);
   public static Item.Properties CopperSword = new Item.Properties().group(MoeCraftMod.TAB).maxStackSize(1);


}
