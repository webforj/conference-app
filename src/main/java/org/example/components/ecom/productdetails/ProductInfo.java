package org.example.components.ecom.productdetails;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.html.elements.Span;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;

public class ProductInfo extends Composite<FlexLayout> {

    private final FlexLayout self = getBoundComponent();

    public ProductInfo(Paragraph title, Paragraph rating, Paragraph stockStatus, String originalPrice, String discountedPrice, String description) {
        self.setDirection(FlexDirection.COLUMN)
            .setJustifyContent(FlexJustifyContent.EVENLY)
            .setSpacing("30px")
            .setStyle("flex", "2")
            .setStyle("margin-bottom", "30px")
            .setStyle("background-color", "var(--dwc-surface-3)");

        title.setStyle("font-weight", "bold")
             .setStyle("font-size", "2rem")
             .setStyle("margin-bottom", "15px");

        rating.setStyle("font-weight", "normal");

        stockStatus.setStyle("display", "flex")
                   .setStyle("padding", "5px 15px")
                   .setStyle("background-color", "#dce5ee")
                   .setStyle("font-weight", "bold")
                   .setStyle("border-radius", "12px")
                   .setStyle("font-size", "0.9em")
                   .setStyle("width", "60px")
                   .setStyle("justify-content", "center");

        Span originalPriceSpan = new Span(originalPrice);
        originalPriceSpan.setStyle("font-size", "1.2rem")
                         .setStyle("color", "#777")
                         .setStyle("text-decoration", "line-through")
                         .setStyle("margin-right", "10px")
                         .setStyle("margin-left", "10px");

        Span discountedPriceSpan = new Span(discountedPrice);
        discountedPriceSpan.setStyle("font-size", "1.5rem")
                           .setStyle("padding-left", "5px");

        Paragraph price = new Paragraph("Price: ");
        price.setStyle("display", "flex")
             .setStyle("align-items", "baseline")
             .setStyle("font-weight", "bold");
        price.add(originalPriceSpan, discountedPriceSpan);

        Paragraph descContainer = new Paragraph(description);
        descContainer.setStyle("font-size", "1rem");

        self.add(title, rating, stockStatus, price, descContainer);
    }
}
