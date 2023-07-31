package api.ControllerImplService;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.el.stream.Stream;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.java.rest.api.model.User;
import com.example.java.rest.api.repository.UserRepository;

@Service
public class UserApImplService {

    private UserRepository userRepository;

    public ResponseEntity<Object> signupImplementation(@RequestBody User userFromClient) {

        List<User> userInDb = StreamSupport.stream(this.userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        for (User user : userInDb) {
            if (user.getEmail().equals(userFromClient.getEmail())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User has already sign up");
            }
        }

        User savedUser = this.userRepository.save(userFromClient);

        return ResponseEntity.ok().body(savedUser);

    }
}
