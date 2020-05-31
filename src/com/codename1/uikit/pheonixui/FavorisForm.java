package com.codename1.uikit.pheonixui;


import com.codename1.components.FloatingActionButton;
import com.codename1.components.SpanLabel;
import com.codename1.db.Cursor;
import com.codename1.db.Database;
import com.codename1.db.Row;
import com.codename1.ui.*;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.uikit.pheonixui.BaseForm;
import com.codename1.uikit.pheonixui.services.ServiceProduits;

import java.io.IOException;
import java.util.List;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class FavorisForm extends BaseForm {

    public FavorisForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    @Override
    protected boolean isCurrentInbox() {
        return true;
    }



    public FavorisForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        Database db;
        Form f;
        try {
            db=Database.openOrCreate("User");
            Cursor cur = db.executeQuery("select nom from user where etat=1");
            while (cur.next()) {
                Row row = cur.getRow();
                String nom = row.getString(0);getToolbar().setTitleComponent(
                        FlowLayout.encloseCenterMiddle(


                                new Label("Favoris", "Title"),
                                new Label(nom, "InboxNumber")
                        )
                );

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }






        installSidemenu(resourceObjectInstance);

        getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {});

        gui_Label_5.setShowEvenIfBlank(true);
        gui_Label_6.setShowEvenIfBlank(true);
        gui_Label_7.setShowEvenIfBlank(true);
        gui_Label_8.setShowEvenIfBlank(true);
        gui_Label_9.setShowEvenIfBlank(true);

        gui_Text_Area_1.setRows(2);
        gui_Text_Area_1.setColumns(100);
        gui_Text_Area_1.setEditable(false);
        gui_Text_Area_1_1.setRows(2);
        gui_Text_Area_1_1.setColumns(100);
        gui_Text_Area_1_1.setEditable(false);
        gui_Text_Area_1_2.setRows(2);
        gui_Text_Area_1_2.setColumns(100);
        gui_Text_Area_1_2.setEditable(false);
        gui_Text_Area_1_3.setRows(2);
        gui_Text_Area_1_3.setColumns(100);
        gui_Text_Area_1_3.setEditable(false);
        gui_Text_Area_1_4.setRows(2);
        gui_Text_Area_1_4.setColumns(100);
        gui_Text_Area_1_4.setEditable(false);

        FloatingActionButton fab  = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        RoundBorder rb = (RoundBorder)fab.getUnselectedStyle().getBorder();
        rb.uiid(true);
        fab.bindFabToContainer(getContentPane());
        fab.addActionListener(e -> {
            fab.setUIID("FloatingActionButtonClose");
            Image oldImage = fab.getIcon();
            FontImage image = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "FloatingActionButton", 3.8f);
            fab.setIcon(image);
            Dialog popup = new Dialog();
            popup.setDialogUIID("Container");
            popup.setLayout(new LayeredLayout());

            Button c1 = new Button(resourceObjectInstance.getImage("contact-a.png"));
            Button c2 = new Button(resourceObjectInstance.getImage("contact-b.png"));
            Button c3 = new Button(resourceObjectInstance.getImage("contact-c.png"));
            Button trans = new Button(" ");
            trans.setUIID("Container");
            c1.setUIID("Container");
            c2.setUIID("Container");
            c3.setUIID("Container");
            Style c1s = c1.getAllStyles();
            Style c2s = c2.getAllStyles();
            Style c3s = c3.getAllStyles();

            c1s.setMarginUnit(Style.UNIT_TYPE_DIPS);
            c2s.setMarginUnit(Style.UNIT_TYPE_DIPS);
            c3s.setMarginUnit(Style.UNIT_TYPE_DIPS);

            c1s.setMarginBottom(16);
            c1s.setMarginLeft(12);
            c1s.setMarginRight(3);

            c2s.setMarginLeft(4);
            c2s.setMarginTop(5);
            c2s.setMarginBottom(10);
            c3s.setMarginRight(14);

            c3s.setMarginTop(12);
            c3s.setMarginRight(16);

            popup.add(trans).
                    add(FlowLayout.encloseIn(c1)).
                    add(FlowLayout.encloseIn(c2)).
                    add(FlowLayout.encloseIn(c3));

            ActionListener a = ee -> popup.dispose();

            trans.addActionListener(a);
            c1.addActionListener(a);
            c2.addActionListener(a);
            c3.addActionListener(a);

            popup.setTransitionInAnimator(CommonTransitions.createEmpty());
            popup.setTransitionOutAnimator(CommonTransitions.createEmpty());
            popup.setDisposeWhenPointerOutOfBounds(true);
            int t = com.codename1.uikit.pheonixui.FavorisForm.this.getTintColor();
            com.codename1.uikit.pheonixui.FavorisForm.this.setTintColor(0);
            popup.showPopupDialog(new Rectangle(com.codename1.uikit.pheonixui.FavorisForm.this.getWidth() - 10, com.codename1.uikit.pheonixui.FavorisForm.this.getHeight() - 10, 10, 10));
            com.codename1.uikit.pheonixui.FavorisForm.this.setTintColor(t);
            fab.setUIID("FloatingActionButton");
            fab.setIcon(oldImage);
        });
    }

    ////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    protected com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.Label gui_Label_4 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();
    protected com.codename1.ui.Label gui_Label_6 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_1_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    protected com.codename1.ui.Container gui_Container_2_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.Label gui_Label_1_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_4_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.Label gui_Label_4_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_3_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_Label_3_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.TextArea gui_Text_Area_1_1 = new com.codename1.ui.TextArea();
    protected com.codename1.ui.Label gui_Label_7 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_1_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    protected com.codename1.ui.Container gui_Container_2_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.Label gui_Label_1_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_4_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.Label gui_Label_4_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_3_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_Label_3_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.TextArea gui_Text_Area_1_2 = new com.codename1.ui.TextArea();
    protected com.codename1.ui.Label gui_Label_8 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_1_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    protected com.codename1.ui.Container gui_Container_2_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.Label gui_Label_1_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_4_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.Label gui_Label_4_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_3_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_Label_3_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.TextArea gui_Text_Area_1_3 = new com.codename1.ui.TextArea();
    protected com.codename1.ui.Label gui_Label_9 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_1_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    protected com.codename1.ui.Container gui_Container_2_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.Label gui_Label_1_4 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_4_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.Label gui_Label_4_4 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_3_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_Label_3_4 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2_4 = new com.codename1.ui.Label();
    protected com.codename1.ui.TextArea gui_Text_Area_1_4 = new com.codename1.ui.TextArea();
    protected com.codename1.ui.Label gui_Label_5 = new com.codename1.ui.Label();


    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setInlineStylesTheme(resourceObjectInstance);
        setInlineStylesTheme(resourceObjectInstance);
        setTitle("InboxForm");
        setName("InboxForm");

        Database db;
        try {
            db=Database.openOrCreate("ProdFav");
            Cursor cur = db.executeQuery("select * from prod");
            while (cur.next()) {
                Row row = cur.getRow();
                String nom = row.getString(0);
                System.out.println("nom :" + nom );
                SpanLabel sp=new SpanLabel();
                sp.setText(nom);
               // f.add(sp);

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!


}
