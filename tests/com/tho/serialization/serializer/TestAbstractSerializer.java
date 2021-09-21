package com.tho.serialization.serializer;

import org.junit.Assert;
import org.junit.Test;

public abstract class TestAbstractSerializer {

	protected abstract AbstractSerializer getSerializer();

	@Test
	public void testSerializationDeserialization() {
		final SerializableTestObject serializable = new SerializableTestObject();
		serializable.mainObject.booleanValue = true;
		serializable.mainObject.byteValue = 100;
		serializable.mainObject.charValue = 't';
		serializable.mainObject.shortValue = 200;
		serializable.mainObject.intValue = 300;
		serializable.mainObject.longValue = 400;
		serializable.mainObject.floatValue = 500.5f;
		serializable.mainObject.doubleValue = 600.5;
		serializable.mainObject.stringValue = "testString1";
		serializable.mainObject.subObject.booleanValue = false;
		serializable.mainObject.subObject.byteValue = 101;
		serializable.mainObject.subObject.charValue = 's';
		serializable.mainObject.subObject.shortValue = 201;
		serializable.mainObject.subObject.intValue = 301;
		serializable.mainObject.subObject.longValue = 401;
		serializable.mainObject.subObject.floatValue = 501.5f;
		serializable.mainObject.subObject.doubleValue = 601.5;
		serializable.mainObject.subObject.stringValue = "testString0";
		serializable.mainObject.booleanValue2 = true;
		serializable.mainObject.byteValue2 = 102;
		serializable.mainObject.charValue2 = 'c';
		serializable.mainObject.shortValue2 = 202;
		serializable.mainObject.intValue2 = 302;
		serializable.mainObject.longValue2 = 402;
		serializable.mainObject.floatValue2 = 502.5f;
		serializable.mainObject.doubleValue2 = 602.5;
		serializable.mainObject.stringValue2 = "testString2";

		getSerializer().serialize(serializable);

		// System.out.println(getSerializer());

		final SerializableTestObject deserialized = new SerializableTestObject();
		getSerializer().deserialize(deserialized);
		Assert.assertEquals("booleanValue", serializable.mainObject.booleanValue, deserialized.mainObject.booleanValue);
		Assert.assertEquals("byteValue", serializable.mainObject.byteValue, deserialized.mainObject.byteValue);
		Assert.assertEquals("charValue", serializable.mainObject.charValue, deserialized.mainObject.charValue);
		Assert.assertEquals("shortValue", serializable.mainObject.shortValue, deserialized.mainObject.shortValue);
		Assert.assertEquals("intValue", serializable.mainObject.intValue, deserialized.mainObject.intValue);
		Assert.assertEquals("longValue", serializable.mainObject.longValue, deserialized.mainObject.longValue);
		Assert.assertEquals("floatValue", serializable.mainObject.floatValue, deserialized.mainObject.floatValue, 1e-6);
		Assert.assertEquals("doubleValue", serializable.mainObject.doubleValue, deserialized.mainObject.doubleValue, 1e-6);
		Assert.assertEquals("stringValue", serializable.mainObject.stringValue, deserialized.mainObject.stringValue);
		Assert.assertEquals("subObject.booleanValue", serializable.mainObject.subObject.booleanValue, deserialized.mainObject.subObject.booleanValue);
		Assert.assertEquals("subObject.byteValue", serializable.mainObject.subObject.byteValue, deserialized.mainObject.subObject.byteValue);
		Assert.assertEquals("subObject.charValue", serializable.mainObject.subObject.charValue, deserialized.mainObject.subObject.charValue);
		Assert.assertEquals("subObject.shortValue", serializable.mainObject.subObject.shortValue, deserialized.mainObject.subObject.shortValue);
		Assert.assertEquals("subObject.intValue", serializable.mainObject.subObject.intValue, deserialized.mainObject.subObject.intValue);
		Assert.assertEquals("subObject.longValue", serializable.mainObject.subObject.longValue, deserialized.mainObject.subObject.longValue);
		Assert.assertEquals("subObject.floatValue", serializable.mainObject.subObject.floatValue, deserialized.mainObject.subObject.floatValue, 1e-6);
		Assert.assertEquals("subObject.doubleValue", serializable.mainObject.subObject.doubleValue, deserialized.mainObject.subObject.doubleValue,
				1e-6);
		Assert.assertEquals("subObject.stringValue", serializable.mainObject.subObject.stringValue, deserialized.mainObject.subObject.stringValue);
		Assert.assertEquals("booleanValue2", serializable.mainObject.booleanValue2, deserialized.mainObject.booleanValue2);
		Assert.assertEquals("byteValue2", serializable.mainObject.byteValue2, deserialized.mainObject.byteValue2);
		Assert.assertEquals("charValue2", serializable.mainObject.charValue2, deserialized.mainObject.charValue2);
		Assert.assertEquals("shortValue2", serializable.mainObject.shortValue2, deserialized.mainObject.shortValue2);
		Assert.assertEquals("intValue2", serializable.mainObject.intValue2, deserialized.mainObject.intValue2);
		Assert.assertEquals("longValue2", serializable.mainObject.longValue2, deserialized.mainObject.longValue2);
		Assert.assertEquals("floatValue2", serializable.mainObject.floatValue2, deserialized.mainObject.floatValue2, 1e-6);
		Assert.assertEquals("doubleValue2", serializable.mainObject.doubleValue2, deserialized.mainObject.doubleValue2, 1e-6);
		Assert.assertEquals("stringValue2", serializable.mainObject.stringValue2, deserialized.mainObject.stringValue2);
	}

}
