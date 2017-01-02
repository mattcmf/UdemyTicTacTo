package demos.udemytictacto;

import java.util.ArrayList;

class WinningPatterns {

    private static ArrayList<int[]> GetWinningPatterns = new ArrayList<int[]>();

    private static int[] TopRow = {1,2,3};
    private static int[] MiddleRow = {4,5,6};
    private static int[] BottomRow = {7,8,9};
    private static int[] LeftColumn = {1,4,7};
    private static int[] MiddleColumn = {2,5,8};
    private static int[] RightColumn = {3,6,9};
    private static int[] TopLeftToBottomRight = {1,5,9};
    private static int[] TopRightToBottomLeft = {3,5,7};

    //TODO: Need draw logic

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

    public static ArrayList<int[]> getGetWinningPatterns(){
        return GetWinningPatterns;
    }
}
