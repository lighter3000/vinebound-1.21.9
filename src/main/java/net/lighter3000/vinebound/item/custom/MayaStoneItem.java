package net.lighter3000.vinebound.item.custom;

import net.lighter3000.vinebound.block.ModBlocks;
import net.lighter3000.vinebound.entity.ModEntities;
import net.lighter3000.vinebound.entity.custom.MossGolemEntity;
import net.lighter3000.vinebound.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class MayaStoneItem extends Item {

    private static final Map<Block, EntityType<MossGolemEntity>> MAYA_STONE_MAP =
            Map.of(
                    ModBlocks.MOSS_GOLEM, ModEntities.MOSS_GOLEM
            );


    public MayaStoneItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(MAYA_STONE_MAP.containsKey(clickedBlock)){
            if(context.getPlayer().getMainHandStack().getItem().equals(ModItems.MAYA_STONE)){
                if(!world.isClient()) {
                    EntityType<MossGolemEntity> type = MAYA_STONE_MAP.get(clickedBlock);
                    MossGolemEntity golem = type.create(world, SpawnReason.TRIGGERED);
                    if(golem != null) {
                        golem.refreshPositionAndAngles(
                                context.getBlockPos().getX() + 0.5,
                                context.getBlockPos().getY() + 0.1,
                                context.getBlockPos().getZ() + 0.5,
                                0.0F,
                                0.0F
                        );
                        world.spawnEntity(golem);
                        world.setBlockState(context.getBlockPos(), Blocks.AIR.getDefaultState());
                    }


                    context.getStack().decrement(1);
                    world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_AMETHYST_BLOCK_STEP, SoundCategory.BLOCKS);
                }
            }
        }
        return ActionResult.SUCCESS;
    }
}
