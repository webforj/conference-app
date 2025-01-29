package org.example.components.home;

import com.webforj.component.Composite;
import com.webforj.component.field.TextField;
import com.webforj.component.html.elements.H3;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;

public class WebComponentSample extends Composite<FlexLayout> {

  private FlexLayout self = getBoundComponent();
  private H3 title = new H3("Simple Counter");
  private QRCode qr = new QRCode();
  private TextField input = new TextField();

  public WebComponentSample() {
    configureStyling();

    title.setText("QRCode Generator");
    qr.setColor(new java.awt.Color(0, 86, 179));
    input.setPlaceholder("Enter a value");
    input.onModify(e -> qr.setValue(input.getText()));
    
    self.add(title, qr, input);
  }

  private void configureStyling() {
    self.setDirection(FlexDirection.COLUMN);
    self.setJustifyContent(FlexJustifyContent.CENTER);
    self.setAlignment(FlexAlignment.CENTER);
    self.setSpacing("var(--dwc-space-m)");
    self.addClassName("example-program");
  }
}
