package net.lighter3000.vinebound.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.lighter3000.vinebound.world.ModPlacedFeatures;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
    public static void generateOres() {

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(BiomeKeys.JUNGLE),
                GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.MAYA_STONE_ORE_PLACED_KEY
        );


        /*
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.MAYA_STONE_ORE_PLACED_KEY
        );
        */

        //BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
        //        ModPlacedFeatures.MAYA_STONE_ORE_PLACED_KEY);
    }   // When generally in the overworld, then instead of BiomeSelectors.includeBykey(...), it needs to be BiomeSelectors.foundInOverworld()

}
