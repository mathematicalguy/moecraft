package com.github.mathematicalguy.init;

import com.github.mathematicalguy.blocks.BlockBasic;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid= "moecraft")
//find Referece
public class ModBlocks {
    public static Block Copperore;
    public static BlockItem Copperoreitem;  // this holds the unique instance of the ItemBlock corresponding to your block


    @SubscribeEvent
    public static void onBlocksRegistration(final RegistryEvent.Register<Block> blockRegisterEvent) {
        Copperore = (BlockBasic) (new BlockBasic().setRegistryName("moecraft", "copperore_registryname"));
        blockRegisterEvent.getRegistry().register(Copperore);
    }

    @SubscribeEvent
    public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {

        final int MAXIMUM_STACK_SIZE = 64;

        Item.Properties CopperProperties = new Item.Properties()
                .maxStackSize(MAXIMUM_STACK_SIZE)
                .group(ItemGroup.BUILDING_BLOCKS);  // which inventory tab?
        Copperoreitem = new BlockItem(Copperore, CopperProperties);
        Copperore.setRegistryName(Copperore.getRegistryName());
        itemRegisterEvent.getRegistry().register(Copperoreitem);
    }
}