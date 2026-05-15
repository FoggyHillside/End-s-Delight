Additional Notes for Source Builds

This patched release focuses only on the runtime compatibility fixes required for NeoForge for Minecraft 1.21.1 + Farmers Delight - 1.21 API compatibility.

Implemented fixes:

* Updated End Stove classes to use the new Farmers Delight stove API
* Updated renderer inventory accessors (`getInventory()` → `getItems()`)
* Updated milk recipe tags (`c:foods/milk` → `c:drinks/milk`)

Additional compatibility cleanup exists in upstream PR #60:
https://github.com/FoggyHillside/End-s-Delight/pull/60

Those extra changes were intentionally not included in this patch jar in order to keep the runtime fix as small and isolated as possible. Users compiling from source may optionally review or incorporate those additional changes depending on their build environment and dependency versions.


# Fix NeoForge for Minecraft 1.21.1 Farmer’s Delight Stove API Compatibility

## Summary

Updates End's Delight stove implementation to match the current Farmer’s Delight 1.21 API structure and fixes outdated milk tag references.

## Changes

* Updated `EndStoveBlockEntity` constructor usage.
* Added explicit `RecipeType.CAMPFIRE_COOKING`.
* Replaced deprecated milk tags:

  * `c:foods/milk`
  * with:
  * `c:drinks/milk`

## Validation

Verified against:

* Farmer’s Delight 1.21 source/API
* Existing End’s Delight source structure
* Patched production JAR

Confirmed:

* No unrelated bytecode changes
* No invalid constructor calls remain
* Stove block entity loads correctly
* Recipe registration structure remains intact

## Result

Resolves compatibility issues and prevents stove-related failures caused by outdated Farmer’s Delight API usage on NeoForge 1.21.1.
