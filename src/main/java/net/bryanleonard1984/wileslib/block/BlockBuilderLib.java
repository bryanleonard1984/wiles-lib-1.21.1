package net.bryanleonard1984.wileslib.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import org.slf4j.Logger;

public class BlockBuilderLib
{
    private static String id;
    private static Logger logger;

    public BlockBuilderLib(String id, Logger logger)
    {
        setId(id);
        setLogger(logger);
    }

    private static Block registerBlock(String name, Block block)
    {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(getId(), name), block);
    }

    private static void registerBlockItem(String name, Block block)
    {
        Registry.register(Registries.ITEM, Identifier.of(getId(), name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks()
    {
        getLogger().info("Registering Mod Blocks for " + getId());
    }

    public static Logger getLogger() {return logger;}
    public static String getId() {return id;}
    public void setLogger(Logger logger) {BlockBuilderLib.logger = logger;}
    public void setId(String id) {BlockBuilderLib.id = id;}

    public static Block createOre(String name, int expMin, int expMax, float hardness, float resistance,
                                           BlockSoundGroup soundGroup)
    {
        return registerBlock(name, new ExperienceDroppingBlock(UniformIntProvider.create(expMin, expMax),
                AbstractBlock.Settings.create().strength(hardness, resistance).requiresTool().sounds(soundGroup)));
    }
}
