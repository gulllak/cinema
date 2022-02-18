package cinema;

public class Cost {
    private final Seats seats;
    private static int sumPrice = 0;

    public int getNumberSeats() {
        return numberSeats;
    }

    private final int numberSeats;

    public Cost(Seats seats) {
        this.seats = seats;
        this.numberSeats = seats.getSeats() * seats.getRows();
    }

    public int calculateProfit() {
        if(numberSeats >= 0 && numberSeats <= 60) {
            return numberSeats * 10;
        } else {
            if(numberSeats > 60 && seats.getRows() % 2 == 0) {
                return (10 * seats.getRows()/2 * seats.getSeats()) + (8 * seats.getRows()/2 * seats.getSeats());
            } else {
                return (10 * (seats.getRows()/2) * seats.getSeats()) + (8 * seats.getSeats() * (seats.getRows() - (seats.getRows()/2)));
            }
        }
    }

    public static int getSumPrice() {
        return sumPrice;
    }

    public int ticketPrice(int row) {
        if(numberSeats >= 0 && numberSeats <= 60) {
            sumPrice += 10;
            return 10;
        } else {
            if(row <= seats.getRows()/2) {
                sumPrice += 10;
                return 10;
            } else {
                sumPrice += 8;
                return 8;
            }
        }
    }
}
