package org.example.views.outlets;

import org.example.sections.dashboard.BottomCharts;
import org.example.sections.dashboard.Counters;
import org.example.sections.dashboard.TeamCardDisplay;
import org.example.sections.dashboard.TodoInbox;
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

@Route(value = "/dashboard", outlet = MainLayout.class)
@FrameTitle("Dashboard")
public class DashboardView extends Composite<FlexLayout> implements HasVisibility{
  
  private FlexLayout self = getBoundComponent();

  public DashboardView() {
    self.addClassName("main-class");
    self.setDirection(FlexDirection.COLUMN);
    self.setAlignment(FlexAlignment.CENTER);
    self.add( new Counters(),
    new TopCharts(), 
    new TopSellingTable(),
    new BottomCharts(),
    new TeamCardDisplay(),
    new TodoInbox());
  }
}
