package hotel.application;

import hotel.domain.Hospede;
import hotel.domain.Quarto;
import hotel.domain.Reserva;
import hotel.domain.TodasReservas;
import hotel.domain.TodosHospedes;
import hotel.domain.TodosQuartos;

import java.util.Calendar;
import java.util.List;

import com.google.inject.Inject;

public class ReservarQuartoFacadeImpl implements ReservarQuartoFacade {

	@Inject
	TodasReservas todasReservas;

	@Inject
	TodosHospedes todosHospedes;

	@Inject
	TodosQuartos todosQuartos;

	public List<Hospede> getHospedesPorParteNome(String parteNome) {
		return todosHospedes.getPorParteNome(parteNome);
	}

	public Reserva reservarQuarto(Long hospedeId, Long quartoId,
			Calendar checkin, Calendar checkout) {

		Hospede hospede = todosHospedes.get(hospedeId);
		Quarto quarto = todosQuartos.get(quartoId);

		Reserva newReserva = new Reserva(hospede, quarto, checkin, checkout);
		todasReservas.add(newReserva);
		return newReserva;
	}

	public List<Quarto> getQuartosDisponiveisPorPeriodo(Calendar checkin,
			Calendar checkout) {
		return todasReservas.getQuartosDisponiveisPorPeriodo(checkin, checkout);
	}

}
