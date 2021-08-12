package sample;
import java.io.File;
import java.io.PrintWriter;

public class P4Data {
    private String name;
    private String email;
    private String theme;
    private String toggleColor;
    private String toggleFinish;
    private String quote;
    private String left;
    private String right;
    private String addOn1;
    private String addOn2;
    private String addOn3;
    private int volume;

    public P4Data() {
        name = "Quay";
        email = "jminnich@cnm.edu";
        theme = "";
        volume = 0;
        toggleColor = "Black";
        toggleFinish = "Matte";
        quote = "\"";
        left = "left ear";
        right = "right ear";
        addOn1 = "Planar Magnetic";
        addOn2 = "Microphone";
        addOn3 = "Case";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getToggleColor() {
        return toggleColor;
    }

    public void setToggleColor(String toggleColor) {
        this.toggleColor = toggleColor;
    }

    public String getToggleFinish() {
        return toggleFinish;
    }

    public void setToggleFinish(String toggleFinish) {
        this.toggleFinish = toggleFinish;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public String getAddOn1() {
        return addOn1;
    }

    public void setAddOn1(String addOn1) {
        this.addOn1 = addOn1;
    }

    public String getAddOn2() {
        return addOn2;
    }

    public void setAddOn2(String addOn2) {
        this.addOn2 = addOn2;
    }

    public String getAddOn3() {
        return addOn3;
    }

    public void setAddOn3(String addOn3) {
        this.addOn3 = addOn3;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Thank you for choosing Quay Bass, " + name + "!\n"
                + "We have your account on file..."
                + "\nFinish your order in the next 15 days and get 15% off!"
                + "\n\nHere are your current order details: "
                + "Theme: " + theme + "\n"
                + "Volume Boost: " + volume + "\n"
                + "Color: " + toggleColor + "\n"
                + "Finish: " + toggleFinish + "\n"
                + "Personalized left ear: " + quote + left + quote + "\n"
                + "Personalized right ear: " + quote + right + quote + "\n"
                + "Add ons: " + addOn1 + ", " + addOn2 + ", " + addOn3 + "\n";
    }

    public void writeFile(File file) throws Exception
    {
        PrintWriter writer = new PrintWriter(file);
        String s = this.toString();
        writer.println(s);
        writer.close();

    }
}


