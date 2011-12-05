package com.manning.gwtia.ch14.client.mvp.views;

import com.manning.gwtia.ch14.client.mvp.presenters.WelcomePresenter;

public interface WelcomeView extends View {
	void setPresenter(WelcomePresenter presenter);
}
