package javaProblemAnalyze.pattern.solid.singleResponsiblePrincibilty;

public class HTMLPrinter implements Printer {

    @Override
    public void printPage(int page) {
        System.out.println("print html text");
    }
}
