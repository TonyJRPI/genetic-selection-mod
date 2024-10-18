package com.geneticselection.mobs.cow;

import com.geneticselection.attributes.GlobalAttributesManager;
import com.geneticselection.attributes.MobAttributes;
import com.geneticselection.individual.MobIndividualAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.server.world.ServerWorld;
import java.util.Objects;

public class CowBreedingLogic {
    public static CowEntity breed(CowEntity parent1, CowEntity parent2, ServerWorld world) {
        CowEntity offspring = EntityType.COW.create(world);
        if (offspring == null) return null;

/*        // Set offspring as a baby
        if (offspring instanceof AgeableEntity ageable) {
            ageable.setBaby(true);
            ageable.setGrowingAge(-24000); // Baby for 20 minutes
        }*/

        // Inherit attributes
        MobAttributes attr1 = MobIndividualAttributes.getAttributes(parent1);
        MobAttributes attr2 = MobIndividualAttributes.getAttributes(parent2);
        MobAttributes childAttributes = inheritAttributes(attr1, attr2);
        MobIndividualAttributes.setAttributes(offspring, childAttributes);

        // Influence global attributes
        influenceGlobalAttributes(childAttributes);
        return offspring;
    }

    private static MobAttributes inheritAttributes(MobAttributes a, MobAttributes b) {
        double speed = Math.random() < 0.5 ? a.getMovementSpeed() : b.getMovementSpeed();
        if (Math.random() < 0.1) speed *= 1.05;
        double health = Math.random() < 0.5 ? a.getMaxHealth() : b.getMaxHealth();
        if (Math.random() < 0.1) health *= 1.05;
        return new MobAttributes(speed, health);
    }

    private static void influenceGlobalAttributes(MobAttributes child) {
        MobAttributes global = GlobalAttributesManager.getAttributes(EntityType.COW);
        global.setMovementSpeed((global.getMovementSpeed() + child.getMovementSpeed()) / 2);
        global.setMaxHealth((global.getMaxHealth() + child.getMaxHealth()) / 2);
        GlobalAttributesManager.updateGlobalAttributes(EntityType.COW, global);
    }
}