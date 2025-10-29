package net.lighter3000.vinebound.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.lighter3000.vinebound.block.ModBlocks;
import net.lighter3000.vinebound.item.ModItems;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.client.data.TexturedModel;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    /*
    Currently trying to better understand how to implement this with custom models / textures that arent simple like a diamond block
     */

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOSS_STONE);
        //blockStateModelGenerator.
        //blockStateModelGenerator.registerGeneric(ModBlocks.MOSS_STONE);
        //blockStateModelGenerator.registerGeneric(ModBlocks.MOSS_GOLEM);
        //blockStateModelGenerator.registerGeneric(ModBlocks.TRADING_TABLE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //itemModelGenerator.register(ModItems.ANCIENT_HAMMER, Models.GENERATED);
        //itemModelGenerator.register(ModItems.ANCIENT_CHISEL, Models.GENERATED);



    }
}
