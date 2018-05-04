package beauty;

public enum Weekday {

    Monday(-400),
    Tuesday(-200),
    Wednesday(0),
    Thursday(200),
    Friday(400),
    Saturday(600),
    Sunday(-600);

    public final int offsetX;
    Weekday(int offsetX){
        this.offsetX = offsetX;
    }

}