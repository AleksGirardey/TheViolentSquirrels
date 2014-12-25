package net.theviolentsquirrels.claims;

import org.bukkit.Location;

public class Claim {
    private String claimName;
    private String claimOwner;
    private Location loc1;
    private Location loc2;

    public Claim(String claimName, String claimOwner, Location loc1, Location loc2) {
        this.claimName = claimName;
        this.claimOwner = claimOwner;
        this.loc1 = loc1;
        this.loc2 = loc2;
    }

    public String getClaimName() {
        return claimName;
    }

    public void setClaimName(String claimName) {
        this.claimName = claimName;
    }

    public String getClaimOwner() {
        return claimOwner;
    }

    public void setClaimOwner(String claimOwner) {
        this.claimOwner = claimOwner;
    }

    public Location getLoc1() {
        return loc1;
    }

    public void setLoc1(Location loc1) {
        this.loc1 = loc1;
    }

    public Location getLoc2() {
        return loc2;
    }

    public void setLoc2(Location loc2) {
        this.loc2 = loc2;
    }
}
