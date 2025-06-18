package dev.spozap.jokercards.commands

import dev.spozap.jokercards.constants.CardConstants
import dev.spozap.jokercards.managers.JokerCardsManager
import org.bukkit.entity.Player
import revxrsal.commands.annotation.Command
import revxrsal.commands.annotation.Subcommand
import revxrsal.commands.bukkit.annotation.CommandPermission

@Command("jokercards")
class CardCommands(private val cardsManager: JokerCardsManager) {

    @Subcommand("give")
    @CommandPermission(CardConstants.CARD_GIVE_COMMAND_PERMISSION)
    fun give(player: Player, cardId: String) {
        val card = cardsManager.giveById(cardId)

        card?.let {
            player.give(card)
        }
    }
}