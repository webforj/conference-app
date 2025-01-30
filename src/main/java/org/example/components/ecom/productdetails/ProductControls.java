package org.example.components.ecom.productdetails;

import java.util.ArrayList;
import com.webforj.component.Composite;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.icons.IconButton;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.list.ListItem;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;

public class ProductControls extends Composite<FlexLayout> {

    private final FlexLayout self = getBoundComponent();

    public ProductControls() {
        self.setDirection(FlexDirection.COLUMN)
            .setSpacing("30px")
            .setStyle("width", "100%"); 

        ChoiceBox sizeDrop = new ChoiceBox();
        sizeDrop.insert(createListItems("XS", "S", "M", "L", "XL"))
                .setLabel("Size")
                .setWidth("85px")
                .selectIndex(0);

        ChoiceBox quantityDrop = new ChoiceBox();
        quantityDrop.insert(createListItems("1", "2", "3", "4", "5"))
                    .setLabel("Quantity")
                    .setWidth("85px")
                    .selectIndex(0);

        FlexLayout menuButtons = new FlexLayout();
        menuButtons.setDirection(FlexDirection.ROW)
                   .setSpacing("30px");
        menuButtons.add(sizeDrop, quantityDrop);

        IconButton likeButton = new IconButton(TablerIcon.create("heart"));
        likeButton.setTheme(Theme.DANGER);

        Button cartButton = new Button("Add To Cart").setTheme(ButtonTheme.PRIMARY);

        FlexLayout optionButtons = new FlexLayout();
        optionButtons.setDirection(FlexDirection.ROW)
                     .setSpacing("30px")
                     .setWidth("200px")
                     .setJustifyContent(FlexJustifyContent.BETWEEN);
        optionButtons.add(likeButton, cartButton);

        self.add(menuButtons, optionButtons);
    }

    private ArrayList<ListItem> createListItems(String... items) {
        ArrayList<ListItem> listItems = new ArrayList<>();
        for (String item : items) {
            listItems.add(new ListItem(item));
        }
        return listItems;
    }
}
