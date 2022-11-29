package tau.sailorsRank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SailorsRankApplicationTests {

	@Mock
	SailorsRankApplication sailorsRankApplication;


	@Test
	void shouldShowSailorsDetails() {
		when(sailorsRankApplication.showSailorsDetails()).thenReturn("Sailor: Mateusz Kusznierewicz" +
				", Sailor ID: MK307" +
				", Sailing class: PROFFESIONAL" +
				", Actual Rank points: 1346");

		assertEquals(sailorsRankApplication.showSailorsDetails(), "Sailor: Mateusz Kusznierewicz" +
				", Sailor ID: MK307" +
				", Sailing class: PROFFESIONAL" +
				", Actual Rank points: 1346");
	}

	@Test
	void shouldAddPoints() {
		final long points = 120L;
		final long expectedRankPoints = 1520L;

		when(sailorsRankApplication.getRankPoints()).thenReturn(1520L);
		when(sailorsRankApplication.addPoints(points)).thenReturn(1520L);

		long rankPointsAfterAdding = sailorsRankApplication.addPoints(points);

		assertEquals(expectedRankPoints, rankPointsAfterAdding);
		assertEquals(rankPointsAfterAdding, sailorsRankApplication.getRankPoints());
	}

	@Test
	void shouldThrowIllegalArgumentException() {
		when(sailorsRankApplication.addPoints(anyLong())).thenThrow(IllegalArgumentException.class);
		assertThrows(IllegalArgumentException.class, () -> sailorsRankApplication.addPoints(-140));
	}

	@Test
	void shouldCancelPoints() {
		final long points = 120L;
		final long expectedRankPoints = 1520L;

		when(sailorsRankApplication.getRankPoints()).thenReturn(1520L);
		when(sailorsRankApplication.cancelPoints(points)).thenReturn(1520L);

		long rankPointsAfterCancelling = sailorsRankApplication.cancelPoints(points);

		assertEquals(expectedRankPoints, rankPointsAfterCancelling);
		assertEquals(rankPointsAfterCancelling, sailorsRankApplication.getRankPoints());
	}

	@Test
	void shoudShowSailorId() {
		String expectedSailorId = "MK307";
		when(sailorsRankApplication.getSailorId()).thenReturn("MK307");

		assertEquals(expectedSailorId, sailorsRankApplication.getSailorId());
	}

	@Test
	void shoudShowSailorFirstName() {
		String expectedFirstName = "Mateusz";
		when(sailorsRankApplication.getSailorFirstName()).thenReturn("Mateusz");

		assertEquals(expectedFirstName, sailorsRankApplication.getSailorFirstName());
	}

	@Test
	void shoudShowSailorLastName() {
		String expectedLastName = "Kusznierewicz";
		when(sailorsRankApplication.getSailorLastName()).thenReturn("Kusznierewicz");

		assertEquals(expectedLastName, sailorsRankApplication.getSailorLastName());
	}

	@Test
	void shoudShowSailorRankPoints() {
		long expectedRankPoints = 1234;
		when(sailorsRankApplication.getRankPoints()).thenReturn(1234L);

		assertEquals(expectedRankPoints, sailorsRankApplication.getRankPoints());
	}

	@Test
	void shouldFindSailor () {
		when(sailorsRankApplication.sarchForSailor(anyString())).thenReturn(true);
		assertTrue(sailorsRankApplication.sarchForSailor("MK123"));
	}
}
