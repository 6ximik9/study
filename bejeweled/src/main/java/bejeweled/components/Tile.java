package bejeweled.components;

public class Tile {
    private int x;
    private int y;
    private int row;
    private int col;
    private int match;
    private TileType type;

    private boolean isSwap;
    private boolean isMoved;
    public Tile(){
        match = 0;
        isSwap=false;
        isMoved=false;
    }

    public boolean isSwap() {
        return isSwap;
    }

    public void setSwap(boolean swap) {
        isSwap = swap;
    }

    public boolean isMoved() {
        return isMoved;
    }

    public void setMoved(boolean moved) {
        isMoved = moved;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getMatch() {
        return match;
    }

    public void setMatch(int match) {
        this.match = match;
    }

    public TileType getType() {
        return type;
    }

    public void setType(TileType type) {
        this.type = type;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
