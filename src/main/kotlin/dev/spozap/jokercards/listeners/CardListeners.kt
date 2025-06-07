package dev.spozap.jokercards.listeners

import dev.spozap.jokercards.JokerCards
import dev.spozap.jokercards.constants.CardConstants
import dev.spozap.jokercards.managers.JokerCardsManager
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.persistence.PersistentDataType

class CardListeners(private val cardsManager: JokerCardsManager) : Listener {

    @EventHandler
    fun onCardUsage(event: PlayerInteractEvent) {

        val item = event.item

        if (item == null || item.type != Material.PAPER) return

        val itemPdc = item.itemMeta.persistentDataContainer

        if (!itemPdc.has(
                NamespacedKey(JokerCards.INSTANCE, CardConstants.CARD_PDC_KEY),
                PersistentDataType.STRING
            )
        ) return

        val jokerCard = cardsManager.getFromItemPdc(itemPdc)

        jokerCard?.apply {
            use(event.player)
        }
    }
}