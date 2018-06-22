package analysis;

public class SentimentModal {

    private int postive;

    private int negative;

    private int natural;

    public int getPostive() {
        return postive;
    }

    public void setPostive(int postive) {
        this.postive = postive;
    }

    public int getNegative() {
        return negative;
    }

    public void setNegative(int negative) {
        this.negative = negative;
    }

    public int getNatural() {
        return natural;
    }

    public void setNatural(int natural) {
        this.natural = natural;
    }

    @Override
    public String toString() {
        return "SentimentModal{" +
                "postive=" + postive +
                ", negative=" + negative +
                ", natural=" + natural +
                '}';
    }
}
