package net.james.dislexikmodz.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.james.dislexikmodz.DislexikModz;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.item.SmithingTemplateItem;

import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;


public class ModItems {
    //public static final Item SAPPHIRE = registerItem("sapphire", new Item(new Item.Settings()));
    public static final Item SAPPHIRE = registerItem("sapphire", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(DislexikModz.MOD_ID,"sapphire")))));
    public static final Item SAPPHITE = registerItem("sapphite", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(DislexikModz.MOD_ID,"sapphite")))));
    public static final Item SAPPHITE_POWDER = registerItem("sapphite_powder", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(DislexikModz.MOD_ID,"sapphite_powder")))));

    public static final Item DEEPSLATE_SAPPHITE_TABLET = registerItem("deepslate_sapphite_tablet", new Item(new Item.Settings().rarity(Rarity.RARE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(DislexikModz.MOD_ID,"deepslate_sapphite_tablet")))));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(DislexikModz.MOD_ID, name), item);

    }

    public static void registerModItems() {
        DislexikModz.LOGGER.info("Registering Mod items for" + DislexikModz.MOD_ID);


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(SAPPHIRE);
            entries.add(SAPPHITE);
            entries.add(DEEPSLATE_SAPPHITE_TABLET);

            entries.add(SAPPHITE_POWDER);
        });
    }


}
