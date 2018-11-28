package View;

import Entidades.Carro;

public class viewCarro {


	public viewCarro() {
		
	}

	public Carro inserir(String modelo, String cor,  String placa, String ano, String tracao) {
		Carro Carro = new Carro();
		
		Carro.setModelo(modelo);
		
		Carro.setCor(cor);
		
		Carro.setPlaca(placa);
		
		Carro.setAno(ano);

		Carro.setTracao(tracao);
										
		return Carro;
	}
	
	
	
}
