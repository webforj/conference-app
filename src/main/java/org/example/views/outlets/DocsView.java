package org.example.views.outlets;

import org.example.views.MainLayout;

import com.webforj.App;
import com.webforj.Page;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.Iframe;
import com.webforj.concern.HasVisibility;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/docs", outlet = MainLayout.class)
@FrameTitle("Docs")
public class DocsView extends Composite<Iframe> implements HasVisibility{
  
  private Iframe self = getBoundComponent();

  public DocsView() {
    self.setHeight("100%");
    self.setWidth("100%");
    self.setAttribute("loading", "lazy");
    self.setStyle("border", "none");
    self.setStyle("overflow", "hidden");
    self.setSrc("https://docs.webforj.com/");
    // setTheme();
  }
  
  // Only works when docs and app are hosted from same location
  private void setTheme(){
    self.setAttribute("id", "docs-iframe");
    if(App.getTheme().equals("light")){
      Page.getCurrent().executeJsVoidAsync("""
        var iframe = document.getElementById('docs-iframe');
        if (iframe) {
          var iframeContent = iframe.contentWindow;
          if (iframeContent && iframeContent.document) {
            var htmlTag = iframeContent.document.querySelector("html");
            htmlTag.setAttribute("data-theme", "light");
          }
        }
      """);
    } else{
      Page.getCurrent().executeJsVoidAsync("""
        var iframe = document.getElementById('docs-iframe');
        if (iframe) {
          var iframeContent = iframe.contentWindow;
          if (iframeContent && iframeContent.document) {
            var htmlTag = iframeContent.document.querySelector("html");
            htmlTag.setAttribute("data-theme", "dark");
          }
        }
      """);
    }
  }
}
