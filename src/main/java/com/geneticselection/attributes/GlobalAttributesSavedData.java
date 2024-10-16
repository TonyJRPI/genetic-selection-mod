package com.geneticselection.attributes;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.PersistentState;

public class GlobalAttributesSavedData extends PersistentState {
    private static final String KEY = "geneticselection";
    private final MobAttributesManagerData data = new MobAttributesManagerData();

    public GlobalAttributesSavedData() {
        super();
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        return toTag(nbt);
    }

    public void fromTag(NbtCompound tag) {
        GlobalAttributesManager.load(tag);
    }

    public NbtCompound toTag(NbtCompound tag) {
        GlobalAttributesManager.save(tag);
        return tag;
    }

    public static GlobalAttributesSavedData fromWorld(ServerWorld world) {
        return world.getPersistentStateManager().getOrCreate(
                new Type<>(
                        GlobalAttributesSavedData::new,
                        (nbt, state) -> {
                            GlobalAttributesSavedData data = new GlobalAttributesSavedData();
                            data.fromTag(nbt);
                            return data;
                        },
                        null
                ),
                KEY
        );
    }
}

class MobAttributesManagerData {
    // Placeholder for future expansion if needed
}
