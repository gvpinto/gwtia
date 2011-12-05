package com.manning.gwtia.ch14.shared;

import java.util.Vector;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PhotoAlbumServiceAsync {

	void getPhotoDetails(String id, AsyncCallback<PhotoDetails> callback);

	void getPhotoList(AsyncCallback<Vector<PhotoDetails>> callback);

	void updatePhotoDetails(PhotoDetails photoDetails,
			AsyncCallback<PhotoDetails> callback);

}
