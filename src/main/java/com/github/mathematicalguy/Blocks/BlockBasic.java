package com.github.mathematicalguy.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


public class BlockBasic extends Block {
    public BlockBasic()
    {
        super(Block.Properties.create(Material.IRON)  // look at Block.Properties for further options
                // typically useful: hardnessAndResistance(), harvestLevel(), harvestTool()
        );
    }

}
