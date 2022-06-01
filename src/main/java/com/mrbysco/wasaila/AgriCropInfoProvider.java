package com.mrbysco.wasaila;

import com.infinityraider.agricraft.AgriCraft;
import com.infinityraider.agricraft.api.v1.AgriApi;
import com.infinityraider.agricraft.reference.AgriToolTips;
import mcp.mobius.waila.api.BlockAccessor;
import mcp.mobius.waila.api.IComponentProvider;
import mcp.mobius.waila.api.ITooltip;
import mcp.mobius.waila.api.config.IPluginConfig;
import net.minecraft.world.entity.player.Player;

public enum AgriCropInfoProvider implements IComponentProvider {
	INSTANCE;

	@Override
	public void appendTooltip(ITooltip iTooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
		AgriApi.getCrop(blockAccessor.getLevel(), blockAccessor.getPosition()).ifPresent(crop -> {
			Player player = blockAccessor.getPlayer();
			// Add data including full genome if in creative mode
			if (false) { //mode == ProbeMode.DEBUG
				crop.addDisplayInfo(iTooltip::add);
				iTooltip.add(AgriToolTips.GENOME);
				crop.getGenome().map(genome -> {
					genome.addDisplayInfo(iTooltip::add);
					return true;
				}).orElseGet(() -> {
					iTooltip.add(AgriToolTips.UNKNOWN);
					return false;
				});
			} else {
				// add crop data
				if (this.shouldAddInfo(player)) {
					crop.addDisplayInfo(iTooltip::add);
				}
			}
		});
		AgriApi.getSoil(blockAccessor.getLevel(), blockAccessor.getPosition()).ifPresent(soil -> soil.addDisplayInfo(iTooltip::add));
	}

	protected boolean shouldAddInfo(Player player) {
		if (AgriCraft.instance.getConfig().doesMagnifyingGlassControlTOP()) {
			return AgriCraft.instance.proxy().isMagnifyingGlassObserving(player);
		}
		return true;
	}
}
