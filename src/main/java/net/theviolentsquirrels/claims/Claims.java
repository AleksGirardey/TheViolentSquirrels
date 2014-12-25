package net.theviolentsquirrels.claims;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Claims {
    private static List<Claim> claimsList = new ArrayList<Claim>();
    private static Map<String, ClaimPoints> claimPointsMap = new HashMap<String, ClaimPoints>();

    public static List<Claim> getClaimsList() {
        return claimsList;
    }

    public static Claim getSpecificClaim(String claimName) {
        for (Claim claim : getClaimsList()) {
            if (claim.getClaimName().equalsIgnoreCase(claimName)) { return (claim); }
        }
        return (null);
    }

    public static void setClaimList(List<Claim> claimsList) {
        Claims.claimsList = claimsList;
    }

    public static Map<String, ClaimPoints> getClaimPointsMap() {
        return claimPointsMap;
    }

    public static void setClaimPointsMap(Map<String, ClaimPoints> claimPointsMap) {
        Claims.claimPointsMap = claimPointsMap;
    }
}
