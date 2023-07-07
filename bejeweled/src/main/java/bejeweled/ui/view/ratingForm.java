package bejeweled.ui.view;

import bejeweled.components.Player;
import bejeweled.entity.Comment;
import bejeweled.entity.Rating;
import bejeweled.service.CommentService;
import bejeweled.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ratingForm extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JLabel ratingLabel;
    private JLabel commentLabel;

    public JTextArea commentField;

    public JComboBox<Integer> ratingComboBox;

    public JButton submitButton;

    private Player player;

    private CommentService commentService;


    private RatingService ratingService;


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


    private GameUI gameUI;


    @Autowired
    public ratingForm(CommentService commentService, RatingService ratingService) {
        this.commentService = commentService;
        this.ratingService = ratingService;
        setTitle("Rating Form");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // Create and add components to the form
        titleLabel = new JLabel("Please rate my game:");
        ratingLabel = new JLabel("Rating:");
        commentLabel = new JLabel("Comment:");

        commentField = new JTextArea();
        commentField.setLineWrap(true);

        Integer[] ratings = {1, 2, 3, 4, 5};
        ratingComboBox = new JComboBox<>(ratings);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(titleLabel);
        panel.add(new JLabel(""));
        panel.add(ratingLabel);
        panel.add(ratingComboBox);
        panel.add(commentLabel);
        panel.add(commentField);

        add(panel, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);

        setVisible(false);

    }


    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == submitButton) {
            addRatingAndComment((int)ratingComboBox.getSelectedItem(), commentField.getText(), player);
        }
    }

    private void addRatingAndComment(int rating, String comment, Player player)
    {
        System.out.println(rating);
        if (!isValidString(comment) && (rating<1 || rating>5)) {
            JOptionPane.showMessageDialog(null, "An error occurred", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Do something with the rating and comment, e.g. save to a database
        System.out.println("Rating: " + rating);
        System.out.println("Comment: " + comment);

        //RatingService ratingService = new RatingServiceJDBC();
        //CommentService commentService = new CommentServiceJDBC();
        ratingService.setRating(new Rating(player.getLogin(), "bejeweled", rating, new Date()));
        commentService.addComment(new Comment(player.getLogin(), "bejeweled", comment, new Date()));

        // Show a message to the user to confirm the submission
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Thank you for your rating!");
        System.exit(0);
//        int option = JOptionPane.showOptionDialog(null, "Do you want play again?", "Confirmation",
//                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
//        if (option == JOptionPane.YES_OPTION) {
//            dispose();
//
////            gameUI.setPlayer(player);
////            gameUI.startGame();
//        } else if (option == JOptionPane.NO_OPTION) {
//            System.exit(0);
//        } else {
//            System.exit(0);
//        }
    }

    public boolean isValidString(String str)
    {
        // Перевіряємо, чи є рядок порожнім або null
        if (str == null || str.isEmpty()) {
            return false;
        }
        // Перевіряємо, чи містить рядок тільки англійські літери та пробіли
        if (!str.matches("[a-zA-Z ]+")) {
            return false;
        }
        // Перевіряємо, чи містить рядок хоча б одну букву
        if (!str.matches(".*[a-zA-Z].*")) {
            return false;
        }
        return true;
    }

    public void showRating()
    {
        this.setVisible(true);
    }

}
