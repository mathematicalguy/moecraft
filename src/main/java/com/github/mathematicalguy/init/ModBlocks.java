package com.github.mathematicalguy.init;

import com.github.mathematicalguy.blocks.BlockBasic;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.github.mathematicalguy.MoeCraftMod.MOD_ID;


@Mod.EventBusSubscriber(modid= MOD_ID)
//find Referece
public class ModBlocks {
    public static BlockBasic CopperOre;
    public static BlockItem CopperOreItem;  // this holds the unique instance of the ItemBlock corresponding to your block


    @SubscribeEvent
    public static void onBlocksRegistration(final RegistryEvent.Register<Block> blockRegisterEvent) {
        CopperOre = (BlockBasic) (new BlockBasic().setRegistryName(MOD_ID, "copper_ore"));
        blockRegisterEvent.getRegistry().register(CopperOre);
    }

    @SubscribeEvent
    public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {
        Item.Properties CopperProperties = new Item.Properties()
                .group(ItemGroup.BUILDING_BLOCKS);  // which inventory tab?
        CopperOreItem = new BlockItem(CopperOre, CopperProperties);
        CopperOreItem.setRegistryName(CopperOre.getRegistryName());
        itemRegisterEvent.getRegistry().register(CopperOreItem);
    }
}