package hotel.application;

import hotel.domain.Reserva;
import hotel.domain.TodasReservas;

import java.util.List;

import com.google.inject.Inject;

public class EfetuarCheckinFacadeImpl implements EfetuarCheckinFacade {

	@Inject
	TodasReservas todasReservas;

	public Reserva efetuarCheckin(Long reservaId) throws Exception {
		Reserva reserva = todasReservas.get(reservaId);
		reserva.efetuarCheckin();
		return reserva;
	}

	public List<Reserva> getListaReservas(String parteNome) {
		return todasReservas.getListaReservas(parteNome);
	}

}
