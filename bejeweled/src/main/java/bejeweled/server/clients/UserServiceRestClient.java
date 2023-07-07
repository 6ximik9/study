package bejeweled.server.clients;

import bejeweled.entity.Rating;
import bejeweled.entity.Score;
import bejeweled.entity.User;
import bejeweled.service.UserException;
import bejeweled.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UserServiceRestClient implements UserService {

    private final String url = "http://localhost:8080/api/users";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addUser(User user) throws UserException {
        restTemplate.postForEntity(url, user, User.class);
    }

    @Override
    public User getUser(String login) throws UserException {
        ResponseEntity<User> response = restTemplate.getForEntity(url + "/" + login, User.class);
        return response.getBody();
    }

    @Override
    public List<User> getAllUser() throws UserException {
        return Arrays.asList(Objects.requireNonNull(
                restTemplate.getForEntity(url + "/all", User[].class).getBody()
        ));
    }
}
