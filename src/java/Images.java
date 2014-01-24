package images;

import java.sql.Blob;
import java.util.Date;

public class Images {
    
    private Integer id;
    private String titre = "";
    private String date;
    private String categorie = "";
    private String urlImg;
    private String depositeur ="";
    
    public Images() {
    }
    
    public Images(Integer unID, String unTitre, String uneDate, String uneCategorie, String unURL, String unDepositeur) {
        this.id = unID;
        this.titre = unTitre;
        this.date = uneDate;
        this.categorie = uneCategorie;
        this.urlImg = unURL;
        this.depositeur = unDepositeur;
    }

    public Integer getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDate() {
        return date;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String img) {
        this.urlImg = img;
    }
    
    public String getDepositeur() {
        return depositeur;
    }

    public void setDepositeur(String unDepositeur) {
        this.depositeur = unDepositeur;
    }
    
}