package com.manning.gwtia.ch14.shared;

import java.util.Vector;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("service")
public interface PhotoAlbumService extends RemoteService {
	PhotoDetails updatePhotoDetails(PhotoDetails photoDetails);
	PhotoDetails getPhotoDetails(String id) throws PhotoNotFoundException;
	Vector<PhotoDetails> getPhotoList();
}
