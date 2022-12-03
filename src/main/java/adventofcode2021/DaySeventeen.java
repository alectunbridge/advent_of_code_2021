package adventofcode2021;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


class PositionAndVelocity {


    private final int posX;
    private final int posY;
    private final int velX;
    private final int velY;

    @Override
    public String toString() {
        return "PositionAndVelocity{" +
                "posX=" + posX +
                ", posY=" + posY +
                ", velX=" + velX +
                ", velY=" + velY +
                '}';
    }

    public PositionAndVelocity(int posX, int posY, int velX, int velY) {
        this.posX = posX;
        this.posY = posY;
        this.velX = velX;
        this.velY = velY;
    }

    public PositionAndVelocity incrementPosition() {
        return new PositionAndVelocity(posX + velX, posY + velY, velX == 0 ? 0 : velX - 1, velY - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionAndVelocity that = (PositionAndVelocity) o;
        return posX == that.posX && posY == that.posY && velX == that.velX && velY == that.velY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(posX, posY, velX, velY);
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}

public class DaySeventeen {
    private final int xMin;
    private final int xMax;
    private final int yMin;
    private final int yMax;
    private final int maxYVelocity;

    public DaySeventeen(int xMin, int xMax, int yMin, int yMax) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
        maxYVelocity = Math.abs(yMin) - 1;
    }

    public int findHighestYValue() {
        return maxYVelocity * (maxYVelocity + 1) / 2;
    }

    public boolean isHit(int initialXVel, int initialYVel) {
        PositionAndVelocity currentState = new PositionAndVelocity(0,0,initialXVel,initialYVel);
        while (currentState.getPosX() <= xMax && currentState.getPosY() >= yMin){
            if(isWithinTarget(currentState)){
                return true;
            }
            currentState = currentState.incrementPosition();
        }
        return false;
    }

    private boolean isWithinTarget(PositionAndVelocity positionAndVelocity) {
        return positionAndVelocity.getPosX() >= xMin && positionAndVelocity.getPosX() <= xMax &&
                positionAndVelocity.getPosY() >= yMin && positionAndVelocity.getPosY() <= yMax;
    }

    public int solvePart2() {
        List<PositionAndVelocity> result = new ArrayList<>();
        for (int xVel = 0; xVel <= xMax; xVel++) {
            for (int yVel = yMin; yVel <= maxYVelocity; yVel++) {
                if(isHit(xVel,yVel)){
                    result.add(new PositionAndVelocity(0,0,xVel,yVel));
                }
            }
        }
        return (int) result.stream().distinct().count();
    }
}
