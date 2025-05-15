package net.james.dislexikmodz.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.james.dislexikmodz.DislexikModz;
import net.james.dislexikmodz.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup DISLEXIK_MODZ_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(DislexikModz.MOD_ID, "dislexik_modz"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE))
                    .displayName(Text.translatable("itemgroup.dislexikmodz.dislexik_modz"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.SAPPHIRE);
                        entries.add(ModItems.SAPPHITE);
                        entries.add(ModBlocks.SAPPHIRE_ORE);
                        entries.add(ModItems.SAPPHITE_UPGRADE_TEMPLATE);

                    }).build());




    public static void registerItemGroups() {
        DislexikModz.LOGGER.info("Registering Items for " + DislexikModz.MOD_ID);

    }
}