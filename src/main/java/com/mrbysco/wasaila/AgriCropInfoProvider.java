package com.mrbysco.wasaila;

import com.infinityraider.agricraft.AgriCraft;
import com.infinityraider.agricraft.api.v1.AgriApi;
import com.infinityraider.agricraft.reference.AgriToolTips;
import mcp.mobius.waila.api.IComponentProvider;
import mcp.mobius.waila.api.IDataAccessor;
import mcp.mobius.waila.api.IPluginConfig;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class AgriCropInfoProvider implements IComponentProvider {
	public static final AgriCropInfoProvider INSTANCE = new AgriCropInfoProvider();

	@Override
	public void appendBody(List<ITextComponent> tooltip, IDataAccessor accessor, IPluginConfig config) {
		AgriApi.getCrop(accessor.getWorld(), accessor.getPosition()).ifPresent(crop -> {
			PlayerEntity player = accessor.getPlayer();
			// Add data including full genome if in creative mode
			if(false) { //mode == ProbeMode.DEBUG
				crop.addDisplayInfo(tooltip::add);
				tooltip.add(AgriToolTips.GENOME);
				crop.getGenome().map(genome -> {
					genome.addDisplayInfo(tooltip::add);
					return true;
				}).orElseGet(() ->{
					tooltip.add(AgriToolTips.UNKNOWN);
					return false;
				});
			} else {
				// add crop data
				if(this.shouldAddInfo(player)) {
					crop.addDisplayInfo(tooltip::add);
				}
			}
		});
		AgriApi.getSoil(accessor.getWorld(), accessor.getPosition()).ifPresent(soil ->
				soil.addDisplayInfo(tooltip::add));
	}

	protected boolean shouldAddInfo(PlayerEntity player) {
		if (AgriCraft.instance.getConfig().doesMagnifyingGlassControlTOP()) {
			return AgriCraft.instance.proxy().isMagnifyingGlassObserving(player);
		}
		return true;
	}
}
