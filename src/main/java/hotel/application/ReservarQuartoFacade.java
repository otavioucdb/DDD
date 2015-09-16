package hotel.application;

import hotel.domain.Hospede;
import hotel.domain.Quarto;
import hotel.domain.Reserva;

import java.util.Calendar;
import java.util.List;

public interface ReservarQuartoFacade {

	List<Quarto> getQuartosDisponiveisPorPeriodo(Calendar checkin,
			Calendar checkout);

	List<Hospede> getHospedesPorParteNome(String parteNome);

	public Reserva reservarQuarto(Long hospedeId, Long quartoId,
			Calendar checkin, Calendar checkout);

}
