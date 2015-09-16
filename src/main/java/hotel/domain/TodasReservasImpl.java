package hotel.domain;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class TodasReservasImpl implements TodasReservas {

	@Inject
	Provider<EntityManager> provider;

	@Inject
	TodosQuartos todosQuartos;

	public void add(Reserva reserva) {
		provider.get().persist(reserva);

	}

	@SuppressWarnings("unchecked")
	public List<Reserva> getListaReservas(String parteNome) {
		return provider
				.get()
				.createQuery(
						"from Reserva where hospede.nome like :parteNome AND emAberto = true")
				.setParameter("parteNome", "%" + parteNome + "%")
				.getResultList();
	}

	public Reserva get(Long reservaId) {
		return provider.get().find(Reserva.class, reservaId);
	}

	@SuppressWarnings("unchecked")
	public List<Quarto> getQuartosDisponiveisPorPeriodo(Calendar checkin,
			Calendar checkout) {
		List<Reserva> reservasEfetuadas = provider
				.get()
				.createQuery(
						"from Reserva where ((:dataCheckin >= dataCheckin AND :dataCheckin <= dataCheckout) OR "
								+ "(:dataCheckout >= dataCheckin AND :dataCheckout <= dataCheckout)) OR "
								+ "(:dataCheckout < dataCheckin AND :dataCheckout > dataCheckout)")
				.setParameter("dataCheckin", checkin).setParameter(
						"dataCheckout", checkout).getResultList();

		List<Quarto> quartos = todosQuartos.list();

		for (Reserva reserva : reservasEfetuadas) {
			quartos.remove(reserva.getQuarto());
		}
		return quartos;
	}
}
