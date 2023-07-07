package bejeweled.ui.view;

import bejeweled.components.GameLogic;
import bejeweled.components.Player;
import bejeweled.entity.Rating;
import bejeweled.entity.User;
import bejeweled.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;


public class SwingUI extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JLabel titleLabelUser;
    private JLabel loginLabel;
    private JLabel passwordLabel;

    private JTextField loginField;
    private JPasswordField passwordField;

    private JButton loginButton;
    private JButton commentButton;


    //private GameLogic logic;

    @Autowired
    private UserService userService;


    private RatingService ratingService;

    @Autowired
    GameUI gameUI;

    @Autowired
    public SwingUI(RatingService ratingService) {
        this.ratingService = ratingService;
        createForm();
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowOpened(WindowEvent e) {
//                titleLabel.setText("Game rating: " + ratingService.getAverageRating("bejeweled"));
//                titleLabelUser.setText("Game was rated by " +ratingService.getCountRating("bejeweled") +  " people");
//            }
//        });
    }


    private void createForm()
    {
        //controller = new uiController();
        setTitle("Login");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        // Create and add components to the form
        //RatingService ratingService = new RatingServiceJDBC();
        titleLabel = new JLabel("Game rating: " + ratingService.getAverageRating("bejeweled"));
//        titleLabel = new JLabel("Game rating: ");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.LEFT);

        titleLabelUser = new JLabel("Game was rated by " + ratingService.getCountRating("bejeweled") +  " people");
//        titleLabelUser = new JLabel("Game was rated by "  + " people");
        titleLabelUser.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabelUser.setHorizontalAlignment(SwingConstants.LEFT);

        loginLabel = new JLabel("Login:");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 24));
        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 24));

        loginField = new JTextField();
        loginField.setFont(new Font("Arial", Font.BOLD, 24));
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.BOLD, 24));

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 24));
        loginButton.setHorizontalAlignment(SwingConstants.CENTER);
        loginButton.addActionListener(this);
        commentButton = new JButton("Comment");
        commentButton.setFont(new Font("Arial", Font.BOLD, 24));
        commentButton.addActionListener(this);


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(loginLabel);
        panel.add(loginField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel(""));

        JPanel panelTitle = new JPanel();
        panelTitle.setLayout(new GridLayout(2, 1));
        panelTitle.add(titleLabel);
        panelTitle.add(titleLabelUser);
        add(panelTitle, BorderLayout.NORTH);

        add(panel, BorderLayout.CENTER);
        //add(loginButton, BorderLayout.SOUTH);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 1));
        panel1.add(loginButton);
        panel1.add(commentButton);
        add(panel1, BorderLayout.SOUTH);
    }
    public void showGame()
    {
        setVisible(true);
    }

    // Getter methods for login and password fields
    public String getLogin() {
        return loginField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == commentButton) {
            new TableForm();
        }
        else if (event.getSource() == loginButton) {
            try {
               int result = login(loginField.getText(), String.copyValueOf(passwordField.getPassword()));
               if(result==1)
               {
                   dispose();
               }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    void registrationUser(String login, String pass) throws Exception {
        //UserService userService = new UserServiceJDBC();
        userService.addUser(new User(login, pass));
    }


    public int login(String login, String pass) throws Exception {
        User user = userService.getUser(login);

        if(user!=null && Objects.equals(user.getPass(), pass))
        {
            JOptionPane.showMessageDialog(null, "Successful authorization");
            //gameUI.setPlayer(new Player(login, 0));
            //gameUI = new GameUI();
            gameUI.setPlayer(new Player(login, 0));
            gameUI.startGame();
            return 1;
        }
        else if(user!=null && !Objects.equals(user.getPass(), pass))
        {
            JOptionPane.showMessageDialog(null, "Error password");
        }
        else {
            int result = JOptionPane.showConfirmDialog(
                    null,
                    "Account does not exist, do I need to create one??",
                    "Create account",
                    JOptionPane.YES_NO_OPTION);

            if(result==JOptionPane.YES_OPTION)
            {
                registrationUser(login, pass);
            }
        }
        return 0;
    }

}

