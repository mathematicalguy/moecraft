package com.github.mathematicalguy.datagen;

import com.github.mathematicalguy.init.ModBlocks;
import com.github.mathematicalguy.init.ModItems;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.StandaloneLootEntry;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {
    public Recipes(DataGenerator generatorIn) {
     super(generatorIn);
    }


   protected void registerRecipes(Consumer<IFinishedRecipe> consumer){
CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ModBlocks.CopperOreItem), ModItems.CopperIngot, 0.6f, 200)
        .addCriterion("item",
                InventoryChangeTrigger.Instance.forItems(ModBlocks.CopperOreItem))
        .build(consumer);

    }
}
