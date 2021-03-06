package com.ojn.gexf4j.core.impl.writer;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.Edge;
import com.ojn.gexf4j.core.viz.EdgeShape;

public class EdgeEntityWriter extends SlicableDatumEntityWriter<Edge> {
	private static final String ENTITY = "edge";
	private static final String ATTRIB_ID = "id";
	private static final String ATTRIB_LABEL = "label";
	private static final String ATTRIB_SOURCE = "source";
	private static final String ATTRIB_TARGET = "target";
	private static final String ATTRIB_WEIGHT = "weight";
	private static final String ATTRIB_TYPE = "type";
	
	public EdgeEntityWriter(XMLStreamWriter writer, Edge entity) {
		super(writer, entity);
		write();
	}
	
	@Override
	protected String getElementName() {
		return ENTITY;
	}

	@Override
	protected void writeElements() throws XMLStreamException {
		super.writeElements();
		
		if (entity.hasColor()) {
			new ColorEntityWriter(writer, entity.getColor());
		}
		
		if (entity.hasThickness()) {
			new ValueEntityWriter<Float>(writer,
					"viz:thickness",
					entity.getThickness());
		}
		
		if (entity.getShape() != EdgeShape.NOTSET) {
			new ValueEntityWriter<String>(writer,
					"viz:shape",
					entity.getShape().toString().toLowerCase());
		}
	}

	@Override
	protected void writeAttributes() throws XMLStreamException {
		super.writeAttributes();
		
		writer.writeAttribute(
				ATTRIB_ID,
				entity.getId());
		
		writer.writeAttribute(
				ATTRIB_SOURCE,
				entity.getSource().getId());
		
		writer.writeAttribute(
				ATTRIB_TARGET,
				entity.getTarget().getId());
		
		writer.writeAttribute(
				ATTRIB_TYPE,
				entity.getEdgeType().toString().toLowerCase());
		
		if (entity.hasLabel()) {
			writer.writeAttribute(
					ATTRIB_LABEL,
					entity.getLabel());
		}
		
		if (entity.hasWeight()) {
			writer.writeAttribute(
					ATTRIB_WEIGHT,
					Float.toString(entity.getWeight()));
		}
	}
}