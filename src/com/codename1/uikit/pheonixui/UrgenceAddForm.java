package com.codename1.uikit.pheonixui;

import com.codename1.components.MultiButton;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.TextModeLayout;
import com.codename1.ui.list.GenericListCellRenderer;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.NumericConstraint;
import com.codename1.ui.validation.Validator;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UrgenceAddForm extends com.codename1.ui.Form {
    public UrgenceAddForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public UrgenceAddForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);

        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Nouvelle urgence", "Title")
                )
        );

        //installSidemenu(resourceObjectInstance);

        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e ->{new Urgence().show();});
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ADD_ALERT, e ->{});

        TableLayout tl;
        int spanButton = 2;
        if(Display.getInstance().isTablet()) {
            tl = new TableLayout(7, 2);
        } else {
            tl = new TableLayout(14, 1);
            spanButton = 1;
        }
        tl.setGrowHorizontally(true);
        setLayout(tl);

        TextComponent plus = new TextComponent().label("Votre entourage").hint("ex : je suis seul");
        TextComponent description = new TextComponent().label("Description").multiline(true);
        CheckBox cb1 = new CheckBox("Selectionner une expedition");
        ComboBox<Map<String, Object>> expedition = new ComboBox<> (
                createListEntry("Expedition 1", "2020"));

        expedition.setRenderer(new GenericListCellRenderer<>(new MultiButton(), new MultiButton()));

        Button envoyer = new Button("Envoyer");
        TableLayout.Constraint cn = tl.createConstraint();
        cn.setHorizontalSpan(spanButton);
        cn.setHorizontalAlign(Component.CENTER);
        Validator val = new Validator();
        val.addConstraint(plus, new LengthConstraint(2));
        expedition.setEnabled(false);

        cb1.addChangeListener(e ->{
            if(cb1.isSelected()){
                plus.setEnabled(false);
                expedition.setEnabled(true);
            }
            else{
                plus.setEnabled(true);
                expedition.setEnabled(false);
            }

        });
            add(tl.createConstraint().horizontalSpan(2), description).
                    add(cb1).
                    add(tl.createConstraint().horizontalSpan(2), plus).
                    add(expedition).
                    add(cn, envoyer);


    }
    private Map<String, Object> createListEntry(String name, String date) {
        Map<String, Object> entry = new HashMap<>();
        entry.put("Line1", name);
        entry.put("Line2", date);
        return entry;
    }

    //-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.TextArea gui_description = new com.codename1.ui.TextArea();
    protected com.codename1.ui.CheckBox gui_checkbox = new com.codename1.ui.CheckBox();
    protected com.codename1.ui.TextField gui_Text_Field = new com.codename1.ui.TextField();
    protected com.codename1.ui.Container gui_Box_Layout_X = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    protected com.codename1.ui.Container gui_Box_Layout_X_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    protected com.codename1.ui.ComboBox gui_expedition = new com.codename1.ui.ComboBox();
    protected com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("UrgenceAddForm");
        setName("UrgenceAddForm");
        addComponent(gui_description);
        addComponent(gui_checkbox);
        addComponent(gui_Text_Field);
        addComponent(gui_Box_Layout_X);
                gui_Box_Layout_X.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X.setName("Box_Layout_X");
        ((com.codename1.ui.layouts.BorderLayout)gui_Box_Layout_X.getLayout()).setCenterBehavior(com.codename1.ui.layouts.BorderLayout.CENTER_BEHAVIOR_CENTER);
        gui_Box_Layout_X.addComponent(com.codename1.ui.layouts.BorderLayout.NORTH, gui_Box_Layout_X_1);
                gui_Box_Layout_X_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_1.setName("Box_Layout_X_1");
        ((com.codename1.ui.layouts.BorderLayout)gui_Box_Layout_X_1.getLayout()).setCenterBehavior(com.codename1.ui.layouts.BorderLayout.CENTER_BEHAVIOR_CENTER);
        gui_Box_Layout_X_1.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_expedition);
                gui_expedition.setInlineStylesTheme(resourceObjectInstance);
        gui_expedition.setInlineAllStyles("border:1.0px underline 6da85a; bgColor:cccccc;");
        gui_expedition.setName("expedition");
        gui_Box_Layout_X.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Button);
                gui_Box_Layout_X_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_1.setName("Box_Layout_X_1");
        ((com.codename1.ui.layouts.BorderLayout)gui_Box_Layout_X_1.getLayout()).setCenterBehavior(com.codename1.ui.layouts.BorderLayout.CENTER_BEHAVIOR_CENTER);
        gui_Button.setText("Envoyer");
                gui_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Button.setName("Button");
        gui_description.setHint("Description");
                gui_description.setInlineStylesTheme(resourceObjectInstance);
        gui_description.setInlineAllStyles("border:1.0px underline 6da85a;");
        gui_description.setName("description");
        gui_description.setColumns(8);
        gui_description.setRows(3);
        gui_checkbox.setSelected(false);
        gui_checkbox.setText("Expedition ?");
                gui_checkbox.setInlineStylesTheme(resourceObjectInstance);
        gui_checkbox.setInlineAllStyles("border:none;");
        gui_checkbox.setName("checkbox");
        gui_Text_Field.setHint("Entourage");
                gui_Text_Field.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Field.setInlineAllStyles("border:1.0px underline 6da85a;");
        gui_Text_Field.setName("Text_Field");
                gui_Box_Layout_X.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X.setName("Box_Layout_X");
        ((com.codename1.ui.layouts.BorderLayout)gui_Box_Layout_X.getLayout()).setCenterBehavior(com.codename1.ui.layouts.BorderLayout.CENTER_BEHAVIOR_CENTER);
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
