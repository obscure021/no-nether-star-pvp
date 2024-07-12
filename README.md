## NoNetherStarPVP Mod

---

### Overview

The **NoNetherStarPVP** mod is a Minecraft Fabric mod designed to manage player-versus-player (PvP) interactions based on the presence of a specific item, defaulting to the Nether Star. This mod provides server admins with configurable options to enable or disable PvP in various contexts, useful for **peaceful** servers.

_This mod doesn't affect PVE i.e Player Vs Entity combat._

### Dependencies

- **Fabric API**
- **Cloth Config API**


### Default Behaviour
- By default, PvP is disabled for all players except the players holding the Nether Star.


### Configuration

The mod uses a configuration file to manage its settings. Below are the available configuration options:

- **`enablePvP`**: A boolean option to disable all PvP. When disabled all PvP is disabled. Default is `true`.
- **`useInverseLogic`**: A boolean option that when true disables PvP when holding `pvpDisableItem` and when false enables PvP only when holding `pvpDisableItem`. Default is `true`.
- **`onlyTargetCheck`**: A boolean option that check for the item only for the target player. Default is `true
- **`pvpDisableItemID`**: Specifies the item which the players should have to allow or disallow PvP. Default is `minecraft:nether_star`.

### Configurations for different scenarios

- **Case 1**: PvP is disabled for all players except the players holding the Nether Star. Both players should have nether star to PvP. **(Default behaviour)**

  - **`enablePvP`**: `true`
  - **`useInverseLogic`**: `true`
  - **`onlyTargetCheck`**: `false`
  - **`pvpDisableItemID`**: `minecraft:nether_star`

  ---

  ```json
  {
    "enablePvP": true,
    "useInverseLogic": true,
    "onlyTargetCheck": false,
    "pvpDisableItemID": "minecraft:nether_star"
  }
  ```

- **Case 2**: PvP is enabled for all players except the players holding the Nether Star. Player holding nether star can hit any player.
  - **`enablePvP`**: `true`
  - **`useInverseLogin`**: `false`
  - **`onlyTargetCheck`**: `true`
  - **`pvpDisableItemID`**: `minecraft:nether_star`

  ---

  ```json
  {
    "enablePvP": true,
    "useInverseLogic": false,
    "onlyTargetCheck": true,
    "pvpDisableItemID": "minecraft:nether_star"
  }
  ```

### Changelog

- **v1.0.0**: Initial release of the mod.
- **v1.1.0**: Add `targetOnly` configuration option to only disable/enable PvP when the _target_ player is holding the `pvpDisableItem`. Also rename