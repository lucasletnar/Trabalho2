package View;

import Entidades.Dono;

public class viewDono {
	
	private int controleID = 0;
	
	public Dono inserir(String nome, String RG) {
		
		Dono donoCarro = new Dono();
		
		donoCarro.setNome(nome);
		
		donoCarro.setRG(RG);
		
		donoCarro.setId(controleID);
		controleID++;
		
		return donoCarro;		
	}

}
