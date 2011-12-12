package com.manning.gwtia.ch14.client.mvp.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.manning.gwtia.ch14.client.mvp.events.TagDeletedEvent;
import com.manning.gwtia.ch14.client.mvp.events.TagDeletedHandler;

public class TagListWidget extends Composite implements HasValue<String>, HasValueChangeHandlers<String> {

	private static TagListWidgetUiBinder uiBinder = GWT
			.create(TagListWidgetUiBinder.class);

	interface TagListWidgetUiBinder extends UiBinder<Widget, TagListWidget> {
	}

	@UiField FlowPanel tags;
	@UiField TextBox newTag;
	
	String DELIMITER = ",";
	
	public TagListWidget() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public TagListWidget(String tags){
		super();
		setValue(tags);
	}
	
	
	@UiHandler("newTag")
	public void onValueChange(ValueChangeEvent<String> event) {
		addTag(newTag.getText());
		newTag.setText("..new tag..");	
		newTag.setFocus(false);
	}
	
	
	@UiHandler("newTag")
	public void onFocus(FocusEvent event){
		newTag.getElement().getStyle().setColor("black");
		newTag.setText("");
	}
	
	@UiHandler("newTag")
	public void onBlur(BlurEvent event){
		newTag.getElement().getStyle().setColor("gray");
		newTag.setText("..new tag..");				
	}

	public void addTag(String theTag){
		final TagDisplay tag = new TagDisplay(theTag);
		tag.setSize("110px", "20px");
		tags.add(tag);
		tag.addHasTagDeletedHandler(new TagDeletedHandler(){
			public void onTagDeleted(TagDeletedEvent event) {
				tags.remove(tag);
				notifyEveryone();
			}
		});
		notifyEveryone();
	}

	private void notifyEveryone(){
		ValueChangeEvent.fire(this, "");
	}

	public String getValue() {
		String tagString = "";
		for (int loop=0; loop<tags.getWidgetCount(); loop++){
			tagString += ((TagDisplay)tags.getWidget(loop)).getTag() + DELIMITER;
		}
		return tagString.substring(0, tagString.length()-1);	}

	public void setValue(String value) {
		String[] theTags = value.split(DELIMITER);
		for (String tag: theTags){
			addTag(tag);
		}		
	}
	
	public void setValue(String value, boolean fireEvents) {
		setValue(value);
	}

	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<String> handler) {
		return null;
	}


	public HandlerRegistration addChangeHandler(ValueChangeHandler<String> handler) {
		return this.addHandler(handler, ValueChangeEvent.getType());
	}
}
