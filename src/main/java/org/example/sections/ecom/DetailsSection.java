package org.example.sections.ecom;

import org.example.components.ecom.productdetails.ProductDetails;
import org.example.components.ecom.productdetails.ProductImage;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;

public class DetailsSection extends Composite<FlexLayout> {

    private final FlexLayout self = getBoundComponent();

    public DetailsSection() {
        
        self.setDirection(FlexDirection.COLUMN)
            .setJustifyContent(FlexJustifyContent.CENTER)
            .setAlignment(FlexAlignment.CENTER)
            .setSpacing("20px")
            .setHeight("auto")
            .setStyle("flex", "0 1 auto")
            .setStyle("background-color", "var(--dwc-surface-3)")
            .setPadding("20px")
            .setMargin("0 0 200px 0");

        String[] imageUrls = {
            "context://static/img/thumbnail-1.jpeg",
            "context://static/img/thumbnail-2.jpeg",
            "context://static/img/thumbnail-3.jpeg",
            "context://static/img/thumbnail-4.jpeg",
        };

        ProductImage productImage = new ProductImage(imageUrls);
        ProductDetails productDetails = new ProductDetails();

        FlexLayout productDetailsContainer = new FlexLayout();
        productDetailsContainer.setDirection(FlexDirection.ROW)
                               .setSpacing("20px")
                               .setStyle("margin", "auto")
                               .setStyle("background-color", "var(--dwc-surface-3)");

        FlexLayout imageContainer = new FlexLayout();
        imageContainer.setDirection(FlexDirection.COLUMN)
                      .setStyle("flex", "1")
                      .setStyle("margin-right", "20px");

        imageContainer.add(productImage);
        productDetailsContainer.add(imageContainer, productDetails);
        self.add(productDetailsContainer);
    }
}