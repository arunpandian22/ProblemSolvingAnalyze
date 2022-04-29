package javaProblemAnalyze.pattern.solid.singleResponsiblePrincibilty;

/**
 * a class will have responsibility of only book related info
 */
public class Book {
    private String title="the book";
    private String author = "arun";
    private int page=1;


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getCurrentPage() {
        return page;
    }

    public void turnPage() {
        page++;
    }

}
