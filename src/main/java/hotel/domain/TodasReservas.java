package hotel.domain;

import java.util.Calendar;
import java.util.List;

public interface TodasReservas {

	List<Reserva> getListaReservas(String parteNome);

	Reserva get(Long reservaId);

	void add(Reserva reserva);

	List<Quarto> getQuartosDisponiveisPorPeriodo(Calendar checkin,
			Calendar checkout);

}
