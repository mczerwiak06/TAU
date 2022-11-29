package tau.sailorsRank;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public  class SailorsRankApplication {

	private String sailorId;
	private String sailorFirstName;
	private String sailorLastName;
	private SailingClass className;

	private long rankPoints;

	public SailorsRankApplication(String sailorId, String sailorFirstName, String sailorLastName, SailingClass className, long rankPoints) {
		this.sailorId = sailorId;
		this.sailorFirstName = sailorFirstName;
		this.sailorLastName = sailorLastName;
		this.className = className;
		this.rankPoints = rankPoints;
	}

	public SailorsRankApplication() {}

	public String showSailorsDetails() {
		return
				"Sailor: " + sailorFirstName + " " + sailorLastName +
						", Sailor ID: " + sailorId +
						", Sailing class: " + className +
						", Actual Rank points: " + rankPoints;
	}

	public long addPoints(long points) {
		if (points > 0) {
			rankPoints = rankPoints + points;
		} else {
			throw new IllegalArgumentException("Points should be more than 0.");
		}
		return rankPoints;
	}

	public long cancelPoints(long points) {
		if (getSailingClass() == SailingClass.AMATEUR) {
			throw new IllegalStateException("Only proffesional sailors can have points cancelled.");
		} else if (rankPoints < points && getSailingClass() == SailingClass.PROFFESIONAL) {
			rankPoints = 0;
		} else {
			rankPoints = rankPoints - points;
		}
		return rankPoints;
	}
	public SailingClass getSailingClass() {
		return className;
	}

	public boolean sarchForSailor(String givenSailorId) {
		if (getSailorId().equals(givenSailorId)) {
			System.out.println(showSailorsDetails());
			return(true);
		} else {
			return false;
		}
	}

	public String getSailorId() {
		return sailorId;
	}

	public String getSailorFirstName() {
		return sailorFirstName;
	}

	public String getSailorLastName() {
		return sailorLastName;
	}

	public long getRankPoints() {
		return rankPoints;
	}
}
