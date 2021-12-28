package adventofcode2021;


import java.util.*;
import java.util.stream.Collectors;

public class DayTwentyThree {
    private int burrowDepth;
    private final String[] state;
    private int cost = 0;

    private static int moveCount;
    private static Map<String, Integer> cache = new HashMap<>();

    public DayTwentyThree(String[] input) {
        this.state = input;
        burrowDepth = state.length-1;
    }

    public DayTwentyThree(String[] state, int costSoFar) {
        this(state);
        cost = costSoFar;
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
                    //if burrow is either empty or only full on same character fill first slot
                    int firstEmptySlot = getFirstEmptyBurrowSlot(piece, burrowX);
                    if (firstEmptySlot>0) {
                        result.add(new int[]{piece[1], piece[2], burrowX, firstEmptySlot});
                    }
                }
                continue;
            }
            for (int x = 0; x < state[0].length(); x++) {
                for (int y = 0; y < state.length; y++) {
                    if (isEntrance(x, y) || !isEmpty(x, y) || x == pieceX || notValidBurrow(piece, x, y)) {
                        continue;
                    }
                    if (canGetToHallway(pieceX, pieceY) && isHallwayClear(pieceX, x)) {
                        result.add(new int[]{pieceX, pieceY, x, y});
                    }
                }
            }
        }
//        List<int[]> burrowMoves = result.stream().filter(arr -> arr[3] > 0).collect(Collectors.toList());
//        if(burrowMoves.size() > 0){
//            result = burrowMoves;
//        }
        return result;
    }

    private int getFirstEmptyBurrowSlot(int[] piece, int burrowX) {
        int firstEmptySlot = 0;
        for (int y = burrowDepth; y > 0; y--) {
            if(isEmpty(burrowX,y)){
                firstEmptySlot = y;
            }
            if(state[y].charAt(burrowX) != piece[0]){
               break;
            }
        }
        return firstEmptySlot;
    }

    private boolean canGetToHallway(int pieceX, int pieceY) {
        for(int y = pieceY-1; y>0; y--){
            if(!isEmpty(pieceX,y)){
                return false;
            }
        }
        return true;
    }

    private boolean notValidBurrow(int[] piece, int x, int y) {
        if(y > 0){
            if(getBurrowXCoordinate(piece[0]) != x) {
                return true;
            }
            return getFirstEmptyBurrowSlot(piece,x) == 0;
        }
        return false;
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
        boolean burrowGood = true;
        for (int burrowIndex = burrowDepth; burrowIndex > 0 ; burrowIndex--) {
            if(state[burrowIndex].charAt(x) != character && !isEmpty(x, burrowIndex)){
                burrowGood = false;
                break;
            }
        }
        return x == burrowXCoordinate && burrowGood;
    }


    private boolean isEmpty(int x, int y) {
        return state[y].charAt(x) == '.';
    }

    public int getMoveCost(char character, int[] move) {
        int stepCost;
        switch (character) {
            case 'A':
                stepCost = 1;
                break;
            case 'B':
                stepCost = 10;
                break;
            case 'C':
                stepCost = 100;
                break;
            case 'D':
                stepCost = 1000;
                break;
            default:
                throw new IllegalArgumentException("invalid amphipod name: " + character);
        }

        int ySteps = move[1] + move[3];
        return (Math.abs(move[0] - move[2]) + ySteps) * stepCost;
    }

    public DayTwentyThree makeMove(int startX, int startY, int endX, int endY) {
        String[] newState = new String[state.length];
        String character = String.valueOf(state[startY].charAt(startX));
        int moveCost = getMoveCost(character.charAt(0), new int[]{startX, startY, endX, endY});
        for (int y = 0; y < state.length; y++) {
            StringBuilder newRow = new StringBuilder(state[y]);
            if (startY == y) {
                newRow.replace(startX, startX + 1, ".");
            }
            if (endY == y) {
                newRow.replace(endX, endX + 1, character);
            }
            newState[y] = newRow.toString();
        }
        moveCount++;
        return new DayTwentyThree(newState, cost + moveCost);
    }

    private DayTwentyThree makeMove(int[] availableMove) {
        return makeMove(availableMove[0], availableMove[1], availableMove[2], availableMove[3]);
    }

    @Override
    public String toString() {
        return "DayTwentyThree{" +
                "state=" + Arrays.toString(state);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DayTwentyThree that = (DayTwentyThree) o;
        return cost == that.cost && Arrays.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(cost);
        result = 31 * result + Arrays.hashCode(state);
        return result;
    }

    public int findMinimumCostToSolve(){
        return findMinimumCostToSolve(Integer.MAX_VALUE);
    }

    private int findMinimumCostToSolve(int minimumCostSoFar) {
        if(cost > minimumCostSoFar){
            return minimumCostSoFar;
        }
        //if we've been here before at lower cost return
        Integer costToGetHereBefore = cache.get(toString());
        if(costToGetHereBefore != null && costToGetHereBefore <= cost){
            return minimumCostSoFar;
        } else {
            cache.put(toString(), cost);
        }

        List<int[]> availableMoves = getAvailableMoves();

        if(availableMoves.isEmpty() && isHallwayEmpty()){
            System.out.println(this + " " + cost);
            if(cost < minimumCostSoFar) {
                minimumCostSoFar = cost;
            }
            return minimumCostSoFar;
        }
        for (int[] availableMove : availableMoves) {
            minimumCostSoFar = makeMove(availableMove).findMinimumCostToSolve(minimumCostSoFar);
        }
        return minimumCostSoFar;
    }

    private boolean isHallwayEmpty() {
        return state[0].equals("...........");
    }

    public static int getMoveCount() {
        return moveCount;
    }
}
