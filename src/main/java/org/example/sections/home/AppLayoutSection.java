package org.example.sections.home;

import java.util.HashMap;

import org.example.components.home.AppLayoutSample;
import org.example.components.home.DemoSection;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Iframe;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.utilities.Assets;

public class AppLayoutSection extends Composite<FlexLayout>{
  
  private FlexLayout self = getBoundComponent();
  private String title = "Simple to Scale.";
  private String subtitle = "As your application scales up,the webforJ framework has you covered! It provides robust and responsive tools, such as the App Layout component, to help quickly and easily make your application ready to meet the needs of your business.";
  private HashMap<String, String> exampleCode = new HashMap<>();
  Iframe iframe = new Iframe();

  public AppLayoutSection(){
    initExampleCode();
    initIFrame();
    self.add(new DemoSection(title, subtitle, exampleCode, iframe));
    // self.add(new DemoSection(title, subtitle, exampleCode, new AppLayoutSample()));
    self.setJustifyContent(FlexJustifyContent.CENTER);
    self.setSpacing("var(--dwc-space-l)");
    self.setWidth(1500);
    self.setMargin("4rem 0");
  }

  private void initExampleCode(){
    exampleCode.put("App.java", Assets.contentOf("static/code/applayout/Application.java"));
  }

  private void initIFrame(){
    iframe.setAttribute("id", "applayout__iframe");
    iframe.setAttribute("loading", "lazy");
    iframe.setSrc("https://demo.webforj.com/webapp/controlsamples/applayoutconferencedemo?");
    iframe.addClassName("example-program");
  }
}
