package org.infernalstudios.endlessabyss.init;

import org.infernalstudios.endlessabyss.EndlessAbyss;
import org.infernalstudios.endlessabyss.block.TeniumSandBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.Level;

import java.util.function.Supplier;

public class EABlocks {
    public static final DeferredRegister<Block> BLOCK_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, EndlessAbyss.MODID);

    // To register a block, please use the template below:
    //  public static final RegistryObject<Block> BLOCK_NAME = register("block_name", () -> new Block(Block.Properties));
    // Create block properties with Block.Properties.create(Material), and modify using subsequent methods
    // Don't repeat properties if you can help it, use Block.Properties.from(Block)


    //Propreties needs to be re-defined.

    // Encrag blocks
    public static final RegistryObject<Block> ENCRAG = registerBlock("encrag", () -> new Block(Block.Properties.create(Material.ANVIL).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.ANCIENT_DEBRIS).harvestTool(ToolType.PICKAXE).setRequiresTool()));
    public static final RegistryObject<Block> COBBLED_ENCRAG = registerBlock("cobbled_encrag", () -> new Block(Block.Properties.from(ENCRAG.get())));
    public static final RegistryObject<Block> ENCRAG_BRICKS = registerBlock("encrag_bricks", () -> new Block(Block.Properties.from(ENCRAG.get())));
    public static final RegistryObject<Block> CHISELED_ENCRAG_BRICKS = registerBlock("chiseled_encrag_bricks", () -> new Block(Block.Properties.from(ENCRAG.get())));
    public static final RegistryObject<Block> POLISHED_ENCRAG = registerBlock("polished_encrag", () -> new Block(Block.Properties.from(ENCRAG.get())));

    // Tenium blocks
    public static final RegistryObject<Block> TENIUM = registerBlock("tenium", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.5F, 6.0F).sound(SoundType.NETHERRACK).harvestTool(ToolType.PICKAXE).setRequiresTool()));
    public static final RegistryObject<Block> TENIUM_SAND = registerBlock("tenium_sand", () -> new TeniumSandBlock(Block.Properties.create(Material.SAND).hardnessAndResistance(0.5F).sound(SoundType.SAND).harvestTool(ToolType.SHOVEL)));
    public static final RegistryObject<Block> TENIUM_BRICKS = registerBlock("tenium_bricks", () -> new Block(Block.Properties.from(TENIUM.get())));
    public static final RegistryObject<Block> POLISHED_TENIUM = registerBlock("polished_tenium", () -> new Block(Block.Properties.from(TENIUM.get())));

    public static RegistryObject<Block> registerBlock(String name, Supplier<? extends Block> blockSupplier) {
        return BLOCK_REGISTRY.register(name, blockSupplier);
    }

    public static void register(IEventBus eventBus) {
        EndlessAbyss.LOGGER.log(Level.DEBUG, "Registering Blocks");
        BLOCK_REGISTRY.register(eventBus);
    }
}
