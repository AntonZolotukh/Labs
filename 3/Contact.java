public class Contact {
    private String name;
    private String email;
    private String additionalInfo;

    public Contact(String name, String email, String additionalInfo) {
        this.name = name;
        this.email = email;
        this.additionalInfo = additionalInfo;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString() {
        return "Contact{name='" + name + "', email='" + email + "', additionalInfo='" + additionalInfo + "'}";
    }
}
