package demos.udemytictacto;

import java.util.ArrayList;

class WinningPatterns {

    private static ArrayList<ArrayList<Integer>> GetWinningPatterns = new ArrayList();

    private static  ArrayList<Integer> TopRow = new ArrayList<Integer>() {{ add(1); add(2); add(3); }};
    private static  ArrayList<Integer> MiddleRow = new ArrayList<Integer>() {{ add(4); add(5); add(6); }};
    private static  ArrayList<Integer> BottomRow = new ArrayList<Integer>() {{add(7); add(8); add(9); }};
    private static  ArrayList<Integer> LeftColumn = new ArrayList<Integer>(){{ add(1); add(4); add(7); }};
    private static  ArrayList<Integer> MiddleColumn = new ArrayList<Integer>() {{ add(2); add(5); add(8); }};
    private static  ArrayList<Integer> RightColumn = new ArrayList<Integer>() {{ add(3); add(6); add(9); }};
    private static  ArrayList<Integer> TopLeftToBottomRight = new ArrayList<Integer>() {{add(1); add(5); add(9); }};
    private static  ArrayList<Integer> TopRightToBottomLeft = new ArrayList<Integer>() {{add(3); add(5); add(7); }};

    static void Setup() {
        GetWinningPatterns.add(TopRow);
        GetWinningPatterns.add(MiddleRow);
        GetWinningPatterns.add(BottomRow);
        GetWinningPatterns.add(LeftColumn);
        GetWinningPatterns.add(MiddleColumn);
        GetWinningPatterns.add(RightColumn);
        GetWinningPatterns.add(TopLeftToBottomRight);
        GetWinningPatterns.add(TopRightToBottomLeft);
    }

    public static ArrayList<ArrayList<Integer>> getGetWinningPatterns(){
        return GetWinningPatterns;
    }
}
