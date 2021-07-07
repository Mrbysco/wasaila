package com.mrbysco.wasaila;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "wasaila", name = "What Agricraft Stats Am I Looking At", version = "@VERSION@", acceptedMinecraftVersions = "[1.12]", dependencies = "required-after:agricraft;required-before:waila;")
public class Wasaila {
	@Instance("wasaila")
	public static Wasaila instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
