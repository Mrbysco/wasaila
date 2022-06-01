package com.mrbysco.wasaila;

import com.infinityraider.agricraft.api.v1.plant.IAgriPlant;
import com.infinityraider.agricraft.content.core.BlockCrop;
import com.infinityraider.agricraft.content.core.TileEntityCrop;
import mcp.mobius.waila.api.BlockAccessor;
import mcp.mobius.waila.api.IComponentProvider;
import mcp.mobius.waila.api.ITooltip;
import mcp.mobius.waila.api.config.IPluginConfig;
import mcp.mobius.waila.api.ui.IElement;
import mcp.mobius.waila.impl.ui.ItemStackElement;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.Nullable;

public enum AgriCropStackOverride implements IComponentProvider {
	INSTANCE;

	@Override
	public @Nullable IElement getIcon(BlockAccessor accessor, IPluginConfig config, IElement currentIcon) {
		if (accessor.getBlock() instanceof BlockCrop) {
			BlockEntity tile = accessor.getBlockEntity();
			if (tile instanceof TileEntityCrop crop) {
				IAgriPlant plant = crop.getPlant();
				if (plant.isPlant()) {
					return ItemStackElement.of(plant.toItemStack());
				}
			}
		}
		return ItemStackElement.of(ItemStack.EMPTY);
	}

	@Override
	public void appendTooltip(ITooltip iTooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {

	}
}
