package bejeweled.server;

import bejeweled.server.clients.UserServiceRestClient;
import bejeweled.server.controller.UserController;
import bejeweled.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Configuration
@EntityScan(basePackages = "bejeweled.entity")
public class GameStudioServer {
    public static void main(String[] args) {
        SpringApplication.run(GameStudioServer.class);
//      SpringApplicationBuilder builder = new SpringApplicationBuilder(GameStudioServer.class);
//
//        builder.headless(false);
//
//        ConfigurableApplicationContext context = builder.run(args);
    }

    @Bean
    public ScoreService scoreService() {
        return new ScoreServiceJPA();
    }

    @Bean
    public CommentService commentService() {
        return new CommentServiceJPA();
    }

    @Bean
    public RatingService ratingService() {
        return new RatingServiceJPA();
    }

    @Bean
    public UserService userService() {
        return new UserServiceJPA();
    }

    @Bean
    public UserController userController() {
        return new UserController();
    }


}

