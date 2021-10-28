public class Application {
    public static void main(String[] args) {
        String source = "/*\n" +
                " * My first ever program in Java!\n" +
                " */\n" +
                "class Hello { // class body starts here \n" +
                "  \n" +
                "  /* main method */\n" +
                "  public static void main(String[] args/* we put command line arguments here*/) {\n" +
                "    // this line prints my first greeting to the screen\n" +
                "    System.out.println(\"Hi!\"); // :)\n" +
                "  }\n" +
                "} // the end\n" +
                "// to be continued...";
        String noComment = removeJavaComments(source);
        System.out.print(noComment);
    }

    private static String removeJavaComments(String source) {
        StringBuilder builder = new StringBuilder();
        boolean temp = false;
        for (int i = 1; i < source.length(); i++) {
            if ((int) source.charAt(i-1) == 47 && (int) source.charAt(i) == 42) { // коммент типа /* */
                if (!builder.isEmpty()) builder.deleteCharAt(builder.length()-1);
                while (!temp && i < source.length()) {
                    i++;
                    if ((int) source.charAt(i-1) == 42 && (int) source.charAt(i) == 47) temp = true;
                }
                temp = false;
            } else if ((int) source.charAt(i-1) == 47 && (int) source.charAt(i) == 47) { // Коммент типа //
                if (!builder.isEmpty()) builder.deleteCharAt(builder.length()-1);
                while (!temp && i < source.length()) {
                    i++;
                    if ((int) source.charAt(i-1) == 10 && (int) source.charAt(i) == 32) temp = true;
                }
                temp = false;
            } else builder.append(source.charAt(i));
        }
        return builder.toString();
    }
}
