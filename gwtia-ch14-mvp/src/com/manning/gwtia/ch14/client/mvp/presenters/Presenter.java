package com.manning.gwtia.ch14.client.mvp.presenters;

import com.google.gwt.user.client.ui.HasWidgets;

public interface Presenter {
	public void go(final HasWidgets container);
	public void bind();
}
