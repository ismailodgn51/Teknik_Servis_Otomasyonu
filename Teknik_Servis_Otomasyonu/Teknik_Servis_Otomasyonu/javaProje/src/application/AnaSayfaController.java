


package application;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AnaSayfaController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;
    @FXML
    private URL location;

    @FXML
    private AnchorPane anasayfaarka;

    @FXML
    private Text kayanyazitext;
    String a="  Ar�za  Teknik  Servis  ";
    // private Object root;


        
      public void basla(){
         new java.util.Timer().schedule( 
         new java.util.TimerTask() {
             @Override
             public void run() {
               basla();
                a=a.substring(1)+a.charAt(0);
        kayanyazitext.setText(a);
             }
         }, 
         250                         
  );
         
        
       
      }
      @FXML
      private Button btn_geri;

      @FXML
      private Button btn_kapat;
      @FXML
      void personelSaglikbilgi_button(ActionEvent event) {
    	  
		FormManager FormOpn =new FormManager();
		  FormOpn.FormOpen("HastaTeshis.fxml","Hasta Sa�l�k Bilgi","teslim.png");
      }
      @FXML
      void btn_geri1(ActionEvent event) {
    	  Node  source = (Node)  event.getSource();
		    Stage stage = (Stage)source.getScene().getWindow();
		    stage.close();
		FormManager FormOpn =new FormManager();
		  FormOpn.FormOpen("giris.fxml","Giri�","teslim.png");
      }

      @FXML
      void btn_kapat1(ActionEvent event) {
    	  Node  source = (Node)  event.getSource();
		    Stage stage = (Stage)source.getScene().getWindow();
		    stage.close();
      }
      @FXML
      void ArizaEkle_button(ActionEvent event) {
    	  FormManager FormOpn =new FormManager();
    	  FormOpn.FormOpen("ArizaEkle.fxml","Ar�za Ekle","ar�za.png");
    	  Node  source = (Node)  event.getSource();
    	    Stage stage = (Stage)source.getScene().getWindow();
    	    stage.close();
      }
      @FXML
      void teslimat_button(ActionEvent event) {
    	  FormManager FormOpn =new FormManager();
    	  FormOpn.FormOpen("Teslimat.fxml","Teslimat ��lemleri","teslim.png");
    	  Node  source = (Node)  event.getSource();
    	    Stage stage = (Stage)source.getScene().getWindow();
    	    stage.close();
      }
      @FXML
      void Atolye_button(ActionEvent event) {
    	  FormManager FormOpn =new FormManager();
    	  FormOpn.FormOpen("AtolyeDurum-Guncelle.fxml","At�lye","atolye.jpg");
    	  Node  source = (Node)  event.getSource();
    	    Stage stage = (Stage)source.getScene().getWindow();
    	    stage.close();
      }
      @FXML
      void MusteriFinans_button(ActionEvent event) {
    	  
    	  FormManager FormOpn =new FormManager();
    	  FormOpn.FormOpen("Finans.fxml","M��teri Finans","finans2.png");
    	  Node  source = (Node)  event.getSource();
    	    Stage stage = (Stage)source.getScene().getWindow();
    	    stage.close(); 
    	 
      }
      @FXML
      void MusteriGuncelleSil_button(ActionEvent event) {
    	  FormManager FormOpn =new FormManager();
    	  FormOpn.FormOpen("MusteriGuncelleSil.fxml","M��teri G�ncelle/Sil ��lemleri","musteri g�ncelle sil.png");
    	  Node  source = (Node)  event.getSource();
    	    Stage stage = (Stage)source.getScene().getWindow();
    	    stage.close();
        	
      }
      @FXML
      void SikayetVeTalepler_button(ActionEvent event) {
    	  
    	  FormManager FormOpn =new FormManager();
    	  FormOpn.FormOpen("MusteriSikayetTalepGor.fxml","�ikayet Ve Taleplerleri G�r�nt�le","�ikayettalep.png");
    	  Node  source = (Node)  event.getSource();
    	    Stage stage = (Stage)source.getScene().getWindow();
    	    stage.close();
    	 
      }
      @FXML
      void sifre_kullanici_button(ActionEvent event) {
    	  FormManager FormOpn =new FormManager();
    	  FormOpn.FormOpen("YoneticiIslemleri.fxml","Kullan�c� Ve �ifre ��lemleri","PngItem_1280822.png");
    	  Node  source = (Node)  event.getSource();
    	    Stage stage = (Stage)source.getScene().getWindow();
    	    stage.close();
      }
      @FXML
      void PersonelFinans_button(ActionEvent event) {
    	  FormManager FormOpn =new FormManager();
    	  FormOpn.FormOpen("personelFinans.fxml","Personel Finans","personel finans.jpg");
    	  Node  source = (Node)  event.getSource();
    	    Stage stage = (Stage)source.getScene().getWindow();
    	    stage.close();
    	 
      }
    @FXML
    void MusteriKaydet_button(ActionEvent event) {
    	FormManager FormOpn =new FormManager();
    	FormOpn.FormOpen("MusteriKaydet.fxml","M��teri Kaydet","musteri kaydet.png");
    	Node  source = (Node)  event.getSource();
  	    Stage stage = (Stage)source.getScene().getWindow();
  	    stage.close();
    }

    @FXML
    void hakkimizda_button(ActionEvent event) {
    	FormManager FormOpn =new FormManager();
    	FormOpn.FormOpen("hakkimizdafxml.fxml","Hakk�m�zda","hakk�m�zda.png");
    	Node  source = (Node)  event.getSource();
  	    Stage stage = (Stage)source.getScene().getWindow();
  	    stage.close();
    }

    @FXML
    void musteri_talep_sikayet_button(ActionEvent event) {
    	FormManager FormOpn =new FormManager();
    	FormOpn.FormOpen("Musteri_sikayet-talep.fxml","M��teri Talep Ve �ikayet Ekle","musteriMemnuniyet.jpg");
    	Node  source = (Node)  event.getSource();
  	    Stage stage = (Stage)source.getScene().getWindow();
  	    stage.close();
    }

    @FXML
    void personelArama_button(ActionEvent event) {
    	FormManager FormOpn =new FormManager();
    	FormOpn.FormOpen("YeniPersonelArama.fxml","Personel Arama","arama.jpg");
    	Node  source = (Node)  event.getSource();
  	    Stage stage = (Stage)source.getScene().getWindow();
  	    stage.close();
    }

    @FXML
    void personelGuncelle_button(ActionEvent event) {
    	FormManager FormOpn =new FormManager();
    	FormOpn.FormOpen("YeniPersonelG�ncelle.fxml","Personel G�ncelleme ��lemleri","g�ncelle.jpg");
    	Node  source = (Node)  event.getSource();
  	    Stage stage = (Stage)source.getScene().getWindow();
  	    stage.close();
    }

    @FXML
    void personelKaydet_button(ActionEvent event) {
    	FormManager FormOpn =new FormManager();
    	FormOpn.FormOpen("YeniPersonelKaydet.fxml","Yeni Personel Ekleme ��lemleri","kaydet.png");
    	Node  source = (Node)  event.getSource();
  	    Stage stage = (Stage)source.getScene().getWindow();
  	    stage.close();
    }

    

    @FXML
    void personelSil_button(ActionEvent event) {
    	FormManager FormOpn =new FormManager();
    	FormOpn.FormOpen("YeniPersonelSil.fxml","Personel Silme ��lemleri","sil.png");
    	Node  source = (Node)  event.getSource();
  	    Stage stage = (Stage)source.getScene().getWindow();
  	    stage.close();
    }

    @FXML
    void initialize() {
    	basla();

    }

}