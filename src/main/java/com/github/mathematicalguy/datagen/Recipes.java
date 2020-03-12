package com.github.mathematicalguy.datagen;

import com.github.mathematicalguy.init.ModBlocks;
import com.github.mathematicalguy.init.ModItems;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.StandaloneLootEntry;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {
    public Recipes(DataGenerator generatorIn) {
     super(generatorIn);
    }

@Override
   protected void registerRecipes(Consumer<IFinishedRecipe> consumer){
    ShapedRecipeBuilder.shapedRecipe(ModItems.CopperPickaxe)
            .patternLine("xxx")
            .patternLine(" y ")
            .patternLine(" y ")
            .key('x', ModItems.CopperIngot)
            .key('y', Items.STICK)
            .addCriterion("Copper Pickaxe",InventoryChangeTrigger.Instance.forItems(ModItems.CopperPickaxe))
            .build(consumer);
    ShapedRecipeBuilder.shapedRecipe(ModItems.CopperAxe)
            .patternLine(" xx")
            .patternLine(" yx")
            .patternLine(" y ")
            .key('x', ModItems.CopperIngot)
            .key('y', Items.STICK)
            .addCriterion("Copper Axe",InventoryChangeTrigger.Instance.forItems(ModItems.CopperAxe))
            .build(consumer);
    ShapedRecipeBuilder.shapedRecipe(ModItems.CopperShovel)
            .patternLine(" x ")
            .patternLine(" y ")
            .patternLine(" y ")
            .key('x', ModItems.CopperIngot)
            .key('y', Items.STICK)
            .addCriterion("Copper Shovel", InventoryChangeTrigger.Instance.forItems(ModItems.CopperShovel))
            .build(consumer);
    ShapedRecipeBuilder.shapedRecipe(ModItems.CopperSword)
            .patternLine(" x ")
            .patternLine(" x ")
            .patternLine(" y ")
            .addCriterion("Copper Sword", InventoryChangeTrigger.Instance.forItems(ModItems.CopperSword))
            .build(consumer);
        /* Already gen recipies */

        //CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ModBlocks.CopperOreItem), ModItems.CopperIngot, 0.6f, 200)
      //  .addCriterion("item",
               // InventoryChangeTrigger.Instance.forItems(ModBlocks.CopperOreItem))
     //   .build(consumer);

    }
}
