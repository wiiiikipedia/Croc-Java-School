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
        source = source.replaceAll("/\\*([\\S\\s]+?)\\*/", ""); // Убираем комментарии типа /* */
        source = source.replaceAll("[^\\\"]\\/\\/.*", ""); // Убираем комментарии типа //
        return source;
    }
}
