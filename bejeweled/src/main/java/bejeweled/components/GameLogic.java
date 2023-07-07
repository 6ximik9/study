package bejeweled.components;

import bejeweled.service.ScoreService;
import bejeweled.ui.view.GameUI;
import bejeweled.ui.view.ratingForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.Timer;

import static java.lang.Math.abs;

@Component
public class GameLogic extends JPanel {

    private Thread thread;
    private final int width = 740;
    private final int height = 480;
    private Tile firstSelectedTile;
    private Tile secondSelectedTile;
    private BufferedImage view, back, gems, cursor;
    private MouseEvent mouse;
    private int x0, y0, x, y;
    private int click = 0;
    private final int tileSize = 54;
    private final int offsetX = 48, offsetY = 24;
    private int score = 0;
    private int countSwap = 0;

    TileType[] type = TileType.values();

    Board board;

    private ScoreService scoreService;

    @Autowired
    public void setScoreService(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    public GameLogic() {
        board = new Board(8,8);
    }



    public void generate()
    {
        generateBoard();
    }

    private void generateBoard()
    {
        try{
            view = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
            Tile[][] tiles = new Tile[10][10];
            try(InputStream backPNG = getClass().getClassLoader().getResourceAsStream("background.png");
                InputStream gemsPNG = getClass().getClassLoader().getResourceAsStream("gems.png");
                InputStream cursorPNG = getClass().getClassLoader().getResourceAsStream("cursor.png"))
            {
                assert backPNG != null;
                back = ImageIO.read(backPNG);
                assert gemsPNG != null;
                gems = ImageIO.read(gemsPNG);
                assert cursorPNG != null;
                cursor = ImageIO.read(cursorPNG);
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
                System.exit(0);
            }
            for (int i=0; i<10; i++)
            {
                for (int j=0; j<10; j++)
                {
                    tiles[i][j] = new Tile();
                }
            }

            for (int i=0; i<=board.getRowCount(); i++)
            {
                for (int j=0; j<=board.getColumnCount(); j++)
                {
                    tiles[i][j].setType(type[new Random().nextInt(7)]);
                    tiles[i][j].setRow(i);
                    tiles[i][j].setCol(j);
                    tiles[i][j].setX(j*tileSize);
                    tiles[i][j].setY(i*tileSize);
                }
            }
            firstSelectedTile = tiles[0][0];
            secondSelectedTile = tiles[5][2];

            board.setTiles(tiles);
        }
        catch (Exception ignored)
        {

        }
    }


    public int checkValidSwap(int x, int x0, int y, int y0) {
        return isValidMove(x, x0, y, y0);
    }

    public int isValidMove(int x, int x0, int y, int y0) {
        return abs(x - x0) + abs(y - y0);
    }

    private void getSelectedItem()
    {
        if (mouse != null && mouse.getID() == MouseEvent.MOUSE_PRESSED) {
            if (mouse.getButton() == MouseEvent.BUTTON1) {
                if(!firstSelectedTile.isSwap() && !secondSelectedTile.isSwap() &&
                        !firstSelectedTile.isMoved() && !secondSelectedTile.isMoved())
                {
                    click++;
                }
                int posX = mouse.getX() - offsetX;
                int posY = mouse.getY() - offsetY;
                if (click == 1) {
                    x0 = posX / tileSize + 1;
                    y0 = posY / tileSize + 1;
                    if(x0<1||x0>8 || y0<1||y0>8)
                    {
                        y0 = 0;
                        x0 = 0;
                        click=0;
                        mouse=null;
                        return;
                    }
                }
                //System.out.println(y0+" " + x0);
                firstSelectedTile = board.getTilesItem(y0,x0);
                if (click == 2) {
                    x = posX / tileSize + 1;
                    y = posY / tileSize + 1;
                    if(x<1||x>8 || y<1||y>8)
                    {
                        y = 0;
                        x = 0;
                        click = 1;
                        mouse=null;
                        return;
                    }
                    //System.out.println(y+" " + x);
                    secondSelectedTile = board.getTilesItem(y,x);
                    if (isValidMove(x,x0,y,y0) == 1) {
                        swapTile(firstSelectedTile, secondSelectedTile);
                        firstSelectedTile.setSwap(true);
                        secondSelectedTile.setSwap(true);
                        //isSwap = true;
                        click = 0;
                        countSwap++;
                    } else {
                        click = 1;
                    }
                }
            }
            mouse = null;
        }
    }



    private void moveTilesAnimation(){
        //Moving animation
        //isMoving = false;
        Tile[][] tiles = board.getTiles();
        firstSelectedTile.setMoved(false);
        secondSelectedTile.setMoved(false);
        for(int i = 1;i <= 8;i++) {
            for (int j = 1;j <= 8;j++) {
                Tile tile = tiles[i][j];
                int dx = 0, dy = 0;
                int speed = 4;
                for(int n = 0; n < speed; n++) {
                    dx = tile.getX() - tile.getCol() * tileSize;
                    dy = tile.getY() - tile.getRow() * tileSize;
                    if (dx != 0) {
                        int newX = tile.getX()-dx / abs(dx);
                        tile.setX(newX);
                    }
                    if (dy != 0) {
                        int newY = tile.getY()-dy / abs(dy);
                        tile.setY(newY);
                    }
                }
                if (dx != 0 || dy != 0) {
                    firstSelectedTile.setMoved(true);
                    secondSelectedTile.setMoved(true);
                }
            }
        }
        board.setTiles(tiles);
    }



    public void playing() {

        getSelectedItem();

        //Match finding
        findMatch();

        moveTilesAnimation();

        //Get score
        calculateScore();

        if (firstSelectedTile.isSwap() && secondSelectedTile.isSwap() && !firstSelectedTile.isMoved() && !secondSelectedTile.isMoved()) {
            swapTile(firstSelectedTile, secondSelectedTile);
            firstSelectedTile.setSwap(false);
            secondSelectedTile.setSwap(false);
        }

        updateBoard();
    }

    private void updateBoard() {
        if (!firstSelectedTile.isMoved() && !secondSelectedTile.isMoved()) {
            for (int i = 8; i > 0; i--) {
                for (int j = 1; j <= 8; j++) {
                    if (board.getTilesItem(i,j).getMatch() != 0) {
                        for (int n = i; n > 0; n--) {
                            if (board.getTilesItem(n,j).getMatch() == 0) {
                                swapTile(board.getTilesItem(n,j), board.getTilesItem(i,j));
                                break;
                            }
                        }
                    }
                }
            }
            for (int j = 1; j <= 8; j++) {
                for (int i = 8, n = 0; i > 0; i--) {
                    if (board.getTilesItem(i,j).getMatch() != 0) {
                        board.getTilesItem(i,j).setType(type[new Random().nextInt(7)]);
                        board.getTilesItem(i,j).setY(-tileSize * n++);
                        board.getTilesItem(i,j).setMatch(0);
                    }
                }
            }
        }
    }




    public void swapTile(Tile tile1, Tile tile2){
        int rowAux = tile1.getRow();
        tile1.setRow(tile2.getRow());
        tile2.setRow(rowAux);


        int colAux = tile1.getCol();
        tile1.setCol(tile2.getCol());
        tile2.setCol(colAux);

        Tile[][] tiles = board.getTiles();

        tiles[tile1.getRow()][tile1.getCol()] = tile1;
        tiles[tile2.getRow()][tile2.getCol()] = tile2;

        board.setTiles(tiles);
    }

    public MouseEvent getMouse() {
        return mouse;
    }

    public void setMouse(MouseEvent mouse) {
        this.mouse = mouse;
    }


    private void findMatch() {
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if (board.getTilesItem(i,j).getType() == board.getTilesItem(i+1,j).getType()) {
                    if (board.getTilesItem(i,j).getType() == board.getTilesItem(i-1,j).getType()) {
                        for (int n = -1; n <= 1; n++) {
                            int newMatch = board.getTilesItem(i+n,j).getMatch() + 1;
                            board.getTilesItem(i+n,j).setMatch(newMatch);
                        }
                    }
                }
                if (board.getTilesItem(i,j).getType() == board.getTilesItem(i,j+1).getType()) {
                    if (board.getTilesItem(i,j).getType() == board.getTilesItem(i,j-1).getType()) {
                        for (int n = -1; n <= 1; n++) {
                            int newMatch = board.getTilesItem(i,j+n).getMatch() + 1;
                            board.getTilesItem(i,j+n).setMatch(newMatch);
                        }
                    }
                }
            }
        }
    }

    void calculateScore() {
        int score = 0;
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if (board.getTilesItem(i,j).getType() == TileType.JAVA) {
                    score += board.getTilesItem(i,j).getMatch();
                } else if (board.getTilesItem(i,j).getType() == TileType.CPP) {
                    score += board.getTilesItem(i,j).getMatch() / 2;
                } else if (board.getTilesItem(i,j).getType() == TileType.CSharp) {
                    score += board.getTilesItem(i,j).getMatch() / 3;
                } else if (board.getTilesItem(i,j).getType() == TileType.PYTHON) {
                    score += board.getTilesItem(i,j).getMatch() / 4;
                } else if (board.getTilesItem(i,j).getType() == TileType.SWIFT) {
                    score += board.getTilesItem(i,j).getMatch() / 5;
                } else if (board.getTilesItem(i,j).getType() == TileType.VISUAL) {
                    score += board.getTilesItem(i,j).getMatch() / 6;
                } else if (board.getTilesItem(i,j).getType() == TileType.XML) {
                    score += board.getTilesItem(i,j).getMatch() / 7;
                }
            }
        }
        if (score > 0) {
            this.score += score;
        }
    }

    public void draw() {
        try {
            Graphics2D g2 = (Graphics2D) view.getGraphics();
            g2.drawImage(back, 0, 0, width, height, null);

            for (int i = 1; i <= 8; i++) {
                for (int j = 1; j <= 8; j++) {
                    g2.drawImage(
                            gems.getSubimage(board.getTilesItem(i, j).getType().ordinal() * 49, 0, 49, 49),
                            board.getTilesItem(i, j).getX() + (offsetX - tileSize),
                            board.getTilesItem(i, j).getY() + (offsetY - tileSize),
                            49,
                            49,
                            null
                    );

                    if (click == 1) {
                        if (x0 == j && y0 == i) {
                            g2.drawImage(
                                    cursor,
                                    board.getTilesItem(i, j).getX() + (offsetX - tileSize),
                                    board.getTilesItem(i, j).getY() + (offsetY - tileSize),
                                    cursor.getWidth(),
                                    cursor.getHeight(),
                                    null
                            );
                        }
                    }
                }
            }

            Graphics g = getGraphics();
            g.drawImage(view, 0, 0, width, height, null);
            g.dispose();
        }
        catch (Exception ignored)
        {

        }
    }

    public Tile[][] getGameBoard()
    {
        return board.getTiles();
    }

    public int getCountSwap() {
        return countSwap;
    }

    public void setCountSwap(int countSwap) {
        this.countSwap = countSwap;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
