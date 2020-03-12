package com.github.mathematicalguy.Properties;

import com.github.mathematicalguy.init.ModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public class ItemTeirs {
    public static IItemTier aluminumcopper = new IItemTier() {
        @Override
        public int getMaxUses() {
            return 100;
        }

        @Override
        public float getEfficiency() {
            return 0;
        }

        @Override
        public float getAttackDamage() {
            return 3;
        }

        @Override
        public int getHarvestLevel() {
            return 1;
        }

        @Override
        public int getEnchantability() { return 10;}

        @Override
        public Ingredient getRepairMaterial() { return null; }
    };
}
