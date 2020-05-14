/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.codename1.uikit.pheonixui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.pheonixui.entities.Produits;
import com.codename1.uikit.pheonixui.services.ServiceProduits;

import javax.naming.directory.SearchResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class ProduitsForm extends BaseForm {
    ArrayList<Produits> prod = new ArrayList<>();
    Form f;
    SpanLabel lb;

    ServiceProduits ser=new ServiceProduits();
    

    public ProduitsForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public ProduitsForm(Resources resourceObjectInstance) {
        /*
        ServiceProduits ser=new ServiceProduits();
        prod = ser.getAllProducts();
        
         */

        installSidemenu(resourceObjectInstance);
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
        setTitle("Catalogue produits");

/*
        SpanLabel sp = new SpanLabel();
        sp.setText(ServiceProduits.getInstance().getAllProducts().toString());
        add(sp);

 */

        f = new Form();
        lb = new SpanLabel("");
        f.add(lb);
   
        ser=new ServiceProduits();
        prod = ser.getAllProducts();
        if(prod!=null && !prod.isEmpty())
        {initi();}
        f.getToolbar().addCommandToRightBar("back", null, (ev)->{ProdForm h=new ProdForm();
            h.getF().show();
        });


    }





    ////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    protected com.codename1.components.MultiButton gui_Multi_Button_1 = new com.codename1.components.MultiButton();
    protected com.codename1.components.MultiButton gui_LA = new com.codename1.components.MultiButton();
    protected com.codename1.ui.Container gui_imageContainer1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    protected com.codename1.ui.TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();
    protected com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_separator1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_null_1_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    protected com.codename1.components.MultiButton gui_null_1_1_1 = new com.codename1.components.MultiButton();
    protected com.codename1.components.MultiButton gui_newYork = new com.codename1.components.MultiButton();
    protected com.codename1.ui.Container gui_imageContainer2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    protected com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    protected com.codename1.ui.TextArea gui_Text_Area_2 = new com.codename1.ui.TextArea();
    protected com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Label_1_1_1 = new com.codename1.ui.Label();


    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setInlineStylesTheme(resourceObjectInstance);
        setInlineStylesTheme(resourceObjectInstance);
        setTitle("Produits");
        setName("Produits");
        gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_imageContainer1.setInlineStylesTheme(resourceObjectInstance);
        gui_imageContainer1.setName("imageContainer1");
        gui_separator1.setUIID("Separator");
        gui_separator1.setInlineStylesTheme(resourceObjectInstance);
        gui_separator1.setName("separator1");
        gui_null_1_1.setInlineStylesTheme(resourceObjectInstance);
        gui_null_1_1.setName("null_1_1");
        gui_imageContainer2.setInlineStylesTheme(resourceObjectInstance);
        gui_imageContainer2.setName("imageContainer2");
        gui_Label_1_1_1.setUIID("Separator");
        gui_Label_1_1_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1_1_1.setName("Label_1_1_1");
        addComponent(gui_Container_1);
        gui_Multi_Button_1.setUIID("Label");
        gui_Multi_Button_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Multi_Button_1.setName("Multi_Button_1");
        gui_Multi_Button_1.setIcon(resourceObjectInstance.getImage("contact-c.png"));
        gui_Multi_Button_1.setPropertyValue("line1", "Ami Koehler");
        gui_Multi_Button_1.setPropertyValue("line2", "@dropperidiot");
        gui_Multi_Button_1.setPropertyValue("uiid1", "Label");
        gui_Multi_Button_1.setPropertyValue("uiid2", "RedLabel");
        gui_LA.setUIID("Label");
        gui_LA.setInlineStylesTheme(resourceObjectInstance);
        gui_LA.setName("LA");
        gui_LA.setPropertyValue("line1", "3 minutes ago");
        gui_LA.setPropertyValue("line2", "in Los Angeles");
        gui_LA.setPropertyValue("uiid1", "SlightlySmallerFontLabel");
        gui_LA.setPropertyValue("uiid2", "RedLabelRight");
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Multi_Button_1);
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_LA);
        addComponent(gui_imageContainer1);
        gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2");
        gui_imageContainer1.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Container_2);
        gui_Text_Area_1.setText("The park is a favorite among skaters in California and it definitely deserves it. The park is complete with plenty of smooth banks to gain a ton of speed in the flow bowl.");
        gui_Text_Area_1.setUIID("SlightlySmallerFontLabelLeft");
        gui_Text_Area_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Area_1.setName("Text_Area_1");
        gui_Button_1.setText("");
        gui_Button_1.setUIID("Label");
        gui_Button_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_1.setName("Button_1");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button_1,"\ue5c8".charAt(0));
        gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Text_Area_1);
        gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Button_1);
        addComponent(gui_separator1);
        addComponent(gui_null_1_1);
        gui_null_1_1_1.setUIID("Label");
        gui_null_1_1_1.setInlineStylesTheme(resourceObjectInstance);
        gui_null_1_1_1.setName("null_1_1_1");
        gui_null_1_1_1.setIcon(resourceObjectInstance.getImage("contact-b.png"));
        gui_null_1_1_1.setPropertyValue("line1", "Detra Mcmunn");
        gui_null_1_1_1.setPropertyValue("line2", "@dropperidiot");
        gui_null_1_1_1.setPropertyValue("uiid1", "Label");
        gui_null_1_1_1.setPropertyValue("uiid2", "RedLabel");
        gui_newYork.setUIID("Label");
        gui_newYork.setInlineStylesTheme(resourceObjectInstance);
        gui_newYork.setName("newYork");
        gui_newYork.setPropertyValue("line1", "15 minutes ago");
        gui_newYork.setPropertyValue("line2", "in New York");
        gui_newYork.setPropertyValue("uiid1", "SlightlySmallerFontLabel");
        gui_newYork.setPropertyValue("uiid2", "RedLabelRight");
        gui_null_1_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_null_1_1_1);
        gui_null_1_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_newYork);
        addComponent(gui_imageContainer2);
        gui_Container_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_3.setName("Container_3");
        gui_imageContainer2.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Container_3);
        gui_Text_Area_2.setText("Griffith Observatory is a facility in Los Angeles, California sitting on the south-facing slope of Mount Hollywood in Los Angeles' Griffith Park.");
        gui_Text_Area_2.setUIID("SlightlySmallerFontLabelLeft");
        gui_Text_Area_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Area_2.setName("Text_Area_2");
        gui_Button_2.setText("");
        gui_Button_2.setUIID("Label");
        gui_Button_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_2.setName("Button_2");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button_2,"\ue5c8".charAt(0));
        gui_Container_3.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Text_Area_2);
        gui_Container_3.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Button_2);
        addComponent(gui_Label_1_1_1);
    }// </editor-fold>



    private void initi()

    {
        int mm = Display.getInstance().convertToPixels(3);
        EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(mm * 3, mm * 4, 0), false);

        f = new Form("Catalogue Produits", new BorderLayout());
        ArrayList<Map<String, Object>> data = new ArrayList<>();

        for(int i =0;i<prod.size();i++)
        {
            String filePath = "file:///D:/wamp64/www/Back/web/uploads/images/"+prod.get(i).getImage();
            if (filePath != null) {
                try {

                    String pathToBeStored;
                    pathToBeStored = FileSystemStorage.getInstance().getAppHomePath() + System.currentTimeMillis();
                    Image img;
                    img = Image.createImage(filePath);
                    int displayHeight = Display.getInstance().getDisplayHeight();
                    Image scaledPhotoImage = img.scaled(-1, displayHeight / 3);
                    data.add(createListEntry("      "+prod.get(i).getNomProduit(),scaledPhotoImage,"Prix: "+String.valueOf(prod.get(i).getPrix())));

                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }



        }

        DefaultListModel<Map<String, Object>> model = new DefaultListModel<>(data);
        MultiList ml = new MultiList(model);
/*ml.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent evt) {

                 System.out.println(ml.getSelectedItem());
             }
         });*/
        f.add(BorderLayout.CENTER, ml);
        ml.addActionListener((ActionListener) (ActionEvent evt) -> {


            AffichageDetails h = new AffichageDetails(prod.get(ml.getSelectedIndex()));
            h.getF().show();


        });
    }





    private Map<String, Object> createListEntry(String nomProduit,Image image, String prix) {
        Map<String, Object> entry = new HashMap<>();

        entry.put("Line1", nomProduit);
        entry.put("Line2", image);
        entry.put("Line3", prix);
        return entry;
    }
    private Map<String, Object> createListEntry1(String nomProduit, String prix) {
        Map<String, Object> entry = new HashMap<>();
        entry.put("Line1", nomProduit);
        entry.put("Line2", prix);

        return entry;
    }



    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

//-- DON'T EDIT ABOVE THIS LINE!!!

    @Override
    protected boolean isCurrentTrending() {
        return true;
    }


}
