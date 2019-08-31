package Java8.SOILD.SingleResponsibility.violate;

public class Text {
    private String text;
    private String author;
    private int length;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // methods that directly relate to the book properties
    public String replaceWordInText(String word){
        return text.replaceAll(word, text);
    }

    public boolean isWordInText(String word){
        return text.contains(word);
    }

    //Violate Single Responsibility
    public void printTextToConsole(){
        // Code for formatting and printing the text
    }

    //Violate Single Responsibility
    void printTextToAnotherMedium(String text){
        // Code for writing to any other location..
    }

    @Override
    public String toString() {
        return "Text{" +
                "text='" + text + '\'' +
                ", author='" + author + '\'' +
                ", length=" + length +
                '}';
    }
}
