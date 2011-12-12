package com.manning.gwtia.ch14.client.mvp.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class EditableLabel extends Composite implements HasValue<String>, HasValueChangeHandlers<String> {

	private static EditableLabelUiBinder uiBinder = GWT
			.create(EditableLabelUiBinder.class);

	interface EditableLabelUiBinder extends UiBinder<Widget, EditableLabel> {
	}

	final int VIEW_MODE = 0;
	final int EDIT_MODE = 1;

	@UiField DeckPanel decks;
	@UiField Label text;
	@UiField TextBox edit;
	
	String oldValue;

	public EditableLabel() {
		initWidget(uiBinder.createAndBindUi(this));
		decks.showWidget(VIEW_MODE);
		edit.setValue("");
	}

	@UiHandler("container")
	public void highlightWidget(MouseOverEvent event) {
		this.getElement().getStyle().setBackgroundColor("yellow");
	}
	
	@UiHandler("container")
	public void unHighlightWidget(MouseOutEvent event) {
		this.getElement().getStyle().setBackgroundColor("");
	}
	
	@UiHandler("text")
	public void handleEdit(ClickEvent event) {
		oldValue = text.getText();
		edit.setValue(oldValue);
		decks.showWidget(EDIT_MODE);
	}

	@UiHandler("cancelEdit")
	public void handleCancelEdit(ClickEvent event) {
		decks.showWidget(VIEW_MODE);
	}
	
	@UiHandler("okEdit")
	public void handleOkEdit(ClickEvent event) {
		text.setText(edit.getValue());
		decks.showWidget(VIEW_MODE);
		ValueChangeEvent.fire(this, edit.getValue());
	}
	
	@Override
	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<String> handler) {
		return addHandler(handler, ValueChangeEvent.getType());
	}

	
	@Override
	public String getValue() {
		return edit.getValue();
	}

	@Override
	public void setValue(String value) {
		edit.setValue(value);
		text.setText(value);
	}

	@Override
	public void setValue(String value, boolean fireEvents) {
		text.setText(value);
		edit.setValue(value, fireEvents);
	}

}
