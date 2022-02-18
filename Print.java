package cinema;

public class Print {
    private final String[][] cinema;

    public Print(String[][] cinema) {
        this.cinema = cinema;
    }

    public void printCinema() {
        int rows = cinema.length;
        int seats = cinema[0].length;
        System.out.println("Cinema:");
        for(int i = 0; i <= rows; i++){
            if(i != 0) {
                System.out.print(i + " ");
            }
            for(int j = 0; j < seats; j++) {
                if(i == 0){
                    if(j == 0) {
                        System.out.print(" ");
                    }
                    System.out.print(" " + (j + 1));
                } else {
                    System.out.print(cinema[i-1][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
        printInstruction();
    }

    public void printInstruction() {
        System.out.println("\n1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public void printStatistics(Booking booking, Cost cost) {
        System.out.println("Number of purchased tickets: " + booking.getNumberOfPurchased());
        System.out.printf("Percentage: %.2f",  ((double)(booking.getNumberOfPurchased() * 100)/cost.getNumberSeats()));
        System.out.println("%");
        System.out.println("Current income: $" + Cost.getSumPrice());
        System.out.println("Total income: $" + cost.calculateProfit());
    }
}
