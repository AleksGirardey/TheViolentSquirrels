package net.theviolentsquirrels.players;

import java.util.ArrayList;
import java.util.List;

public class PlayerChunks {
    private static List<PlayerChunk> playerChunksList = new ArrayList<PlayerChunk>();

    public static List<PlayerChunk> getPlayerChunksList() { return playerChunksList; }

    public static void setPlayerChunksList(List<PlayerChunk> playerChunksList) {
        PlayerChunks.playerChunksList = playerChunksList;
    }

    public static PlayerChunk getSpecificPlayerChunk(String playerChunkName) {
        for (PlayerChunk playerChunk : getPlayerChunksList()) {
            if (playerChunk.getChunkName().equalsIgnoreCase(playerChunkName)) { return (playerChunk); }
        }
        return (null);
    }

    public static boolean isAlreadyChunked(PlayerChunk chunk) {
        List<PlayerChunk> playerChunksList = getPlayerChunksList();
        for (PlayerChunk playerChunk : playerChunksList) {
            if (chunk.getChunkX() == playerChunk.getChunkX() && chunk.getChunkZ() == playerChunk.getChunkZ()) {
                return (true);
            }
        }
        return (false);
    }
}
