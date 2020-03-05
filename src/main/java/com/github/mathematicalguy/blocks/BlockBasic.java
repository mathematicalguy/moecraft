package com.github.mathematicalguy.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockBasic extends Block {
    private Item drop;
    private int meta;
    private int least_quantity;
    private int most_quantity;
        public BlockBasic(){
        super(Block.Properties.create(Material.IRON).hardnessAndResistance(6));
    }
    public BlockBasic(BlockItem drop, int meta, int least_quantity, int most_quantity)
    {
<<<<<<< HEAD
        super(Block.Properties.create(Material.IRON).hardnessAndResistance(6)  // look at Block.Properties for further options
                // typically useful: hardnessAndResistance(), harvestLevel(), harvestTool()
        );
=======
        super(Block.Properties.create(Material.IRON).hardnessAndResistance(6));
        this.drop = drop;
        this.meta = meta;
        this.least_quantity = least_quantity;
        this.most_quantity = most_quantity;
    }

    public Item getItemDropped(int meta, Random random, int fortune) {
        return this.drop;
>>>>>>> 6f6f081f232ef68dfec7293d3da94d8d4f675f40
    }


    public int damageDropped(int metadata) {
        return this.meta;
    }

    public int quantityDropped(int meta, int fortune, Random random) {
        if (this.least_quantity >= this.most_quantity)
            return this.least_quantity;
        return this.least_quantity + random.nextInt(this.most_quantity - this.least_quantity + fortune + 1);
    }
}
