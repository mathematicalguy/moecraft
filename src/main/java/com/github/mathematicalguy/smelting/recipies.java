package com.github.mathematicalguy.smelting;

import com.github.mathematicalguy.init.ModBlocks;
import com.github.mathematicalguy.init.ModItems;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.function.Consumer;

public class recipies {
    public static void initrecipies(Consumer<IFinishedRecipe> consumer){
CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ModBlocks.CopperOreItem.getItem()), ModItems.CopperIngot.getItem(), 0.6f, 200)
        .addCriterion("item", InventoryChangeTrigger.Instance.forItems(ModBlocks.CopperOreItem.getItem()))
        .build(consumer, new ResourceLocation("moecraft","﻿copper_ingot_smelting"));

    }
}
