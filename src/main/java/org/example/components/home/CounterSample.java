package org.example.components.home;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.html.elements.H3;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;

public class CounterSample extends Composite<FlexLayout> {
  
  private FlexLayout self = getBoundComponent();
  private int count = 0;
  private H3 title = new H3("Simple Counter");
  private Paragraph text = new Paragraph("Count: 0");
  private Button counter = new Button("Counter");

  public CounterSample(){
    configureStyling();
    self.add(title, text, counter);
    counter.onClick(e -> text.setText("Count: " + (++count)));
  }

  private void configureStyling(){
    self.setDirection(FlexDirection.COLUMN);
    self.setJustifyContent(FlexJustifyContent.CENTER);
    self.setAlignment(FlexAlignment.CENTER);
    self.setSpacing("var(--dwc-space-m)");
    self.addClassName("example-program");
  }


}
