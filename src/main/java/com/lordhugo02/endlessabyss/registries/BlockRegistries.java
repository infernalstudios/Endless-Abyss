package com.lordhugo02.endlessabyss.registries;

import com.lordhugo02.endlessabyss.EndlessAbyss;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class BlockRegistries
{

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EndlessAbyss.modid);

    //All blocks

    //Basic blocks
    public static final RegistryObject<Block> encrag = createBlock("encrag", () -> new Block(Block.Properties.create(Material.ANVIL).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.ANCIENT_DEBRIS)));





    //used to create an item equal to its block and to put it into MISC tab (WIP)
    public static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier)
    {
        RegistryObject<Block> block = BLOCKS.register(name, supplier);
        ItemRegistries.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(ItemGroup.MISC)));
        return block;
    }
}
