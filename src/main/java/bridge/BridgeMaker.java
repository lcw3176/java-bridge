package bridge;

import bridge.command.Direction;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridges = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int direction = bridgeNumberGenerator.generate();
            String upOrDown = setUpOrDown(direction);
            bridges.add(upOrDown);
        }

        return bridges;
    }

    private String setUpOrDown(int direction) {
        if (direction == Direction.UP.getNumber()) {
            return Direction.UP.getText();
        }

        return Direction.DOWN.getText();
    }
}
