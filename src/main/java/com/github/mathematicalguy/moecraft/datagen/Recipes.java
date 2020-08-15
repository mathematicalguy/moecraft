package com.github.mathematicalguy.moecraft.datagen;

import net.minecraft.data.*;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {
    public Recipes(DataGenerator generatorIn) {
     super(generatorIn);
    }

@Override
   protected void registerRecipes(Consumer<IFinishedRecipe> consumer){

}
}



        /* Already gen recipies */
     /*    ShapedRecipeBuilder.shapedRecipe(ModItems.CopperHoe)
                .patternLine(" xx")
                .patternLine(" y ")
                .patternLine(" y ")
                .key('x',ModItems.CopperIngot)
                .key('y', Items.STICK)
                .addCriterion("Copper Hoe", InventoryChangeTrigger.Instance.forItems(ModItems.CopperHoe))
                .build(consumer); */

        //CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ModBlocks.CopperOreItem), ModItems.CopperIngot, 0.6f, 200)
      //  .addCriterion("item",
               // InventoryChangeTrigger.Instance.forItems(ModBlocks.CopperOreItem))
     //   .build(consumer);