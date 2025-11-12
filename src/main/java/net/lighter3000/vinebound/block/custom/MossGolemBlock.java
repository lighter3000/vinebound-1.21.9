package net.lighter3000.vinebound.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class MossGolemBlock extends HorizontalFacingBlock {
    public static final MapCodec<MossGolemBlock> CODEC = createCodec(MossGolemBlock::new);
    private static final VoxelShape SHAPE = Block.createCuboidShape(5.0, 0.0, 2.0, 11.0, 16.0, 14.0);

    public MossGolemBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction facing = state.get(FACING);

        return switch(facing) {
            case NORTH -> Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 16.0, 10.0);
            case SOUTH -> Block.createCuboidShape(2.0, 0.0, 6.0, 14.0, 16.0, 14.0);
            case EAST -> Block.createCuboidShape(6.0, 0.0, 2.0, 14.0, 16.0, 14.0);
            case WEST -> Block.createCuboidShape(2.0, 0.0, 2.0, 10.0, 16.0, 14.0);

            default -> Block.createCuboidShape(5.0, 0.0, 2.0, 11.0, 16.0, 14.0);
        };
    }


    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
