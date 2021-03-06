package net.playavalon.avnrep.api;

import net.playavalon.avnrep.data.player.AvalonPlayer;
import net.playavalon.avnrep.data.player.Reputation;
import net.playavalon.avnrep.data.reputation.Faction;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

import static net.playavalon.avnrep.AvNRep.plugin;

public class ReputationAPI {

    public HashMap<String, ReputationTrigger> triggers;

    public ReputationAPI() {
        triggers = new HashMap<>();
    }

	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	[ PLAYER REPUTATION METHODS ]
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


    /**
     * Get a reputation object, containing information on how a particular reputation functions.
     * @param faction The namespace of the faction we are retrieving from the player
     * @return The reputation object containing the reputation info
     */
    public double getPlayerReputation(@NotNull Player player, @NotNull String faction) {
        try {
            AvalonPlayer ap = plugin.getAvalonPlayer(player);
            if (ap == null) {
                throw new IllegalArgumentException("Could not find AvalonPlayer linked with provided player!");
            }
            Reputation pRep = ap.getReputation(faction);
            if (pRep == null) {
                throw new IllegalArgumentException("Player does not have faction '" + faction + "'!");
            }
            return pRep.getRepValue();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    /**
     * Get a reputation object, containing information on how a particular reputation functions.
     * @param faction The namespace of the faction we are retrieving from the player
     * @return The reputation object containing the reputation info
     */
    public int getPlayerReputationLevel(@NotNull Player player, @NotNull String faction) {
        try {
            AvalonPlayer ap = plugin.getAvalonPlayer(player);
            if (ap == null) {
                throw new IllegalArgumentException("Could not find AvalonPlayer linked with provided player!");
            }
            Reputation pRep = ap.getReputation(faction);
            if (pRep == null) {
                throw new IllegalArgumentException("Player does not have faction '" + faction + "'!");
            }
            return pRep.getRepLevel();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	[ PLAYER DATA SETTERS ]
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    /**
     * Add reputation to a player.
     * @param player The player we are adding reputation to
     * @param faction The namespace of the faction we are adding reputation to
     * @param value How much reputation we are adding
     * @return Whether or not we successfully added reputation to the player.
     */
    public boolean addPlayerReputation(@NotNull Player player, @NotNull String faction, double value) {
        try {
            AvalonPlayer ap = plugin.getAvalonPlayer(player);
            if (ap == null) {
                throw new IllegalArgumentException("Could not find AvalonPlayer linked with provided player!");
            }
            Reputation pRep = ap.getReputation(faction);
            if (pRep == null) {
                throw new IllegalArgumentException("Player does not have faction '" + faction + "'!");
            }

            // We have all the info we need. Add reputation to the player.
            pRep.addRepValue(value);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Set the reputation of a player.
     * @param player The player we are setting the reputation of
     * @param faction The namespace of the faction we are setting the reputation of
     * @param value The new reputation value
     * @return Whether or not we successfully changed the players reputation
     */
    public boolean setPlayerReputation(@NotNull Player player, @NotNull String faction, double value) {
        try {
            AvalonPlayer ap = plugin.getAvalonPlayer(player);
            if (ap == null) {
                throw new IllegalArgumentException("Could not find AvalonPlayer linked with provided player!");
            }
            Reputation pRep = ap.getReputation(faction);
            if (pRep == null) {
                throw new IllegalArgumentException("Player does not have faction '" + faction + "'!");
            }

            // We have all the info we need. Set the reputation value of the player.
            pRep.setRepValue(value);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Remove reputation from a player.
     * @param player The player we are removing reputation from
     * @param faction The namespace of the faction we are subtracting reputation from
     * @param value How much reputation we are removing
     * @return Whether or not we successfully removed reputation from the player.
     */
    public boolean subtractPlayerReputation(@NotNull Player player, @NotNull String faction, double value) {
        try {
            AvalonPlayer ap = plugin.getAvalonPlayer(player);
            if (ap == null) {
                throw new IllegalArgumentException("Could not find AvalonPlayer linked with provided player!");
            }
            Reputation pRep = ap.getReputation(faction);
            if (pRep == null) {
                throw new IllegalArgumentException("Player does not have faction '" + faction + "'!");
            }

            // We have all the info we need. Remove reputation from the player.
            pRep.removeRepValue(value);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    /**
     * Add reputation levels to a player.
     * @param player The player we are adding reputation levels to
     * @param reputation The namespace of the faction we are increasing the level of
     * @param level How many reputation levels we are adding
     * @return Whether or not we successfully added reputation levels to the player.
     */
    public boolean addPlayerReputationLevel(@NotNull Player player, @NotNull String reputation, int level) {
        try {
            AvalonPlayer ap = plugin.getAvalonPlayer(player);
            if (ap == null) {
                throw new IllegalArgumentException("Could not find AvalonPlayer linked with provided player!");
            }
            Reputation pRep = ap.getReputation(reputation);
            if (pRep == null) {
                throw new IllegalArgumentException("Player does not have faction '" + reputation + "'!");
            }

            // We have all the info we need. Add reputation levels to the player.
            pRep.addRepLevel(level);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Set the reputation level of a player.
     * @param player The player we are setting the reputation level of
     * @param reputation The namespace of the faction we are setting the level of
     * @param level The new reputation level
     * @return Whether or not we successfully changed the players reputation level
     */
    public boolean setPlayerReputationLevel(@NotNull Player player, @NotNull String reputation, int level) {
        try {
            AvalonPlayer ap = plugin.getAvalonPlayer(player);
            if (ap == null) {
                throw new IllegalArgumentException("Could not find AvalonPlayer linked with provided player!");
            }
            Reputation pRep = ap.getReputation(reputation);
            if (pRep == null) {
                throw new IllegalArgumentException("Player does not have faction '" + reputation + "'!");
            }

            // We have all the info we need. Set the reputation level of the player.
            pRep.setRepLevel(level);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Remove reputation levels from a player.
     * @param player The player we are removing reputation levels from
     * @param reputation The namespace of the faction we are decreasing the level of
     * @param level How many reputation levels we are removing
     * @return Whether or not we successfully removed reputation levels from the player.
     */
    public boolean subtractPlayerReputationLevel(@NotNull Player player, @NotNull String reputation, int level) {
        try {
            AvalonPlayer ap = plugin.getAvalonPlayer(player);
            if (ap == null) {
                throw new IllegalArgumentException("Could not find AvalonPlayer linked with provided player!");
            }
            Reputation pRep = ap.getReputation(reputation);
            if (pRep == null) {
                throw new IllegalArgumentException("Player does not have faction '" + reputation + "'!");
            }

            // We have all the info we need. Subtract reputation levels from the player.
            pRep.removeRepLevel(level);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Save the player's data.
     * @param player The player we are saving data for.
     * @return Whether or not we successfully saved the player's data.
     */
    public boolean savePlayerData(@NotNull Player player) {
        try {
            AvalonPlayer ap = plugin.getAvalonPlayer(player);
            if (ap == null) {
                throw new IllegalArgumentException("Could not find AvalonPlayer linked with provided player!");
            }

            // We have all the info we need. Save the player's data.
            ap.savePlayerData();
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	[ FACTION METHODS ]
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    /**
     * Get a faction object, containing information on how a particular faction functions.
     * @param faction The namespace of the faction we are retrieving
     * @return The faction object containing the faction info
     */
	public Faction getFaction(@NotNull String faction) {
        try {
            Faction rep = plugin.repManager.get(faction);
            if (rep == null) {
                throw new IllegalArgumentException("A faction by name '" + faction + "' does not exist!");
            }
            return rep;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	[ API METHODS ]
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

	public void registerTrigger(ReputationTrigger... triggers) {
	    for (ReputationTrigger trigger : triggers) {
            this.triggers.put(trigger.getTriggerName(), trigger);
            Bukkit.getPluginManager().registerEvents(trigger, plugin);
        }
    }

}
