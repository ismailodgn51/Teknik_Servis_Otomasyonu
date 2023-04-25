package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.ProjeMySQL.Util.VeritabaniUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class MusteriKaydetController {
	public  MusteriKaydetController() {
		 
		baglanti=VeritabaniUtil.Baglan();
		
	} @FXML
    private Button btn_geri;

    @FXML
    private Button btn_kapat;
    
    @FXML
    void btn_geri1(ActionEvent event) {
    	Node  source = (Node)  event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.close();
    FormManager FormOpn =new FormManager();
      FormOpn.FormOpen("AnaSayfa.fxml","Teslimat ��lemleri","teslim.png");
    }

    @FXML
    void btn_kapat1(ActionEvent event) {
    	Node  source = (Node)  event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.close();
    }
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_kaydet;

    @FXML
    private RadioButton radio1_evt;

    @FXML
    private RadioButton radio2_hyr;

    @FXML
    private TextField txt_adi;

    @FXML
    private TextField txt_mail;

    @FXML
    private TextField txt_soy;

    @FXML
    private TextField txt_tc;

    @FXML
    private TextField txt_telefon;
    
    Connection baglanti=null;
    PreparedStatement sorguifadesi=null;
    ResultSet getirilen=null; 	
    String sql;
    @FXML
    void btn_kydt_click(ActionEvent event) {
    	if (radio1_evt.isSelected()) {
    		
    		 AlertManager.Alert("Yanl�� ��lem!","M��teri Kay�tlarda Bulunuyor...","L�tfen G�ncellemelerden M��teri Bilgilerini D�zenleyiniz...\n");
           
		}
    	else if (radio2_hyr.isSelected()) {
    		sql="insert into musteri(M_ad,M_soy,M_mail,M_tel,M_tc) values(?,?,?,?,?)";
            
            try {
         	   sorguifadesi=baglanti.prepareStatement(sql);
                sorguifadesi.setString(1, txt_adi.getText().trim());
                sorguifadesi.setString(2, txt_soy.getText().trim());
                sorguifadesi.setString(3, txt_mail.getText().trim());
                sorguifadesi.setString(4, txt_telefon.getText().trim());
                sorguifadesi.setString(5, txt_tc.getText().trim());
               
                sorguifadesi.executeUpdate();
                AlertManager.Alert("D�KKAT!","Bilgilendirme Mesaj�","Kullan�c� Ekleme i�lemi ger�ekle�ti...");
            
                
                
     		
     	} catch (Exception e) {
     		 AlertManager.Alert("HATTA!","Bilgilendirme Mesaj�","Kullan�c� ekleme i�lemi ger�ekle�medi...\n"+e.getMessage().toString());
             
     		
     	}txt_adi.clear();
     	txt_mail.clear();
     	txt_soy.clear();
     	txt_tc.clear();
     	txt_telefon.clear();
		}else if(!radio1_evt.isSelected()&& !radio2_hyr.isSelected()){
			AlertManager.Alert("Yanl�� ��lem!","L�tfen B�t�n Alanlar� Cevaplad���n�zdan Emin olun...","Eski M��terimiz Olup Olmad���ndan Emin Olun...\n");
            
			
		}

    }

    @FXML
    void initialize() {
        
    	ToggleGroup grup1= new ToggleGroup();
        radio1_evt.setToggleGroup(grup1);
        radio2_hyr.setToggleGroup(grup1);
    }

}
