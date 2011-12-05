package com.manning.gwtia.ch14.client.mvp.views;

import com.google.gwt.user.client.ui.HasValue;
import com.manning.gwtia.ch14.client.mvp.presenters.PhotoDetailsPresenter;

public interface PhotoDetailsView extends View {
	HasValue<String> getPhotoTitle();
	HasValue<String> getPhotoTags();
	void setPhoto(String largeUrl);
	void setPresenter(PhotoDetailsPresenter presenter);
}
