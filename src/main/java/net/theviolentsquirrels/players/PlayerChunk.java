package net.theviolentsquirrels.players;

public class PlayerChunk {
    String chunkName;
    String chunkOwner;
    int chunkX;
    int chunkZ;

    public PlayerChunk(String chunkName, String chunkOwner, int chunkX, int chunkZ) {
        this.chunkName = chunkName;
        this.chunkOwner = chunkOwner;
        this.chunkX = chunkX;
        this.chunkZ = chunkZ;
    }

    public String getChunkName() {
        return chunkName;
    }

    public void setChunkName(String chunkName) {
        this.chunkName = chunkName;
    }

    public String getChunkOwner() {
        return chunkOwner;
    }

    public void setChunkOwner(String chunkOwner) {
        this.chunkOwner = chunkOwner;
    }

    public int getChunkX() {
        return chunkX;
    }

    public void setChunkX(int chunkX) {
        this.chunkX = chunkX;
    }

    public int getChunkZ() {
        return chunkZ;
    }

    public void setChunkZ(int chunkZ) {
        this.chunkZ = chunkZ;
    }
}
