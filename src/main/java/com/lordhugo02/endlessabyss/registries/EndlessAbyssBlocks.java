package com.lordhugo02.endlessabyss.registries;

import com.lordhugo02.endlessabyss.EndlessAbyss;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class EndlessAbyssBlocks {

    public static final DeferredRegister<Block> BLOCK_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, EndlessAbyss.MODID);

    public static final RegistryObject<Block> ENCRAG = register("encrag", () -> new Block(Block.Properties.create(Material.ANVIL).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.ANCIENT_DEBRIS)));

    public static RegistryObject<Block> register(String name, Supplier<? extends Block> blockSupplier) {
        return BLOCK_REGISTRY.register(name, blockSupplier);
    }
}
