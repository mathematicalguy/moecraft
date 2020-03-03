package com.github.mathematicalguy.minecraft;


import net.minecraft.client.renderer.RenderType;

/**
 * Pretty shamelessly stolen from
 * https://github.com/TheGreyGhost/MinecraftByExample/blob/master/src/main/java/minecraftbyexample/usefultools/RenderTypeMBE.java
 *
 * This utility class just provides useful names to some of the decompiled functions for
 * RenderType. It includes the ones from Minecraft By Example, and a few others.
 *
 * More can be mapped if needed
 *
 * @see net.minecraft.client.renderer.RenderType
 */
public abstract class RenderTypeUtil {
    private RenderTypeUtil() {
        // Don't try to instantiate this class. All of its methods are declared static.
        throw new IllegalStateException("This is a utility class, it can not be instantiated.");
    }

    public static RenderType solid() {return RenderType.func_228639_c_(); }

    public static RenderType cutoutMipped() {
        return RenderType.func_228641_d_();
    }

    public static RenderType cutout() {
        return RenderType.func_228643_e_();
    }

    public static RenderType translucent() {
        return RenderType.func_228645_f_();
    }

    public static RenderType translucentNoCrumbling() {
        return RenderType.func_228647_g_();
    }

    public static RenderType leash() {
        return RenderType.func_228649_h_();
    }

    public static RenderType waterMask() {
        return RenderType.func_228651_i_();
    }

    public static RenderType glint() {
        return RenderType.func_228653_j_();
    }

    public static RenderType entityGlint() {
        return RenderType.func_228655_k_();
    }

    public static RenderType lightning() {
        return RenderType.func_228657_l_();
    }

    public static RenderType lines() {
        return RenderType.func_228659_m_();
    }
}
