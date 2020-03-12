package com.github.mathematicalguy.init;

        import com.github.mathematicalguy.Properties.Itemprops;
        import com.github.mathematicalguy.Properties.NewItemTier;
        import net.minecraft.item.*;

public class ModItems {
    public static Item CopperIngot =new Item(Itemprops.IngotProperties).setRegistryName("copper_ingot");
    public static Item aluminumIngot = new Item(Itemprops.IngotProperties).setRegistryName("aluminum_ingot");

    public static Item CopperPickaxe = new PickaxeItem(NewItemTier.COPPER, 2, 2, Itemprops.StoneTool).setRegistryName("copper_pickaxe");
    public static Item CopperAxe = new AxeItem(NewItemTier.COPPER, 4,1,Itemprops.StoneTool).setRegistryName("copper_axe");
    public static Item CopperShovel = new ShovelItem(NewItemTier.COPPER, 1, 2, Itemprops.StoneTool).setRegistryName("copper_shovel");
    public static Item CopperSword = new SwordItem(NewItemTier.COPPER, 5, 3, Itemprops.StoneTool).setRegistryName("copper_sword");
    public static Item CopperHoe = new HoeItem(NewItemTier.COPPER, 2,Itemprops.StoneTool).setRegistryName("copper_hoe");
}
