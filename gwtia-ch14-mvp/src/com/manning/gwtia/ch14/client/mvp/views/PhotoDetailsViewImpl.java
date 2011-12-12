package com.manning.gwtia.ch14.client.mvp.views;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Image;
import com.manning.gwtia.ch14.client.mvp.presenters.PhotoDetailsPresenter;
import com.manning.gwtia.ch14.client.mvp.ui.AppMenuBar;
import com.manning.gwtia.ch14.client.mvp.ui.EditableLabel;
import com.manning.gwtia.ch14.client.mvp.ui.TagListWidget;

public class PhotoDetailsViewImpl extends Composite implements PhotoDetailsView {

	private PhotoDetailsPresenter presenter;
	private final EditableLabel title;
	private final TagListWidget tags;
	private final DockLayoutPanel container;
	
	Image thePhoto;
	
	
	public PhotoDetailsViewImpl() {
		DockLayoutPanel view = new DockLayoutPanel(Unit.PX);
		DecoratorPanel photoDetailsDecorator = new DecoratorPanel();
		photoDetailsDecorator.setWidth("22em");
		
		view.addNorth(new AppMenuBar(), 25);
		view.add(photoDetailsDecorator);
		
		initWidget(view);
		
		view.setSize("100%", "100%");
		view.forceLayout();
		
		FlowPanel photoDetailsPanel = new FlowPanel();
		photoDetailsPanel.setWidth("100%");

		container = new DockLayoutPanel(Unit.PX);
		container.setWidth("100%");
		
		title = new EditableLabel();
		tags = new TagListWidget();

		container.addNorth(title, 30);
		FlowPanel photo = new FlowPanel();
		thePhoto = new Image();
		thePhoto.setSize("100%", "100%");
		photo.add(thePhoto);
		photo.add(tags);
		container.add(photo);
		container.setSize("600", "600");
		container.forceLayout();
		photoDetailsPanel.add(container);

		photoDetailsDecorator.add(photoDetailsPanel);
		bind();


	}
	
	@Override
	public HasValue<String> getPhotoTitle() {
		return title;
	}

	@Override
	public HasValue<String> getPhotoTags() {
		return tags;
	}

	public void setPresenter(PhotoDetailsPresenter presenter) {
		this.presenter = presenter;
	}


	public void bind() {
		title.addValueChangeHandler(new ValueChangeHandler<String>(){
			public void onValueChange(ValueChangeEvent<String> event) {
				if (presenter != null){
					presenter.onUpdateTitle();
				}
			}
			
		});
		tags.addChangeHandler(new ValueChangeHandler<String>(){
			public void onValueChange(ValueChangeEvent<String> event) {
				if (presenter != null){
					presenter.onUpdateTags();
				}
			}			
		});
	}

	@Override
	public void setPhoto(String url) {
		//thePhoto.setUrl(url);
		// Actually, the URL in our example is really the background colour
		thePhoto.getElement().getStyle().setBackgroundColor(url);
	}

}
