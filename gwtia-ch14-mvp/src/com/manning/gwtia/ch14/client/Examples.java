package com.manning.gwtia.ch14.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Examples implements EntryPoint {
	public void onModuleLoad() {
		RootPanel.get().add(new ExamplePanel(), 0, 0);
	}
}
