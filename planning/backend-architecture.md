# PvP Guide Backend – Planning

## Current state
The backend structure is now mostly defined.  
The UML class diagram has been drafted with the main classes, enums, multiplicities, and the most important relations.

Some parts may still be adjusted later, but the overall domain model and API structure are clear enough to start implementation.

---

## What the backend should provide
The backend should work as a content API for the PvP Guide.

It should support:
- Minecraft PvP content separated by combat version (`V1_8_PLUS` and `V1_9_PLUS`)
- Kits and server-specific kit variants
- Rules and loadouts for each kit variant
- Learning content such as mechanics, techniques, and drills
- Matchups between kit variants
- Tags for filtering and categorization
- Media and reference links for extra content

Ranking, accounts, and match tracking are not part of the first version.

---

## Data structure (high level)

### Core PvP structure
- `Server` = a server that provides specific kit variants
- `Kit` = an abstract kit type (for example NetPot, Crystal, Sword)
- `KitVariant` = a server-specific implementation of a kit
- `KitRuleFlags` = rules for a specific kit variant
- `KitLoadoutItem` = the items that belong to a specific kit variant

### Learning content
- `Mechanic` = theory or explanation of a PvP concept
- `Technique` = how to apply a specific skill in practice
- `Drill` = a training routine for improving a skill
- `Matchup` = strategy between two kit variants
- `Tag` = used for filtering and categorizing content

---

## API plan (REST)

### Base
- Base path: `/api`
- JSON responses
- Filtering via query parameters such as `versionGroup`, `server`, `tag`, and `difficulty`

### Version filtering
Most list endpoints should support:
- `versionGroup=V1_8_PLUS`
- `versionGroup=V1_9_PLUS`

---

## Endpoints

### Health
- `GET /api/health`
  - returns whether the backend is running

---

### Servers
- `GET /api/servers`
  - optional filters: `active`, `region`
- `GET /api/servers/{slug}`
- `GET /api/servers/{slug}/kit-variants`
  - optional filters: `versionGroup`, `kitSlug`

---

### Kits
- `GET /api/kits`
  - optional filters: `versionGroup`
- `GET /api/kits/{slug}`
- `GET /api/kits/{slug}/variants`
  - optional filters: `server`, `versionGroup`

---

### Kit Variants
- `GET /api/kit-variants`
  - optional filters: `server`, `kit`, `versionGroup`
- `GET /api/kit-variants/{id}`
- `GET /api/kit-variants/{id}/rules`
- `GET /api/kit-variants/{id}/loadout`
- `GET /api/kit-variants/{id}/techniques`
- `GET /api/kit-variants/{id}/drills`

---

### Mechanics
- `GET /api/mechanics`
  - optional filters: `versionGroup`, `tag`
- `GET /api/mechanics/{slug}`
- `GET /api/mechanics/{slug}/techniques`

---

### Techniques
- `GET /api/techniques`
  - optional filters: `versionGroup`, `difficulty`, `tag`
- `GET /api/techniques/{slug}`

---

### Drills
- `GET /api/drills`
  - optional filters: `versionGroup`, `difficulty`, `tag`
- `GET /api/drills/{slug}`

---

### Matchups
- `GET /api/matchups`
  - optional filters: `versionGroup`, `kitVariantA`, `kitVariantB`
- `GET /api/matchups/{id}`
- `GET /api/matchups/byVariants?A={id}&B={id}`
  - should return the matchup regardless of argument order

---

### Tags
- `GET /api/tags`
  - optional filters: `type`
- `GET /api/tags/{id}/content`
  - returns related mechanics, techniques, drills, kits, or kit variants
  - optional filters: `versionGroup`

---

### Search
- `GET /api/search?query=...`
  - optional filters: `versionGroup`, `tag`, `type`
  - returns mixed results depending on the search query

---

### Media and References
- `GET /api/media?targetType=...&targetId=...`
- `GET /api/references?targetType=...&targetId=...`

`targetType` can be something like:
- `TECHNIQUE`
- `MECHANIC`
- `KIT_VARIANT`

---

## Rules / constraints
- Slugs should be unique where they exist (`kits`, `servers`, `mechanics`, `techniques`, `drills`)
- `KitVariant` should be unique per `(kitId + serverId)`
- `versionGroup` should stay consistent across linked content
- A `Matchup` should always reference exactly two `KitVariant` entries

---

## Not in scope (for now)
- player ranking / elo
- accounts / login
- tracking real matches

---

## Files
- UML diagram: `pvp-guide-backend-class-diagram.drawio`
- planning file: `backend-architecture.md`