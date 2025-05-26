import java.util.Objects;

public class Address {
    protected String country;
    protected String city;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city);
    }

    @Override
    public boolean equals(Object obj) {
        Address address = (Address) obj;
        return country.equals(address.country) &&
                city.equals(address.city);
    }
}
