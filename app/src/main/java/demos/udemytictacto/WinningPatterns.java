package demos.udemytictacto;

import java.util.ArrayList;

public class WinningPatterns {

    //TODO: Need to test all winning patterns
    //TODO: Need draw logic

    public static ArrayList getTop() {
        return new ArrayList() {{
            add(1);
            add(2);
            add(3);
        }};
    }

    public static ArrayList middle() {
        return new ArrayList() {{
            add(4);
            add(5);
            add(6);
        }};
    }

    public static ArrayList bottom() {
        return new ArrayList() {{
            add(7);
            add(8);
            add(9);
        }};
    }

    public static ArrayList topLeftToBottomRight() {
        return new ArrayList() {{
            add(1);
            add(5);
            add(9);
        }};
    }

    public static ArrayList topRightToBottomLeft() {
        return new ArrayList() {{
            add(3);
            add(5);
            add(7);
        }};
    }
}
