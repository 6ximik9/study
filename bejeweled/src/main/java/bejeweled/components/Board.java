package bejeweled.components;

public class Board {
    private int rowCount = 8,
                      columnCount = 8;

    private Tile[][] tiles;

    public Board(int rowCount, int columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        tiles = new Tile[rowCount][columnCount];
    }


    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public Tile getTilesItem(int x, int y) {
        return tiles[x][y];
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }

}
