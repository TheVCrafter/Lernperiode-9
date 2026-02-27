# PvP Guide Backend – Planning

## Where I’m at
I’m still building the UML diagram. I don’t have all classes/enums in yet and I also haven’t drawn all relations (multiplicities) yet.
That’s fine for now — but I want the API plan to already be “finishable”, so I know what the backend must provide.

---

## What the backend should provide
The backend should basically be a content API for my PvP guide.

It needs to support:
- Minecraft PvP content separated by combat version (1.8+ vs 1.9+)
- Kits + server-specific kit variants (because servers differ)
- Rules + loadouts for each kit variant
- Learning content (mechanics, techniques, drills)
- Matchups (strategy between two kit variants)
- Tags + search/filtering (so the frontend can find stuff fast)
- Media + references (videos, docs, links)

Ranking / accounts are NOT part of the first version.

---

## Data structure (high level)
- `Kit` = abstract kit type (NetPot / Crystal / Sword / etc.)
- `KitVariant` = server-specific version of a kit (rules + loadout)
- `KitRuleFlags` = what is allowed (shields, crystals, build, etc.)
- `KitLoadoutItem` = actual items in the kit

Learning:
- `Mechanic` = theory
- `Technique` = how to execute skills
- `Drill` = training routine
- `Matchup` = kitVariant vs kitVariant strategy

---

## API Plan (REST)

### Base
- Base path: `/api`
- JSON everywhere
- Filtering via query params (`versionGroup`, `server`, `tag`, `difficulty`, etc.)

### Version filtering
Most list endpoints should accept:
- `versionGroup=V1_8_PLUS` or `versionGroup=V1_9_PLUS`

---

## Endpoints

### Health
- `GET /api/health`
  - just returns that the backend is running

---

### Servers
- `GET /api/servers`
  - filters: `active`, `region`
- `GET /api/servers/{slug}`
- `GET /api/servers/{slug}/kit-variants`
  - optional filters: `versionGroup`, `kitSlug`

---

### Kits (base kits)
- `GET /api/kits`
  - filters: `versionGroup`
- `GET /api/kits/{slug}`
- `GET /api/kits/{slug}/variants`
  - filters: `server`, `versionGroup`

---

### Kit Variants (server-specific kits)
- `GET /api/kit-variants`
  - filters: `server`, `kit`, `versionGroup`
- `GET /api/kit-variants/{id}`
- `GET /api/kit-variants/{id}/rules`
- `GET /api/kit-variants/{id}/loadout`
- `GET /api/kit-variants/{id}/techniques`
- `GET /api/kit-variants/{id}/drills`

---

### Mechanics
- `GET /api/mechanics`
  - filters: `versionGroup`, `tag`
- `GET /api/mechanics/{slug}`
- `GET /api/mechanics/{slug}/techniques`

---

### Techniques
- `GET /api/techniques`
  - filters: `versionGroup`, `difficulty`, `tag`
- `GET /api/techniques/{slug}`

---

### Drills
- `GET /api/drills`
  - filters: `versionGroup`, `difficulty`, `tag`
- `GET /api/drills/{slug}`

---

### Matchups
- `GET /api/matchups`
  - filters: `versionGroup`, `kitVariantA`, `kitVariantB`
- `GET /api/matchups/{id}`
- `GET /api/matchups/byVariants?A={id}&B={id}`
  - this should work regardless of order (A/B swapped)

---

### Tags
- `GET /api/tags`
  - filters: `type`
- `GET /api/tags/{id}/content`
  - returns mixed results (mechanics/techniques/drills/kits/variants)
  - optional filters: `versionGroup`

---

### Search
- `GET /api/search?query=...`
  - optional filters: `versionGroup`, `tag`, `type`
  - returns mixed results (guides, mechanics, techniques, drills, kits, variants)

---

### Media + References
- `GET /api/media?targetType=...&targetId=...`
- `GET /api/references?targetType=...&targetId=...`

(Where `targetType` is something like `TECHNIQUE`, `MECHANIC`, `KIT_VARIANT`, etc.)

---

## Notes / Rules I want to enforce
- Slugs should be unique where they exist (kits, servers, mechanics, techniques, drills).
- `KitVariant` should be unique per `(kitId + serverId)`.
- `versionGroup` should match when linking content (no mixing 1.8+ techniques into 1.9+ kits).

---

## Not in scope (for now)
- player ranking / elo
- accounts / login
- tracking real matches

---

## Files
- UML diagram: `pvp-guide-backend-class-diagram.drawio`
- this planning file: `backend-architecture.md`