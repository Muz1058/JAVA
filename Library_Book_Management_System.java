class Book{
    private String isbn;
    private String title;
    private String author;
    private int availableCopies;
    private double [] rating;
    public Book(){
        isbn="----";
        title="----";
        author="----";
        availableCopies=0;
        rating=new double[5];
    }

    public Book(String isbn, String title, String author, int availableCopies, double[] rating) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
        rating=new double[5];
        for (int i = 0; i < rating.length; i++) {
            this.rating[i]=rating[i];
        }

    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        if(availableCopies>0)
        {
            this.availableCopies = availableCopies;
        }
    }

    public double[] getRating() {
        return rating;
    }

    public void setRating(double[] rating) {
        for (int i = 0; i < rating.length; i++) {
            if(rating[i]>=0.0&&rating[i]<=5.0)
            {
                this.rating[i]=rating[i];
            }
        }
    }

    public double calculateAverageRating(){
        double sum=0.0;
        int size= rating.length;;
        for (int i = 0; i < size; i++) {
            sum+=this.rating[i];
        }
        sum/=size;
        return sum;
    }


}


public class Library_Book_Management_System {
    public static void main(String[] args) {

    }
}
