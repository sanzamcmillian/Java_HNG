package hang.tech.numbers_api;

import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class NumberController {
    private final NumberService numberService;

    public  NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    @GetMapping("/classify-number")
    public Object classifyNumber(@RequestParam String number) {
        try {
            int num = Integer.parseInt(number);
            return numberService.classifyNumber(num);
        } catch (NumberFormatException e) {
            return new ErrorResponse(number,true);
        }
    }
}


class ErrorResponse {
    private final String number;
    private final boolean error;

    public ErrorResponse(String number, boolean error) {
        this.number = number;
        this.error = error;
    }

    public String getNumber() {
        return number;
    }

    public  boolean isError() {
        return error;
    }
}
