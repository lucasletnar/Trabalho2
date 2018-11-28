package EFAXCARRO;


import Entidades.Carro;
import Entidades.Dono;
import View.viewCarro;
import View.viewDono;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;


import DAO.CarroDAO;
import DAO.DonoDAO;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLControleCarro implements Initializable {
//	private Carro Carros = new Carro();
	private viewCarro viewCarro = new viewCarro();
    private CarroDAO CarroDAO = new CarroDAO();
    private ArrayList<Carro> listaCarros = new ArrayList<Carro>();	
    private Carro carroEscolhido;
    private viewDono viewDono = new viewDono();
    private DonoDAO donoBanco = new DonoDAO(); 
	private ArrayList<Carro> pesquisaCarro = new ArrayList<Carro>();  
    @FXML
    private TableView<Carro> table;

    @FXML
    private TableColumn<?, ?> ID;

    @FXML
    private TableColumn<?, ?> Modelo;

    @FXML
    private TableColumn<?, ?> Cor;

    @FXML
    private TableColumn<?, ?> Ano;

    @FXML
    private TableColumn<?, ?> Placa;

    @FXML
    private TableColumn<?, ?> Tracao;

    @FXML
    private Button BTNCADASTRAR;

    @FXML
    private TextField TXTMODELO;

    @FXML
    private TextField TXTCOR;

    @FXML
    private TextField TXTANO;

    @FXML
    private TextField TXTTRACAO;

    @FXML
    private TextField TXTPLACA;

    @FXML
    private Button BTNEDITAR;

    @FXML
    private Button BTNEXCLUIR;
    
    @FXML
    private Button BTNPesquisar;

    @FXML
    private TextField TXTPESQUISA;

    @FXML
    private TextField txtrgDono;

    @FXML
    private TextField txtnomeDono;	
    
    public void initialize(URL location, ResourceBundle resources) {
	    ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		Modelo.setCellValueFactory(new PropertyValueFactory<>("Modelo"));
		Cor.setCellValueFactory(new PropertyValueFactory<>("Cor"));
		Ano.setCellValueFactory(new PropertyValueFactory<>("ano"));
		Placa.setCellValueFactory(new PropertyValueFactory<>("Placa"));
		Tracao.setCellValueFactory(new PropertyValueFactory<>("Tracao"));
		refreshTable();

		table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Carro>() {

			@Override
			public void changed(ObservableValue<? extends Carro> observable, Carro oldValue, Carro newValue) {
				carroEscolhido = newValue;
			}
		});
	}
    @FXML
    private void cadastrar(ActionEvent event) {
    	
    	Carro Carros = viewCarro.inserir(TXTMODELO.getText(), TXTCOR.getText(), TXTANO.getText(), TXTPLACA.getText(), TXTTRACAO.getText() );
    	Dono dono = viewDono.inserir(txtnomeDono.getText(), txtrgDono.getText());
    	donoBanco.inserirDono(dono);
    	Carros.setDono(dono); 	
    	CarroDAO.inserirCarro(Carros);
    	refreshTable();

    }
    
    @FXML
    private void refreshTable() {
		listaCarros = new CarroDAO().listarCarro();
		ObservableList<Carro> observableList = FXCollections.observableArrayList(listaCarros);
		table.setItems(observableList);	
	}
    
    @FXML
	 private void deletar() {
			CarroDAO.excluirCarro(carroEscolhido);
			refreshTable();	 
	 }
    
    @FXML
	 private void editarCarro() {
		 TXTMODELO.setText(carroEscolhido.getModelo());
		 TXTCOR.setText(carroEscolhido.getCor());
		 TXTANO.setText(carroEscolhido.getAno());
		 TXTPLACA.setText(carroEscolhido.getPlaca());
		 TXTTRACAO.setText(carroEscolhido.getTracao());
		 
		 CarroDAO.alterarCarro(carroEscolhido);
		 refreshTable();	
	 }
    
    @FXML
    private void editar() {
    	 carroEscolhido.setModelo(TXTMODELO.getText());
    	 carroEscolhido.setCor(TXTCOR.getText());
    	 carroEscolhido.setAno(TXTANO.getText());
    	 carroEscolhido.setPlaca(TXTPLACA.getText());
    	 carroEscolhido.setTracao(TXTTRACAO.getText());
    	 
    	
		 
		 CarroDAO.alterarCarro(carroEscolhido);
		 refreshTable();	
	 }
    @FXML
   private  void sair(ActionEvent event ) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Sair");
    	String s ="Voce quer sair mesmo";
    	alert.setContentText(s);
    	
    	Optional<ButtonType> result = alert.showAndWait();
    	
    	if((result.isPresent()) && (result.get() == ButtonType.OK)){
    		System.exit(0);
    	
    }
    }
    
    @FXML
	 private void pesquisar() {
		 
		 CarroDAO CarroPesquisar = new CarroDAO();
		
		 Carro pesquisar = new Carro();
		 
		 pesquisar = CarroPesquisar.pesquisar(TXTPESQUISA.getText());
		 
		 pesquisaCarro.add(pesquisar);
		 		 
		 ObservableList<Carro> observableList = FXCollections.observableArrayList(pesquisar);
		 	 
		 table.setItems(observableList);
		 
	 }
    
    
   

}
