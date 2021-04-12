package com.lordhugo02.endlessabyss.registries;

import com.lordhugo02.endlessabyss.EndlessAbyss;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class EndlessAbyssItems
{

    public static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, EndlessAbyss.MODID);

    public static final RegistryObject<Item> ENCRAG = register("encrag", () -> new BlockItem(EndlessAbyssBlocks.ENCRAG.get(), new Item.Properties().group(ItemGroup.MISC)));

    public static RegistryObject<Item> register(String name, Supplier<? extends Item> itemSupplier) {
        return ITEM_REGISTRY.register(name, itemSupplier);
    }
}
