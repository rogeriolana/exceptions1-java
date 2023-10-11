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

		System.out.print("Numero do quarto: ");
		int number = sc.nextInt();
		System.out.print("Data de check-in(dd/MM/yyy) : ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data de check-out(dd/MM/yyy) : ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Erro de reserva: os detalhes do check-out devem ser posteriores aos detalhes do check-in");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reserva: " + reservation);

			System.out.println();
			System.out.println("Insira os dados para atualizar a reserva");
			System.out.print("Data de check-in(dd/MM/yyy) : ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de chec-out(dd/MM/yyy) : ");
			checkOut = sdf.parse(sc.next());

	
			
				String error = reservation.updateDates(checkIn, checkOut);
				if (error != null) {
					System.out.println("Erro na reserva" + ":" + error);
				}
				else {
				System.out.println("Reserva: " + reservation);
				}
		}
		sc.close();

	}

}
