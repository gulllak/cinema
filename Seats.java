package cinema;

public class Seats {
    private final int rows;
    private final int seats;
    private final String[][] cinema;

    public Seats(int rows, int seats) {
        this.rows = rows;
        this.seats = seats;
        cinema = new String[rows][seats];
        createCinema(rows, seats);
    }

    private void createCinema(int rows, int seats) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                cinema[i][j] = "S ";
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getSeats() {
        return seats;
    }

    public String[][] getCinema() {
        return cinema;
    }
}
