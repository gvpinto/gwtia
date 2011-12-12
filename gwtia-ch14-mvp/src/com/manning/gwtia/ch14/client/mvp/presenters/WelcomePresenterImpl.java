package com.manning.gwtia.ch14.client.mvp.presenters;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import com.manning.gwtia.ch14.client.mvp.Tokens;
import com.manning.gwtia.ch14.client.mvp.views.WelcomeView;

public class WelcomePresenterImpl implements WelcomePresenter {

	private final WelcomeView welcomeView;

	public WelcomePresenterImpl(WelcomeView welcomeView) {
		this.welcomeView = welcomeView;
		bind();
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(welcomeView.asWidget());
	}

	@Override
	public void bind() {
		welcomeView.setPresenter(this);
	}

	@Override
	public void onshowPhotosButtonClicked() {
		History.newItem(Tokens.LIST);
	}

}
