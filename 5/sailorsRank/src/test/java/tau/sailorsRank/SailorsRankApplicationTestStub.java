package tau.sailorsRank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SailorsRankApplicationTestStub {

    SailorsRankApplicationStub sailorsRankApplicationStub;

    @BeforeEach
    public void create() {
        sailorsRankApplicationStub = new SailorsRankApplicationStub();
    }

    @Test
    public void shouldShowSailorsDetails() {
        assertEquals("Sailor: Mateusz Kusznierewicz" +
                ", Sailor ID: MK307" +
                ", Sailing class: PROFFESIONAL" +
                ", Actual Rank points: 1346", sailorsRankApplicationStub.showSailorsDetails());
    }

    @Test
    public void shouldAddPoints() {
        final long points = 120L;
        final long expecedRankPoints = 1466L;
        long rankPointsAfterAdding = sailorsRankApplicationStub.addPoints(points);

        assertEquals(expecedRankPoints, rankPointsAfterAdding);
    }

    @Test
    public void shouldCancelPoints() {
        final long points = 120L;
        final long expecedRankPoints = 1226L;
        long rankPointsAfterCancelling = sailorsRankApplicationStub.cancelPoints(points);

        assertEquals(expecedRankPoints, rankPointsAfterCancelling);
    }

    @Test
    public void shouldFindSailor() {
        assertTrue(sailorsRankApplicationStub.sarchForSailor("MK307"));
    }

    @Test
    public void shouldShowRankPoints() {
        long expectedRankPoints = 1346L;
        assertEquals(expectedRankPoints, sailorsRankApplicationStub.getRankPoints());
    }

    @Test
    public void shouldShowSailorId() {
        String expectedSailorId = "MK307";
        assertEquals(expectedSailorId, sailorsRankApplicationStub.getSailorId());
    }

}
