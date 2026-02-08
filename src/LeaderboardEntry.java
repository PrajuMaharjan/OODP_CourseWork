public class LeaderboardEntry {
	
    private int rank;
    private String username;
    private int totalScore;
    private int testsTaken;

    public LeaderboardEntry(int rank, String username, int totalScore, int testsTaken) {
        this.rank=rank;
        this.username=username;
        this.totalScore=totalScore;
        this.testsTaken=testsTaken;
    }

    public int getRank() {
        return rank;
    }

    public String getUsername() {
        return username;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getTestsTaken() {
        return testsTaken;
    }

    public void setRank(int rank) {
        this.rank=rank;
    }

    public void setUsername(String username) {
        this.username=username;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore=totalScore;
    }

    public void setTestsTaken(int testsTaken) {
        this.testsTaken=testsTaken;
    }
}