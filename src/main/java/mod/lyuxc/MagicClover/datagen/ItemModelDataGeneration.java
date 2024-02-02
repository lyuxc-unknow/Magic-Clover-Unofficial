package mod.lyuxc.MagicClover.datagen;

import mod.lyuxc.MagicClover.MagicClover;
import mod.lyuxc.MagicClover.Registry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemModelDataGeneration extends ItemModelProvider {
    public ItemModelDataGeneration(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MagicClover.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(Registry.MAGIC_CLOVER_ITEM_DEFERRED_ITEM.get());
    }
}
