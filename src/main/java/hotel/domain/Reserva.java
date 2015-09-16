package hotel.domain;

import hotel.util.CalendarUtils;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reserva {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Quarto quarto;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Hospede hospede;

	@Temporal(TemporalType.DATE)
	@Column
	private Calendar dataCheckin;

	@Temporal(TemporalType.DATE)
	@Column
	private Calendar dataCheckout;

	@ManyToOne
	@JoinColumn
	private Conta conta;

	@Column
	private boolean emAberto = true;

	public Reserva() {
		super();
	}

	public Reserva(Hospede hospede, Quarto quarto, Calendar dataCheckin,
			Calendar dataCheckout) {
		super();
		this.quarto = quarto;
		this.hospede = hospede;
		this.dataCheckin = dataCheckin;
		this.dataCheckout = dataCheckout;
	}

	public Long getId() {
		return id;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public Long getQuantDiarias() {
		return CalendarUtils.days(dataCheckin, dataCheckout);
	}

	public BigDecimal getValorDiarias() {
		BigDecimal precoDiaria = quarto.getCategoria().getPrecoDiaria();
		return precoDiaria.multiply(new BigDecimal(getQuantDiarias()));
	}

	public void efetuarCheckin() throws Exception {
		if (CalendarUtils.days(dataCheckin, Calendar.getInstance()) != 0) {
			throw new Exception("Data da reserva não é para hoje");
		}
		emAberto = false;
		conta = new Conta();
	}

	public boolean isAberto() {
		return emAberto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
