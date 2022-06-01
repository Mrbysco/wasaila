package com.mrbysco.wasaila;

import com.infinityraider.agricraft.content.irrigation.TileEntityIrrigationChannel;
import com.infinityraider.agricraft.content.irrigation.TileEntityIrrigationComponent;
import com.infinityraider.agricraft.reference.AgriToolTips;
import mcp.mobius.waila.api.BlockAccessor;
import mcp.mobius.waila.api.IComponentProvider;
import mcp.mobius.waila.api.ITooltip;
import mcp.mobius.waila.api.config.IPluginConfig;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.level.block.entity.BlockEntity;

public enum AgriIrrigationInfoProvider implements IComponentProvider {
	INSTANCE;

	@Override
	public void appendTooltip(ITooltip iTooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
		BlockEntity tile = blockAccessor.getBlockEntity();
		if (tile instanceof TileEntityIrrigationComponent component) {
			if (tile instanceof TileEntityIrrigationChannel channel) {
				if (channel.hasValve()) {
					if (channel.isOpen()) {
						iTooltip.add(AgriToolTips.VALVE_INFO_OPEN);
					} else {
						iTooltip.add(AgriToolTips.VALVE_INFO_CLOSED);
					}
				}
			}

			iTooltip.add(new TextComponent(component.getContent() + " / " + component.getCapacity() + " mB"));
//			info.progress(component.getContent(), component.getCapacity(), new ProgressStyle()
//					.filledColor(0xff327DCD)
//					.alternateFilledColor(0xff3732CD)
//					.suffix(" mB")
//			);
		}
	}
}
