package dev.spozap.jokercards.cards

import dev.spozap.jokercards.JokerCards
import dev.spozap.jokercards.constants.CardConstants
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType

open class JokerCard(
    val id: String,
) {

    val itemStack: ItemStack

    init {
        itemStack = generate()
    }

    open fun use(player: Player) {
        player.playSound(player, Sound.BLOCK_BELL_USE, 1f, 1f)
    }

    // TODO: Custom amount
    fun generate(): ItemStack {
        val card = ItemStack(Material.PAPER, 1)
        val meta = card.itemMeta

        meta.persistentDataContainer.set(
            NamespacedKey(JokerCards.INSTANCE, CardConstants.CARD_PDC_KEY),
            PersistentDataType.STRING,
            id
        )

        card.itemMeta = meta

        return card
    }
}