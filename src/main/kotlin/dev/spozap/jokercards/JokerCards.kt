package dev.spozap.jokercards

import dev.spozap.jokercards.listeners.CardListeners
import dev.spozap.jokercards.managers.JokerCardsManager
import org.bukkit.plugin.java.JavaPlugin
import revxrsal.commands.Lamp
import revxrsal.commands.bukkit.BukkitLamp
import revxrsal.commands.bukkit.actor.BukkitCommandActor

class JokerCards : JavaPlugin() {

    companion object {
        lateinit var INSTANCE: JokerCards
    }

    private lateinit var jokerCardsManager: JokerCardsManager

    override fun onEnable() {
        INSTANCE = this

        initCommands()
        initManagers()
        initEvents()
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    private fun initCommands() {
        val lamp: Lamp<BukkitCommandActor> = BukkitLamp.builder(this)
            .build()
    }

    private fun initManagers() {
        jokerCardsManager = JokerCardsManager()
    }

    private fun initEvents() {
        server.pluginManager.registerEvents(CardListeners(jokerCardsManager), this)
    }

}
