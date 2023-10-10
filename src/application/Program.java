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
		System.out.print("Data de check-in(dd/MM/yyy) : ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data de check-out(dd/MM/yyy) : ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Erro de reserva: os dados de check-out devem ser posteriores aos dados de check-in");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reserva: " + reservation);

			System.out.println();
			System.out.println("Insira os dados para atualizar a reserva:");
			System.out.print("Check-in data(dd/MM/yyy) : ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out data(dd/MM/yyy) : ");
			checkOut = sdf.parse(sc.next());

			Date now = new Date();
			if (checkIn.before(now) || checkIn.before(now)) {
				System.out.println("Erro nas datas de reserva para atualização deve ser futuro!");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Erro de reserva: A data de check-out deve ser posterior à data de check-in!");
			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reserva: " + reservation);
			}
		}
		sc.close();

	}

}
