package adventofcode2021;

import java.util.*;

public class DayThirteen {


    private final Set<CoordDayThirteen> coords = new HashSet<>();

    public DayThirteen(List<String> input) {
        boolean readingCoords = true;
        for (String line : input) {
            if(line.isEmpty()){
                readingCoords = false;
                continue;
            }
            if(readingCoords) {
                Scanner coordScanner = new Scanner(line).useDelimiter(",");
                coords.add(new CoordDayThirteen(coordScanner.nextInt(), coordScanner.nextInt()));
            } else {
                Scanner foldScanner = new Scanner(line).useDelimiter("=");
                if(foldScanner.next().equals("fold along y")){
                    foldY(foldScanner.nextInt());
                } else {
                    foldX(foldScanner.nextInt());
                }
            }
        }
    }

    private void foldX(int xFold) {
        Set<CoordDayThirteen> newCoords = new HashSet<>();
        for (Iterator<CoordDayThirteen> iterator = coords.iterator(); iterator.hasNext(); ) {
            CoordDayThirteen coord = iterator.next();
            if (coord.getX() > xFold) {
                iterator.remove();
                newCoords.add(new CoordDayThirteen(2 * xFold - coord.getX(), coord.getY()));
            }
        }
        coords.addAll(newCoords);
    }

    private void foldY(int yFold) {
        Set<CoordDayThirteen> newCoords = new HashSet<>();
        for (Iterator<CoordDayThirteen> iterator = coords.iterator(); iterator.hasNext(); ) {
            CoordDayThirteen coord = iterator.next();
            if (coord.getY() > yFold) {
                iterator.remove();
                newCoords.add(new CoordDayThirteen(coord.getX(), 2 * yFold - coord.getY()));
            }
        }
        coords.addAll(newCoords);
    }

    public int solvePart1() {
        return coords.size();
    }

    public void solvePart2() {
        int minX = coords.stream().mapToInt(CoordDayThirteen::getX).min().orElse(0);
        int maxX = coords.stream().mapToInt(CoordDayThirteen::getX).max().orElse(Integer.MAX_VALUE);
        int minY = coords.stream().mapToInt(CoordDayThirteen::getY).min().orElse(0);
        int maxY = coords.stream().mapToInt(CoordDayThirteen::getY).max().orElse(Integer.MAX_VALUE);

        for (int y = minY; y <= maxY; y++) {
            for (int x = minX; x <= maxX ; x++) {
                if(coords.contains(new CoordDayThirteen(x,y))){
                    System.out.print("#");
                } else {
                    System.out.printf(".");
                }
            }
            System.out.print("\n");

        }
    }
}
