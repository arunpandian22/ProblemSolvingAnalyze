package javaProblemAnalyze.pattern.solid.singleResponsiblePrincibilty;


public class SingleResponsibilityPrinciple {


    public static void main(String[] args) {
//        Book book = new Book();
//        System.out.println(book.getCurrentPage());

        Colours Red = null ;

        Colours Green = Colours.Green;

        Colours Brown = Colours.Brown;

        Colours Yellow = Colours.Yellow;

//        System.out.println(" Red ordinal = "+Red.ordinal());
//        System.out.println(" Red ordinal = "+Red.name());

        System.out.println(" Green Ordinal = "+Colours.values());

        System.out.println(" Brown Ordinal = "+Brown.ordinal());

        System.out.println(" Yellow Ordinal = "+Yellow.ordinal());
    }


    enum Colours{
        Red,Green,Brown,Yellow;
    }
}
