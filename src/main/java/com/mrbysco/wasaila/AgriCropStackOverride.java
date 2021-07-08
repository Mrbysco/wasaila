package com.mrbysco.wasaila;

import com.infinityraider.agricraft.api.v1.plant.IAgriPlant;
import com.infinityraider.agricraft.content.core.BlockCropPlant;
import com.infinityraider.agricraft.content.core.TileEntityCropPlant;
import mcp.mobius.waila.api.IComponentProvider;
import mcp.mobius.waila.api.IDataAccessor;
import mcp.mobius.waila.api.IPluginConfig;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class AgriCropStackOverride implements IComponentProvider {
	public static final AgriCropStackOverride INSTANCE = new AgriCropStackOverride();

	@Override
	public ItemStack getStack(IDataAccessor accessor, IPluginConfig config) {
		if(accessor.getBlock() instanceof BlockCropPlant) {
			TileEntity tile = accessor.getTileEntity();
			if(tile instanceof TileEntityCropPlant) {
				TileEntityCropPlant crop = (TileEntityCropPlant) tile;
				IAgriPlant plant = crop.getPlant();
				if(plant.isPlant()) {
					return plant.toItemStack();
				}
			}
		}
		return ItemStack.EMPTY;
	}
}
