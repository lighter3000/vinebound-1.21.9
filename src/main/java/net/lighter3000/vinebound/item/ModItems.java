package net.lighter3000.vinebound.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lighter3000.vinebound.Vinebound;
import net.lighter3000.vinebound.entity.ModEntities;
import net.lighter3000.vinebound.item.custom.AncientChiselItem;
import net.lighter3000.vinebound.item.custom.AncientHammerItem;
import net.lighter3000.vinebound.item.custom.MayaStoneItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    //public static final Item ANCIENT_CHISEL = registerItem("ancient_chisel", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Vinebound.MOD_ID,"ancient_chisel")))));
    //public static final Item ANCIENT_HAMMER = registerItem("ancient_hammer", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Vinebound.MOD_ID, "ancient_hammer")))));

    public static final Item ANCIENT_HAMMER = registerItem("ancient_hammer", new AncientHammerItem(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Vinebound.MOD_ID, "ancient_hammer"))).maxDamage(32)));
    public static final Item ANCIENT_CHISEL = registerItem("ancient_chisel", new AncientChiselItem(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Vinebound.MOD_ID,"ancient_chisel"))).maxDamage(32)));

//    public static final Item MOSS_GOLEM_SPAWN_EGG = registerItem("moss_golem_spawn_egg",
 //           setting -> new SpawnEggItem(setting.spawnEgg(ModEntities.MOSS_GOLEM)));
    public static final Item MAYA_STONE = registerItem("maya_stone", new MayaStoneItem(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Vinebound.MOD_ID, "maya_stone")))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Vinebound.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Vinebound.LOGGER.info("Registering Mod Items for " + Vinebound.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ANCIENT_CHISEL);
            fabricItemGroupEntries.add(ANCIENT_HAMMER);
            fabricItemGroupEntries.add(MAYA_STONE);
        });

    }
}
