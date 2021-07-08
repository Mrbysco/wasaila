package com.mrbysco.wasaila;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;

@Mod(modid = "wasaila", name = "What Agricraft Stats Am I Looking At", version = "@VERSION@", acceptedMinecraftVersions = "[1.12]", dependencies = "required-after:agricraft;required-before:waila;")
public class Wasaila {
	@Instance("wasaila")
	public static Wasaila instance;
}
