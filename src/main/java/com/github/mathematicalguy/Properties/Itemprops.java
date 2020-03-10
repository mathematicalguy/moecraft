package com.github.mathematicalguy.Properties;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;

public class Itemprops {
   public static Item.Properties OreProperties = new Item.Properties().group(ItemGroup.BUILDING_BLOCKS);  // which inventory tab?
   public static Item.Properties IngotProperties = new Item.Properties().group(ItemGroup.MATERIALS);
   public static Item.Properties StonePickaxe = new Item.Properties().group(ItemGroup.TOOLS).maxStackSize(1).addToolType(ToolType.PICKAXE, 2);
   public static Item.Properties StoneAxe = new Item.Properties().group(ItemGroup.TOOLS).maxStackSize(1).addToolType(ToolType.AXE, 2);
   public static Item.Properties StoneShovel = new Item.Properties().group(ItemGroup.TOOLS).maxStackSize(1).addToolType(ToolType.SHOVEL, 2);
}
