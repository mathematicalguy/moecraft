package com.github.mathematicalguy.Properties;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;

public class Itemprops {
   public static Item.Properties OreProperties = new Item.Properties().group(ItemGroup.BUILDING_BLOCKS);  // which inventory tab?
   public static Item.Properties IngotProperties = new Item.Properties().group(ItemGroup.MATERIALS);
   public static Item.Properties CopperAxe= new Item.Properties().group(ItemGroup.TOOLS).maxStackSize(1);
   public static Item.Properties CopperShovel = new Item.Properties().group(ItemGroup.TOOLS).maxStackSize(1);
   public static Item.Properties CooperHoe = new Item.Properties().group(ItemGroup.TOOLS).maxStackSize(1);
   public static Item.Properties CooperPickaxe = new Item.Properties().group(ItemGroup.TOOLS).maxStackSize(1);
   public static Item.Properties CooperSword = new Item.Properties().group(ItemGroup.TOOLS).maxStackSize(1);

}
