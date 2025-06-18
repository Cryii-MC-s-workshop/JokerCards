package dev.spozap.jokercards.cards

import org.bukkit.entity.Player

open class ConsumableJokerCard(id: String) : JokerCard(id) {

    override fun use(player: Player) {
        super.use(player)
        consume(player)
    }

    private fun consume(player: Player) {
        val card = player.inventory.itemInMainHand
        card.amount -= 1
        player.inventory.setItemInMainHand(card)
    }

}