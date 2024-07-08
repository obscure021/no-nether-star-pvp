## NoNetherStarPVP Mod

### Overview

The **NoNetherStarPVP** mod is a Minecraft Fabric mod designed to manage player-versus-player (PvP) interactions based on the presence of a specific item, defaulting to the Nether Star. This mod provides server administrators with configurable options to enable or disable PvP in various contexts, useful for **peaceful** servers.

_This mod doesn't disable PVE i.e Player Vs Entity combat._

### Dependencies

- **Fabric API**
- **Cloth Config API**

### Features

- **Disable PvP**: Automatically disables all PvP (punches, swords, axes, bows, crossbows, etc.) based on configuration settings.
- **Configurable PvP Item**: Allows customization of the item that allows PvP, with the default set to the Nether Star.
- **Server-Side Configuration**: Provides server-side configuration options to manage PvP rules dynamically.

### Configuration

The mod uses a configuration file to manage its settings. Below are the available configuration options:

- **`allowPvP`**: A boolean option to disable all PvP. When disabled all PvP is disabled. Default is `true`.
- **`inverse`**: A boolean option that when true disables PvP when holding `pvpDisableItem` and when false enables PvP only when holding `pvpDisableItem`. Default is `true`.
- **`pvpDisableItem`**: Specifies the item which the players should have to allow or disallow PvP. Default is `minecraft:nether_star`.

### Example Configuration

```json
{
  "allowPvP": true,
  "inverse": true,
  "pvpDisableItem": "minecraft:nether_star"
}
```
