package mod.lyuxc.MagicClover.datagen;

import mod.lyuxc.MagicClover.MagicClover;
import mod.lyuxc.MagicClover.Registry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class langZhCn extends LanguageProvider {
    public langZhCn(PackOutput output, String locale) {
        super(output, MagicClover.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add(Registry.MAGIC_CLOVER_ITEM_DEFERRED_ITEM.get(),"魔法四叶草");
        add("tips.magic_clover.item","有%s%%的概率原地生成闪电苦力怕，祝你好运");
    }
}
