Additional Notes for Source Builds

This patched release focuses only on the runtime compatibility fixes required for NeoForge 1.21.1 + Farmers Delight 1.21 API compatibility.

Implemented fixes:

* Updated End Stove classes to use the new Farmers Delight stove API
* Updated renderer inventory accessors (`getInventory()` → `getItems()`)
* Updated milk recipe tags (`c:foods/milk` → `c:drinks/milk`)

Additional compatibility cleanup exists in upstream PR #60:
https://github.com/FoggyHillside/End-s-Delight/pull/60

Those extra changes were intentionally not included in this patch jar in order to keep the runtime fix as small and isolated as possible. Users compiling from source may optionally review or incorporate those additional changes depending on their build environment and dependency versions.
