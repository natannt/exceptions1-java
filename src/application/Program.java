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

			// Atualizando a reserva.
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			// Instanciando o objeto now, para verificar se a data é antes da data atual
			// para gerar a critica no programa
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future.");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date.");
			} else {

				// Depois de lida as novas datas, atualizar as datas.
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);

			}

		}

		sc.close();
	}

}
