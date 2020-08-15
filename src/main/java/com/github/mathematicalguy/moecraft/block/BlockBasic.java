package com.github.mathematicalguy.moecraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class BlockBasic extends Block {
    private Item drop;
    private int meta;
    private int least_quantity;
    private int most_quantity;
       // public BlockBasic(){
      //  super(Block.Properties.create(Material.IRON).hardnessAndResistance(6));
   // }
    public BlockBasic(BlockItem drop,  int least_quantity, int most_quantity)
    {
        super(Block.Properties.create(Material.IRON)
            .harvestTool(ToolType.PICKAXE)
            .hardnessAndResistance(6)
            .harvestLevel(1));
        this.drop = drop;
        this.least_quantity = least_quantity;
        this.most_quantity = most_quantity;
    }
    public BlockBasic(){
        super(Block.Properties.create(Material.IRON).hardnessAndResistance(6));
    }
}
