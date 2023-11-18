package it.trashband.communism;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.level.saveddata.SavedData;

public class CommunismSavedData extends SavedData
{
	public SimpleContainer globalContainer = new SimpleContainer(54);

	public static SavedData.Factory<CommunismSavedData> factory() {
		return new SavedData.Factory<>(
			CommunismSavedData::new, CommunismSavedData::load, null);
	}

	public static CommunismSavedData load(CompoundTag compoundTag) {
		var data = new CommunismSavedData();
		ContainerHelper.loadAllItems(compoundTag, data.globalContainer.items);
		return data;
	}

	@Override
	public CompoundTag save(CompoundTag compoundTag)
	{
		ContainerHelper.saveAllItems(compoundTag, globalContainer.items);
		return compoundTag;
	}
}
