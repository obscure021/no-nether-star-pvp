package com.obscure;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "nopvpwithitem")
public class NoPvPConfig implements ConfigData {
    public boolean enablePvP = true;
    public boolean useInverseLogic = true;
    public boolean onlyTargetCheck = true;
    public String pvpDisableItemID = "minecraft:nether_star";

    public static NoPvPConfig get() {
        return AutoConfig.getConfigHolder(NoPvPConfig.class).getConfig();
    }
}