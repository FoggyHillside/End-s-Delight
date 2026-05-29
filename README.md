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
