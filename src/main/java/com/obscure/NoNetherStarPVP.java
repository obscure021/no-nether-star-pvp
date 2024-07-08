package com.obscure;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import static net.minecraft.registry.Registries.ITEM;

public class NoNetherStarPVP implements ModInitializer {
	@Override
	public void onInitialize() {
		// Register the configuration
		AutoConfig.register(NoPvPConfig.class, GsonConfigSerializer::new);

		// Register the entity damage event callback
		ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, source, amount) -> {
			NoPvPConfig config = NoPvPConfig.get();
			boolean inverse = config.inverse;
			if (entity instanceof PlayerEntity target) {
				Entity attackerEntity = source.getAttacker();
				if (attackerEntity instanceof PlayerEntity attacker) {
					if (shouldCancelAttack(attacker, target)) {
						return inverse ? true : false; // Cancel damage
					}
				}
			}
			return inverse ? false : true; // Allow the damage
		});
	}

	private boolean shouldCancelAttack(PlayerEntity player, PlayerEntity target) {
		NoPvPConfig config = NoPvPConfig.get();
		Item disableItem = ITEM.get(Identifier.of(config.pvpDisableItem));

		if (!config.allowPvP) {
			return true;
		}

		return hasItem(player, disableItem) && hasItem(target, disableItem);
	}

	private boolean hasItem(PlayerEntity player, Item item) {
		return player.getMainHandStack().getItem() == item ||
				player.getOffHandStack().getItem() == item ||
				player.getInventory().contains(new ItemStack(item));
	}
}
