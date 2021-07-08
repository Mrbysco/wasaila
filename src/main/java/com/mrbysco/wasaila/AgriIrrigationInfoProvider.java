package com.mrbysco.wasaila;

import com.infinityraider.agricraft.content.irrigation.TileEntityIrrigationChannel;
import com.infinityraider.agricraft.content.irrigation.TileEntityIrrigationComponent;
import com.infinityraider.agricraft.reference.AgriToolTips;
import mcp.mobius.waila.api.IComponentProvider;
import mcp.mobius.waila.api.IDataAccessor;
import mcp.mobius.waila.api.IPluginConfig;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;

import java.util.List;

public class AgriIrrigationInfoProvider implements IComponentProvider {
	public static final AgriIrrigationInfoProvider INSTANCE = new AgriIrrigationInfoProvider();

	@Override
	public void appendBody(List<ITextComponent> tooltip, IDataAccessor accessor, IPluginConfig config) {
		TileEntity tile = accessor.getTileEntity();
		if(tile instanceof TileEntityIrrigationComponent) {
			if(tile instanceof TileEntityIrrigationChannel) {
				TileEntityIrrigationChannel channel = (TileEntityIrrigationChannel) tile;
				if(channel.hasValve()) {
					if(channel.isOpen()) {
						tooltip.add(AgriToolTips.VALVE_INFO_OPEN);
					} else {
						tooltip.add(AgriToolTips.VALVE_INFO_CLOSED);
					}
				}
			}

			TileEntityIrrigationComponent component = (TileEntityIrrigationComponent) tile;
			tooltip.add(new StringTextComponent(component.getContent() + " / " + component.getCapacity() + " mB"));
//			info.progress(component.getContent(), component.getCapacity(), new ProgressStyle()
//					.filledColor(0xff327DCD)
//					.alternateFilledColor(0xff3732CD)
//					.suffix(" mB")
//			);
		}
	}
}
