package dev.spozap.jokercards.commands

import dev.spozap.jokercards.managers.JokerCardsManager
import org.bukkit.entity.Player
import revxrsal.commands.annotation.Command
import revxrsal.commands.annotation.Subcommand

@Command("jokercards")
class CardCommands(private val cardsManager: JokerCardsManager) {

    @Subcommand("give")
    fun give(player: Player, cardId: String) {
        val card = cardsManager.giveById(cardId)

        card?.let {
            player.give(card)
        }
    }
}