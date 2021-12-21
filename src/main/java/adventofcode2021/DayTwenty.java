package adventofcode2021;

import java.util.List;

public class DayTwenty {

    private final String enhancer;
    private char[][] floor;

    public DayTwenty(List<String> input) {
        this.enhancer = input.get(0);
        int floorSize = input.size() - 2;
        floor = new char[floorSize][floorSize];
        for (int rowIndex = 2; rowIndex < input.size(); rowIndex++) {
            floor[rowIndex - 2] = input.get(rowIndex).toCharArray();
        }
    }

    public String getEnhancer() {
        return enhancer;
    }

    public String getFloor() {
        StringBuilder stringBuilder = new StringBuilder();
        for (char[] row : floor) {
            stringBuilder.append(new String(row));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public int getIndex(int row, int column) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = row-1; i <= row+1 ; i++) {
            for (int j = column-1; j <= column+1 ; j++) {
                try{
                    if(floor[i][j] == '.') {
                        stringBuilder.append("0");
                    } else {
                        stringBuilder.append("1");
                    }
                } catch (ArrayIndexOutOfBoundsException e){
                    stringBuilder.append("0");
                }
            }
        }
        return Integer.parseInt(stringBuilder.toString(),2);
    }

    public char getEnhancedCharacter(int index) {
        return enhancer.charAt(index);
    }

    public void step() {
        char[][] newFloor = new char[floor.length+2][floor.length+2];
        for (int row = -1; row <= floor.length; row++) {
            for (int column = -1; column <= floor.length; column++) {
                newFloor[row+1][column+1] = getEnhancedCharacter(getIndex(row,column));
            }
        }
        floor = newFloor;
    }

    public int getPixelCount() {
        int count = 0;
        for (char[] row : floor) {
            for (char c : row) {
                if(c=='#'){
                    count++;
                }
            }
        }
        return count;
    }
}
