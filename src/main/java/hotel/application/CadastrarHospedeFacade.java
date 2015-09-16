package hotel.application;

import hotel.domain.Endereco;
import hotel.domain.Hospede;

import java.util.Calendar;
import java.util.List;

public interface CadastrarHospedeFacade {

	Hospede get(Long id);

	List<Hospede> buscaPorParteNome(String parteNome);

	Hospede buscaPeloNome(String nome);

	Hospede update(Long id, String nome);

	public Hospede create(String nome, Calendar dataNascimento,
			String funcionalidade, Endereco endereco);

}
