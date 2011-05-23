package com.ojn.gexf4j.core.impl.data;

import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeClass;
import com.ojn.gexf4j.core.data.AttributeTest;
import com.ojn.gexf4j.core.data.AttributeType;

public class AttributeImplTest extends AttributeTest {

	@Override
	protected Attribute newAttribute(final AttributeType type, final String id, final AttributeClass attribClass) {
		return new AttributeImpl(id, type, attribClass.toString());
	}

}