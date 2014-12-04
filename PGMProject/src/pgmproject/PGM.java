/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgmproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 *
 * @author Fabien
 */
public class PGM {
    private int maxNiveauGris; //Le maximum des niveaux de gris possible
    private int largeur; //Largeur de l'image
    private int hauteur; //Hauteur de l'image
    
    private List<Integer> niveauxGris; //Les niveaux de gris des pixels de l'image
    
    /**
     * Constructeur à 4 paramètres de la classe PGM.
     * @param maxNivGris de type int : le niveau de gris maximal de l'image
     * @param largeur de type int : la largeur de l'image
     * @param hauteur de type int : la hauteur de l'image
     * @param nivGris de type List d'entiers : la liste des niveaux de gris des pixels
     */
    public PGM(int maxNivGris, int largeur, int hauteur, List<Integer> nivGris){
        maxNiveauGris = maxNivGris;
        this.largeur=largeur;
        this.hauteur=hauteur;
        niveauxGris=nivGris;
    }
    /**
     * Constructeur à 3 paramètres de la classe PGM. La liste des niveaux de gris
     * est initialisée vide.
     * @param maxNivGris de type int : le niveau de gris maximal de l'image
     * @param largeur de type int : la largeur de l'image
     * @param hauteur de type int : la hauteur de l'image
     */
    public PGM(int maxNivGris, int largeur, int hauteur){
        this(maxNivGris, largeur, hauteur, new ArrayList<Integer>());
    }
    
    /**
     * Constructeur de recopie de la classe PGM
     * @param a de type PGM : l'image à recopier
     */
    public PGM(PGM a){
        this.maxNiveauGris=a.maxNiveauGris;
        this.largeur=a.largeur;
        this.hauteur=a.hauteur;
        this.niveauxGris=a.niveauxGris;
    }
    /**
     * Constructeur sans paramètres, uui initialise les attributs entiers à 0
     */
    public PGM(){
        this(0, 0, 0);
    }
    /**
     * Getter sur l'attribut maxNiveauGris
     * @return de type int : le niveau de gris maximal de l'image
     */
    public int getMaxNiveauGris() {
        return maxNiveauGris;
    }
     /**
     * Getter sur l'attribut largeur
     * @return de type int : la largeur de l'image
     */
    public int getLargeur() {
        return largeur;
    }
     /**
     * Getter sur l'attribut hauteur
     * @return de type int : la hauteur de l'image
     */
    public int getHauteur() {
        return hauteur;
    }
     /**
     * Getter sur l'attribut niveauxGris
     * @return de type Liste d'entiers : les niveaux de gris des pixels de l'image
     */
    public List<Integer> getNiveauxGris() {
        return niveauxGris;
    }
    /**
     * Setter sur l'attribut niveauxGris
     * @param niveauxGris : la liste d'entiers qu'on veut obtenir dans l'attribut
     */
    public void setNiveauxGris(List<Integer> niveauxGris) {
        this.niveauxGris = niveauxGris;
    }
    /**
     * Setter pour l'attribut maxNiveauGris
     * @param maxNiveauGris 
     */
    public void setMaxNiveauGris(int maxNiveauGris) {
        this.maxNiveauGris = maxNiveauGris;
    }
    /**
     * Setter pour l'attribut largeur
     * @param largeur 
     */
    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }
    /**
     * Setter pour l'attribut hauteur
     * @param hauteur 
     */
    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }
    /**
     * Méthode permettant de charger une image au format PGM. Si le type de fichier
     * est incorrect (cad si la première ligne n'est pas P2), une erreur s'affiche dans la console.
     * @param nomFichier de type String : le nom du fichier à charger
     */
    public void lecturePGM(String nomFichier){
        try{
            String line;
            BufferedReader fichier = new BufferedReader(new FileReader(nomFichier));
            String delimiteurs = " \t";
            if (!fichier.readLine().equals("P2")){
                throw new WrongFileTypeException();
            }
            fichier.readLine();
            line=fichier.readLine();
            StringTokenizer tokenizer = new StringTokenizer(line, delimiteurs);
            largeur = Integer.valueOf(tokenizer.nextToken());
            hauteur = Integer.valueOf(tokenizer.nextToken());
            line=fichier.readLine();
            maxNiveauGris = Integer.valueOf(line);
            while((line=fichier.readLine()) != null){
                StringTokenizer tokenize = new StringTokenizer(line, delimiteurs);
                while (tokenize.hasMoreTokens()){
                    int a = Integer.valueOf(tokenize.nextToken());
                    if(a<0){
                        a=0;
                    }
                    else if(a>maxNiveauGris){
                        a=maxNiveauGris;
                    }
                    niveauxGris.add(a);
                }
            }
            fichier.close();
        }
        catch(WrongFileTypeException e){
            System.out.println("Le format du fichier est incorrect");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void ecriturePGM(String nomFichier){        
        try{
            String fichier = nomFichier+".pgm";
            String test = "";
            
            BufferedWriter file = new BufferedWriter(new FileWriter(fichier));
            file.write("P2");
            file.newLine();
            file.write("#");
            file.newLine();
            file.write(largeur+" "+hauteur);
            file.newLine();
            file.write(String.valueOf(maxNiveauGris));
            file.newLine();
            for(int i=0; i<niveauxGris.size(); i++){
                test += " "+niveauxGris.get(i);
                if(test.length()>70){
                   file.newLine();
                   test = "";
                }
                file.write(String.valueOf(niveauxGris.get(i))+"\t");
            }
        
            if(file != null){
                    file.flush();
                    file.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }        
    }
    /**
     * Méthode comparant un objet à l'instance courante de la classe PGM.
     * @param a : l'objet à comparer à l'instance de la classe
     * @return de type boolean, vrai si les deux objets sont les mêmes
     */
    @Override
    public boolean equals(Object a){
        if (!a.getClass().equals(this.getClass())){
            return false;
        }
        if (((PGM)a).maxNiveauGris!=this.maxNiveauGris || ((PGM)a).hauteur!=this.hauteur ||
              ((PGM)a).largeur!= this.largeur || ((PGM)a).niveauxGris.size()!= this.niveauxGris.size()){
            return false;
        }
        for (int i=0; i<niveauxGris.size(); i++){
            if (!Objects.equals(((PGM)a).niveauxGris.get(i), niveauxGris.get(i))){
                return false;
            }
        }
        return true;
    }
}
