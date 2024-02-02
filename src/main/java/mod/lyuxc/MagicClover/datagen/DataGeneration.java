package mod.lyuxc.MagicClover.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class DataGeneration {
    public static void generate(GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        PackOutput packOutput = event.getGenerator().getPackOutput();
        dataGenerator.addProvider(event.includeClient(),new ItemModelDataGeneration(packOutput,event.getExistingFileHelper()));
        dataGenerator.addProvider(event.includeClient(),new langEnUs(packOutput,"en_us"));
        dataGenerator.addProvider(event.includeClient(),new langZhCn(packOutput,"zh_cn"));
    }
}
