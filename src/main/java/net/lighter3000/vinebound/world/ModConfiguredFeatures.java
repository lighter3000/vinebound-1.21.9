package net.lighter3000.vinebound.world;

import net.lighter3000.vinebound.Vinebound;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class ModConfiguredFeatures {


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

    }


    // ConfigureFeature -> PlacedFeature -> BiomeModification // How does it look -> How is it placed -> Where is it placed?
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Vinebound.MOD_ID, name));
    }


    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
