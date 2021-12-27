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
            //if in hallway go to burrow
            int pieceX = piece[1];
            int pieceY = piece[2];
            boolean pieceIsInHallway = pieceY == 0;
            if (pieceIsInHallway) {
                int burrowX = getBurrowXCoordinate(piece[0]);
                if (isHallwayClear(pieceX, burrowX)) {
                    if (isEmpty(burrowX, 2)) {
                        result.add(new int[]{piece[1], piece[2], burrowX, 2});
                    } else if (isEmpty(burrowX, 1) && state[2].charAt(burrowX) == piece[0]) {
                        result.add(new int[]{piece[1], piece[2], burrowX, 1});
                    }
                }
                continue;
            }
            for (int x = 0; x < state[0].length(); x++) {
                for (int y = 0; y < state.length; y++) {
                    if (isEntrance(x, y) || !isEmpty(x, y) || x == pieceX || (y > 0 && getBurrowXCoordinate(piece[0]) != x)) {
                        continue;
                    }
                    boolean canGetToHallway = pieceY == 1 || isEmpty(pieceX, 1);
                    if (canGetToHallway && isHallwayClear(pieceX, x)) {
                        result.add(new int[]{pieceX, pieceY, x, y});
                    }
                }
            }
        }
        return result;
    }

    private boolean isEntrance(int x, int y) {
        return (x == 2 || x == 4 || x == 6 || x == 8) && y == 0;
    }

    private boolean isHallwayClear(int startX, int endX) {
        int delta = (endX - startX) / Math.abs(endX - startX);
        for (int interX = startX + delta; interX != endX; interX += delta) {
            if (!isEmpty(interX, 0)) {
                return false;
            }
        }
        return true;
    }

    private int getBurrowXCoordinate(int name) {
        switch (name) {
            case 'A':
                return 2;
            case 'B':
                return 4;
            case 'C':
                return 6;
            case 'D':
                return 8;
            default:
                throw new IllegalArgumentException("Invalid piece name " + name);
        }
    }

    public List<int[]> getPiecesToMove() {
        List<int[]> result = new ArrayList<>();
        for (int x = 0; x < state[0].length(); x++) {
            for (int y = 0; y < state.length; y++) {
                char character = state[y].charAt(x);
                if (Character.isAlphabetic(character) && !isSnugInBorrow(character, x, y)) {
                    result.add(new int[]{character, x, y});
                }
            }
        }
        return result;
    }

    private boolean isSnugInBorrow(char character, int x, int y) {
        int burrowXCoordinate = getBurrowXCoordinate(character);
        return (x == burrowXCoordinate) && (y == 2 || (y == 1 && state[2].charAt(x) == character));
    }


    private boolean isEmpty(int x, int y) {
        return state[y].charAt(x) == '.';
    }
}
