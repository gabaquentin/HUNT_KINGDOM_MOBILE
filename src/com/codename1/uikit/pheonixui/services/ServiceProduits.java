package com.codename1.uikit.pheonixui.services;

import com.codename1.io.*;
import com.codename1.ui.events.ActionListener;
import com.codename1.uikit.pheonixui.entities.Produits;
import com.codename1.uikit.pheonixui.utils.ProduitsStatics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServiceProduits {

    public static ServiceProduits instance=null;
    private ConnectionRequest req;
    public ArrayList<Produits> produits;
    public static ServiceProduits getInstance() {
        if (instance == null) {
            instance = new ServiceProduits();
        }
        return instance;
    }


    public ArrayList<Produits> parseTasks(String jsonText){
        try {
            produits=new ArrayList<Produits>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient
            l'utilité de new CharArrayReader(json.toCharArray())

            La méthode parse json retourne une MAP<String,Object> ou String est
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets
                    c'est la clé définissant le tableau de tâches.
            */
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

              /* Ici on récupère l'objet contenant notre liste dans une liste
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche.

            Le format Json impose que l'objet soit définit sous forme
            de clé valeur avec la valeur elle même peut être un objet Json.
            Pour cela on utilise la structure Map comme elle est la structure la
            plus adéquate en Java pour stocker des couples Key/Value.

            Pour le cas d'un tableau (Json Array) contenant plusieurs objets
            sa valeur est une liste d'objets Json, donc une liste de Map
            */
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");

            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                Produits p = new Produits();
                float id = Float.parseFloat(obj.get("id").toString());
                p.setId((int)id);
                p.setNomProduit(obj.get("NomProduit").toString());
                p.setQuantite(((int)Float.parseFloat(obj.get("Quantite").toString())));
                p.setCategorie(obj.get("categorie").toString());
                p.setPrix(((int)Float.parseFloat(obj.get("prix").toString())));
                p.setImage(obj.get("Image").toString());
                p.setFournisseur(((int)Float.parseFloat(obj.get("fournisseur").toString())));
                p.setDescription(obj.get("description").toString());
                //Ajouter la tâche extraite de la réponse Json à la liste
                produits.add(p);
            }


        } catch (IOException ex) {

        }
         /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web

        */
        return produits;
    }



    public ArrayList<Produits> getAllTasks(){
        String url = ProduitsStatics.BASE_URL+"/tasks/";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                produits = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return produits;
    }



}
