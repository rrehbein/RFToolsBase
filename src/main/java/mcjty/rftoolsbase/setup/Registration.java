package mcjty.rftoolsbase.setup;


import mcjty.lib.api.smartwrench.SmartWrenchMode;
import mcjty.rftoolsbase.RFToolsBase;
import mcjty.rftoolsbase.blocks.DimensionalShardBlock;
import mcjty.rftoolsbase.blocks.ModBlocks;
import mcjty.rftoolsbase.items.SmartWrenchItem;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RFToolsBase.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Registration {

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new DimensionalShardBlock(DimensionalShardBlock.OreType.ORE_OVERWORLD));
        event.getRegistry().register(new DimensionalShardBlock(DimensionalShardBlock.OreType.ORE_NETHER));
        event.getRegistry().register(new DimensionalShardBlock(DimensionalShardBlock.OreType.ORE_END));
    }

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new SmartWrenchItem(SmartWrenchMode.MODE_WRENCH));
        event.getRegistry().register(new SmartWrenchItem(SmartWrenchMode.MODE_SELECT));
        event.getRegistry().register(new Item(new Item.Properties()
                    .maxStackSize(64)
                    .group(RFToolsBase.setup.getTab()))
                .setRegistryName("dimensionalshard"));

        Item.Properties properties = new Item.Properties().group(RFToolsBase.setup.getTab());
        event.getRegistry().register(new BlockItem(ModBlocks.DIMENSIONAL_SHARD_OVERWORLD, properties).setRegistryName(ModBlocks.DIMENSIONAL_SHARD_OVERWORLD.getRegistryName()));
        event.getRegistry().register(new BlockItem(ModBlocks.DIMENSIONAL_SHARD_NETHER, properties).setRegistryName(ModBlocks.DIMENSIONAL_SHARD_NETHER.getRegistryName()));
        event.getRegistry().register(new BlockItem(ModBlocks.DIMENSIONAL_SHARD_END, properties).setRegistryName(ModBlocks.DIMENSIONAL_SHARD_END.getRegistryName()));
    }

    @SubscribeEvent
    public static void registerTiles(final RegistryEvent.Register<TileEntityType<?>> registry) {
    }

}