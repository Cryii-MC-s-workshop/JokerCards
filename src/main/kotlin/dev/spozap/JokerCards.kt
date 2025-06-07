package dev.spozap

import org.bukkit.plugin.java.JavaPlugin
import revxrsal.commands.Lamp
import revxrsal.commands.bukkit.BukkitLamp
import revxrsal.commands.bukkit.actor.BukkitCommandActor

class JokerCards : JavaPlugin() {
    override fun onEnable() {
        val lamp: Lamp<BukkitCommandActor> = BukkitLamp.builder(this)
            .build()
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
