package net.james.dislexikmodz.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.james.dislexikmodz.DislexikModz;
import net.minecraft.block.AbstractBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.block.Block;

import java.util.function.Function;

public class ModBlocks {

    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        // Create a registry key for the block
        RegistryKey<Block> blockKey = keyOfBlock(name);
        // Create the block instance
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:moving_piston` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            // Items need to be registered with a different type of registry key, but the ID
            // can be the same.
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(DislexikModz.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(DislexikModz.MOD_ID, name));
    }

    public static final Block SAPPHIRE_ORE = register(
            "sapphire_ore",
            Block::new,
            AbstractBlock.Settings.create()
                    .strength(3.0F, 3.0F) // hardness & resistance
                    .requiresTool()       // makes sure it only drops when using correct tool
                    .sounds(BlockSoundGroup.DEEPSLATE),
            true
    );



    public static void registerModBlocks(){
        DislexikModz.LOGGER.info("Registering Mod Blocks for" + DislexikModz.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.SAPPHIRE_ORE);
        });

    }






    /*
    public static final Block SAPPHIRE_ORE = registerBlack("sapphire_ore", new Block(AbstractBlock.Settings.create().strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));

    private static Block registerBlack(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(DislexikModz.MOD_ID, name), block);
    }


    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(DislexikModz.MOD_ID, name),
            new BlockItem(block, new Item.Settings()));

    }

    */

}
