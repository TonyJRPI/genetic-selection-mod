package com.geneticselection.genetics;

import com.geneticselection.attributes.MobAttributes;
import com.geneticselection.individual.MobIndividualAttributes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.CowEntity;

import java.util.Objects;

public class CowGenetics implements Genetics {
    @Override
    public void applyAttributes(Entity entity) {
        if (entity instanceof CowEntity cow) {
            MobAttributes attributes = MobIndividualAttributes.getAttributes(cow);
            Objects.requireNonNull(cow.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED))
                    .setBaseValue(attributes.getMovementSpeed());
            Objects.requireNonNull(cow.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH))
                    .setBaseValue(attributes.getMaxHealth());
            cow.setHealth((float) attributes.getMaxHealth());
        }
    }
}