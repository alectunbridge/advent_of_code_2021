package adventofcode2021;

import java.util.ArrayList;
import java.util.List;

public class DayTwentyThree {
    private final String[] state;

    public DayTwentyThree(String[] input) {
        this.state = input;
    }

    public List<int[]> getAvailableMoves() {
        List<int[]> result = new ArrayList<>();

        for (int[] piece : getPiecesToMove()) {
            for (int x = 0; x < state[0].length(); x++) {
                for (int y = 0; y < state.length; y++) {
                    //check intervening locs
                    if(piece[2] <= 1 || isEmpty(x,1)) {
                        //we're good to get to hallway
                        //are we good to move along it?
                        if (isAllowedLocation(x, y)) {
                            result.add(new int[]{piece[1], piece[2], x, y});
                        }
                    }
                }
            }
        }
        return result;
    }

    public List<int[]> getPiecesToMove() {
        List<int[]> result = new ArrayList<>();
        for (int x = 0; x < state[0].length(); x++) {
            for (int y = 0; y < state.length; y++) {
                char character = state[y].charAt(x);
                if(Character.isAlphabetic(character)){
                    result.add(new int[]{character,x,y});
                }
            }
        }
        return result;
    }

    private boolean isAllowedLocation(int x, int y) {
        boolean entrance = x==2 || x == 4 || x==6 || x==8;
        return !entrance && isEmpty(x, y);
    }

    private boolean isEmpty(int x, int y) {
        return state[y].charAt(x) == '.';
    }
}
