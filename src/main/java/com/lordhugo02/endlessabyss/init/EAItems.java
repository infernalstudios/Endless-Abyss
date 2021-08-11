package com.lordhugo02.endlessabyss.init;

import com.lordhugo02.endlessabyss.EndlessAbyss;
import com.lordhugo02.endlessabyss.item.ModSpawnEggItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class EAItems {
    public static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, EndlessAbyss.MODID);

    // To register a item, please use the template below:
    //  public static final RegistryObject<Item> ITEM_NAME = register("item_name", () -> new Item(Item.Properties));
    // Create item properties with Item.Properties.create(Material), and modify using subsequent methods
    // Use the BlockItem class instead of the Item class when registering items for blocks:
    //  public static final RegistryObject<Item> BLOCK_NAME = register("block_name", () -> new BlockItem(Block, Item.Properties));

    // Encrag items
    public static final RegistryObject<Item> ENCRAG = register("encrag", () -> new BlockItem(EABlocks.ENCRAG.get(), new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> COBBLED_ENCRAG = register("cobbled_encrag", () -> new BlockItem(EABlocks.COBBLED_ENCRAG.get(), new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> ENCRAG_BRICKS = register("encrag_bricks", () -> new BlockItem(EABlocks.ENCRAG_BRICKS.get(), new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> CHISELED_ENCRAG_BRICKS = register("chiseled_encrag_bricks", () -> new BlockItem(EABlocks.CHISELED_ENCRAG_BRICKS.get(), new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> POLISHED_ENCRAG = register("polished_encrag", () -> new BlockItem(EABlocks.POLISHED_ENCRAG.get(), new Item.Properties().group(ItemGroup.MISC)));


    // Tenium items
    public static final RegistryObject<Item> TENIUM = register("tenium", () -> new BlockItem(EABlocks.TENIUM.get(), new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> TENIUM_SAND = register("tenium_sand", () -> new BlockItem(EABlocks.TENIUM_SAND.get(), new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> TENIUM_BRICKS = register("tenium_bricks", () -> new BlockItem(EABlocks.TENIUM_BRICKS.get(), new Item.Properties().group(ItemGroup.MISC)));
    public static final RegistryObject<Item> POLISHED_TENIUM = register("polished_tenium", () -> new BlockItem(EABlocks.POLISHED_TENIUM.get(), new Item.Properties().group(ItemGroup.MISC)));

    // Spawn eggs
    public static final RegistryObject<Item> SIROCCO_SPAWN_EGG = register("sirocco_spawn_egg", () -> new ModSpawnEggItem(EAEntityTypes.SIROCCO, 0xC6C4A7, 0x595858, new Item.Properties().group(ItemGroup.MISC)));

    public static RegistryObject<Item> register(String name, Supplier<? extends Item> itemSupplier) {
        return ITEM_REGISTRY.register(name, itemSupplier);
    }
}
