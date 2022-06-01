package com.mrbysco.wasaila;

import com.infinityraider.agricraft.content.core.BlockCrop;
import mcp.mobius.waila.api.IWailaClientRegistration;
import mcp.mobius.waila.api.IWailaPlugin;
import mcp.mobius.waila.api.TooltipPosition;
import mcp.mobius.waila.api.WailaPlugin;
import net.minecraft.world.level.block.Block;

@WailaPlugin
public class WailaHandler implements IWailaPlugin {

	@Override
	public void registerClient(IWailaClientRegistration registration) {
		registration.registerIconProvider(AgriCropStackOverride.INSTANCE, BlockCrop.class);
		registration.registerComponentProvider(AgriCropInfoProvider.INSTANCE, TooltipPosition.BODY, Block.class);
		registration.registerComponentProvider(AgriIrrigationInfoProvider.INSTANCE, TooltipPosition.BODY, Block.class);
	}
}
