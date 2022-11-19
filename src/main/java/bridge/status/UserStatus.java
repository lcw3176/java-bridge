package bridge.status;

import java.util.List;

public class UserStatus {

    private final List<String> directions;
    private int position;
    private boolean available;
    private static final String ON_SUCCESS = " O ";
    private static final String ON_FAILED = " X ";
    private static final String ON_NOTHING = "   ";

    public UserStatus(List<String> directions, int position, boolean available) {
        this.directions = directions;
        this.position = position;
        this.available = available;
    }

    public void addDirection(String direction) {
        this.directions.add(direction);
        this.position++;
    }

    public int getPosition() {
        return this.position - 1;
    }

    public String getMostRecentDirection() {
        if (this.position - 1 < 0) {
            throw new IndexOutOfBoundsException("게임을 먼저 진행해야 합니다.");
        }

        return this.directions.get(this.position - 1);
    }


    public boolean isAvailable() {
        return this.available;
    }

    public void lose() {
        this.available = false;
    }

    public void tryAgain() {
        this.directions.clear();
        this.position = 0;
        this.available = true;
    }

    public String getUserScoreByDirectionOrElseSpace(String compareDirection, int position) {
        String userDirection = this.directions.get(position);

        if (userDirection.equals(compareDirection) && this.available) {
            return ON_SUCCESS;
        }

        if (userDirection.equals(compareDirection) && !this.available) {
            return ON_FAILED;
        }

        return ON_NOTHING;
    }

}