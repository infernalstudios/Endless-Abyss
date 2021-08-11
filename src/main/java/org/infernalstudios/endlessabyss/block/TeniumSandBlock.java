package org.infernalstudios.endlessabyss.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class TeniumSandBlock extends FallingBlock {
    public TeniumSandBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onEndFalling(World worldIn, BlockPos pos, BlockState fallingState, BlockState hitState, FallingBlockEntity fallingBlock) {
        if (fallingBlock.fallTime >= 15) {
            worldIn.createExplosion(fallingBlock, pos.getX(), pos.getY(), pos.getZ(), 3, Explosion.Mode.NONE);
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
        }
    }
}
