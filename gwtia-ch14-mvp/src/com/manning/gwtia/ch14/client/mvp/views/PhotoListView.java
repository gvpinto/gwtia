package com.manning.gwtia.ch14.client.mvp.views;

import java.util.Vector;

import com.manning.gwtia.ch14.client.mvp.presenters.PhotoListPresenter;
import com.manning.gwtia.ch14.shared.PhotoDetails;

public interface PhotoListView extends View {
	void setPresenter(PhotoListPresenter presenter);
	void addPictures(Vector<PhotoDetails> photos);
}
