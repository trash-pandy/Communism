package it.trashband.communism;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.level.storage.DimensionDataStorage;

import java.util.Optional;

public class Communism implements DedicatedServerModInitializer
{
	public static CommunismSavedData data;

	@Override
	public void onInitializeServer()
	{
		ServerLifecycleEvents.SERVER_STARTED.register(server -> {
			var storage = server.overworld().getDataStorage();
			data = storage.computeIfAbsent(CommunismSavedData.factory(), "it.trashband.communism");
			data.setDirty();
		});
	}
}
