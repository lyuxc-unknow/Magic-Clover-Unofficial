package mod.lyuxc.MagicClover;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MagicCloverItem extends Item {
    public MagicCloverItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, @NotNull Player pPlayer, @NotNull InteractionHand pUsedHand) {
        if(!pLevel.isClientSide) {
            if(pLevel.getDifficulty() != Difficulty.PEACEFUL && Math.random() * 100.0D < MagicClover.Creeper_Spawn_Probability.get()) {
                Creeper creeper = new Creeper(EntityType.CREEPER,pLevel);
                LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT,pLevel);
                creeper.moveTo(pPlayer.getX(),pPlayer.getY(),pPlayer.getZ());
                creeper.thunderHit((ServerLevel) pLevel,lightningBolt);
                pLevel.addFreshEntity(creeper);
            } else {
               if(MagicClover.Randomly_Select_all_items.get()) {
                   pPlayer.drop(MagicCloverGetItem.getAnyRandomItem(),true);
               } else {
                   pPlayer.drop(MagicCloverGetItem.getRandomItem(),true);
               }
            }
            pPlayer.getItemInHand(pUsedHand).setCount(pPlayer.getItemInHand(pUsedHand).getCount() - 1);
            pPlayer.getCooldowns().addCooldown(pPlayer.getItemInHand(pUsedHand).getItem(),5);
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tips.magic_clover.item",MagicClover.Creeper_Spawn_Probability.get()));
    }
}
