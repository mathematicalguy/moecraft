package com.github.mathematicalguy.moecraft.common;

import com.github.mathematicalguy.moecraft.MoeCraftMod;
import com.mojang.datafixers.util.Pair;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.JigsawPiece;
import net.minecraft.world.gen.feature.jigsaw.SingleJigsawPiece;
import net.minecraft.world.gen.feature.structure.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Village {
    public static final Random RAND = new Random();
    private static final ResourceLocation CHEMIST_TEXTURE = new ResourceLocation(MoeCraftMod.MOD_ID + ":textures/entity/gunsmith.png");


    //adding mr Conlon to the villager pool
    public static void init(){
        PlainsVillagePools.init();
        SnowyVillagePools.init();
        SavannaVillagePools.init();
        DesertVillagePools.init();
        TaigaVillagePools.init();


        //will registers conlons house for each biome
        for (String biome: new String[]{"plains","snowy","savanna","desert","taiga"})
            addToPool(new ResourceLocation("village/"+biome+"/houses"),rl("village/houses/"+biome+"_chemist"), 1);
    }

    private static void addToPool(ResourceLocation pool, ResourceLocation toAdd, int weight)
    {
        JigsawPattern old = JigsawManager.REGISTRY.get(pool);
        List<JigsawPiece> shuffled = old.getShuffledPieces(RAND);
        List<Pair<JigsawPiece, Integer>> newPieces = new ArrayList<>();
        for(JigsawPiece p : shuffled)
        {
            newPieces.add(new Pair<>(p, 1));
        }
        newPieces.add(new Pair<>(new SingleJigsawPiece(toAdd.toString()), weight));
        ResourceLocation name = old.getName();
        JigsawManager.REGISTRY.register(new JigsawPattern(pool, name, newPieces, JigsawPattern.PlacementBehaviour.RIGID));
    }
    public static ResourceLocation rl(String path)
    {
        return new ResourceLocation(MoeCraftMod.MOD_ID, path);
    }
}
