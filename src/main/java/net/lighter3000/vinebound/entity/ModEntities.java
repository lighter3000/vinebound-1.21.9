package net.lighter3000.vinebound.entity;

import net.lighter3000.vinebound.Vinebound;
import net.lighter3000.vinebound.entity.custom.MossGolemEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEntities {
    private static final RegistryKey<EntityType<?>> MOSS_GOLEM_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(Vinebound.MOD_ID, "moss_golem"));

    public static final EntityType<MossGolemEntity> MOSS_GOLEM = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Vinebound.MOD_ID, "moss_golem"),
            EntityType.Builder.create(MossGolemEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.8f, 1f).build(MOSS_GOLEM_KEY));

    public static void registerModEntities() {
        Vinebound.LOGGER.info("Registering Mod Entities for " + Vinebound.MOD_ID);
    }
}
