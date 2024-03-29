package com.manning.gwtia.ch14.client.mvp;

import com.google.gwt.event.shared.EventBus;
import com.manning.gwtia.ch14.client.mvp.views.PhotoDetailsView;
import com.manning.gwtia.ch14.client.mvp.views.PhotoListView;
import com.manning.gwtia.ch14.client.mvp.views.WelcomeView;
import com.manning.gwtia.ch14.shared.PhotoAlbumServiceAsync;

public interface ClientFactory {
	public EventBus getEventBus();
	PhotoAlbumServiceAsync getPhotoServices();
	PhotoDetailsView getPhotoView();
	PhotoListView getListView();
	WelcomeView getWelcomeView();
}
