package com.lordhugo02.endlessabyss.registries;

import com.lordhugo02.endlessabyss.EndlessAbyss;
import com.lordhugo02.endlessabyss.block.TeniumSandBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class EndlessAbyssBlocks {
    public static final DeferredRegister<Block> BLOCK_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, EndlessAbyss.MODID);

    // To register a block, please use the template below:
    //  public static final RegistryObject<Block> BLOCK_NAME = register("block_name", () -> new Block(Block.Properties));
    // Create block properties with Block.Properties.create(Material), and modify using subsequent methods
    // Don't repeat properties if you can help it, use Block.Properties.from(Block)

    // Encrag blocks
    public static final RegistryObject<Block> ENCRAG = register("encrag", () -> new Block(Block.Properties.create(Material.ANVIL).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.ANCIENT_DEBRIS)));
    public static final RegistryObject<Block> COBBLED_ENCRAG = register("cobbled_encrag", () -> new Block(Block.Properties.from(ENCRAG.get())));
    public static final RegistryObject<Block> ENCRAG_BRICKS = register("encrag_bricks", () -> new Block(Block.Properties.from(ENCRAG.get())));
    public static final RegistryObject<Block> CHISELED_ENCRAG_BRICKS = register("chiseled_encrag_bricks", () -> new Block(Block.Properties.from(ENCRAG.get())));

    // Tenium blocks
    public static final RegistryObject<Block> TENIUM = register("tenium", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.5F, 6.0F).sound(SoundType.NETHERRACK)));
    public static final RegistryObject<Block> TENIUM_SAND = register("tenium_sand", () -> new TeniumSandBlock(Block.Properties.create(Material.SAND).hardnessAndResistance(0.5F).sound(SoundType.SAND).harvestTool(ToolType.SHOVEL)));
    public static final RegistryObject<Block> TENIUM_BRICKS = register("tenium_bricks", () -> new Block(Block.Properties.from(TENIUM.get())));
    public static final RegistryObject<Block> POLISHED_TENIUM = register("polished_tenium", () -> new Block(Block.Properties.from(TENIUM.get())));

    public static RegistryObject<Block> register(String name, Supplier<? extends Block> blockSupplier) {
        return BLOCK_REGISTRY.register(name, blockSupplier);
    }
}
