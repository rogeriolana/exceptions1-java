package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import apmodel.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date(dd/MM/yyy) : ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date(dd/MM/yyy) : ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Booking error: Check-out details must be later than check-in details");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation");
			System.out.print("Check-in date(dd/MM/yyy) : ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date(dd/MM/yyy) : ");
			checkOut = sdf.parse(sc.next());

			Date now = new Date();
			if (checkIn.before(now) || checkIn.before(now)) {
				System.out.println("Error in reservation dates for update must be future!");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Reservation error: Check-out date must be later than check-in date!");
			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}
		}
		sc.close();

	}

}
