public class Main {

    private static final String REGEX = "^[a-zA-Z0-9_]*$";

    public static void main(String[] args) {
        System.out.println(isStringCorrect("ageswhAsthsrhs"));
try{
        check("admin", "qwe123qwe1", "qwe123qwe1");
    System.out.println("Проверка пройдена!");
    } catch(WrongLoginException | WrongPasswordException e)
    {
        System.out.println(e.getMessage());
    }

}


    public static void check(String login, String password, String confirmPassword) {
        if (!login.matches(REGEX)) {
            throw new WrongLoginException("В логине есть запрещенный символ ");
        }
        if (login.length() > 20) {
            throw new WrongLoginException("Длинна логина больше 20 символов ");
        }
        if (!password.equals(confirmPassword)){
            throw new WrongPasswordException("Пароли не совпадают");
        }
        if (password.length()>20){
            throw new WrongPasswordException("Длинна пароля больше 20 символов");
        }
        if (!isStringCorrect(password)){
            throw new WrongPasswordException("Пароль содержит некорректный символ");
        }

    }
    private static boolean isStringCorrect(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z') ||
                    ('1' <= ch && ch <= '9') || (ch == '_')) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}


