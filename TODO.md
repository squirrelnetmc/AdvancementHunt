# AdvancementHunt TODO

## Fix standalone first

1. Messages
  - Add option in Config.yml to change where messages are displayed (chat, actionbar, title)
  - Display advancements as their Display name, not their namespaced ID
  - Add placeholder that displays advancements as their Display name, not their namespaced ID
1. Fix the way dead players are handled
  - Handle doImmediateRespawn with vanilla, change API version to 1.15
  - Display vanilla death messages, not modified ones
1. General cleanup
  - Elaborate on README
  - Bugfix some little things (like my shitty code in the MySQL class)
  - Add data for autocompleting commands in 1.13+

## After the plugin is working standalone, I need structure to intregrate it into my server network.

1. BungeeCord
  - Kick players to lobby using BungeeServerManager
  - Add a "queue" system using a table on the MySQL database so players can be sent to servers running the plugin
  