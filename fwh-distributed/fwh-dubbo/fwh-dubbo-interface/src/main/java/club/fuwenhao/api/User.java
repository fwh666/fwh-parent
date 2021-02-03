package club.fuwenhao.api;

/**
 * @author fwh [2021/2/2 && 4:03 下午]
 * @return
 */
public class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
