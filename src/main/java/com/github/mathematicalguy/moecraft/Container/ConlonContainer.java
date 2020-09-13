package com.github.mathematicalguy.moecraft.Container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.MerchantInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.MerchantContainer;
import net.minecraft.inventory.container.Slot;

import javax.annotation.Nullable;


public class ConlonContainer extends MerchantContainer {


    public ConlonContainer(int id, PlayerInventory playerInventoryIn) {
        super(id, playerInventoryIn);
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return false;
    }

}
