package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		// Ler o numero do quarto, a data de checkin e a data de checkout.
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next()); // Vai entrar a data em formato de texto e o SDF vai converter para Date.
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next()); // Vai entrar a data em formato de texto e o SDF vai converter para Date.

		// Para instaciar a reserva a data de checkIn não pode ser posterior a checkout
		// Método de teste
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date.");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			// Atualizando a reserva
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			 	// Depois de lida as novas datas, atualizar as datas
				String error = reservation.updateDates(checkIn, checkOut);
				if (error != null) {
					System.out.println("Error in reservation: " + error);
				}
				else {
				System.out.println("Reservation: " + reservation);
			}
				

		}

		sc.close();
	}

}
