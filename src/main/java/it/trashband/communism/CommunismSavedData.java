package it.trashband.communism;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.level.saveddata.SavedData;
import org.jetbrains.annotations.NotNull;

public class CommunismSavedData extends SavedData
{
	public SimpleContainer globalContainer = new SimpleContainer(54);

	public static SavedData.Factory<CommunismSavedData> factory() {
		return new SavedData.Factory<>(
			CommunismSavedData::new, CommunismSavedData::load, null);
	}

	public static CommunismSavedData load(CompoundTag compoundTag, HolderLookup.Provider provider) {
		var data = new CommunismSavedData();
		ContainerHelper.loadAllItems(compoundTag, data.globalContainer.items, provider);
		return data;
	}

	@Override
	public @NotNull CompoundTag save(CompoundTag compoundTag, HolderLookup.Provider provider)
	{
		ContainerHelper.saveAllItems(compoundTag, globalContainer.items, provider);
		return compoundTag;
	}
}
