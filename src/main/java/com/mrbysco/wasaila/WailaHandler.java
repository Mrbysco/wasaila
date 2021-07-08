package com.mrbysco.wasaila;

import com.infinityraider.agricraft.api.v1.misc.IAgriDisplayable;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaPlugin;
import mcp.mobius.waila.api.IWailaRegistrar;
import mcp.mobius.waila.api.WailaPlugin;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

@WailaPlugin
public class WailaHandler implements IWailaDataProvider, IWailaPlugin {

    @Override
    public List<String> getWailaBody(ItemStack itemStack, List<String> tooltip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
    	Block block = accessor.getBlock();
        if (block instanceof IAgriDisplayable) {
            ((IAgriDisplayable) block).addDisplayInfo(tooltip::add);
        }
        TileEntity te = accessor.getTileEntity();
        if (te instanceof IAgriDisplayable) {
            ((IAgriDisplayable) te).addDisplayInfo(tooltip::add);
        }
        return tooltip;
    }

    @Override
    public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, BlockPos pos) {
    	if (te != null) {
            te.writeToNBT(tag);
        }
        return tag;
    }

	@Override
	public void register(IWailaRegistrar registrar) {
		WailaHandler instance = new WailaHandler();
		registrar.registerBodyProvider(instance, Block.class);
	}
}
