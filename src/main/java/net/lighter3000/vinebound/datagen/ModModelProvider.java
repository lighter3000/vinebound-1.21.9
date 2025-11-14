package net.lighter3000.vinebound.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.lighter3000.vinebound.Vinebound;
import net.lighter3000.vinebound.block.ModBlocks;
import net.lighter3000.vinebound.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.enums.SlabType;
import net.minecraft.client.data.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }


    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOSS_STONE);
        //blockStateModelGenerator.
        //blockStateModelGenerator.registerGeneric(ModBlocks.MOSS_STONE);
        //blockStateModelGenerator.registerGeneric(ModBlocks.MOSS_GOLEM);
        //blockStateModelGenerator.registerGeneric(ModBlocks.TRADING_TABLE);

        /*

        BlockStateModelGenerator.BlockTexturePool mossStonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOSS_STONE);


        BlockStateModelGenerator.BlockTexturePool mossyMossStonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOSSY_MOSS_STONE);


        mossStonePool.stairs(ModBlocks.MOSS_STONE_STAIRS);
        mossStonePool.slab(ModBlocks.MOSS_STONE_SLAB);
        mossStonePool.button(ModBlocks.MOSS_STONE_BUTTON);
        mossStonePool.pressurePlate(ModBlocks.MOSS_STONE_PRESSURE_PLATE);
        mossStonePool.wall(ModBlocks.MOSS_STONE_WALLS);

        mossyMossStonePool.stairs(ModBlocks.MOSSY_MOSS_STONE_STAIRS);
        mossyMossStonePool.slab(ModBlocks.MOSSY_MOSS_STONE_SLAB);
        mossyMossStonePool.button(ModBlocks.MOSSY_MOSS_STONE_BUTTON);
        mossyMossStonePool.pressurePlate(ModBlocks.MOSSY_MOSS_STONE_PRESSURE_PLATE);
        mossyMossStonePool.wall(ModBlocks.MOSSY_MOSS_STONE_WALLS);

        */

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAYA_STONE_ORE);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //itemModelGenerator.register(ModItems.ANCIENT_HAMMER, Models.GENERATED);
        //itemModelGenerator.register(ModItems.ANCIENT_CHISEL, Models.GENERATED);



    }

}
