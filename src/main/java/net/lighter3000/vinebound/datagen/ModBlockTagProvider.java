package net.lighter3000.vinebound.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.lighter3000.vinebound.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.MOSS_GOLEM)
                .add(ModBlocks.MOSS_STONE)
                .add(ModBlocks.MOSSY_MOSS_STONE)
                .add(ModBlocks.TRADING_TABLE)
                .add(ModBlocks.MAYA_STONE_ORE);
        /*
                .add(ModBlocks.MOSS_STONE_STAIRS)
                .add(ModBlocks.MOSS_STONE_SLAB)
                .add(ModBlocks.MOSS_STONE_BUTTON)
                .add(ModBlocks.MOSS_STONE_PRESSURE_PLATE)
                .add(ModBlocks.MOSS_STONE_WALLS)
                .add(ModBlocks.MOSSY_MOSS_STONE_STAIRS)
                .add(ModBlocks.MOSSY_MOSS_STONE_SLAB)
                .add(ModBlocks.MOSSY_MOSS_STONE_BUTTON)
                .add(ModBlocks.MOSSY_MOSS_STONE_PRESSURE_PLATE)
                .add(ModBlocks.MOSSY_MOSS_STONE_WALLS);

         */

        valueLookupBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.MOSS_GOLEM)
                .add(ModBlocks.MOSS_STONE)
                .add(ModBlocks.MOSSY_MOSS_STONE);

        /*
                .add(ModBlocks.MOSS_STONE_STAIRS);
                .add(ModBlocks.MOSS_STONE_SLAB)
                .add(ModBlocks.MOSS_STONE_BUTTON)
                .add(ModBlocks.MOSS_STONE_PRESSURE_PLATE)
                .add(ModBlocks.MOSS_STONE_WALLS)
                .add(ModBlocks.MOSSY_MOSS_STONE_STAIRS)
                .add(ModBlocks.MOSSY_MOSS_STONE_SLAB)
                .add(ModBlocks.MOSSY_MOSS_STONE_BUTTON)
                .add(ModBlocks.MOSSY_MOSS_STONE_PRESSURE_PLATE)
                .add(ModBlocks.MOSSY_MOSS_STONE_WALLS);

         */


        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.MAYA_STONE_ORE);

        /*
        valueLookupBuilder(BlockTags.WALLS)
                .add(ModBlocks.MOSS_STONE_WALLS)
                .add(ModBlocks.MOSSY_MOSS_STONE_WALLS);

         */
    }
}
