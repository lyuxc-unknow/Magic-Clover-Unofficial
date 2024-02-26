package mod.lyuxc.MagicClover;

import mod.lyuxc.MagicClover.datagen.DataGeneration;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.TallGrassBlock;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.List;

@Mod(MagicClover.MOD_ID)
@Mod.EventBusSubscriber
public class MagicClover {
    public static final String MOD_ID = "magic_clover";
    public static  ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
    public static ModConfigSpec.ConfigValue<Integer> Creeper_Spawn_Probability;
    public static ModConfigSpec.ConfigValue<Boolean> Randomly_Select_all_items;
    public static ModConfigSpec.ConfigValue<List<? extends String>> BlackList;
    public static ModConfigSpec.ConfigValue<List<? extends String>> WhiteList;
    public static ModConfigSpec.ConfigValue<Integer> ProbabilityOfMagicCLover;

    public MagicClover(IEventBus iEventBus) {
        Registry.init(iEventBus);
        iEventBus.addListener(DataGeneration::generate);
        Creeper_Spawn_Probability = builder.defineInRange("Chance to spawn a creeper from clover",10,0,100);
        Randomly_Select_all_items = builder.define("any item add to Random list",false);
        BlackList = builder.defineList("BlackList",List.of(""),o -> true);
        WhiteList = builder.defineList("WhiteList",List.of(""),o -> true);
        ProbabilityOfMagicCLover = builder.defineInRange("The probability of magic clover falling",10,0,100);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON,builder.build());
    }
    @SubscribeEvent
    public static void BlockBreak(BlockEvent.BreakEvent event) {
        if(event.getState().getBlock() instanceof TallGrassBlock) {
            if(Math.random() * 100.0d < ProbabilityOfMagicCLover.get()) {
                event.getPlayer().drop(new ItemStack(Registry.MAGIC_CLOVER_ITEM_DEFERRED_ITEM.get().asItem()),true);
            }
        }
    }
}
