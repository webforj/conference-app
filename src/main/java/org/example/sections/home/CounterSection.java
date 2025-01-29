package org.example.sections.home;

import java.util.HashMap;

import org.example.components.home.CounterSample;
import org.example.components.home.DemoSection;

import com.webforj.component.Composite;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.utilities.Assets;

public class CounterSection extends Composite<FlexLayout>{

  private FlexLayout self = getBoundComponent();
  private String title = "Easy to Start.";
  private String subtitle = "Creating your application in webforJ is simple - use our extensive library of feature-rich and robust components to start building your application with a few lines of Java or Kotlin code!";
  private HashMap<String, String> exampleCode = new HashMap<>();

  public CounterSection(){
    initExampleCode();
    self.add(new DemoSection(title, subtitle, exampleCode, new CounterSample()));
    self.setJustifyContent(FlexJustifyContent.CENTER);
    self.setSpacing("var(--dwc-space-l)");
    self.setWidth(1500);
    self.setMargin("4rem 0");
  }

  private void initExampleCode(){
    exampleCode.put("App.java", Assets.contentOf("static/code/counter/Application.java"));
    exampleCode.put("App.kt", Assets.contentOf("static/code/counter/Application.kt"));
  }
}
