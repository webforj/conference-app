package org.example.components.ecom.products;

import java.util.ArrayList;
import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.TextField;
import com.webforj.component.field.TextField.Type;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.list.ListItem;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;

public class SearchBar extends Composite<FlexLayout> {
  
    private FlexLayout searchContainer = new FlexLayout();
    private FlexLayout sortContainer = new FlexLayout();
    private TextField searchInput = new TextField();
    private Button searchBtn = new Button("Go");
    private Paragraph sortLbl = new Paragraph("Sort by");
    private ChoiceBox sortDrop = new ChoiceBox();

    public SearchBar() {
      
        FlexLayout self = getBoundComponent();
        self.setJustifyContent(FlexJustifyContent.BETWEEN)
            .setAlignment(FlexAlignment.CENTER)
            .setWidth("100%")
            .setMargin("0 20px")  
            .setWidth("calc(100% - 40px)")
            .setPadding("20px")
            .setStyle("background-color", "var(--dwc-surface-3)");

        searchInput.setType(Type.SEARCH)
                   .setPlaceholder("Search...")
                   .setStyle("flex", "1");

        searchBtn.setTheme(ButtonTheme.OUTLINED_PRIMARY)
                 .setStyle("min-width", "60px"); // Prevents it from shrinking

        searchContainer.setAlignment(FlexAlignment.CENTER)
                       .setSpacing("10px")
                       .setWidth("100%");
        searchContainer.add(searchInput, searchBtn);

        ArrayList<ListItem> categories = new ArrayList<>();
        categories.add(new ListItem("All"));
        categories.add(new ListItem("Popular"));
        categories.add(new ListItem("Price Low to High"));
        categories.add(new ListItem("Price High to Low"));
        categories.add(new ListItem("Sold Out"));
        sortDrop.insert(categories)
                .selectIndex(0)
                .setStyle("flex", "1");

        sortLbl.setStyle("font-weight", "bold")
               .setStyle("margin-right", "5px");

        sortContainer.setDirection(FlexDirection.ROW)
                     .setAlignment(FlexAlignment.CENTER)
                     .setSpacing("10px")
                     .setWidth("300px")
                     .setStyle("margin-left", "auto"); 
        sortContainer.add(sortLbl, sortDrop);

        self.add(searchContainer, sortContainer);
    }
}