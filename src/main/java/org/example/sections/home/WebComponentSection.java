package org.example.sections.home;

import java.util.HashMap;

import org.example.components.home.DemoSection;
import org.example.components.home.WebComponentSample;

import com.webforj.component.Composite;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.utilities.Assets;

public class WebComponentSection extends Composite<FlexLayout>{

  private FlexLayout self = getBoundComponent();
  private String title = "Use Powerful Web Components.";
  private String subtitle = "Reach outside of the extensive set of webforJ core components by importing your favorite web components using webforJ's web component API. Utilize any open-source web component library, or create your own for use in your application.";
  private HashMap<String, String> exampleCode = new HashMap<>();

  public WebComponentSection(){
    initExampleCode();
    self.add(new DemoSection(title, subtitle, exampleCode, new WebComponentSample()));
    self.setJustifyContent(FlexJustifyContent.CENTER);
    self.setSpacing("var(--dwc-space-l)");
    self.setWidth(1500);
    self.setMargin("4rem 0");
  }

  private void initExampleCode(){
    exampleCode.put("App.java", Assets.contentOf("static/code/qrcode/QRCodeApplication.java"));
    exampleCode.put("QRCode.java", Assets.contentOf("static/code/qrcode/QRCode.java"));
  }
}