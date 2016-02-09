package org.audenaerde.prism;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.html.WebComponent;
import org.apache.wicket.markup.parser.XmlTag;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * Created by raudenaerde on 9-2-16.
 */
public class PrismLabel extends WebComponent
{
	private static final JavaScriptResourceReference PRISM_JS = new JavaScriptResourceReference(PrismLabel.class, "prism.js");
	private static final CssResourceReference PRISM_CSS = new CssResourceReference(PrismLabel.class, "prism.css");

	public PrismLabel(String id, IModel<String> model) {
		super(id, model);
		this.setOutputMarkupId(true);
	}


	public void onComponentTagBody(MarkupStream markupStream, ComponentTag openTag) {
		this.replaceComponentTagBody(markupStream, openTag, this.getDefaultModelObjectAsString());
	}

	protected void onComponentTag(ComponentTag tag) {
		super.onComponentTag(tag);
		tag.setName("code");
		tag.getAttributes().put("class=","language-vcconditions");
		if (tag.isOpenClose()) {
			tag.setType(XmlTag.TagType.OPEN);
		}
	}

	public void renderHead(IHeaderResponse response) {
		response.render(JavaScriptReferenceHeaderItem.forReference(PRISM_JS));
		response.render(CssReferenceHeaderItem.forReference(PRISM_CSS));
		response.render(OnDomReadyHeaderItem.forScript(String.format("Prism.highlightElement(document.getElementById('%s'));", this.getMarkupId())));
	}
}
