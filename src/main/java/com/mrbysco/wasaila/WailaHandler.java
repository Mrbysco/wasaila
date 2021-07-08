package com.mrbysco.wasaila;

import com.infinityraider.agricraft.content.core.BlockCropPlant;
import mcp.mobius.waila.api.IRegistrar;
import mcp.mobius.waila.api.IWailaPlugin;
import mcp.mobius.waila.api.TooltipPosition;
import mcp.mobius.waila.api.WailaPlugin;
import net.minecraft.block.Block;

@WailaPlugin
public class WailaHandler implements IWailaPlugin {

	@Override
	public void register(IRegistrar iRegistrar) {
		iRegistrar.registerStackProvider(AgriCropStackOverride.INSTANCE, BlockCropPlant.class);
		iRegistrar.registerComponentProvider(AgriCropInfoProvider.INSTANCE, TooltipPosition.BODY, Block.class);
		iRegistrar.registerComponentProvider(AgriIrrigationInfoProvider.INSTANCE, TooltipPosition.BODY, Block.class);
	}
}
