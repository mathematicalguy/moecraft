package com.github.mathematicalguy.moecraft.common;

import com.github.mathematicalguy.moecraft.MoeCraftMod;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.JigsawPiece;
import net.minecraft.world.gen.feature.jigsaw.SingleJigsawPiece;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Village {
    public static final Random RAND = new Random();
    public static final ResourceLocation CHEMIST = new ResourceLocation(MoeCraftMod.MOD_ID,"chemist");


    //adding mr Conlon to the villager pool
    public static void init() {
        PlainsVillagePools.init();
        SnowyVillagePools.init();
        SavannaVillagePools.init();
        DesertVillagePools.init();
        TaigaVillagePools.init();


        //will registers conlons house for each biome
        for (String biome : new String[]{"plains", "snowy", "savanna", "desert", "taiga"}) {
            addToPool(new ResourceLocation("village/" + biome + "/houses"), rl("village/houses/" + biome + "_chemist"), 1);
        }
        JigsawManager.REGISTRY.register(new JigsawPattern(
                new ResourceLocation(MoeCraftMod.MOD_ID, "village/workstations"),
                new ResourceLocation("empty"),
                ImmutableList.of(
                        new Pair<>(new SingleJigsawPiece(MoeCraftMod.MOD_ID + ":village/workstations/chemist"), 1)
                ),
                JigsawPattern.PlacementBehaviour.RIGID
        ));
    }

    private static void addToPool(ResourceLocation pool, ResourceLocation toAdd, int weight) {
        JigsawPattern old = JigsawManager.REGISTRY.get(pool);
        List<JigsawPiece> shuffled = old.getShuffledPieces(RAND);
        List<Pair<JigsawPiece, Integer>> newPieces = new ArrayList<>();
        for (JigsawPiece p : shuffled) {
            newPieces.add(new Pair<>(p, 1));
        }
        newPieces.add(new Pair<>(new SingleJigsawPiece(toAdd.toString()), weight));
        ResourceLocation name = old.getName();
        JigsawManager.REGISTRY.register(new JigsawPattern(pool, name, newPieces, JigsawPattern.PlacementBehaviour.RIGID));
    }

    public static ItemStack copyStackWithAmount(ItemStack stack, int amount)
    {
        if(stack.isEmpty())
            return ItemStack.EMPTY;
        ItemStack s2 = stack.copy();
        s2.setCount(amount);
        return s2;
    }

    public static ResourceLocation rl(String path) {
        return new ResourceLocation(MoeCraftMod.MOD_ID, path);
    }


    @Mod.EventBusSubscriber(modid = MoeCraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class Events {
        @SubscribeEvent
        public static void registerTrades(VillagerTradesEvent ev) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = ev.getTrades();
            if(CHEMIST.equals(ev.getType().getRegistryName())){
                trades.get(1).add(new EmeraldForItems(Items.DIAMOND_BLOCK, new PriceInterval(32,64),16,2));
            }
        }
    }
    private static class EmeraldForItems implements VillagerTrades.ITrade
    {
        public ItemStack buyingItem;
        public PriceInterval buyAmounts;
        final int maxUses;
        final int xp;

        public EmeraldForItems(@Nonnull ItemStack item, @Nonnull PriceInterval buyAmounts, int maxUses, int xp)
        {
            this.buyingItem = item;
            this.buyAmounts = buyAmounts;
            this.maxUses = maxUses;
            this.xp = xp;
        }

        public EmeraldForItems(@Nonnull IItemProvider item, @Nonnull PriceInterval buyAmounts, int maxUses, int xp)
        {
            this(new ItemStack(item), buyAmounts, maxUses, xp);
        }

        @Nullable
        @Override
        public MerchantOffer getOffer(Entity trader, Random rand)
        {
            return new MerchantOffer(
                    copyStackWithAmount(this.buyingItem, this.buyAmounts.getPrice(rand)),
                    new ItemStack(Items.EMERALD),
                    //TODO adjust values for individual trades
                    maxUses, xp, 0.05f);
        }
    }
    private static class PriceInterval
    {
        private final int min;
        private final int max;

        private PriceInterval(int min, int max)
        {
            this.min = min;
            this.max = max;
        }

        int getPrice(Random rand)
        {
            return min >= max?min: min+rand.nextInt(max-min+1);
        }
    }
}