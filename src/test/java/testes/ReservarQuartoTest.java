package testes;

import hotel.application.ReservarQuartoFacade;
import hotel.domain.Hospede;
import hotel.domain.Quarto;
import hotel.domain.Reserva;
import hotel.infra.TestModule;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Injector;

public class ReservarQuartoTest {

	ReservarQuartoFacade facade;

	@Before
	public void setUp() throws Exception {
		Injector inj = TestModule.getInjector();
		facade = inj.getInstance(ReservarQuartoFacade.class);
	}

	@Test
	public void deveExibirUmaListaHospedesPorParteNome() {
		List<Hospede> hospedes = facade.getHospedesPorParteNome("a");
		Assert.assertEquals(2, hospedes.size());
	}

	@Test
	public void deveExibirUmaListaQuartosDisponiveis() {
		Calendar checkin = Calendar.getInstance();
		Calendar checkout = Calendar.getInstance();

		List<Quarto> quartos = facade.getQuartosDisponiveisPorPeriodo(checkin,
				checkout);
		Assert.assertEquals(9, quartos.size());
	}

	@Test
	public void deveEfetuarUmaReservaParaUmHospede() {
		Reserva reserva = facade.reservarQuarto(2l, 10l,
				Calendar.getInstance(), Calendar.getInstance());
		Assert.assertNotNull(reserva.getId());
	}

}
