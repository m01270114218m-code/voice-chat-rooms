# Farah Chat — Visual Asset System

Source-of-truth for all original visual assets.

## Seat assets
- empty: empty professional 3D seat
- occupied: seat + user portrait; the seat body is replaced by the seated user composition
- speaking: occupied + speaking glow
- muted: occupied + muted indicator
- locked: professional seat + lock emblem
- vip: occupied + premium transparent frame

## Role frames
owner, admin, moderator, agent, recharge_agent, supporter, vip

## Other families
room_templates, banners, entry_effects, gifts, coins, agency_badges

The Android room is designed around these asset states so assets can be swapped later from the online admin panel.

SVGA is a binary animation format; the repository currently contains the asset contract and integration-ready structure. Final original SVGA binaries should be exported from the approved artwork rather than copied from third-party applications.
