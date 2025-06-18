package dev.spozap.jokercards.managers

import dev.spozap.jokercards.JokerCards
import dev.spozap.jokercards.cards.JokerCard
import dev.spozap.jokercards.cards.impl.DebugCard
import dev.spozap.jokercards.cards.impl.FeedCard
import dev.spozap.jokercards.constants.CardConstants
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataContainer
import org.bukkit.persistence.PersistentDataType

class JokerCardsManager {

    private val activeCards: MutableMap<String, JokerCard> = mutableMapOf()

    init {
        register(DebugCard())
        register(FeedCard())
    }

    private fun register(card: JokerCard) {
        activeCards[card.id] = card
    }

    fun getFromItemPdc(pdcContainer: PersistentDataContainer): JokerCard? {
        val id = pdcContainer.get(
            NamespacedKey(JokerCards.INSTANCE, CardConstants.CARD_PDC_KEY),
            PersistentDataType.STRING
        )
        return activeCards[id]
    }

    fun giveById(id: String): ItemStack? {
        val card = activeCards[id] ?: return null
        return card.generate()
    }
}