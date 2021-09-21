package com.tho.serialization.serializer;

public class TestXmlDomSerializer extends TestAbstractSerializer {

	private final AbstractSerializer xmlDomSerializer = new XmlDomSerializer();

	@Override
	protected AbstractSerializer getSerializer() {
		return this.xmlDomSerializer;
	}
}
