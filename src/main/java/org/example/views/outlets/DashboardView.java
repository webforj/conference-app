package org.example.views.outlets;

import org.example.sections.dashboard.BottomCharts;
import org.example.sections.dashboard.TeamCardDisplay;
import org.example.sections.dashboard.TopCharts;
import org.example.sections.dashboard.TopSellingTable;
import org.example.views.MainLayout;

import com.webforj.component.Composite;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.concern.HasVisibility;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.router.annotation.RouteAlias;

@Route(value = "/", outlet = MainLayout.class)
@RouteAlias(value = "/dashboard")
@FrameTitle("Dashboard")
public class DashboardView extends Composite<FlexLayout> implements HasVisibility{
  
  private FlexLayout self = getBoundComponent();

  public DashboardView() {
    self.setPadding("0 0 50vh 0");
    self.setDirection(FlexDirection.COLUMN);
    self.setAlignment(FlexAlignment.CENTER);
    self.add(new TopCharts(), 
    new TopSellingTable(),
    new BottomCharts(),
    new TeamCardDisplay());
  }
}
