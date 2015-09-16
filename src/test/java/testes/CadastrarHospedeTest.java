package testes;

import hotel.application.CadastrarHospedeFacade;
import hotel.domain.Endereco;
import hotel.domain.Hospede;
import hotel.infra.TestModule;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Injector;

public class CadastrarHospedeTest {

	CadastrarHospedeFacade facade;

	@Before
	public void setUp() throws Exception {
		Injector inj = TestModule.getInjector();
		facade = inj.getInstance(CadastrarHospedeFacade.class);
	}

	@Test
	public void deveBuscarHospedePorParteNome() {
		List<Hospede> hospedes = facade.buscaPorParteNome("a");
		Assert.assertEquals(2, hospedes.size());
	}

	@Test
	public void deveRetornarUmUnicoHospede() {
		Hospede hospede = facade.buscaPeloNome("Martin Fowler");
		Assert.assertEquals("Martin Fowler", hospede.getNome());
	}

	@Test
	public void deveEditarUmHospede() {
		Hospede hospedeUpd = facade.update(2l, "Martin R. Fowler");
		Assert.assertEquals("Martin R. Fowler", hospedeUpd.getNome());
	}

	@Test
	public void deveCriarUmHospede() {
		Hospede hospedeNew = facade.create("Grady Booch", Calendar
				.getInstance(), "brasileiro", new Endereco("Rua Sao Jorge",
				"Aqui", "Campo Grande", "MS", "79000000"));
		Assert.assertEquals("Grady Booch", hospedeNew.getNome());
	}
}
