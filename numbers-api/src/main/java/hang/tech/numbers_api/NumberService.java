package hang.tech.numbers_api;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import  java.util.List;

@Service
public class NumberService {

    public NumberResponse classifyNumber(int num) {
        List<String> properties = new ArrayList<>();
        if (isArmstrong(num)) {
            properties.add("armstrong");
        }
        if (num % 2 == 0) {
            properties.add("even");
        }
        else {
            properties.add("odd");
        }

        int digitSum = (num < 0) ? -sumDigits(-num) : sumDigits(num);

        return new NumberResponse(
                num,
                isPrime(num),
                isPerfect(num),
                properties,
                digitSum,
                getFunFact(num)
        );
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private boolean isPerfect(int n) {
        if (n < 1) return  false;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) sum += i;
        }
        return sum == n;
    }

    private boolean isArmstrong(int n) {
        if (n < 0) return false;
        int temp = n, sum = 0, digits = String.valueOf(n).length();
        while (temp > 0) {
            int d = temp % 10;
            sum += Math.pow(d, digits);
            temp /= 10;
        }
        return sum == n;
    }

    private int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    private String getFunFact(int n) {
        RestTemplate restTemplate = new RestTemplate();
        try{
            return restTemplate.getForObject("http://numbersapi.com" + n + "/math", String.class);
        } catch (Exception e) {
            return n + " is an interesting number!";
        }
    }
}
