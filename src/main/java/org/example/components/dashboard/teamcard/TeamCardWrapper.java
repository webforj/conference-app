package org.example.components.dashboard.teamcard;

import java.util.ArrayList;

import com.webforj.component.Composite;
import com.webforj.component.dialog.Dialog;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Img;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.html.elements.Strong;
import com.webforj.component.icons.FeatherIcon;
import com.webforj.component.icons.IconButton;

public class TeamCardWrapper extends Composite<Div> implements CardClickListener {
  ArrayList<TeamCard> teamCards = new ArrayList<>();

  public TeamCardWrapper(){
    getBoundComponent().addClassName("teamcard__wrapper");
  }

  public void onCardClicked(TeamCard card) {
    updateActiveCard(card);
    openContactInfo(card);
  }

  public void openContactInfo(TeamCard card) {
    Dialog dialog = new Dialog();
    Img img = new Img(card.getAvatar().getSrc(), "Avatar");
    img.addClassName("team__avatar");

    IconButton exit = new IconButton(FeatherIcon.X.create());
    exit.onClick(event -> {dialog.close();});

    Strong name = new Strong();
    name.addClassName("team__username")
      .setText(card.getUserName().getText());
    Paragraph position = new Paragraph();
    position.addClassName("team__position")
      .setText(card.getPosition().getText());


    dialog.addClassName("contact--info")
      .add(img, exit, name, position);
      dialog.setBlurred(true);

    getBoundComponent().add(dialog);
    dialog.open();
  }

  public void updateActiveCard(TeamCard activeCard) {
    for (TeamCard card : teamCards) {
      card.setActive(card.equals(activeCard));
    }
  }

  public void addTeamCard(TeamCard card) {
    card.setClickListener(this);
    teamCards.add(card);
    getBoundComponent().add(card);
  }
    
}