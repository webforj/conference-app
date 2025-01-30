package org.example.views;

import java.util.Set;

import org.example.components.ThemeToggle;

import com.webforj.component.Component;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.H1;
import com.webforj.component.html.elements.Img;
import com.webforj.component.icons.TablerIcon;
import com.webforj.component.layout.applayout.AppLayout;
import com.webforj.component.layout.applayout.AppLayout.DrawerPlacement;
import com.webforj.component.tabbedpane.Tab;
import com.webforj.component.tabbedpane.TabbedPane;
import com.webforj.component.tabbedpane.event.TabSelectEvent;
import com.webforj.dispatcher.ListenerRegistration;
import com.webforj.router.PersistentRouteOutlet;
import com.webforj.router.RouteOutlet;
import com.webforj.router.Router;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.router.event.DidEnterEvent;
import com.webforj.router.event.NavigateEvent;
import com.webforj.router.history.Location;
import com.webforj.router.history.ParametersBag;
import com.webforj.router.observer.DidEnterObserver;

@Route
public class MainLayout extends Composite<AppLayout> implements DidEnterObserver, RouteOutlet {
  private static final String DEFAULT_VIEW = "home";
  private AppLayout self = getBoundComponent();
  private TabbedPane nav = new TabbedPane();
  private H1 title = new H1();
  private ListenerRegistration<TabSelectEvent> registration;
  PersistentRouteOutlet outlet = new PersistentRouteOutlet(this);

  public MainLayout() {
    setNav();
    Router.getCurrent().onNavigate(this::onNavigate);
    self.addClassName("main-layout");
  }

  @Override
  public void onDidEnter(DidEnterEvent event, ParametersBag parameters) {
    // setSelectListener();
  }

  private void setNav() {
    nav.addClassName("app-nav");
    nav.setBodyHidden(true);
    nav.setBorderless(true);
    nav.setPlacement(TabbedPane.Placement.TOP);
    nav.setAlignment(TabbedPane.Alignment.CENTER);
    
    nav.addTab(new Tab("Home", TablerIcon.create("home")));
    nav.addTab(new Tab("Dashboard", TablerIcon.create("dashboard")));
    nav.addTab(new Tab("Ecom", TablerIcon.create("shopping-cart")));
    nav.addTab(new Tab("Docs", TablerIcon.create("book")));
    
    self.setDrawerPlacement(DrawerPlacement.HIDDEN);
    self.addToHeader(new Img("ws://logo.png").addClassName("header-logo"), nav, new ThemeToggle());
  }

  private void onNavigate(NavigateEvent ev) {
    setAppTitle(ev);
    setSelectedTab(ev);
  }

  private void setAppTitle(NavigateEvent ev) {
    Set<Component> components = ev.getContext().getAllComponents();
    Component view = components.stream().filter(c -> c.getClass().getSimpleName().endsWith("View")).findFirst()
        .orElse(null);

    if (view != null) {
      FrameTitle frameTitle = view.getClass().getAnnotation(FrameTitle.class);
      title.setText(frameTitle != null ? frameTitle.value() : "");
    }
  }

  private void setSelectedTab(NavigateEvent ev) {
    String path = ev.getLocation().getFullURI().substring(1);
    if (path.isEmpty()) {
      path = DEFAULT_VIEW;
    }

    for (Tab tab : nav.getTabs()) {
      if (tab.getText().toLowerCase().equals(path)) {
        // temporarily remove the listener to avoid history push
        removeSelectListener();
        nav.select(tab);
        setSelectListener();
        break;
      }
    }
  }

  private void setSelectListener() {
    registration = nav.onSelect(ev -> {
      String tab = ev.getTab().getText().toLowerCase();
      Router.getCurrent().navigate(new Location(tab));
    });
  }

  private void removeSelectListener() {
    if (registration != null) {
      registration.remove();
    }
  }

  @Override
  public void showRouteContent(Component component) {
    outlet.showRouteContent(component);
  }

  @Override
  public void removeRouteContent(Component component) {
    outlet.removeRouteContent(component);
  }
}
