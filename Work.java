package cinema;

import java.util.Scanner;

public class Work {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int rows;
        int seats;
        do {
            System.out.println("Enter the number of rows:");
            rows = scanner.nextInt();
            System.out.println("Enter the number of seats in each row:");
            seats = scanner.nextInt();
        } while (rows > 9 && seats > 9);
        Seats cinema = new Seats(rows, seats);
        Cost cost = new Cost(cinema);
        Print print = new Print(cinema.getCinema());
        Booking booking = new Booking(cinema.getCinema(), 0, 0);
        print.printInstruction();
        boolean check = false;

        while (!check) {
            int menu = scanner.nextInt();
            if (menu == 1) {
                print.printCinema();
            } else if (menu == 2) {
                boolean loop = false;
                while (!loop) {
                    System.out.println("Enter a row number:");
                    int row = scanner.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    int seat = scanner.nextInt();
                    booking = new Booking(cinema.getCinema(), row, seat);
                    if (booking.checkError()) {
                        System.out.println("Wrong input!\n");
                        continue;
                    } else {
                        boolean book = booking.bookingSeat();
                        if (book) {
                            System.out.printf("Ticket price: $%d\n", cost.ticketPrice(row));
                            loop = true;
                        } else {
                            System.out.println("That ticket has already been purchased!");
                            continue;
                        }
                        print.printInstruction();
                    }
                }
            } else if (menu == 3) {
                print.printStatistics(booking, cost);
                print.printInstruction();
            } else if (menu == 0) {
                check = true;
            }
        }
    }
}
