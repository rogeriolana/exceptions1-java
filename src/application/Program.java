package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import apmodel.entities.Reservation;
import model.excepitions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

		try {
		    System.out.print("Numero do quarto: ");
		    int number = sc.nextInt();
		    System.out.print("Data de check-in(dd/MM/yyy) : ");
		    Date checkIn = sdf.parse(sc.next());
		    System.out.print("Data de check-out(dd/MM/yyy) : ");
		    Date checkOut = sdf.parse(sc.next());

		    Reservation reservation = new Reservation(number, checkIn, checkOut);
		    System.out.println("Reserva: " + reservation);

		    System.out.println();
		    System.out.println("Insira os dados para atualizar a reserva");
		    System.out.print("Data de check-in(dd/MM/yyy) : ");
		    checkIn = sdf.parse(sc.next());
		    System.out.print("Data de chec-out(dd/MM/yyy) : ");
		    checkOut = sdf.parse(sc.next());

		    reservation.updateDates(checkIn, checkOut);
 
		    System.out.println("Reserva: " + reservation);
		}
		
		catch (ParseException e) {
			System.out.println("Formato de data inválido");
		}
		catch (DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		
		sc.close();

	}

}
