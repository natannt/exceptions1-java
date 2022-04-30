package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	// Atributs
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	//Formatando a data conforme pedido.
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

	// Constructors
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	// Getters and Setters
	// setCheckin e setCheckOut apagados, pois as datas vão ser alteradas por meio
	// de métodos.
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	// Methods
	
	// Calculando a diferença entre duas datas.
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime(); // Devolve a quantidade de milisegundos da diferença entre
															// as duas datas.
		// Convertendo milisegundos para dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // Converde o valor de diff em milisegunos para dias.
	}
	
	// Update dates
	public void updateDates(Date checkIn, Date checkOut) {
		this.checkIn = checkIn; // checkIn objeto recebe o checkIn do argumento.
		this.checkOut = checkOut; // checkOut obejto recebe o checkOut argumento.
	}
	
	// toString para imprimir valores na tela
	
	@Override
	public String toString() {
		return "Romm "
			+ roomNumber
			+ ", check-in: "
			+ sdf.format(checkIn)
			+ ", check-out: "
			+ sdf.format(checkOut)
			+ ", "
			+ duration()
			+ " nights";
	}
}
