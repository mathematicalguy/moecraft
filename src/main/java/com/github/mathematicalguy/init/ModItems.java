package com.github.mathematicalguy.init;

import com.github.mathematicalguy.MoeCraftMod;
import com.github.mathematicalguy.Properties.Itemprops;
import com.github.mathematicalguy.Properties.NewItemTier;
import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.github.mathematicalguy.MoeCraftMod.MOD_ID;

@net.minecraftforge.registries.ObjectHolder(MoeCraftMod.MOD_ID)
public class ModItems {
    private static final DeferredRegister<Item> ITEM_DEFERRED_REGISTER = new DeferredRegister(ForgeRegistries.ITEMS, MOD_ID);

    public static RegistryObject<Item> CopperIngot = ITEM_DEFERRED_REGISTER.register("copper_ingot", () -> new Item(Itemprops.IngotProperties));
    public static RegistryObject<Item> AluminumIngot = ITEM_DEFERRED_REGISTER.register("aluminum_ingot", () -> new Item(Itemprops.IngotProperties));
    public static RegistryObject<Item> CopperPickaxe = ITEM_DEFERRED_REGISTER.register("copper_pickaxe", () -> new PickaxeItem(NewItemTier.COPPER, 2, 2, Itemprops.CopperPickaxe));
    public static RegistryObject<Item> CopperAxe = ITEM_DEFERRED_REGISTER.register("copper_axe", () -> new AxeItem(NewItemTier.COPPER, 4,1,Itemprops.CopperAxe));
    public static RegistryObject<Item> CopperShovel = ITEM_DEFERRED_REGISTER.register("copper_shovel", () -> new ShovelItem(NewItemTier.COPPER, 1, 2, Itemprops.CopperShovel));
    public static RegistryObject<Item> CopperSword = ITEM_DEFERRED_REGISTER.register("copper_sword", () -> new SwordItem(NewItemTier.COPPER, 5, 3, Itemprops.CopperSword));
    public static RegistryObject<Item> CopperHoe = ITEM_DEFERRED_REGISTER.register("copper_hoe", () -> new HoeItem(NewItemTier.COPPER, 2,Itemprops.CopperHoe));

    // Block Items
    public static RegistryObject<Item> CopperOreItem = ITEM_DEFERRED_REGISTER.register("copper_ore", () -> new BlockItem(ModBlocks.CopperOre.get(), Itemprops.OreProperties));
    public static RegistryObject<Item> AluminumOreItem = ITEM_DEFERRED_REGISTER.register("aluminum_ore", () -> new BlockItem(ModBlocks.AluminumOre.get(), Itemprops.OreProperties));

    public static void register(IEventBus bus) {
        ITEM_DEFERRED_REGISTER.register(bus);
    }

}
