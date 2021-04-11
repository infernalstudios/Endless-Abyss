package com.lordhugo02.endlessabyss.registries;

import com.lordhugo02.endlessabyss.EndlessAbyss;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistries
{

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EndlessAbyss.modid);

    public static final RegistryObject<Item> test = ITEMS.register("test", () -> new Item (new Item.Properties().group(ItemGroup.MISC)));


}
