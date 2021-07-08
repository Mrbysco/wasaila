package com.mrbysco.wasaila;

import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.tuple.Pair;

@Mod("wasaila")
public class Wasaila {
	public Wasaila() {
		//Make sure the mod being absent on the other network side does not cause the client to display the server as incompatible
		ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.DISPLAYTEST, () -> Pair.of(
				() -> "Trans Rights Are Human Rights",
				(remoteVersionString,networkBool) -> networkBool
		));
	}
}
