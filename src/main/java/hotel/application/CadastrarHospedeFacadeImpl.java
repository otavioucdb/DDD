package hotel.application;

import hotel.domain.Endereco;
import hotel.domain.Hospede;
import hotel.domain.TodosHospedes;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.wideplay.warp.persist.Transactional;

public class CadastrarHospedeFacadeImpl implements CadastrarHospedeFacade {

	@Inject
	Provider<EntityManager> provider;
	@Inject
	TodosHospedes todosHospedes;

	@Transactional
	public Hospede get(Long id) {
		return todosHospedes.get(id);
	}

	@Transactional
	public Hospede update(Long id, String nome) {
		Hospede hospede = todosHospedes.get(id);

		hospede.setNome(nome);

		return hospede;
	}

	@Transactional
	public Hospede create(String nome, Calendar dataNascimento,
			String nacionalidade, Endereco endereco) {

		Hospede hospedeNew = new Hospede();
		hospedeNew.setNome(nome);
		hospedeNew.setDataNascimento(dataNascimento);
		hospedeNew.setNacionalidade(nacionalidade);
		hospedeNew.setEndereco(endereco);

		todosHospedes.add(hospedeNew);

		return hospedeNew;
	}

	public List<Hospede> buscaPorParteNome(String parteNome) {
		return todosHospedes.getPorParteNome(parteNome);
	}

	public Hospede buscaPeloNome(String nome) {
		return todosHospedes.getPorNomeCompleto(nome);
	}

}
