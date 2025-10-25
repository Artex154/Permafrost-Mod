package be.artex.permafrost.block;

import be.artex.permafrost.Permafrost;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {
    public static final Block PACKED_ICE_BRICKS = registerBlock("packed_ice_bricks", Block::new, AbstractBlock.Settings.copy(Blocks.PACKED_ICE));
    public static final Block POLISHED_PACKED_ICE = registerBlock("polished_packed_ice", Block::new, AbstractBlock.Settings.copy(Blocks.PACKED_ICE));
    public static final Block BLACK_ICE = registerBlock("black_ice", Block::new, AbstractBlock.Settings.create()
            .mapColor(MapColor.PALE_PURPLE)
            .instrument(NoteBlockInstrument.CHIME)
            .slipperiness(0.997F)
            .strength(0.5F)
            .sounds(BlockSoundGroup.GLASS)
    );

    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings) {
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Permafrost.MOD_ID, name));

        Block block = blockFactory.apply(settings.registryKey(blockKey));

        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Permafrost.MOD_ID, name));

        BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, blockItem);

        return Registry.register(Registries.BLOCK, Identifier.of(Permafrost.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        Permafrost.LOGGER.debug("Registering mod items: " + Permafrost.MOD_ID);
    }
}
