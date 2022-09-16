package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private Button btnDelete;
    
    @FXML
    private Label txtTime; 

    @FXML
    void doInsert(ActionEvent event) {
    	txtTime.setText("");
    	long start, end;
    	start = System.currentTimeMillis();
    	
    	elenco.addParola(txtParola.getText());
    	String tutte = "";
    	for(String s : elenco.getElenco()) {
    		if(tutte!=null) {
    			tutte += "\n";
    		}
    		tutte += s;
    	}
    	
    	txtResult.setText(tutte);
    	txtParola.setText("");
    	
    	end = System.currentTimeMillis();
    	txtTime.setText("tempo impiegato = " + (end-start)+ " ms");
    }
    
    @FXML
    void doDeleteWord(ActionEvent event) {
    	txtTime.setText("");
    	long start, end;
    	start = System.currentTimeMillis();
    	
    	String word = txtResult.getSelectedText();
    	elenco.removeParola(word);
    	
    	String tutte = "";
    	for(String s : elenco.getElenco()) {
    		if(tutte!=null) {
    			tutte += "\n";
    		}
    		tutte += s;
    	}
    	
    	txtResult.setText(tutte);
    	end = System.currentTimeMillis();
    	txtTime.setText("tempo impiegato = " + (end-start)+ " ms");
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtTime.setText("");
    	long start, end;
    	
    	start = System.currentTimeMillis();
    	elenco.reset();
    	String tutto = "";
    	
    	for(String i : elenco.getElenco()) {
    	tutto += i; 
    	}
    	
    	txtResult.setText(tutto);
    	txtParola.setText("");
    	end = System.currentTimeMillis();
    	txtTime.setText("tempo impiegato = " + (end-start)+ " ms");
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnDelete != null : "fx:id=\"btnDelete\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
