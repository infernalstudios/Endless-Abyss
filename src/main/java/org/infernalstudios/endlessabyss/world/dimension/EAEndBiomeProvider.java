package org.infernalstudios.endlessabyss.world.dimension;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeRegistry;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.ZoomLayer;
import org.infernalstudios.endlessabyss.EndlessAbyss;
import org.infernalstudios.endlessabyss.util.WorldSeedHolder;

import javax.annotation.Nonnull;
import java.util.function.LongFunction;

public class EAEndBiomeProvider extends BiomeProvider {

    public static void registerBiomeProvider() {
        Registry.register(Registry.BIOME_PROVIDER_CODEC, new ResourceLocation(EndlessAbyss.MODID, "biome_provider"), MOD_NETHER_CODEC);
    }

    public static final Codec<EAEndBiomeProvider> MOD_NETHER_CODEC =
        RecordCodecBuilder.create((instance) -> instance.group(
                Codec.LONG.fieldOf("seed").orElseGet(WorldSeedHolder::getSeed).forGetter((biomeSource) -> biomeSource.seed),
                RegistryLookupCodec.getLookUpCodec(Registry.BIOME_KEY).forGetter((biomeProvider) -> biomeProvider.biomeRegistry),
                Codec.intRange(1, 20).fieldOf("biome_size").orElse(1).forGetter((biomeSource) -> biomeSource.biomeSize))
            .apply(instance, EAEndBiomeProvider::new));

    public final long seed;
    private final int biomeSize;
    private final Layer biomeLayer;
    protected final Registry<Biome> biomeRegistry;

    public EAEndBiomeProvider(long seed, Registry<Biome> biomeRegistry, int size) {
        super(EAEndBiomeCollector.endBiomeCollection(biomeRegistry).stream().map((registryKey) -> () -> (Biome) biomeRegistry.getValueForKey(registryKey)));

        this.seed = seed;
        this.biomeLayer = buildWorldProcedure(seed, size, biomeRegistry);
        this.biomeRegistry = biomeRegistry;
        this.biomeSize = size;
    }

    public static Layer buildWorldProcedure(long seed, int biomeSize, Registry<Biome> biomeRegistry) {
        IAreaFactory<LazyArea> layerFactory = build((salt) -> new LazyAreaLayerContext(25, seed, salt),
            biomeSize,
            seed,
            biomeRegistry);
        return new Layer(layerFactory);
    }

    public static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> build(LongFunction<C> contextFactory, int biomeSize, long seed, Registry<Biome> biomeRegistry) {
        IAreaFactory<T> layerFactory = (new EAEndMasterLayer(seed, biomeRegistry)).apply(contextFactory.apply(200L));

        for (int currentExtraZoom = 0; currentExtraZoom < biomeSize; currentExtraZoom++) {
            if ((currentExtraZoom + 2) % 3 != 0) {
                layerFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2001L + currentExtraZoom), layerFactory);
            } else {
                layerFactory = ZoomLayer.FUZZY.apply(contextFactory.apply(2000L + (currentExtraZoom * 31)), layerFactory);
            }
        }

        return layerFactory;
    }

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        int k = (this.biomeLayer).field_215742_b.getValue(x, z);
        Biome biome = this.biomeRegistry.getByValue(k);
        if (biome == null) {
            //fallback to builtin registry if dynamic registry doesnt have biome
            if (SharedConstants.developmentMode) {
                throw Util.pauseDevMode(new IllegalStateException("Unknown biome id: " + k));
            } else {
                return this.biomeRegistry.getValueForKey(BiomeRegistry.getKeyFromID(0));
            }
        } else {
            return biome;
        }
    }

    @Nonnull
    @Override
    protected Codec<? extends BiomeProvider> getBiomeProviderCodec() {
        return MOD_NETHER_CODEC;
    }

    @Nonnull
    @Override
    public BiomeProvider getBiomeProvider(long seed) {
        return new EAEndBiomeProvider(seed, this.biomeRegistry, this.biomeSize);
    }

}
