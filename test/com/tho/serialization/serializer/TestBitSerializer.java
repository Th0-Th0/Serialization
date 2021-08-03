package com.tho.serialization.serializer;

public class TestBitSerializer extends TestAbstractSerializer {

	private final AbstractSerializer bitSerializer = new BitSerializer(8 * 2048);

	@Override
	protected AbstractSerializer getSerializer() {
		return this.bitSerializer;
	}
}
