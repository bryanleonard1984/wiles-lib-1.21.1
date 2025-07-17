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
    private String id;
    private Logger logger;

    public BlockBuilderLib(String id, Logger logger)
    {
        setId(id);
        setLogger(logger);
    }

    /*The id parameter must be equal to "minecraft" in order to override vanilla blocks.
     * Otherwise, use the getId() method to choose the id for the particular mod.*/

    private Block registerBlock(String id, String name, Block block)
    {
        registerBlockItem(id, name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(id, name), block);
    }

    private void registerBlockItem(String id, String name, Block block)
    {
        Registry.register(Registries.ITEM, Identifier.of(id, name),
                new BlockItem(block, new Item.Settings()));
    }

    public void registerModBlocks()
    {
        getLogger().info("Registering Mod Blocks for " + getId());
    }

    public Logger getLogger() {return logger;}
    public String getId() {return id;}
    public void setLogger(Logger logger) {this.logger = logger;}
    public void setId(String id) {this.id = id;}

    public Block createOre(String name, int expMin, int expMax, float hardness, float resistance,
                           BlockSoundGroup soundGroup)
    {
        return registerBlock(getId(), name, new ExperienceDroppingBlock(UniformIntProvider.create(expMin, expMax),
                AbstractBlock.Settings.create().strength(hardness, resistance).requiresTool().sounds(soundGroup)));
    }

    public Block createOre(String id, String name, int expMin, int expMax, float hardness, float resistance,
                                           BlockSoundGroup soundGroup)
    {
        return registerBlock(id, name, new ExperienceDroppingBlock(UniformIntProvider.create(expMin, expMax),
                AbstractBlock.Settings.create().strength(hardness, resistance).requiresTool().sounds(soundGroup)));
    }

    public Block createBasicBlock(String name, int hardness, int resistance, BlockSoundGroup soundGroup)
    {
        return registerBlock(getId(), name, new Block(AbstractBlock.Settings.create()
                .strength(hardness, resistance).sounds(soundGroup)));
    }

    public Block createBasicBlock(String id, String name, int hardness, int resistance,
                                  BlockSoundGroup soundGroup)
    {
        return registerBlock(id, name, new Block(AbstractBlock.Settings.create()
                .strength(hardness, resistance).sounds(soundGroup)));
    }
}
