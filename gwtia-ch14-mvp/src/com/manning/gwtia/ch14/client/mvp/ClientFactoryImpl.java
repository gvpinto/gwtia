package com.manning.gwtia.ch14.client.mvp;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.manning.gwtia.ch14.client.mvp.views.PhotoDetailsView;
import com.manning.gwtia.ch14.client.mvp.views.PhotoDetailsViewImpl;
import com.manning.gwtia.ch14.client.mvp.views.PhotoListView;
import com.manning.gwtia.ch14.client.mvp.views.PhotoListViewImpl;
import com.manning.gwtia.ch14.client.mvp.views.WelcomeView;
import com.manning.gwtia.ch14.client.mvp.views.WelcomeViewImpl;
import com.manning.gwtia.ch14.shared.PhotoAlbumService;
import com.manning.gwtia.ch14.shared.PhotoAlbumServiceAsync;

public class ClientFactoryImpl implements ClientFactory {

	private EventBus eventBus;	
	private PhotoAlbumServiceAsync rpcService; 
	private PhotoDetailsView photoDetailsView;
	private PhotoListView photoListView;
	private WelcomeView welcomeView;
	
	@Override
	public EventBus getEventBus() {
		if (eventBus == null) eventBus = new SimpleEventBus();
		return eventBus;
	}

	@Override
	public PhotoAlbumServiceAsync getPhotoServices() {
		if (rpcService == null) rpcService = GWT.create(PhotoAlbumService.class);
		return rpcService;
	}

	@Override
	public PhotoDetailsView getPhotoView() {
		if (photoDetailsView == null) photoDetailsView = new PhotoDetailsViewImpl();
		return photoDetailsView;
	}

	@Override
	public PhotoListView getListView() {
		if (photoListView == null) photoListView = new PhotoListViewImpl();
		return photoListView;
	}

	@Override
	public WelcomeView getWelcomeView() {
		if (welcomeView == null) welcomeView = new WelcomeViewImpl();
		return welcomeView;
	}

}
