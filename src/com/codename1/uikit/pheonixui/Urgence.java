package com.codename1.uikit.pheonixui;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.MultiButton;
import com.codename1.ui.*;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.*;
import com.codename1.ui.list.GenericListCellRenderer;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.Validator;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Urgence extends BaseForm {
    public Urgence() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public Urgence(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);

        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Urgence", "Title")
                )
        );

        installSidemenu(resourceObjectInstance);

       // getToolbar().addCommandToRightBar("", resourceObjectInstance.getImage("toolbar-profile-pic.png"), e -> {});

        setLayout(new BorderLayout());

        BrowserComponent browser = new BrowserComponent();
        URL url = this.getClass().getResource("html/mapUrgence.html");
        browser.setURL(url.toString());


        addComponent(BorderLayout.CENTER, browser);

        FloatingActionButton fab  = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        RoundBorder rb = (RoundBorder)fab.getUnselectedStyle().getBorder();
        rb.uiid(true);
        fab.bindFabToContainer(getContentPane(),LEFT,BOTTOM);
        fab.addActionListener(e -> {
            new UrgenceAddForm().show();
        });

    }

    public void onText_AreaActionEvent(com.codename1.ui.events.ActionEvent ev) {
    }


//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.FlowLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("Urgence");
        setName("Urgence");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
