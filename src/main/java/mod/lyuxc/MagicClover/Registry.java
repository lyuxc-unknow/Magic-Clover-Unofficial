package mod.lyuxc.MagicClover;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Registry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MagicClover.MOD_ID);
    public static final DeferredItem<MagicCloverItem> MAGIC_CLOVER_ITEM_DEFERRED_ITEM = ITEMS.register("magic_clover",() -> new MagicCloverItem(new Item.Properties()));

    public static void init(IEventBus iEventBus) {
        ITEMS.register(iEventBus);
    }
}
