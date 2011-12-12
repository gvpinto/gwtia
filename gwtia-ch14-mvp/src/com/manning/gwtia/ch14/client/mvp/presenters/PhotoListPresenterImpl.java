package com.manning.gwtia.ch14.client.mvp.presenters;

import java.util.Vector;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.manning.gwtia.ch14.client.mvp.ClientFactory;
import com.manning.gwtia.ch14.client.mvp.Tokens;
import com.manning.gwtia.ch14.client.mvp.events.AppBusyEvent;
import com.manning.gwtia.ch14.client.mvp.events.AppFreeEvent;
import com.manning.gwtia.ch14.client.mvp.views.PhotoListView;
import com.manning.gwtia.ch14.shared.PhotoAlbumServiceAsync;
import com.manning.gwtia.ch14.shared.PhotoDetails;

public class PhotoListPresenterImpl implements PhotoListPresenter {

	private ClientFactory clientFactory = GWT.create(ClientFactory.class);
	private PhotoAlbumServiceAsync rpcService;
	private EventBus eventBus;
	private PhotoListView photoListView;

	public PhotoListPresenterImpl(PhotoListView photoListView) {
		this.rpcService = clientFactory.getPhotoServices();
		this.eventBus = clientFactory.getEventBus();
		this.photoListView = photoListView;
		this.onNewPhotosNeeded();
		bind();
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(photoListView.asWidget());
	}

	@Override
	public void bind() {
		photoListView.setPresenter(this);
	}

	@Override
	public void onSelectPhotoClicked(String id) {
		History.newItem(Tokens.DETAIL + "&" + id);
	}

	@Override
	public void onNewPhotosNeeded(){
		eventBus.fireEvent(new AppBusyEvent());
		rpcService.getPhotoList(
				new AsyncCallback<Vector<PhotoDetails>>() {
					public void onSuccess(Vector<PhotoDetails> result) {
						photoListView.addPictures(result);
						eventBus.fireEvent(new AppFreeEvent());
					}

					public void onFailure(Throwable caught) {
						Window.alert("Error");
						eventBus.fireEvent(new AppFreeEvent());
					}
				});
	}

}
