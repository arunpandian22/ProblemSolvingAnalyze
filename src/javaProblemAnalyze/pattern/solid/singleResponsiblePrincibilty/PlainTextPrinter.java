package javaProblemAnalyze.pattern.solid.singleResponsiblePrincibilty;


public class PlainTextPrinter implements Printer {

    @Override
    public void printPage(int page) {
        System.out.println("print plain text");
    }
}
