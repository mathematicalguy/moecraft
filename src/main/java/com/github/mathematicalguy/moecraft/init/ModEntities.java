package com.github.mathematicalguy.moecraft.init;

import com.github.mathematicalguy.moecraft.MoeCraftMod;
import com.github.mathematicalguy.moecraft.entity.Mrconlon;
import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(MoeCraftMod.MOD_ID)
public class ModEntities {
    @ObjectHolder("mr_conlon")
    public static final EntityType<Mrconlon> MrConlon = null;
}
