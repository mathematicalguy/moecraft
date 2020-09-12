package com.github.mathematicalguy.moecraft.Container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.MerchantInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;

import javax.annotation.Nullable;


public class ConlonContainer extends Container {

    protected ConlonContainer(@Nullable ContainerType<?> type, int id) {
        super(type, id);
    }
    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return false;
    }

}
