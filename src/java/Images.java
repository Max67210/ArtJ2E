package images;

import java.sql.Blob;
import java.util.Date;

public class Images {
    
    private Integer id;
    private String titre = "";
    private Date date;
    private String categorie = "";
    private Blob img;
    
    public Images() {
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

    public Date getDate() {
        return date;
    }

    public Blob getImg() {
        return img;
    }

    public void setImg(Blob img) {
        this.img = img;
    }
    
}