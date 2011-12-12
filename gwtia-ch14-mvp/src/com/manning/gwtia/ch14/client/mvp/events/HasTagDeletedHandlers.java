package com.manning.gwtia.ch14.client.mvp.events;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasTagDeletedHandlers extends HasHandlers {
	 public HandlerRegistration addHasTagDeletedHandler(TagDeletedHandler handler); 
}
