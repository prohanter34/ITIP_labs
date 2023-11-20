package lab8;

public class People {
    private String name;
    private float currency;
    private String country;
    private String email;

    public People(String name,String country, float currency, String email) {
        this.name = name;
        this.currency = currency;
        this.country = country;
        this.email = email;
    }

    @Override
    public String toString() {
        return name + "," + country + "," + currency + "," + email;
    }

    public String getName() {
        return name;
    }

    public float getCurrency() {
        return currency;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }
}
