package autoriz;

public class Admin {
    private int key;
    private String login;
    private String password;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "key=" + key +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
