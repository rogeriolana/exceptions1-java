package apmodel.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.excepitions.DomainException;

public class Reservation {


	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut)  {
		if (!checkOut.after(checkIn)) {
			throw new DomainException("A data de check-out deve ser posterior à data de check-in!");
		} 
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

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

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkIn, Date checkOut)  {
		
		Date now = new Date();
		if (checkIn.before(now) || checkIn.before(now)) {
			throw new DomainException("Erro nas datas de reserva para atualização deve ser futuras!");
		}  
		if (!checkOut.after(checkIn)) {
			throw new DomainException("A data de check-out deve ser posterior à data de check-in!");
		} 
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}

	@Override
	public String toString() {
		return "Quarto : " + roomNumber + " , check-in: " + sdf.format(checkIn) + " , check-out: " + " , " + duration()
				+ " noites ";
	}
}
