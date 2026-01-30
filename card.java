//Ethan Pham
//CS1400
//Assignment 4
//11/25/25



public class card {

    // fields
    private String face;
    private String suit;
    private int value;

    // constructor

    public card(String inFace, String inSuit, int inValue)
    {
        face = inFace;
        suit = inSuit;
        value = inValue;
    }

    // getters

    public String getFace()
    {
        return face;
    }

    public String getSuit()
    {
        return suit;
    }

    public int getValue()
    {
        return value;
    }

    // setters

    public void setFace(String inFace)
    {
        face = inFace;
    }

    public void setSuit(String inSuit)
    {
        suit = inSuit;
    }

    public void setValue(String inValue)
    {
        value = inValue;
    }
}
