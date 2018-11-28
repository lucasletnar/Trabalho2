package Entidades;

public class Automovel{
	private int ID;
	private String Modelo;
	private String Cor;
	private String ano;
	private String Placa;
	//class pojo (comun a todos)
	
	public Automovel() {
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public String getCor() {
		return Cor;
	}

	public void setCor(String cor) {
		Cor = cor;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getPlaca() {
		return Placa;
	}

	public void setPlaca(String placa) {
		Placa = placa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Cor == null) ? 0 : Cor.hashCode());
		result = prime * result + ID;
		result = prime * result + ((Modelo == null) ? 0 : Modelo.hashCode());
		result = prime * result + ((Placa == null) ? 0 : Placa.hashCode());
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
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
		Automovel other = (Automovel) obj;
		if (Cor == null) {
			if (other.Cor != null)
				return false;
		} else if (!Cor.equals(other.Cor))
			return false;
		if (ID != other.ID)
			return false;
		if (Modelo == null) {
			if (other.Modelo != null)
				return false;
		} else if (!Modelo.equals(other.Modelo))
			return false;
		if (Placa == null) {
			if (other.Placa != null)
				return false;
		} else if (!Placa.equals(other.Placa))
			return false;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Automovel [ID=" + ID + ", Modelo=" + Modelo + ", Cor=" + Cor + ", ano=" + ano + ", Placa=" + Placa
				+ "]";
	}

	public Automovel(int iD, String modelo, String cor, String ano, String placa) {
		super();
		ID = iD;
		Modelo = modelo;
		Cor = cor;
		this.ano = ano;
		Placa = placa;
	}
	
	
}
