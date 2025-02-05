package hang.tech.numbers_api;

import java.util.List;


public class NumberResponse {
    private int number;
    private boolean isPrime;
    private boolean isPerfect;
    private List<String> properties;
    private  int digitSum;
    private  String funFact;

    public NumberResponse(int number, boolean isPrime, boolean isPerfect, List<String> properties, int digitSum, String funFact) {
        this.number = number;
        this.isPrime = isPrime;
        this.isPerfect = isPerfect;
        this.properties = properties;
        this.digitSum = digitSum;
        this.funFact = funFact;
    }


    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setDigitSum(int digitSum) {
        this.digitSum = digitSum;
    }

    public int getDigitSum() {
        return digitSum;
    }

    public void setPerfect(boolean perfect) {
        isPerfect = perfect;
    }

    public boolean isPerfect() {
        return isPerfect;
    }

    public void setPrime(boolean prime) {
        isPrime = prime;
    }

    public boolean isPrime() {
        return isPrime;
    }

    public void setProperties(List<String> properties) {
        this.properties = properties;
    }

    public List<String> getProperties() {
        return properties;
    }

    public void setFunFact(String funFact) {
        this.funFact = funFact;
    }

    public String getFunFact() {
        return funFact;
    }
}
