package org.example.components.dashboard.teamcard;

import com.webforj.component.Composite;
import com.webforj.component.element.concern.HasElementClickListener;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Img;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.html.elements.Strong;

public class TeamCard extends Composite<Div> implements HasElementClickListener {
  Img avatar = new Img();
  Strong username = new Strong();
  Paragraph position = new Paragraph();
  Div textWrapper = new Div(username, position);
  CardClickListener clickListener;

  public TeamCard(String imgUrl, String username, String position){
    getBoundComponent().addClassName("team__card");

    avatar.setSrc(imgUrl);
    this.username.setText(username);
    this.position.setText(position);

    this.avatar.addClassName("team__avatar");
    this.username.addClassName("team__username");
    this.position.addClassName("team__position");
    getBoundComponent().add(avatar, textWrapper);
    listenForCardClicked();
  }

  public Img getAvatar() {
    return avatar;
  }

  public Strong getUserName() {
    return this.username;
  }

  public Paragraph getPosition() {
    return position;
  }

  public void setActive(boolean isActive) {
    if (isActive) {
      getBoundComponent().addClassName("is-active");
    } else {
      getBoundComponent().removeClassName("is-active");
    }
  }

  public void listenForCardClicked() {
    getBoundComponent().addClickListener(event -> {
      if (clickListener != null) {
        clickListener.onCardClicked(this);
      }
    });
  }

  public void setClickListener(CardClickListener listener) {
    this.clickListener = listener;
  }
}
