package tau.sailorsRank;

public class SailorsRankApplicationStub extends SailorsRankApplication{
    private final SailorsRankApplication sailorsRankApplicationStub = new SailorsRankApplication("MK307", "Mateusz", "Kusznierewicz", SailingClass.PROFFESIONAL, 1346);

    @Override
    public String showSailorsDetails() {
        return "Sailor: " + sailorsRankApplicationStub.getSailorFirstName() + " " + sailorsRankApplicationStub.getSailorLastName() +
                ", Sailor ID: " + sailorsRankApplicationStub.getSailorId() +
                ", Sailing class: " + sailorsRankApplicationStub.getSailingClass() +
                ", Actual Rank points: "+ sailorsRankApplicationStub.getRankPoints();
    }

    @Override
    public long addPoints(long points) {
        return sailorsRankApplicationStub.getRankPoints() + points;
    }

    @Override
    public long cancelPoints(long points) {
        return sailorsRankApplicationStub.getRankPoints() - points;
    }

    @Override
    public SailingClass getSailingClass() {
        return sailorsRankApplicationStub.getSailingClass();
    }

    @Override
    public boolean sarchForSailor(String givenSailorId) {
        return sailorsRankApplicationStub.sarchForSailor(givenSailorId);
    }

    @Override
    public String getSailorId() {
        return sailorsRankApplicationStub.getSailorId();
    }

    @Override
    public String getSailorFirstName() {
        return sailorsRankApplicationStub.getSailorFirstName();
    }

    @Override
    public String getSailorLastName() {
        return sailorsRankApplicationStub.getSailorLastName();
    }

    @Override
    public long getRankPoints() {
        return sailorsRankApplicationStub.getRankPoints();
    }
}
