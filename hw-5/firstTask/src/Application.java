public class Application {
    public static void main(String[] args) throws InterruptedException {

        if (args == null || args.length != 2) {
            throw new IllegalArgumentException("Program expect 2 argument!");
        }
        int countFlow = Integer.getInteger(args[0]);
        String trueHash = args[1];


        //на вот этих примерах работало с разным кол-вом потоков :)
        //int countFlow = 5;
        //String trueHash = "0cc175b9c0f1b6a831c399e269772661"; //a
        //String trueHash = "4124bc0a9335c27f086f24ba207a4912"; //aa


        //String trueHash = "40682260cc011947fc2d0b1a927138c5"; //passwrd

        for (int i = 0; i < countFlow; ++i) {
            Hash h = new Hash(trueHash);
            Thread thread = new HashThread(h);
            thread.run();
            //thread.join();
        }
    }
}