package com.geneticselection.genetics;

import net.minecraft.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

public class GeneticsRegistry {
    private static final Map<EntityType<?>, Genetics> registry = new HashMap<>();

    public static void register(EntityType<?> type, Genetics genetics) {
        registry.put(type, genetics);
    }

    public static Genetics getGenetics(EntityType<?> type) {
        return registry.get(type);
    }
}