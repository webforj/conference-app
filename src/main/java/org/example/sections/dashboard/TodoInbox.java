package org.example.sections.dashboard;

import org.example.components.dashboard.inbox.Inbox;
import org.example.components.dashboard.todo.ToDo;

import com.webforj.component.Composite;
import com.webforj.component.layout.flexlayout.FlexLayout;

public class TodoInbox extends Composite<FlexLayout>{
  
  FlexLayout self = getBoundComponent();

  public TodoInbox(){
    self.add(new ToDo(), new Inbox());
    self.setSpacing("var(--dwc-space-m)");
    self.setWidth("102%");
  }
}
