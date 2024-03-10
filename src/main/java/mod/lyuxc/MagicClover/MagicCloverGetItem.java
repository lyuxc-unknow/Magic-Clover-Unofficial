package mod.lyuxc.MagicClover;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.fml.ModList;

import java.util.List;

public class MagicCloverGetItem {
    public static final Item air = BuiltInRegistries.ITEM.get(new ResourceLocation("minecraft:air"));
    private static final List<? extends String> WhiteList = MagicClover.WhiteList.get();
    private static final RandomSource RANDOM_SOURCE = RandomSource.create(ModList.get().size() * 1024000L);

    public static ItemStack getAnyRandomItem() {
        return MagicClover.allItems.get(RandomSource.create().nextInt(MagicClover.allItems.size()));
    }

    public static ItemStack getRandomItem() {
        int randomID_WhiteList = RANDOM_SOURCE.nextInt(WhiteList.size());
        Item item = getItemByName(WhiteList.get(randomID_WhiteList));
        for (String id : MagicClover.BlackList.get()) {
            if (item == getItemByName(id)) {
                return new ItemStack(air);
            }
        }
        return new ItemStack(item);
    }

    public static Item getItemByName(String itemName) {
        return BuiltInRegistries.ITEM.get(new ResourceLocation(itemName));
    }
}
