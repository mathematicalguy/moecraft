package com.github.mathematicalguy.moecraft.registry;

import com.github.mathematicalguy.moecraft.MoeCraftMod;
import com.github.mathematicalguy.moecraft.entity.Mrconlon;
import com.github.mathematicalguy.moecraft.properties.Itemprops;
import com.github.mathematicalguy.moecraft.properties.NewItemTier;
import com.github.mathematicalguy.moecraft.block.BlockBasic;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.*;
import net.minecraft.particles.ParticleType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.village.PointOfInterestType;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.github.mathematicalguy.moecraft.MoeCraftMod.MOD_ID;

public class Registrations {

    private static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MOD_ID);
    private static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MOD_ID);
    private static final DeferredRegister<Feature<?>> FEATURES = new DeferredRegister<>(ForgeRegistries.FEATURES, MOD_ID);
    private static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = new DeferredRegister<TileEntityType<?>>(ForgeRegistries.TILE_ENTITIES, MOD_ID);
    private static final DeferredRegister<EntityType<?>> ENTITIES = new DeferredRegister<>(ForgeRegistries.ENTITIES, MOD_ID);
    private static final DeferredRegister<ContainerType<?>> CONTAINERS = new DeferredRegister<>(ForgeRegistries.CONTAINERS, MOD_ID);
    private static final DeferredRegister<ParticleType<?>> PARTICLES = new DeferredRegister<ParticleType<?>>(ForgeRegistries.PARTICLE_TYPES, MOD_ID);
    public static final DeferredRegister<PointOfInterestType> POINTS_OF_INTEREST = new DeferredRegister<>(ForgeRegistries.POI_TYPES, MOD_ID);

    /*
     * Register Blocks
     */
    public static final RegistryObject<Block> CopperOre = BLOCKS.register("copper_ore", () -> new BlockBasic());
    public static final RegistryObject<Block> AluminumOre = BLOCKS.register("aluminum_ore", () -> new BlockBasic());
    public static final RegistryObject<Block> Salt = BLOCKS.register("salt", () -> new BlockBasic());
    /*
     * Register BlockItems
     */
    public static RegistryObject<Item> CopperOreItem = ITEMS.register("copper_ore", () -> new BlockItem(CopperOre.get(), Itemprops.OreProperties));
    public static RegistryObject<Item> AluminumOreItem = ITEMS.register("aluminum_ore", () -> new BlockItem(AluminumOre.get(), Itemprops.OreProperties));
    public static RegistryObject<Item> SaltItem = ITEMS.register("salt", () -> new BlockItem(Salt.get(), Itemprops.OreProperties));

    /*
     * Register Items
     */
    public static RegistryObject<Item> CopperIngot = ITEMS.register("copper_ingot", () -> new Item(Itemprops.IngotProperties));
    public static RegistryObject<Item> AluminumIngot = ITEMS.register("aluminum_ingot", () -> new Item(Itemprops.IngotProperties));
    public static RegistryObject<Item> CopperPickaxe = ITEMS.register("copper_pickaxe", () -> new PickaxeItem(NewItemTier.COPPER, 2, 2, Itemprops.CopperPickaxe));
    public static RegistryObject<Item> CopperAxe = ITEMS.register("copper_axe", () -> new AxeItem(NewItemTier.COPPER, 4,1,Itemprops.CopperAxe));
    public static RegistryObject<Item> CopperShovel = ITEMS.register("copper_shovel", () -> new ShovelItem(NewItemTier.COPPER, 1, 2, Itemprops.CopperShovel));
    public static RegistryObject<Item> CopperSword = ITEMS.register("copper_sword", () -> new SwordItem(NewItemTier.COPPER, 5, 3, Itemprops.CopperSword));
    public static RegistryObject<Item> CopperHoe = ITEMS.register("copper_hoe", () -> new HoeItem(NewItemTier.COPPER, 2,Itemprops.CopperHoe));

    /*
     * Register Features
     */
    // I think this can be used to generate ore's, etc. (I'm just not sure how)
//    public static final RegistryObject<CopperOreFeature> CopperOreOverwoldGen = FEATURES.register("copper_ore_overworld_gen", () -> new CopperOreFeature(CopperOreFeatureConfig::deserialize));



    /*
     * Register TileEntities
     */
//    public static final RegistryObject<TileEntityType<MyTileEntity>> MyTileEntity = TILE_ENTITIES.register("my_tile_entity", () -> TileEntityType.Builder.create(MyTileEntity::new, CopperOre.get()).build(null));


    /*
     * Register Entities
     */
  public static final RegistryObject<EntityType<Mrconlon>> Mr_Conlon = ENTITIES.register("mr_conlon", () -> EntityType.Builder.<Mrconlon>create(Mrconlon::new, EntityClassification.CREATURE).setTrackingRange(64).size(0.5f, 0.5f).build("mr_conlon"));


    /*
     * Register Containers
     */
//    public static final RegistryObject<ContainerType<MyContainer>> MyContainer = CONTAINERS.register("my_container", () -> IForgeContainerType.create(MyContainer::new));


    /*
     * Register Particles
     */
//    public static final RegistryObject<ParticleType<MyParticleData>> MyParticle = PARTICLES.register("my_particle", () -> new MyParticleType());


    public static void register(IEventBus bus) {
        MoeCraftMod.LOGGER.debug("Connecting the event bus with the registration system.");
        BLOCKS.register(bus);
        ITEMS.register(bus);
        FEATURES.register(bus);
        TILE_ENTITIES.register(bus);
        ENTITIES.register(bus);
        CONTAINERS.register(bus);
        PARTICLES.register(bus);
    }
}
