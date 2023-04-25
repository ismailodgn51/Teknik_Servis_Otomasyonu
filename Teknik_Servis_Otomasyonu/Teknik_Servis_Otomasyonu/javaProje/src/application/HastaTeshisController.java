package application;

import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class HastaTeshisController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane ComboSehir;

    @FXML
    private Button BtnEkle;

    @FXML
    private Button BtnSil;

    @FXML
    private Button BtnG�ncelle;

    @FXML
    private Button BtnSorgula;

    @FXML
    private TableView<HastaBilgi> TblHastaBilgileri;

   
    @FXML
    private TableColumn<HastaBilgi ,String > tblhastaadi;

    @FXML
    private TableColumn<HastaBilgi ,String> tblmemleket;

    @FXML
    private TableColumn<HastaBilgi ,String> tblmeslek;

    @FXML
    private TableColumn<HastaBilgi ,String> tblcinsiyet;

    @FXML
    private TableColumn<HastaBilgi ,String> tblates;

    @FXML
    private TableColumn<HastaBilgi ,String> tblteshis;
    @FXML
    private TableColumn<HastaBilgi ,LocalDate> tbltarih;

    @FXML
    private TextField TxtAdSoyad;

    @FXML
    private Slider SldAtes;

    @FXML
    private ComboBox<String> ComboBox;

    @FXML
    private CheckBox checkteshis;

    @FXML
    private ToggleGroup Cinsiyet;

    @FXML
    private ToggleGroup Meslek;

    @FXML
    private Label lblates;
    
    @FXML
    private Label lbltarih;
    
    @FXML
    private DatePicker dp1;
    
    @FXML
    private DatePicker dt2;
    
    @FXML
    private PieChart pieGrafik;
    
    @FXML
    private Label lblt�kla;
    @FXML
    private Button btn_geri;

    @FXML
    private Button btn_kapat;
    @FXML
    private BarChart<String, Integer> barGrafik;
    
    LocalDate atarih;
      int sayac;
  
    
    String memleket;
    public int Siirt=0;
    public int I�d�r=0;
    public int �stanbul=0;
    public int Hatay=0;
    public int  Mersin=0;
    public double SiirtT=0;
    public double I�d�rT=0;
    public double istanbulT=0;
    public double HatayT=0;
    public double MersinT=0;
    
    
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
    void checkteshis_click(ActionEvent event) {
    	sayac++;
    	if(sayac%2==1) {
    		checkteshis.setText("pozitif");
    	}
    	if(sayac%2==0) {
    		checkteshis.setText("negatif");
    	}
    	

    }
    @FXML
    public void ShowDate(ActionEvent event) {
    	LocalDate tarih=dp1.getValue();
    	atarih=tarih;
    	
    	
    }
    @FXML
    private void MemleketSec(ActionEvent event) {
		{
			memleket=ComboBox.getValue();
		}
	
    }
    @FXML
    void pieGrafik(MouseEvent event){
    int siirtHastaSayisi=0;
	int istanbulHastaSayisi=0;
	int �gd�rHastaSayisi=0;
	int hatayHastaSayisi=0;
	int mersinHastaSayisi=0;
	
    for(HastaBilgi hasta : TblHastaBilgileri.getItems())
    {
   	 
   		 if(hasta.getMemleket().equalsIgnoreCase("Siirt")&& hasta.getTeshis().equalsIgnoreCase("Pozitif"))
   		 {
   			siirtHastaSayisi++;
   			
   		 }

   		 if(hasta.getMemleket().equalsIgnoreCase("�stanbul")&& hasta.getTeshis().equalsIgnoreCase("Pozitif"))
   		 {
   			istanbulHastaSayisi++;
   			
   		 }
   		 

   		 if(hasta.getMemleket().equalsIgnoreCase("I�d�r")&& hasta.getTeshis().equalsIgnoreCase("Pozitif"))
   		 {
   			�gd�rHastaSayisi++;
   			
   		 }
   		 

   		 if(hasta.getMemleket().equalsIgnoreCase("Hatay")&& hasta.getTeshis().equalsIgnoreCase("Pozitif"))
   		 {
   			hatayHastaSayisi++;
   			
   		 }
   		 
   		if(hasta.getMemleket().equalsIgnoreCase("Mersin")&& hasta.getTeshis().equalsIgnoreCase("Pozitif"))
  		 {
   			mersinHastaSayisi++;
  			
  		 }
   		
    }
    
    
    	ObservableList<PieChart.Data> pieChartData =
    			FXCollections.observableArrayList( 
    					new PieChart.Data("Siirt", (siirtHastaSayisi*100)/5),
    					new PieChart.Data("�stanbul", (istanbulHastaSayisi*100)/5),
    					new PieChart.Data("I�d�r", (�gd�rHastaSayisi*100)/5),
    					new PieChart.Data("Hatay", (hatayHastaSayisi*100)/5),
    					new PieChart.Data("Mersin", (mersinHastaSayisi++*100)/5));
    	final PieChart chart = new PieChart(pieChartData);
    	pieGrafik.setTitle("Da��l�m"); 
    	pieGrafik.setData(pieChartData);

    }
    
    @FXML
    void GrafikClick(MouseEvent event) {
    	
    	int siirtHastaSayisi=0;
    	int istanbulHastaSayisi=0;
    	int �gd�rHastaSayisi=0;
    	int hatayHastaSayisi=0;
    	int mersinHastaSayisi=0;
    	
        for(HastaBilgi hasta : TblHastaBilgileri.getItems())
        {
       	 
       		 if(hasta.getMemleket().equalsIgnoreCase("Siirt")&& hasta.getTeshis().equalsIgnoreCase("Pozitif"))
       		 {
       			siirtHastaSayisi++;
       			
       		 }

       		 if(hasta.getMemleket().equalsIgnoreCase("�stanbul")&& hasta.getTeshis().equalsIgnoreCase("Pozitif"))
       		 {
       			istanbulHastaSayisi++;
       			
       		 }
       		 

       		 if(hasta.getMemleket().equalsIgnoreCase("I�d�r")&& hasta.getTeshis().equalsIgnoreCase("Pozitif"))
       		 {
       			�gd�rHastaSayisi++;
       			
       		 }
       		 

       		 if(hasta.getMemleket().equalsIgnoreCase("Hatay")&& hasta.getTeshis().equalsIgnoreCase("Pozitif"))
       		 {
       			hatayHastaSayisi++;
       			
       		 }
       		 
       		if(hasta.getMemleket().equalsIgnoreCase("Mersin")&& hasta.getTeshis().equalsIgnoreCase("Pozitif"))
      		 {
       			mersinHastaSayisi++;
      			
      		 }
       		 
       	 }
	
    	XYChart.Series<String, Integer> series = new XYChart.Series<>();                
    		for (int i = 0; i < 5 ; i++) {          

    			series.getData().add(new Data<String, Integer>("Siirt",siirtHastaSayisi));
    			series.getData().add(new Data<String, Integer>("�stanbul",istanbulHastaSayisi));
    			series.getData().add(new Data<String, Integer>("I�d�r",�gd�rHastaSayisi));
    			series.getData().add(new Data<String, Integer>("Hatay",hatayHastaSayisi));
    			series.getData().add(new Data<String, Integer>("Mersin",mersinHastaSayisi));
    			
    			}                
    		barGrafik.getData().clear();
    		barGrafik.getData().add(series);
    }
    @FXML
    private CategoryAxis grafikSehir;

    @FXML
    void initialize() {
    	
    	
    	
    	 ObservableList<HastaBilgi> hastaData;    
    	 hastaData=FXCollections.observableArrayList();
    	    
    	TblHastaBilgileri.setItems(hastaData);
    	
    
    	tblhastaadi.setCellValueFactory(new PropertyValueFactory<HastaBilgi,String>("hastaAdiSoyadi"));
    	tblmemleket.setCellValueFactory(new PropertyValueFactory<HastaBilgi,String>("memleket"));    	
    	tblmeslek.setCellValueFactory(new PropertyValueFactory<HastaBilgi,String>("meslek"));
    	tblcinsiyet.setCellValueFactory(new PropertyValueFactory<HastaBilgi,String>("cinsiyet"));
    	tblates.setCellValueFactory(new PropertyValueFactory<HastaBilgi,String>("hastaAtes"));
    	tblteshis.setCellValueFactory(new PropertyValueFactory<HastaBilgi,String>("teshis"));
    	tbltarih.setCellValueFactory(new PropertyValueFactory<HastaBilgi,LocalDate>("tarih"));

    	ObservableList<String> Sehirler=FXCollections.observableArrayList("Siirt","�stanbul","I�d�r","Hatay","Mersin");
    	ComboBox.setItems(Sehirler);
    	grafikSehir.setCategories(Sehirler);
       
    
    	SldAtes.setMin(21.0);
    	SldAtes.setMax(43.7);
    	SldAtes.setShowTickLabels(true);
        
    	SldAtes.valueProperty().addListener(new ChangeListener<Number>() {
             @Override
             public void changed(ObservableValue<? extends Number> observed, Number oldValue, Number newValue) {

           	  lblates.setText(newValue+"derece");

             }
         });
    	
    	

    }
    ObservableList<HastaBilgi> hastaData;
   

    @FXML
    void BtnEkleClick(ActionEvent event) {
    	
    	
    	try {
    	
    	RadioButton cinsyt=(RadioButton) Cinsiyet.getSelectedToggle();
    	String cinsiyet=cinsyt.getText();
    	RadioButton mslk=(RadioButton) Meslek.getSelectedToggle();
    	String hastaates=lblates.getText();
    	
    	
        
    	hastaData=FXCollections.observableArrayList();
    	hastaData.add(new HastaBilgi(TxtAdSoyad.getText(),memleket,mslk.getText(),cinsyt.getText(),lblates.getText(),checkteshis.getText(),atarih));
    	TblHastaBilgileri.getItems().addAll(hastaData);
    	
   
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Kay�t Ekleme");
    	alert.setHeaderText(null);
    	alert.setContentText("Kay�t Ekleme Ba�ar�l�!!");
    	alert.showAndWait();
    	
    	} catch (Exception e) {
    		
			 Alert alert = new Alert(AlertType.ERROR);
		      	alert.setTitle("HATA");
		      	alert.setHeaderText(" ");
		      	alert.setContentText("EKLEME BA�ARISIZ");
		      	alert.showAndWait();
		      	}
    	
    }
    

    @FXML
    void BtnG�ncelleClick(ActionEvent event) {
    	HastaBilgi hastaData=TblHastaBilgileri.getSelectionModel().getSelectedItem();

    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("G�ncelleme Onay�");
    	alert.setHeaderText("G�ncelleme onay� bekleyiniz.");
    	alert.setContentText("G�ncellemek istiyor musunuz?");
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get()==ButtonType.OK) {
    		
    	String Adi=TxtAdSoyad.getText();
    	RadioButton mslk=(RadioButton) Meslek.getSelectedToggle();
    	String Meslek=mslk.getText();
    	String memleket=ComboBox.getSelectionModel().getSelectedItem().toString();
    	RadioButton cinsyt=(RadioButton) Cinsiyet.getSelectedToggle();
    	String cinsiyet=cinsyt.getText();
    	
    	
 
    	hastaData.setHastaAdiSoyadi(Adi);
    	hastaData.setMeslek(Meslek);
    	hastaData.setMemleket(memleket);
    	hastaData.setCinsiyet(cinsiyet);
    	hastaData.setHastaAtes(lblates.getText());
    
    	TblHastaBilgileri.refresh();
    	
    	}
    	
    		
    }

    @FXML
    void BtnSilClick(ActionEvent event) {
    	
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Covid-19 Takip Sistemi");
    	alert.setHeaderText("");
    	alert.setContentText("Silmek istedi�inize emin misiniz?");
    	
    	Optional<ButtonType> result=alert.showAndWait();
    	if(result.get()==ButtonType.OK) {
    		
    	ObservableList<HastaBilgi> tiklananKayit,tumKayitlar;
    	tumKayitlar=TblHastaBilgileri.getItems();
    	tiklananKayit=TblHastaBilgileri.getSelectionModel().getSelectedItems();
    	tiklananKayit.forEach(tumKayitlar::remove);
    		
    	}
    	else {
    		alert.close();
    	}
    		
    	}
    	
  
    

    @FXML
    void BtnSorgulaClick(ActionEvent event) {
    	if(ComboBox.getSelectionModel().getSelectedIndex()==0)
    	{
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Siirt'te covid19 vakas�:");
        	alert.setHeaderText("Siirteki Hasta Say�s�: "+Siirt+"\n Siirteki Vakalar�n Ortalama Atesi: "+ SiirtT/Siirt);
        	alert.showAndWait();
        	
        	
    		
    	}
    	if(ComboBox.getSelectionModel().getSelectedIndex()==1)
    	{
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("I�d�rdaki covid19 vakas�");
        	alert.setHeaderText("I�d�r Hasta Say�s�: "+I�d�r+"\n I�d�rdaki Vakalar�n Ortalama Atesi: "+ I�d�rT/I�d�r);
        	alert.showAndWait();
    		
    	}
    	if(ComboBox.getSelectionModel().getSelectedIndex()==2)
    	{
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("�stanbul covid19 vakas�:");
        	alert.setHeaderText("�stanbul Hasta Say�s�: "+�stanbul+"\n �stanbuldaki Vakalar�n Ortalama Atesi: "+ istanbulT/�stanbul);
        	alert.showAndWait();
    		
    	}
    	if(ComboBox.getSelectionModel().getSelectedIndex()==3)
    	{
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Mersin covid19 vakas�:");
        	alert.setHeaderText("Mersin Hasta Say�s�: "+Mersin+"\n Mersindeki Vakalar�n Ortalama Atesi: "+ MersinT/Mersin);
        	alert.showAndWait();
    		
    	}
    	if(ComboBox.getSelectionModel().getSelectedIndex()==4)
    	{
    		Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Hatay covid19 vakas�:");
        	alert.setHeaderText("Hatay Hasta Say�s�: "+Hatay+"\n Hataydaki Vakalar�n Ortalama Atesi: "+ HatayT/Hatay);
        	alert.showAndWait();
    		
    	}


    }
    
 
    

   
}
