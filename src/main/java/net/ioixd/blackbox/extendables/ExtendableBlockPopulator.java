package net.ioixd.blackbox.extendables;

import java.util.Random;

import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.LimitedRegion;
import org.bukkit.generator.WorldInfo;
import org.bukkit.plugin.Plugin;

import net.ioixd.blackbox.BlackBox;

public class ExtendableBlockPopulator extends BlockPopulator {
    BlackBox blackBox;
    String inLibName;
    String name;

    @Override
    public void populate(WorldInfo worldInfo, Random random, int chunkX, int chunkZ, LimitedRegion limitedRegion) {
        Object result = null;
        try {
            result = Misc.tryExecute(this.blackBox, this.inLibName, this.name, "BlockPopulator", "populate",
                    new Object[] {
                            worldInfo, random, chunkX, chunkZ, limitedRegion
                    }, false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (result == null) {
            super.populate(worldInfo, random, chunkX, chunkZ, limitedRegion);
        }
    }

    ExtendableBlockPopulator(Plugin blackBox, String name, String inLibName) {
        this.blackBox = (BlackBox) blackBox;
        this.name = name;
        this.inLibName = inLibName;
    }
}
