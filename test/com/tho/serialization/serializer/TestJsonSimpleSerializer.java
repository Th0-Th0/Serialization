package com.tho.serialization.serializer;

public class TestJsonSimpleSerializer extends TestAbstractSerializer {

	private final AbstractSerializer jsonSimpleSerializer = new JsonSimpleSerializer();

	@Override
	protected AbstractSerializer getSerializer() {
		return this.jsonSimpleSerializer;
	}
}
