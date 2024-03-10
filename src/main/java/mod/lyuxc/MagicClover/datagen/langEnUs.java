package mod.lyuxc.MagicClover.datagen;

import mod.lyuxc.MagicClover.MagicClover;
import mod.lyuxc.MagicClover.Registry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class langEnUs extends LanguageProvider {
    public langEnUs(PackOutput output, String locale) {
        super(output, MagicClover.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add(Registry.MAGIC_CLOVER_ITEM_DEFERRED_ITEM.get(),"Magic Clover");
        add("tips.magic_clover.item","There is a %s %%chance of spawning lightning creepers on the spot. Good luck to you.");
    }
}
