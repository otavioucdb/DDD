package testes;

import hotel.application.EfetuarCheckinFacade;
import hotel.domain.Reserva;
import hotel.infra.TestModule;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EfetuarCheckinTest {

	EfetuarCheckinFacade facade;

	@Before
	public void setUp() throws Exception {
		facade = TestModule.getInjector().getInstance(
				EfetuarCheckinFacade.class);
	}

	@Test
	public void deveExibirListaReservasPorParteNomeHospede() {
		List<Reserva> reservas = facade.getListaReservas("Martin");
		Assert.assertEquals(2, reservas.size());
	}

	@Test
	public void deveEfetuarCheckinECriarContaReserva() throws Exception {
		Reserva reserva = facade.efetuarCheckin(4l);
		Assert.assertFalse(reserva.isAberto());

	}

	@Test(expected = Exception.class)
	public void naoDevePermitirEfetuarCheckinForaDataHoje() throws Exception {
		facade.efetuarCheckin(3l);
	}
}
