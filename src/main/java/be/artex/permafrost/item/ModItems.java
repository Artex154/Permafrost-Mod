package be.artex.permafrost.item;

import be.artex.permafrost.Permafrost;
import be.artex.permafrost.item.advanced.ModToolMaterials;
import be.artex.permafrost.item.advanced.scythe.ScytheItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public class ModItems {
    public static final Item FROZEN_SCYTHE = registerItem("glacial_scythe", settings -> new ScytheItem(ModToolMaterials.GLACIAL, 1f, -2.7f, settings),
            new Item.Settings().maxCount(1).rarity(Rarity.RARE));

    public static Item registerItem(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Permafrost.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void registerModItems() {
        Permafrost.LOGGER.debug("Registering mod items: " + Permafrost.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> content.add(FROZEN_SCYTHE));
    }
}
