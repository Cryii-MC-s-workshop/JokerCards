package dev.spozap.jokercards.cards

import org.bukkit.entity.Player

open class JokerCard(
    val id: String
) {

    open fun use(player: Player) {}

}