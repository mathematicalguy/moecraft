package com.github.mathematicalguy.moecraft.minecraft;

import net.minecraft.nbt.*;

/**
 * Shamelessly stolen from
 * https://github.com/TheGreyGhost/MinecraftByExample/blob/master/src/main/java/minecraftbyexample/usefultools/NBTtypesMBE.java
 *
 * Used to make code a little more readable, and rename decompiled functions
 */
public abstract class NBTTypes {
    public static final byte LONG_NBT_ID = LongNBT.valueOf(0).getId();
    public static final byte INT_NBT_ID = IntNBT.valueOf(0).getId();
    public static final byte SHORT_NBT_ID = ShortNBT.valueOf((short)0).getId();
    public static final byte BYTE_NBT_ID = ByteNBT.valueOf((byte)0).getId();
    public static final byte FLOAT_NBT_ID = FloatNBT.valueOf(0).getId();
    public static final byte DOUBLE_NBT_ID = DoubleNBT.valueOf(0).getId();
    public static final byte STRING_NBT_ID = StringNBT.valueOf("").getId();
    public static final byte BYTE_ARRAY_NBT_ID = new ByteArrayNBT(new byte[] {0}).getId();
    public static final byte INT_ARRAY_NBT_ID = new IntArrayNBT(new int[] {0}).getId();
    public static final byte LONG_ARRAY_NBT_ID = new LongArrayNBT(new long[] {0}).getId();
    public static final byte LIST_NBT_ID = new ListNBT().getId();
    public static final byte COMPOUND_NBT_ID = new CompoundNBT().getId();

    private NBTTypes() {
        // Don't try to instantiate this class. All of its methods are declared static.
        throw new IllegalStateException("This is a utility class, it can not be instantiated.");
    }
}
