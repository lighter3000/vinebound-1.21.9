package net.lighter3000.vinebound.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lighter3000.vinebound.Vinebound;
import net.lighter3000.vinebound.block.custom.TradingTableBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.function.Function;

public class ModBlocks {



    public static final Block MOSS_STONE = registerBlock("moss_stone",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block MOSS_GOLEM = registerBlock("moss_golem",
            properties -> new Block(properties.strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.STONE).nonOpaque()));

    public static final Block TRADING_TABLE = registerBlock("trading_table",
            properties -> new TradingTableBlock(properties.nonOpaque()));


    public static final Block MAYA_STONE_ORE = registerBlock("maya_stone_ore",
            properties -> new ExperienceDroppingBlock(UniformIntProvider.create(1,1),
                    properties.strength(4f).requiresTool()));


    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Vinebound.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(Vinebound.MOD_ID, name), toRegister);
    }

    private static Block registerBlockWithoutBlockItem(String name, Function<AbstractBlock.Settings, Block> function) {
        return Registry.register(Registries.BLOCK, Identifier.of(Vinebound.MOD_ID, name),
                function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Vinebound.MOD_ID, name)))));
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Vinebound.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Vinebound.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        Vinebound.LOGGER.info("Registering Mod Blocks for " + Vinebound.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.MOSS_STONE);
            fabricItemGroupEntries.add(ModBlocks.MOSS_GOLEM);
            fabricItemGroupEntries.add(ModBlocks.TRADING_TABLE);
            fabricItemGroupEntries.add(ModBlocks.MAYA_STONE_ORE);
        });
    }
}
