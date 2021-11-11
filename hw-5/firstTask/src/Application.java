public class Application {
    public static void main(String[] args) {

        //if (args == null || args.length != 2) {
        //    throw new IllegalArgumentException("Program expect 2 argument!");
        //}
        //int countFlow = Integer.getInteger(args[0]);
        //String password = args[1];

        int countFlow = 1;
        String trueHash = "40682260cc011947fc2d0b1a927138c5"; //passwrd

        for (int i = 0; i < countFlow; ++i) {
            Hash hash = new Hash(trueHash);
            hash.run("");
        }
    }
}
