package hng.tech.PublicAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/")
public class ApiController {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter
            .ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
            .withZone(ZoneOffset.UTC);

    @GetMapping
    public Map<String, Object> getInfo() {
        Map<String, Object> response = new HashMap<>();
        response.put("email", "sanzamcmillian@gmail.com");
        response.put("current_datetime", FORMATTER.format(Instant.now()));
        response.put("github_url", "https://github.com/sanzamcmillian/Java_HNG");
        return response;
    }
}
