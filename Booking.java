package cinema;

import java.util.Objects;

public class Booking {
    private final String[][] cinema;
    private final int row;
    private final int seat;
    private static int numberOfPurchased = 0;

    public int getNumberOfPurchased() {
        return numberOfPurchased;
    }



    public Booking(String[][] cinema, int row, int seat) {
        this.cinema = cinema;
        this.row = row;
        this.seat = seat;

    }

    public boolean checkError() {
        return row > cinema.length || seat > cinema[0].length || row < 1 || seat < 1;
    }

    public boolean bookingSeat() {
        boolean check = Objects.equals(cinema[row - 1][seat - 1], "S ");
        if(check) {
            cinema[row - 1][seat - 1] = "B ";
            numberOfPurchased++;
        }
        return check;
    }
}
