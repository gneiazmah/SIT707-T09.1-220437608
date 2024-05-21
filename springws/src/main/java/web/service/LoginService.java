package web.service;

public class LoginService {
    public static boolean login(String username, String password, String dob) {
        // Implement your login logic here
        return "ahsan".equals(username) && "ahsan_pass".equals(password) && "2000-01-01".equals(dob);
    }
}
