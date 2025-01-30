package org.example.components.ecom.productdetails;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Img;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.layout.flexlayout.FlexWrap;

public class ProductImage extends Composite<FlexLayout> {

    private final FlexLayout self = getBoundComponent();
    private final Img mainImage;
    private final FlexLayout thumbnailContainer;
    private final String[] imageUrls;

    public ProductImage(String[] imageUrls) {
        this.imageUrls = imageUrls;

        self.setDirection(FlexDirection.COLUMN)
            .setJustifyContent(FlexJustifyContent.CENTER)
            .setAlignment(FlexAlignment.CENTER)
            .setSpacing("20px")
            .setStyle("margin-right", "20px")
            .setStyle("background-color", "var(--dwc-surface-3)");

        mainImage = new Img(imageUrls[0]);
        mainImage.setWidth("350px")
                 .setHeight("auto")
                 .setStyle("margin-bottom", "10px");

        thumbnailContainer = new FlexLayout();
        thumbnailContainer.setJustifyContent(FlexJustifyContent.EVENLY)
                          .setWrap(FlexWrap.WRAP)
                          .setSpacing("10px")
                          .setStyle("margin-top", "10px");

        for (int i = 0; i < imageUrls.length; i++) {
            final int index = i;
            Img thumbnail = new Img(imageUrls[i]);
            thumbnail.setWidth("70px") 
                     .setHeight("auto")
                     .setStyle("cursor", "pointer");
            thumbnail.addClickListener(e -> updateMainImage(index));
            thumbnailContainer.add(thumbnail);
        }

        self.add(mainImage, thumbnailContainer);
    }

    private void updateMainImage(int index) {
        mainImage.setSrc(imageUrls[index]);
    }
}