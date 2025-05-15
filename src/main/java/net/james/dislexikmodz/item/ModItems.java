package net.james.dislexikmodz.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.james.dislexikmodz.DislexikModz;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;


public class ModItems {
    //public static final Item SAPPHIRE = registerItem("sapphire", new Item(new Item.Settings()));
    public static final Item SAPPHIRE = registerItem("sapphire", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(DislexikModz.MOD_ID,"sapphire")))));
    public static final Item SAPPHITE = registerItem("sapphite", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(DislexikModz.MOD_ID,"sapphite")))));



    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(DislexikModz.MOD_ID, name), item);

    }

    public static void registerModItems() {
        DislexikModz.LOGGER.info("Registering Mod items for" + DislexikModz.MOD_ID);


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(SAPPHIRE);
            entries.add(SAPPHITE);
        });
    }
}
