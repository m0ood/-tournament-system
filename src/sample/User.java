package sample;

public class User {
    private int Id;
    private String Quantity;
    private String Login;
    private String Password;

    public User() {

    }
    public int getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
