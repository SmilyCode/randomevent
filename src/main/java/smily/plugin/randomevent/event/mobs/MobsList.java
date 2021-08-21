package smily.plugin.randomevent.event.mobs;

import org.bukkit.entity.EntityType;
import smily.plugin.randomevent.util.Randomizer;

import java.util.Arrays;
import java.util.List;

public class MobsList {
    private final EntityType[] entityList = {
            EntityType.ZOMBIE,
            EntityType.SKELETON,
            EntityType.GHAST,
            EntityType.BLAZE,
            EntityType.SHEEP,
            EntityType.AXOLOTL,
            EntityType.SPIDER,
            EntityType.SPIDER,
            EntityType.SILVERFISH,
            EntityType.TROPICAL_FISH,
            EntityType.SHEEP,
            EntityType.COW
    };

    public EntityType[] getEntityList() {
        return entityList;
    }

    public EntityType randomType(){
        List<EntityType> list = Arrays.asList(entityList);

        return list.get(Randomizer.randomValue(list.size()));
    }
}
