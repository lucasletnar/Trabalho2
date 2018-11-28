package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.Carro;
import conexao.CNXHSQLDB;

public class CarroDAO {

	private final String SQL_INSERIR_CARRO = "INSERT INTO CARRO ("+ "MODELO, COR, ANO, PLACA, TRACAO, DONO)" + "VALUES (?, ?, ?, ?, ?, ?)";
	private final String SQL_ALTERAR_CARRO = "UPDATE CARRO SET MODELO=?, COR=?, ANO=?, PLACA=?, TRACAO=?  WHERE ID=?;";
	private final String SQL_EXCLUIR_CARRO = "DELETE FROM CARRO WHERE ID=?";
	private final String SQL_SELECIONAR_CARRO = "SELECT *FROM CARRO";
	private final String SQL_PESQUISAR_CARRO = "SELECT DISTINCT * FROM CARRO WHERE MODELO=?";
	
private PreparedStatement pst = null;
	
	public boolean inserirCarro(Carro umCarro) {
		boolean ret = false;
		Connection conn = CNXHSQLDB.conectar();
		try {
			pst = conn.prepareStatement(SQL_INSERIR_CARRO);
			pst.setString(1, umCarro.getModelo());
			pst.setString(2, umCarro.getCor());
			pst.setString(3, umCarro.getAno());
			pst.setString(4, umCarro.getPlaca());
			pst.setString(5, umCarro.getTracao());
			pst.setInt(6, umCarro.getDono().getId());
			ret = pst.execute();
			CNXHSQLDB.fecharCNX();
		} catch (SQLException e){
			System.out.println("Erro ao executar o Statement " +e.toString() );
		}
		return ret;
	}
	
	public ArrayList<Carro> listarCarro(){
		ArrayList<Carro> listaCarro = new ArrayList<Carro>();
		Connection conn = CNXHSQLDB.conectar();
		Carro umCarro;
		try {
			pst = conn.prepareStatement(SQL_SELECIONAR_CARRO);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				umCarro = new Carro();
				umCarro.setID(rs.getInt("ID"));
				umCarro.setModelo(rs.getString("MODELO"));
				umCarro.setCor(rs.getString("COR"));
				umCarro.setAno(rs.getString("ANO"));
				umCarro.setPlaca(rs.getString("PLACA"));	
				umCarro.setTracao(rs.getString("TRACAO"));		
				listaCarro.add(umCarro);
			}
			rs.close();
			pst.close();
			CNXHSQLDB.fecharCNX();			
		} catch (SQLException e) {
			System.out.println("Erro ao executar o Statement " +e.toString() );
		}
		return listaCarro;
	}
	
	public boolean alterarCarro(Carro umCarro) {
		boolean ret = false;
		Connection conn = CNXHSQLDB.conectar();
		try {
			pst = conn.prepareStatement(SQL_ALTERAR_CARRO);
			pst.setString(1, umCarro.getModelo());
			pst.setString(2, umCarro.getCor());
			pst.setString(3, umCarro.getAno());
			pst.setString(4, umCarro.getPlaca());
			pst.setString(5, umCarro.getTracao());
			pst.setInt(6, umCarro.getID());
			ret = pst.execute();
			pst.close();
			CNXHSQLDB.fecharCNX();
		} catch (SQLException e){
			System.out.println("Erro ao executar o Statement " +e.toString() );
		}
		return ret;	
	}
	
	public boolean excluirCarro(Carro umCarro) {
		boolean ret = false;
		Connection conn = CNXHSQLDB.conectar();
		try {
			pst = conn.prepareStatement(SQL_EXCLUIR_CARRO);
			pst.setInt(1, umCarro.getID());
			ret = pst.execute();
			pst.close();
			CNXHSQLDB.fecharCNX();
		} catch (SQLException e){
			System.out.println("Erro ao executar o Statement " +e.toString() );
		}
		return ret;	
	}
	
	public Carro pesquisar(String pesquisar){
		Connection conn = CNXHSQLDB.conectar();
		Carro umCarro = new Carro();
		try {
			pst = conn.prepareStatement(SQL_PESQUISAR_CARRO);
			pst.setString(1, pesquisar);
			ResultSet rs = pst.executeQuery();			
			while(rs.next()) {				
				umCarro.setID(rs.getInt("ID"));
				umCarro.setModelo(rs.getString("MODELO"));
				umCarro.setCor(rs.getString("COR"));
				umCarro.setAno(rs.getString("ANO"));
				umCarro.setPlaca(rs.getString("PLACA"));		
			}
			rs.close();
			pst.close();
			CNXHSQLDB.fecharCNX();			
		} catch (SQLException e) {
			System.out.println("Erro ao executar o Statement " +e.toString() );
		}
		return umCarro;
	}

}
