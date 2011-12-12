package com.manning.gwtia.ch14.client.mvp.events;

import com.google.gwt.event.shared.EventHandler;

public interface TagDeletedHandler extends EventHandler{
	  public void onTagDeleted(TagDeletedEvent event);
}
