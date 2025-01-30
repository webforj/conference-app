package org.example.components.dashboard.todo;


import org.example.utils.todo.ToDoRepository;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;

public class ToDo extends Composite<Div> {

  Div self = getBoundComponent();

  public ToDo() {
    self.addClassName("card card__todo");

    Paragraph header = new Paragraph("To Do")
      .addClassName("card__header");
    self.add(header);

    ToDoRepository repository = new ToDoRepository();
    repository.addItem("Contact the organizers");
    repository.addItem("Register for the event", true);
    repository.addItem("Book a hotel room");
    repository.addItem("Book a flight");
    repository.addItem("Start testing your application", true);
    repository.addItem("Start preparing your presentation", true);
    repository.addItem("Build your demo application", true);
    repository.addItem("Book a demo for webforj");
    repository.addItem("Prepare for meeting with the boss");

    self.add(
        new ToDoToolbar(repository),
        new ToDoList(repository),
        new ToDoInput(repository));
  }
}