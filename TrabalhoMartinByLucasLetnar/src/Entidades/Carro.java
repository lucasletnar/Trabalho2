package Entidades;

public class Carro extends Automovel {

	private String Tracao;
	private Dono dono;
	
	public String getTracao() {
		return Tracao;
	}
	public void setTracao(String tracao) {
		Tracao = tracao;
	}
	public Dono getDono() {
		return dono;
	}
	public void setDono(Dono dono) {
		this.dono = dono;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Tracao == null) ? 0 : Tracao.hashCode());
		result = prime * result + ((dono == null) ? 0 : dono.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (Tracao == null) {
			if (other.Tracao != null)
				return false;
		} else if (!Tracao.equals(other.Tracao))
			return false;
		if (dono == null) {
			if (other.dono != null)
				return false;
		} else if (!dono.equals(other.dono))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Carro [Tracao=" + Tracao + ", dono=" + dono + ", getID()=" + getID() + ", getModelo()=" + getModelo()
				+ ", getCor()=" + getCor() + ", getAno()=" + getAno() + ", getPlaca()=" + getPlaca() + "]";
	}
	public Carro() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Carro(int iD, String modelo, String cor, String ano, String placa) {
		super(iD, modelo, cor, ano, placa);
		// TODO Auto-generated constructor stub
	}
	
	
	

	
}
