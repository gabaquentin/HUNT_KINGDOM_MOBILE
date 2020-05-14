/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.pheonixui;

import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.pheonixui.entities.Produits;
import com.codename1.uikit.pheonixui.services.ServiceProduits;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sana
 */
public class ProdForm extends BaseForm {

    Form f;
    TextField tnom;
    TextField tetat;
    TextField trecherche;
    Button btnrecherche;
    Button btnajout,btnaff,btnStat;
    ServiceProduits ser=new ServiceProduits();
    ArrayList<Produits> produits = new ArrayList<>();
    SpanLabel lb;

    public ProdForm(Resources resourceObjectInstance) {
        f = new Form("Boutique");
        lb = new SpanLabel("");



        btnaff=new Button("Catalogue Produits");
        btnStat = new Button("Statistique Produits");


        f.add(lb);
       /* btnrecherche.addActionListener((e) -> {
            ServiceVoyage ser = new ServiceVoyage();
            Voyage v = new Voyage();
            ser.FindVoyage(v);


        });*/



        f.add(btnaff);
        f.add(btnStat);
        btnaff.addActionListener((e)->{
            ProduitsForm a=new ProduitsForm();
            a.getF().show();
        });

    }

    public ProdForm() {

    }

    public void show(){
        f.show();
    }

    public Form getF() {
        return f;
    }
    private Map<String, Object> createListEntry(String nomProduit,Image image, String prix) {
        Map<String, Object> entry = new HashMap<>();

        entry.put("Line1", nomProduit);
        entry.put("Line2", image);
        entry.put("Line3", prix);
        return entry;
    }

    public void setF(Form f) {
        this.f = f;
    }





}
