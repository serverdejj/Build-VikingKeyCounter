package com.serverdejj.vikingkey;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class VikingKeyCounter extends JavaPlugin {
    @Override
    public void onEnable() {
        if (getServer().getPluginManager().getPlugin("PlaceholderAPI") == null) {
            getLogger().severe("PlaceholderAPI no está instalado. Desactivando VikingKeyCounter.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        new VikingExpansion(this).register();
        getLogger().info("Contador de llaves Viking activado. Placeholder: %vikingkey_count%");
    }

    private int countVikingKeys(Player player) {
        int total = 0;
        PlayerInventory inventory = player.getInventory();
        for (ItemStack item : inventory.getStorageContents()) {
            total += countIfVikingKey(item);
        }
        // También cuenta la mano secundaria, por si el jugador guarda la llave allí.
        total += countIfVikingKey(inventory.getItemInOffHand());
        return total;
    }

    private int countIfVikingKey(ItemStack item) {
        if (item == null || item.getType() != Material.TRIAL_KEY || !item.hasItemMeta()) return 0;
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return 0;
        PersistentDataContainer data = meta.getPersistentDataContainer();
        for (var key : data.getKeys()) {
            // La salida /data get mostró el campo key.id con el valor llave_vikingo.
            // Se comprueba el nombre corto para tolerar diferencias de namespace.
            if (key.getKey().equalsIgnoreCase("key.id")) {
                String id = data.get(key, PersistentDataType.STRING);
                if ("llave_vikingo".equalsIgnoreCase(id)) return item.getAmount();
            }
        }
        return 0;
    }

    private static final class VikingExpansion extends PlaceholderExpansion {
        private final VikingKeyCounter plugin;
        private VikingExpansion(VikingKeyCounter plugin) { this.plugin = plugin; }
        @Override public @NotNull String getIdentifier() { return "vikingkey"; }
        @Override public @NotNull String getAuthor() { return "ServerDeJJ"; }
        @Override public @NotNull String getVersion() { return plugin.getDescription().getVersion(); }
        @Override public boolean persist() { return true; }
        @Override public @Nullable String onPlaceholderRequest(Player player, @NotNull String params) {
            if (player == null || !params.equalsIgnoreCase("count")) return null;
            return Integer.toString(plugin.countVikingKeys(player));
        }
    }
}
