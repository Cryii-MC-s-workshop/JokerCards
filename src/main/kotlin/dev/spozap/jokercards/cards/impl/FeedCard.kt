package dev.spozap.jokercards.cards.impl

import dev.spozap.jokercards.cards.ConsumableJokerCard
import org.bukkit.entity.Player

class FeedCard : ConsumableJokerCard("feedCard") {

    override fun use(player: Player) {
        super.use(player)
        player.foodLevel = 20
    }

}