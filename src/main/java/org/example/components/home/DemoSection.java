package org.example.components.home;

import java.util.Map;

import com.webforj.component.Component;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.H2;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.tabbedpane.TabbedPane;

public class DemoSection extends Composite<FlexLayout>  {
  
  private FlexLayout self = getBoundComponent();
  private FlexLayout subSection = new FlexLayout();
  private H2 title = new H2();
  private Paragraph subtitle = new Paragraph();
  Div header = new Div();
  private TabbedPane codeTabs = new TabbedPane();

  public DemoSection(String title, String subtitle, Map<String, String> exampleCode, Component demo){
    initHeader(title, subtitle);
    initCodeTabs(exampleCode);
    self.add(subSection, demo);
    configureLayout();
  }

  private void initHeader(String title, String subtitle){
    this.title.setText(title);
    this.subtitle.setText(subtitle);
    header.add(this.title, this.subtitle);
    subSection.add(header);
  }

  private void initCodeTabs(Map<String, String> exampleCode){
    for(Map.Entry<String, String> entry: exampleCode.entrySet()){
      CodeDisplay tabCode = new CodeDisplay();
      tabCode.setLanguage("java");
      tabCode.setText(entry.getValue());
      codeTabs.addTab(entry.getKey(), tabCode);
    }
    subSection.add(codeTabs);
  }

  private void configureLayout(){
    self.setSpacing("4rem");

    subSection.setDirection(FlexDirection.COLUMN);
    subSection.setSpacing("var(--dwc-space-l)");
    subSection.setWidth("600px");
  }
}
