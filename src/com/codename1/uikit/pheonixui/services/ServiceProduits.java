package com.codename1.uikit.pheonixui.services;

import com.codename1.db.Cursor;
import com.codename1.db.Database;
import com.codename1.db.Row;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.codename1.uikit.pheonixui.InboxForm;
import com.codename1.uikit.pheonixui.entities.Produits;
import com.codename1.uikit.pheonixui.entities.Users;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author islem
 */
public class ServiceProduits {
    public ArrayList<Produits> produits;

    public static ServiceProduits instance=null;
    public boolean resultOK;
    private ConnectionRequest connectionRequest;
    Database db;

    public ServiceProduits() {
        connectionRequest = new ConnectionRequest();
    }

    public static ServiceProduits getInstance() {
        if (instance == null) {
            instance = new ServiceProduits();
        }
        return instance;
    }

    public ArrayList<Produits> parseProduits(String jsonText){
        try {
            produits=new ArrayList<>();

            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Produits prod = new Produits();

                float id = Float.parseFloat(obj.get("id").toString());
                prod.setId((int)id);
                prod.setNomProduit(obj.get("nomProduit").toString());
                prod.setQuantite(((int)Float.parseFloat(obj.get("quantite").toString())));
                prod.setCategorie(obj.get("categorie").toString());
                prod.setPrix(((int)Float.parseFloat(obj.get("prix").toString())));
                prod.setImage(obj.get("image").toString());
                prod.setDescription(obj.get("description").toString());



                produits.add(prod);
            }


        } catch (IOException ex) {

        }
        return produits;
    }

    public ArrayList<Produits> getAllProducts(){
        String url = "http://localhost/Boutique/web/app_dev.php/tasks";
        connectionRequest.setUrl(url);
        connectionRequest.setPost(false);
        connectionRequest.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                produits = parseProduits(new String(connectionRequest.getResponseData()));
                connectionRequest.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(connectionRequest);
        return produits;
    }

    public String find(String nom , String prenom) throws IOException {
        db = Database.openOrCreate("User");
        Cursor cur = db.executeQuery("select * from user");
        Users usr=new Users();


        while (cur.next()) {
            int a = 0;
            Row row = cur.getRow();
            String nomC = row.getString(0);
            String prenomC = row.getString(1);
            String telephone = row.getString(2);

            if(nomC.equals(nom)==true && prenomC.equals(prenom)==true) {


                    usr.setNom(nom);
                    usr.setPrenom(prenom);
                    usr.setTel(Integer.parseInt(telephone));
                    new InboxForm().show();


            }
        }
        return usr.getNom();
    }


}
