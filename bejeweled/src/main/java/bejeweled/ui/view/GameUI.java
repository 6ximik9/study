package bejeweled.ui.view;

import bejeweled.components.GameLogic;
import bejeweled.components.GameState;
import bejeweled.components.Player;
import bejeweled.entity.Score;
import bejeweled.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Time;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class GameUI extends JFrame implements MouseListener, Runnable {

    private int score;

    private int TimeLimit;

    GameState gameState;

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    private Thread thread;

    public JTextField scoreL = new JTextField("Your score: " + score);
    public JTextField records = new JTextField("User     Score");
    public JTextField time = new JTextField("Time: " + TimeLimit);

    public JTable table = new JTable();
    static JPanel panel;

    Player player;

    GameLogic gameLogic;

    Timer myTimer;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private ratingForm ratingForm;

    @Autowired
    public GameUI(ScoreService scoreService) {
        this.scoreService = scoreService;
        gameLogic = new GameLogic();
        generateForm();
        getScores();
        TimeLimit = 60 - 50;
        setGameState(GameState.PLAYING);
    }


    private void generateForm() {
        setTitle("Bejeweled");
        gameLogic.setLayout(null);
        int height = 500;
        int width = 740;
        setPreferredSize(new Dimension(width, height));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(this);
        add(gameLogic);
        pack();
        setLocationRelativeTo(null);

        scoreL.setSize(190, 25);
        scoreL.setLocation(540, 10);
        scoreL.setBackground(new Color(24, 65, 128));
        scoreL.setForeground(Color.WHITE);
        scoreL.setBorder(null);
        scoreL.setVisible(true);
        scoreL.setEditable(false);
        gameLogic.add(scoreL);

        time.setSize(190, 25);
        time.setLocation(540, 35);
        time.setBackground(new Color(24, 65, 128));
        time.setForeground(Color.WHITE);
        time.setBorder(null);
        time.setVisible(true);
        time.setEditable(false);
        gameLogic.add(time);

        records.setSize(150, 25);
        records.setLocation(540, 103);
        records.setBackground(new Color(24, 65, 128));
        records.setForeground(Color.WHITE);
        records.setBorder(null);
        records.setVisible(true);
        records.setEditable(false);
        gameLogic.add(records);


        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        panel.setLocation(510, 110);
        panel.setSize(210, 350);
        panel.setBackground(new Color(24, 65, 128));
        panel.setVisible(true);
        //board.add(panel);

        JScrollPane scrollPane = new JScrollPane(table);
        table.setBackground(new Color(24, 65, 128));
        table.setFont(new Font("Arial", Font.PLAIN, 20));
        table.setFillsViewportHeight(true);
        table.setRowHeight(22);
        table.setVisible(true);
        scrollPane.setVisible(true);
        panel.add(scrollPane);
        gameLogic.add(panel);

        this.setVisible(false);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        gameLogic.setMouse(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
        //gameLogic.setPlayer(player);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public JTextField getScoreL() {
        return scoreL;
    }

    public void setScoreL(JTextField scoreL) {
        this.scoreL = scoreL;
    }

    public JTextField getRecords() {
        return records;
    }

    public void setRecords(JTextField records) {
        this.records = records;
    }

    public int getTimeLimit() {
        return TimeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        TimeLimit = timeLimit;
    }

    public JTextField getTime() {
        return time;
    }

    public void setTime(JTextField time) {
        this.time = time;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public void startGame() {
        if (player != null) {
            startTimer();
            setVisible(true);
            System.out.println(scoreService);
        } else {
            JOptionPane.showMessageDialog(this, "Error user");
            System.exit(0);
        }
    }

    private void getScores() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Player");
        dtm.addColumn("Score");

        getTable().setModel(dtm);
        getTable().setForeground(Color.WHITE);
        getTable().setShowGrid(false);
        getTable().setEnabled(false);

        //ScoreServiceJDBC scoreServiceJDBC = new ScoreServiceJDBC();

        var recordsList = scoreService.getTopScores("bejeweled");
//        System.out.println(recordsList);
        int ii = 0;
        if (recordsList != null) {
            for (var rec : recordsList) {
                dtm.setRowCount(dtm.getRowCount() + 1);
                String login = rec.getPlayer();
                int score = rec.getPoints();
                if (score <= 0) {
                    continue;
                }
                dtm.setValueAt(login, ii, 0);
                dtm.setValueAt(score, ii, 1);
                ii++;
            }
        }

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        getTable().getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        getTable().getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

        getTable().getTableHeader().setResizingAllowed(false);
        getTable().setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);

        getTable().getTableHeader().setResizingAllowed(false);
        getTable().setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
    }

    private void startTimer() {
        myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            public void run() {
                if (TimeLimit == 0) {
                    scoreService.addScore(new Score(player.getLogin(), "bejeweled", gameLogic.getScore(), new Date()));
                    myTimer.cancel();
                    myTimer = null;
                    //setGameState(GameState.END);
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    setVisible(false);
                    int dialogResult = JOptionPane.showOptionDialog(null, "Your result: " + score + "\nPlay again?",
                            "Question", dialogButton, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Yes", "No", "Rate the game"}, "default");
                    if (dialogResult == JOptionPane.YES_OPTION) {
                        setVisible(true);
                        TimeLimit = 60;
                        startTimer();
                        getScores();
                        score = 0;
                        gameLogic.setCountSwap(0);
                        gameState = GameState.PLAYING;
                        thread.run();
                    } else if (dialogResult == JOptionPane.NO_OPTION) {
                        System.exit(0);
                    } else if (dialogResult == JOptionPane.CANCEL_OPTION) {
                        dispose();
                        ratingForm.setPlayer(player);
                        ratingForm.showRating();
                        System.out.println("User clicked Rate the game");
                    } else {
                        System.exit(0);
                    }
                }
                TimeLimit--;
            }
        }, 1, 1000);
    }


    @Override
    public void run() {

        update();
    }

    public void update() {
        try {
            gameLogic.generate();
            gameLogic.playing();
            gameLogic.draw();
            score = 0;
            while (getGameState() == GameState.PLAYING) {
                gameLogic.playing();
                gameLogic.draw();
                if (gameLogic.getCountSwap() == 0 && gameLogic.getScore() > 0) {
                    gameLogic.setScore(0);
                }
                getScoreL().setFont(new Font("Arial", Font.PLAIN, 20));
                getScoreL().setText("Your score: " + gameLogic.getScore());

                getRecords().setFont(new Font("Arial", Font.PLAIN, 20));
                getRecords().setText("User         Score");

                getTime().setFont(new Font("Arial", Font.PLAIN, 20));
                getTime().setText("Time: " + TimeLimit);

                getTable().setFont(new Font("Arial", Font.PLAIN, 20));

                Thread.sleep(1000 / 40);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void addNotify() {
        super.addNotify();
        if (thread == null) {
            thread = new Thread(this);
            setGameState(GameState.PLAYING);
            thread.start();
        }
    }
}
