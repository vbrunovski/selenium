package beauty;

public class UserProfile {
    public UserProfile(String firstname, String lastname, String email, String phoneNumber, String country,
                       String city, String district, String address, String zip, String lang) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.city = city;
        this.district = district;
        this.address = address;
        this.zip = zip;
        this.lang = lang;

    }

    public final String firstname;
    public final String lastname;
    public final String email;
    public final String phoneNumber;
    public final String country;
    public final String city;
    public final String district;
    public final String address;
    public final String zip;
    public final String lang;

}
