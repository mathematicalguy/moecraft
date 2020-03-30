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

    public static PickaxeItem CopperPickaxe = register("copper_pickaxe", new PickaxeItem(NewItemTier.COPPER, 2, 2, Itemprops.StoneTool));
    public static AxeItem CopperAxe = register("copper_axe", new AxeItem(NewItemTier.COPPER, 4,1,Itemprops.StoneTool));
    public static ShovelItem CopperShovel = register("copper_shovel", new ShovelItem(NewItemTier.COPPER, 1, 2, Itemprops.StoneTool));
    public static SwordItem CopperSword = register("copper_sword", new SwordItem(NewItemTier.COPPER, 5, 3, Itemprops.StoneTool));
    public static HoeItem CopperHoe = register("copper_hoe", new HoeItem(NewItemTier.COPPER, 2,Itemprops.StoneTool));

    private static <T extends Item> T register(String key, T p_221547_1_) {
        return register(new ResourceLocation(key), p_221547_1_);
    }

    private static  <T extends Item> T register(ResourceLocation key, T p_221544_1_) {
        if (p_221544_1_ instanceof BlockItem) {
            ((BlockItem)p_221544_1_).addToBlockToItemMap(Item.BLOCK_TO_ITEM, p_221544_1_);
        }

        return (T) Registry.register(Registry.ITEM, key, p_221544_1_);
    }
}
