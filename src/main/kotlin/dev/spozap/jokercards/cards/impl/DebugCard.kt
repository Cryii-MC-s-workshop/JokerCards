package dev.spozap.jokercards.cards.impl

import dev.spozap.jokercards.cards.JokerCard
import org.bukkit.entity.Player

class DebugCard : JokerCard(id = "debugCard") {

    override fun use(player: Player) {
        player.sendMessage("asd")
    }
}