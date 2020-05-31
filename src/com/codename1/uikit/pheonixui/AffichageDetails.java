
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.pheonixui;



import com.codename1.components.SpanLabel;
import com.codename1.db.Cursor;
import com.codename1.db.Database;
import com.codename1.db.Row;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.NetworkManager;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.pheonixui.entities.Produits;
import com.codename1.uikit.pheonixui.ProduitsForm;



import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import static com.codename1.push.PushContent.setTitle;


/**
 *
 * @author khalil
 */
public class AffichageDetails extends BaseForm {
    Form f;
    //Label lb_description;
    Label lb_price;
    Label lb_nomP;
    Image img;
    Image scaledPhotoImage;
    Button btnPanier;
    Button btnFav;
    public AffichageDetails(Produits p)
    {
        f = new Form("Details Produit");

        f.getToolbar().addCommandToRightBar("Retour", null, (ev)->{ProduitsForm h=new ProduitsForm();
            h.getF().show();
        });
        /*
        Resources resourceObjectInstance = null;
        installSidemenu(resourceObjectInstance);
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
        */




        setTitle("Catalogue produits");
        lb_nomP = new Label("           "+p.getNomProduit());
        f.add(lb_nomP);

        String filePath = "file:///D:/wamp64/www/Back/web/uploads/images/"+p.getImage();
        if (filePath != null) {
            try {

                String pathToBeStored;
                pathToBeStored = FileSystemStorage.getInstance().getAppHomePath() + System.currentTimeMillis();

                img = Image.createImage(filePath);
                int displayHeight = Display.getInstance().getDisplayHeight();
                scaledPhotoImage = img.scaled(-1, displayHeight / 3);


            }
            catch (Exception e) {
                e.printStackTrace();
            }
            f.add(scaledPhotoImage);


        }


        lb_price = new Label("Prix: "+p.getPrix()+" DT");
        f.add(lb_price);

        //lb_description = new Label("Description: \n"+p.getDescription());
        SpanLabel lb_description  = new SpanLabel();
        lb_description.setText("Description: \n"+p.getDescription());
        f.add(lb_description);
//        btnPanier.setAlignment(4);

        btnPanier = new Button("Ajouter Au Panier");
        btnFav = new Button("Ajouter Au Panier 2");






        f.add(btnPanier);
        f.add(btnFav);


        btnPanier.addActionListener((e)->{
            Database db;
            try {
                db=Database.openOrCreate("User");
                Cursor cur = db.executeQuery("select telephone from user where etat=1");
                while (cur.next()) {
                    Row row = cur.getRow();
                    int num = Integer.parseInt(row.getString(0));
                    System.out.println("nom :" + num );
                    String myURL = "https://rest.nexmo.com/sms/json?api_key=7f104be5&api_secret=ngMSEGkLbvt45Se8&to="+num+"" + "&from=HuntKingdom&text="+p.getNomProduit()+ " Ajouté au panier";
                    ConnectionRequest cntRqst = new ConnectionRequest() {
                        protected void readResponse(InputStream in) throws IOException {
                        }
                        @Override
                        protected void postResponse() {
                            Dialog.show("SMS", "SMS Envoyé Avec Succès", "OK", null);
                        }

                    };
                    cntRqst.setUrl(myURL);
                    NetworkManager.getInstance().addToQueue(cntRqst);


                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }


        }

);
        btnFav.addActionListener((e)->{
            Database db;
            try {
                db=Database.openOrCreate("ProdFav");
                db.execute("create table if not exists prod (nomP TEXT);");

                db.execute("insert into prod (nomP) values ('"+p.getNomProduit()+"'); ");

                Cursor cur = db.executeQuery("select * from prod");
                while (cur.next()) {
                    Row row = cur.getRow();
                    String nom = row.getString(0);
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            new FavorisForm().show();


        });
    }

    public AffichageDetails(int id) {

    }

    public Form getF() {
        return f;
    }
    public void show(){
        f.show();
    }


}

