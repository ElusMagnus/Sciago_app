package projet_commun.sciagoapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataBase {

    private Map<Integer, ArrayList<String>> listeFinancements;
    private Map<Integer, ArrayList<String>> listeChercheurs;

    String title;
    String desc;
    int icon;

    /*public DataBase(){
        listeFinancements = new HashMap<Integer, ArrayList<String>>();
        listeChercheurs = new HashMap<Integer, ArrayList<String>>();
    }*/

    public DataBase(String title, String desc, int icon){
        this.title = title;
        this.desc = desc;
        this.icon = icon;
    }
    public String getTitle() {
        return this.title;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getIcon() {
        return this.icon;
    }


    public void connexion(){

    }


    /**
     * @return la liste des financements
     */
    public Map<Integer, ArrayList<String>> getListeFinancements(){

        return listeFinancements;
    }

    /**
     * @return la liste des chercheurs (prénom nom, profession)
     */
    public Map<Integer, ArrayList<String>> getListeChercheurs(){
        ArrayList<String> infosChercheur = new ArrayList<String>();
        infosChercheur.add("Daniel Diaz");
        infosChercheur.add("Enseignant Chercheur - Paris 1");
        listeChercheurs.put(0, infosChercheur);

        infosChercheur = new ArrayList<String>();
        infosChercheur.add("Rebeca Denecker");
        infosChercheur.add("Enseignant Chercheur - Paris 1");
        listeChercheurs.put(1, infosChercheur);

        infosChercheur = new ArrayList<String>();
        infosChercheur.add("Prénom Nom");
        infosChercheur.add("Chercheur - Paris 8");
        listeChercheurs.put(2, infosChercheur);

        infosChercheur = new ArrayList<String>();
        infosChercheur.add("Prénom Nom");
        infosChercheur.add("Chercheur - Paris 9");
        listeChercheurs.put(3, infosChercheur);

        infosChercheur = new ArrayList<String>();
        infosChercheur.add("Prénom Nom");
        infosChercheur.add("Chercheur - Paris 8");
        listeChercheurs.put(4, infosChercheur);
        infosChercheur = new ArrayList<String>();
        infosChercheur.add("Prénom Nom");
        infosChercheur.add("Chercheur - Paris 8");
        listeChercheurs.put(5, infosChercheur);
        infosChercheur = new ArrayList<String>();
        infosChercheur.add("Prénom Nom");
        infosChercheur.add("Chercheur - Paris 8");
        listeChercheurs.put(6, infosChercheur);

        return listeChercheurs;
    }
}
