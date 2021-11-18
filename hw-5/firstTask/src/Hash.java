import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash implements  Runnable{

    boolean flag = true;
    public  String trueHash;
    public static String hash = "";
    public static String password = "";

    private static final char[] letters = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] digits = "0123456789abcdef".toCharArray();

    public Hash (String hash) {
        this.trueHash = hash;
    }

    private static String toHexString(byte[] bytes) {
        StringBuilder hex = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            hex.append(digits[(b & 0xff) >> 4]);
            hex.append(digits[b & 0x0f]);
        }
        return hex.toString();
    }

    private static String hashPassword(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        digest.update(password.getBytes());
        byte[] bytes = digest.digest();
        return toHexString(bytes);
    }

    public void run(String s) {
            //while (flag)


                if (!password.isEmpty()) {
                    System.out.println(password);
                    //return;
                    System.exit(0);
                }

                if (s.length() == 2) {
                    String ans = hashPassword(s);
                    if (ans.equals(trueHash)) {
                        hash = ans;
                        password = s;
                        flag = false;
                        //return;
                    }
                    else {
                        s = s.substring(0, s.length() - 1); //перебираем символы для последнего символа
                        for (char l : letters) {
                            run(s + l);
                        }
                    }
                }
                if (flag) {
                    for (char l : letters) {
                        run(s + l);
                    }
                }

            return;
    }
}