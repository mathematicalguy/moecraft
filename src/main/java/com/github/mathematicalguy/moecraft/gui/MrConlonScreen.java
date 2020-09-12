package com.github.mathematicalguy.moecraft.gui;

import com.github.mathematicalguy.moecraft.MoeCraftMod;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.MerchantContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MrConlonScreen extends ContainerScreen<MerchantContainer> {

    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(MoeCraftMod.MOD_ID, "textures/Gui/mrconlonsrealgui.png" );
    public MrConlonScreen(MerchantContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
        this.guiLeft = 0;
        this.guiTop = 0;
    }

    @Override
    public void render(final int mouseX,final int mouseY, final float partialTicks){
        this.renderBackground();
        super.render(mouseX,mouseY,partialTicks);
        this.renderHoveredToolTip(mouseX,mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
        this.font.drawString(this.title.getFormattedText(),12.0f,12.0f,4210752);
                // x and y are coords for the title on the gui
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0f,1.0f,1.0f,1.0f);
        this.minecraft.getTextureManager().bindTexture(BACKGROUND_TEXTURE);
        int x = (this.width - this.xSize) /2;
        int y =(this.height - this.ySize) /2;
        this.blit(x,y,0,0,this.xSize,this.ySize);
    }
}