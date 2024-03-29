package com.manning.gwtia.ch14.client.mvp.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.manning.gwtia.ch14.client.mvp.events.HasTagDeletedHandlers;
import com.manning.gwtia.ch14.client.mvp.events.TagDeletedEvent;
import com.manning.gwtia.ch14.client.mvp.events.TagDeletedHandler;

public class TagDisplay extends Composite implements HasTagDeletedHandlers {

	private static TagDisplayUiBinder uiBinder = GWT
			.create(TagDisplayUiBinder.class);

	interface TagDisplayUiBinder extends UiBinder<Widget, TagDisplay> {
	}

	public TagDisplay() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField Label tag;
	@UiField Label delete;
	
	public TagDisplay(String theTag){
		initWidget(uiBinder.createAndBindUi(this));
		tag.setText(theTag);
	}
	
	public String getTag(){
		return tag.getText();
	}
	
	@UiHandler("delete")
	public void remove(ClickEvent event){
		TagDeletedEvent.fire(this, tag.getText());
	}

	public HandlerRegistration addHasTagDeletedHandler(TagDeletedHandler handler) {
		return this.addHandler(handler, TagDeletedEvent.getType());
	}
}
