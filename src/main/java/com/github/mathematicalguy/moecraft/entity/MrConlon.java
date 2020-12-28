package com.github.mathematicalguy.moecraft.entity;

import com.github.mathematicalguy.moecraft.registry.Registrations;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class MrConlon extends AbstractVillagerEntity {
    public MrConlon(EntityType<? extends AbstractVillagerEntity> type, World worldIn) {
        super(type, worldIn);
    }
    @Override
    public AbstractVillagerEntity createChild(AgeableEntity ageable) {
        MrConlon entity = new MrConlon(Registrations.Mr_Conlon.get(), this.world);
        entity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(entity)), SpawnReason.BREEDING, (ILivingEntityData) null, (CompoundNBT) null);
        entity.setGlowing(true);
        return entity;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();


        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, ZombieEntity.class, 8.0F, 0.5D, 0.5D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, EvokerEntity.class, 12.0F, 0.5D, 0.5D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, VindicatorEntity.class, 8.0F, 0.5D, 0.5D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, VexEntity.class, 8.0F, 0.5D, 0.5D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, PillagerEntity.class, 15.0F, 0.5D, 0.5D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, IllusionerEntity.class, 12.0F, 0.5D, 0.5D));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 0.5D));
        this.goalSelector.addGoal(1, new LookAtGoal(this, MobEntity.class, 8.0F));

    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
    }
    public boolean processInteract(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        boolean flag = itemstack.getItem() == Items.NAME_TAG;
        if (flag) {
            itemstack.interactWithEntity(player, this, hand);
            return true;
        } else if (itemstack.getItem() != Items.VILLAGER_SPAWN_EGG && this.isAlive() && !this.hasCustomer() && !this.isSleeping() && !player.isSecondaryUseActive()) {
            if (this.isChild()) {
                this.shakeHead();
                return super.processInteract(player, hand);
            } else {
                boolean flag1 = this.getOffers().isEmpty();
                if (hand == Hand.MAIN_HAND) {
                    if (flag1 && !this.world.isRemote) {
                        this.shakeHead();
                    }

                    player.addStat(Stats.TALKED_TO_VILLAGER);
                }

                if (flag1) {
                    return super.processInteract(player, hand);
                } else {
                    if (!this.world.isRemote && !this.offers.isEmpty()) {
                       // this.displayMerchantGui(player);
                    }

                    return true;
                }
            }
        } else {
            return super.processInteract(player, hand);
        }
    }
    private void shakeHead() {
        this.setShakeHeadTicks(40);
        if (!this.world.isRemote()) {
            this.playSound(SoundEvents.ENTITY_VILLAGER_NO, this.getSoundVolume(), this.getSoundPitch());
        }
    }

    @Override
    protected void onVillagerTrade(MerchantOffer offer) {

    }

    @Override
    protected void populateTradeData() {

    }

//processinteract  method VillagerEntity class appears to be on mouse click
}
