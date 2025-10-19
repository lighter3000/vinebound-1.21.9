package net.lighter3000.vinebound.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.lighter3000.vinebound.Vinebound;
import net.lighter3000.vinebound.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {


    public static final ItemGroup VINEBOUND_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Vinebound.MOD_ID, "vinebound_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ANCIENT_HAMMER))
                    .displayName(Text.translatable("itemgroup.vinebound.vinebound_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ANCIENT_HAMMER);
                        entries.add(ModItems.ANCIENT_CHISEL);
                        entries.add(ModBlocks.MOSS_STONE);
                        entries.add(ModBlocks.MOSS_GOLEM);
                    }).build());


    public static void registerItemGroups() {
        Vinebound.LOGGER.info("Registering Item Groups for " + Vinebound.MOD_ID);
    }
}
