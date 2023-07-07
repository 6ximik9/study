package bejeweled;


import bejeweled.components.GameLogic;
import bejeweled.components.Player;
import bejeweled.server.clients.CommentServiceRestClient;
import bejeweled.server.clients.RatingServiceRestClient;
import bejeweled.server.clients.ScoreServiceRestClient;
import bejeweled.server.clients.UserServiceRestClient;
import bejeweled.service.*;
import bejeweled.ui.view.GameUI;
import bejeweled.ui.view.SwingUI;
import bejeweled.ui.view.ratingForm;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,
        pattern = "bejeweled.server.*"))
public class SpringClient{

    public static void main(String[] args) {
//        SpringApplication.run(SpringClient.class);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringClient.class);

        builder.headless(false);
        builder.web(WebApplicationType.NONE).run(args);

        ConfigurableApplicationContext context = builder.run(args);

//        String[] beanNames = context.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }

    }

    @Bean
    public CommandLineRunner commandLineRunner(SwingUI swingUI)
    {
       return s -> swingUI.showGame();
    }

    @Bean
    public SwingUI swingUI(){
        return new SwingUI(ratingService());
    }

    @Bean
    public GameLogic gameLogic()
    {
        return new  GameLogic();
    }

    @Bean
    public GameUI gameUI()
    {
        return new GameUI(scoreService());
    }

    @Bean
    public ratingForm rating_Form()
    {
        return new ratingForm(commentService(), ratingService());
    }

    @Bean
    public CommentService commentService() {
        //return new CommentServiceJPA();
        return new CommentServiceRestClient();
    }

    @Bean
    public UserService userService() {
        //return new UserServiceJPA();
        return new UserServiceRestClient();
    }

    @Bean
    public RatingService ratingService()
    {
//        return new RatingServiceJPA();
        return new RatingServiceRestClient();
    }

    @Bean
    public ScoreService scoreService() {
        //return new ScoreServiceJPA();
        return new ScoreServiceRestClient();
    }

    @Bean
    public Player player()
    {
        return new Player("", 0);
    }


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
