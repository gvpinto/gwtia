package com.manning.gwtia.ch14.client.mvp.presenters;

public interface PhotoListPresenter extends Presenter {
	public void onSelectedPhotoClicked(String id);
	public void onNewPhotosNeeded();
}
