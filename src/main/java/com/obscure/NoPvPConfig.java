package com.obscure;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

@Config(name = "nopvpwithitem")
public class NoPvPConfig implements ConfigData {
    public boolean allowPvP = true;
    public boolean inverse = true;
    public String pvpDisableItem = "minecraft:nether_star";

    public static NoPvPConfig get() {
        return AutoConfig.getConfigHolder(NoPvPConfig.class).getConfig();
    }
}