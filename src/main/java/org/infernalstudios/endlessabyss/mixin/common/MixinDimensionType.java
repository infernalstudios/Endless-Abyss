package org.infernalstudios.endlessabyss.mixin.common;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.NoiseChunkGenerator;
import org.infernalstudios.endlessabyss.world.dimension.EAEndBiomeProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DimensionType.class)
public class MixinDimensionType {

    @Inject(at = @At("HEAD"), method = "getEndChunkGenerator(Lnet/minecraft/util/registry/Registry;Lnet/minecraft/util/registry/Registry;J)Lnet/minecraft/world/gen/ChunkGenerator;", cancellable = true)
    private static void EA_endDimension(Registry<Biome> registry, Registry<DimensionSettings> dimensionSettings, long seed, CallbackInfoReturnable<ChunkGenerator> cir) {
        cir.setReturnValue(new NoiseChunkGenerator(new EAEndBiomeProvider(seed, registry, 6), seed, () -> dimensionSettings.getOrThrow(DimensionSettings.END)));
    }

}
