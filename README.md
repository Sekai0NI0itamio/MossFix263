# Moss Fix — Modern Port for Minecraft 26.3 (Fabric)

![Mod loader: Fabric](https://img.shields.io/badge/modloader-Fabric-1976d2?style=for-the-badge)
![Minecraft: 26.3](https://img.shields.io/badge/Minecraft-26.3-green?style=for-the-badge)
![GitHub license](https://img.shields.io/github/license/Sekai0NI0itamio/MossFix263?style=for-the-badge)

**Fixes moss by allowing it to spread under transparent blocks.**

Vanilla only lets you bonemeal moss when there's air above it, so moss
refuses to spread under glass, slabs, and other transparent blocks.
Moss Fix checks instead whether the block above is a redstone
conductor — if it isn't, the moss can spread. Simple, server-side,
no gameplay changes beyond the fix.

Now with a **modern port for Minecraft 26.3 (Fabric)**.

### What it does

- Moss blocks are bonemealable when the block above is not a redstone conductor
- Works under transparent blocks (glass, slabs, etc.)

### Port changes vs. the original

- Target class updated: `BonemealableFeaturePlacerBlock` in 26.3
  (was `MossBlock` before 1.21.2)
- The original's optional datapack spread system (cobblestone/sand
  datapacks) is not ported — the core fix is preserved

### Modern port notes (26.3)

- Java 25 · Fabric Loader 0.20.1+ · Fabric API 0.165.0+26.3
- Built and verified in CI via GitHub Actions, including a headless
  runtime test that launches the client, joins a world, and quits cleanly

### Installation

1. Install Fabric Loader for Minecraft 26.3
2. Install Fabric API
3. Drop `mossfix263-*.jar` into your `mods` folder

### Original mod & credit

This is an unofficial modern port by **Itamio** of **Moss Fix
Remastered** by **gamma-02** — the original (549k downloads on
Modrinth, last updated for 1.21.9) has not been updated to 26.3.

- Original mod: https://modrinth.com/mod/moss-fix
- Original source: https://github.com/gamma-02/moss-fix-remastered
- License: MIT — see `LICENSE`

All credit for the original concept, design, and logic goes to
gamma-02. This port exists to bring it to Minecraft 26.3. See `NOTICE`.
