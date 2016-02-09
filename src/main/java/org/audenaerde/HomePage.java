package org.audenaerde;

import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.audenaerde.prism.PrismLabel;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		add(new PrismLabel("code", Model.of("aap.code.EXISTS(noot_2,mies)>0 OR wim.code.EXISTS(zus,jet)>0)")));

    }
}
