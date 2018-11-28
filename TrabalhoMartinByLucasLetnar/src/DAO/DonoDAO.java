package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Entidades.Dono;
import conexao.CNXHSQLDB;

public class DonoDAO {
	private final String SQL_INSERIR_DONO = "INSERT INTO DONO ("+ "NOME, RG)" + "VALUES (?, ?)";
	private final String SQL_ALTERAR_DONO = "UPDATE DONO SET Nome=?, RG=? WHERE ID=?;";
	private final String SQL_EXCLUIR_DONO = "DELETE FROM DONO WHERE ID=?";
	private final String SQL_SELECIONAR_DONO = "SELECT *FROM CARRO";
	
private PreparedStatement pst = null;
	
	public boolean inserirDono(Dono umDono) {
		boolean ret = false;
		Connection conn = CNXHSQLDB.conectar();
		try {
			pst = conn.prepareStatement(SQL_INSERIR_DONO);
			pst.setString(1, umDono.getNome());
			pst.setString(2, umDono.getRG());
			ret = pst.execute();
			CNXHSQLDB.fecharCNX();
		} catch (SQLException e){
			System.out.println("Erro ao executar o Statement " +e.toString() );
		}
		return ret;
	}
	
	public ArrayList<Dono> listarDono(){
		ArrayList<Dono> listaDono = new ArrayList<Dono>();
		Connection conn = CNXHSQLDB.conectar();
		Dono umDono;
		try {
			pst = conn.prepareStatement(SQL_SELECIONAR_DONO);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				umDono = new Dono();
				umDono.setId(rs.getInt("ID"));
				umDono.setNome(rs.getString("NOME"));
				umDono.setRG(rs.getString("RG"));	
				listaDono.add(umDono);
			}
			rs.close();
			pst.close();
			CNXHSQLDB.fecharCNX();		
			
		} catch (SQLException e) {
			System.out.println("Erro ao executar o Statement " +e.toString() );
		}
		return listaDono;
	}
	
	public boolean alterarDono(Dono umDono) {
		boolean ret = false;
		Connection conn = CNXHSQLDB.conectar();
		try {
			pst = conn.prepareStatement(SQL_ALTERAR_DONO);
			pst.setString(1, umDono.getNome());
			pst.setString(2, umDono.getRG());
			pst.setInt(6, umDono.getId());
			ret = pst.execute();
			pst.close();
			CNXHSQLDB.fecharCNX();
		} catch (SQLException e){
			System.out.println("Erro ao executar o Statement " +e.toString() );
		}
		return ret;	
	}
	
	public boolean excluirCarro(Dono umDono) {
		boolean ret = false;
		Connection conn = CNXHSQLDB.conectar();
		try {
			pst = conn.prepareStatement(SQL_EXCLUIR_DONO);
			pst.setInt(1, umDono.getId());
			ret = pst.execute();
			pst.close();
			CNXHSQLDB.fecharCNX();
		} catch (SQLException e){
			System.out.println("Erro ao executar o Statement " +e.toString() );
		}
		return ret;	
	}

}
