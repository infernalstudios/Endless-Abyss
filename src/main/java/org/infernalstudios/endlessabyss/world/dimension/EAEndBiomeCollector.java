package org.infernalstudios.endlessabyss.world.dimension;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class EAEndBiomeCollector {

    public static List<RegistryKey<Biome>> endBiomeList = new ArrayList<>();

    public static List<RegistryKey<Biome>> endBiomeCollection(Registry<Biome> biomeRegistry) {

        for (Map.Entry<RegistryKey<Biome>, Biome> entry : biomeRegistry.getEntries()) {
            if (entry.getValue().getCategory() == Biome.Category.THEEND && !entry.getKey().getLocation().getNamespace().equals("ultra_amplified_dimension")) {
                if (!endBiomeList.contains(entry.getKey())) {
                    endBiomeList.add(entry.getKey());
                }
            }
        }

        endBiomeList.sort(Comparator.comparing(key -> key.getLocation().toString()));
        return endBiomeList;
    }

    public static int getRandomEndBiomes(INoiseRandom random, Registry<Biome> registry) {
        return registry.getId(registry.getValueForKey(endBiomeList.get(random.random(endBiomeList.size()))));
    }
}
