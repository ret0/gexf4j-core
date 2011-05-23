package com.ojn.gexf4j.core.impl.data;

import java.util.UUID;

import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeType;
import com.ojn.gexf4j.core.data.AttributeValue;
import com.ojn.gexf4j.core.data.AttributeValueTest;

public class AttributeValueImplTest extends AttributeValueTest {

	@Override
	protected Attribute newAttribute() {
		return new AttributeImpl(UUID.randomUUID().toString(), AttributeType.STRING, UUID.randomUUID().toString());
	}

	@Override
	protected AttributeValue newAttributeValue(final Attribute attrib, final String value) {
		return new AttributeValueImpl(attrib);
	}
}