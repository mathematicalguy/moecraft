package com.github.mathematicalguy.Properties;

import com.github.mathematicalguy.MoeCraftMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;

public class Itemprops {
   public static Item.Properties OreProperties = new Item.Properties().group(MoeCraftMod.TAB);  // which inventory tab?
   public static Item.Properties IngotProperties = new Item.Properties().group(MoeCraftMod.TAB);
   public static Item.Properties CopperAxe= new Item.Properties().group(MoeCraftMod.TAB).maxStackSize(1);
   public static Item.Properties CopperShovel = new Item.Properties().group(MoeCraftMod.TAB).maxStackSize(1);
   public static Item.Properties CopperHoe = new Item.Properties().group(MoeCraftMod.TAB).maxStackSize(1);
   public static Item.Properties CopperPickaxe = new Item.Properties().group(MoeCraftMod.TAB).maxStackSize(1);
   public static Item.Properties CopperSword = new Item.Properties().group(MoeCraftMod.TAB).maxStackSize(1);

}
