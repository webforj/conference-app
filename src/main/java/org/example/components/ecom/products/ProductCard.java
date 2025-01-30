package org.example.components.ecom.products;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Img;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route
@FrameTitle("Item Cards")
public class ProductCard extends Composite<FlexLayout> {

  public ProductCard(String imageUrl, String name, String price, String rating, String stock) {
    
    FlexLayout itemCard = getBoundComponent();
    itemCard.setDirection(FlexDirection.COLUMN);
    itemCard.setAlignment(FlexAlignment.CENTER);
    itemCard.setPadding("15px 40px");
    itemCard.setStyle("gap", "0")
            .setStyle("flex", "1 1 15%")
            .setStyle("background-color", "var(--dwc-surface-3)")
            .setStyle("box-shadow", "0 2px 4px var(--dwc-shadow-color)");

    // Image
    Img itemImage = new Img(imageUrl, "Product Image");
    itemImage.setWidth("100%");
    itemImage.setHeight("auto");
    itemImage.setStyle("object-fit", "contain");

    // Name
    Paragraph itemName = new Paragraph(name);
    itemName.setStyle("font-weight", "bold");

    // Price
    Paragraph itemPrice = new Paragraph(price);
    itemPrice.setStyle("font-size", "1.2em");

    // Rating
    FlexLayout ratingContainer = new FlexLayout();
    ratingContainer.setJustifyContent(FlexJustifyContent.CENTER);
    ratingContainer.add(new Paragraph(rating));

    // Stock Status
    Paragraph stockStatus = new Paragraph(stock);
    stockStatus.setStyle("font-size", "0.8em");

    // Add components to card
    itemCard.add(itemImage, itemName, itemPrice, ratingContainer, stockStatus);
  }
}
