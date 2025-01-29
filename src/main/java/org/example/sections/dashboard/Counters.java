package org.example.sections.dashboard;

import org.example.components.dashboard.counters.Target;
import org.example.components.dashboard.counters.TodaySales;
import org.example.components.dashboard.counters.TotalRevenue;

import com.webforj.component.Composite;
import com.webforj.component.layout.flexlayout.FlexLayout;

public class Counters extends Composite<FlexLayout>{

  FlexLayout self = getBoundComponent();

  public Counters(){
    self.add(new TotalRevenue(), new Target(), new TodaySales());
    self.setSpacing("var(--dwc-space-m)");
    self.setWidth("102%");
  }
  
}
