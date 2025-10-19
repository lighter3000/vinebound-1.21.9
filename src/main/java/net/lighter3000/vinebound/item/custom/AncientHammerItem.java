package net.lighter3000.vinebound.item.custom;

import net.lighter3000.vinebound.block.ModBlocks;
import net.lighter3000.vinebound.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class AncientHammerItem extends Item { // CTRL + H on Item marked to see how other Item work

    private static final Map<Block, Block> HAMMER_MAP =
            Map.of(
                    ModBlocks.MOSS_STONE, ModBlocks.MOSS_GOLEM // Placeholder, later to ModBlocks.MOSS_GOLEM
            );



    public AncientHammerItem(Settings settings) {
        super(settings);
    }

    // write override to see things to override


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(HAMMER_MAP.containsKey(clickedBlock)) {
            if(context.getPlayer().getMainHandStack().getItem().equals(ModItems.ANCIENT_HAMMER) && context.getPlayer().getOffHandStack().getItem().equals(ModItems.ANCIENT_CHISEL)){
                if(!world.isClient()) {
                    world.setBlockState(context.getBlockPos(), HAMMER_MAP.get(clickedBlock).getDefaultState());

                    context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                            item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                    context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                            item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.OFFHAND));


                    world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);
                }
            }

        }


        return ActionResult.SUCCESS;
    }
}
