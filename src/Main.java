import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        checkLoginPassword("login","qwerty","qwerty");
        checkLoginPassword("login@","qwerty","qwerty");
        checkLoginPassword("login","qwerty@","qwerty");
        checkLoginPassword("login","qwerty","qwerty122");

    }

        private static void checkLogin (String login) throws WrongLoginException {
            Pattern p = Pattern.compile("^[a-z0-9_-]{1,20}$");
            if (!p.matcher(login).matches()) {
                throw new WrongLoginException("Логин не подходит: " + login);
            }
        }
        private static void checkPassword (String password, String confirmPassword) throws WrongPasswordException {
            Pattern p = Pattern.compile("^[a-z0-9_-]{1,20}$");
            if (!p.matcher(password).matches()) {
                throw new WrongPasswordException("Пароль не подходит: " + password);
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароли не совпадают");
            }
        }
        public static void checkLoginPassword (String login, String password, String confirmPassword) {
            try {
                checkLogin(login);
                checkPassword(password, confirmPassword);
            } catch (WrongLoginException | WrongPasswordException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Проверка проведена");
            }
        }
    }