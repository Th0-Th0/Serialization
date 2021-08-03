package com.tho.serialization.serializer;

import com.tho.serialization.Serializable;

public class SerializableTestObject implements Serializable {

	public static class SubObject implements Serializable {
		private static final String booleanValueName = "booleanValue";
		public boolean booleanValue;

		private static final String byteValueName = "byteValue";
		public byte byteValue;

		private static final String charValueName = "charValue";
		public char charValue;

		private static final String shortValueName = "shortValue";
		public short shortValue;

		private static final String intValueName = "intValue";
		public int intValue;

		private static final String longValueName = "longValue";
		public long longValue;

		private static final String floatValueName = "floatValue";
		public float floatValue;

		private static final String doubleValueName = "doubleValue";
		public double doubleValue;

		private static final String stringValueName = "stringValue";
		public String stringValue;

		@Override
		public void serialize(final AbstractSerializer serializer) {
			serializer.putBoolean(SubObject.booleanValueName, this.booleanValue);
			serializer.putByte(SubObject.byteValueName, this.byteValue);
			serializer.putChar(SubObject.charValueName, this.charValue);
			serializer.putShort(SubObject.shortValueName, this.shortValue);
			serializer.putInt(SubObject.intValueName, this.intValue);
			serializer.putLong(SubObject.longValueName, this.longValue);
			serializer.putFloat(SubObject.floatValueName, this.floatValue);
			serializer.putDouble(SubObject.doubleValueName, this.doubleValue);
			serializer.putString(SubObject.stringValueName, this.stringValue);
		}

		@Override
		public void deserialize(final AbstractSerializer serializer) {
			this.booleanValue = serializer.getBoolean(SubObject.booleanValueName);
			this.byteValue = serializer.getByte(SubObject.byteValueName);
			this.charValue = serializer.getChar(SubObject.charValueName);
			this.shortValue = serializer.getShort(SubObject.shortValueName);
			this.intValue = serializer.getInt(SubObject.intValueName);
			this.longValue = serializer.getLong(SubObject.longValueName);
			this.floatValue = serializer.getFloat(SubObject.floatValueName);
			this.doubleValue = serializer.getDouble(SubObject.doubleValueName);
			this.stringValue = serializer.getString(SubObject.stringValueName);
		}
	}

	public static class MainObject implements Serializable {
		private static final String booleanValueName = "booleanValue";
		public boolean booleanValue;

		private static final String byteValueName = "byteValue";
		public byte byteValue;

		private static final String charValueName = "charValue";
		public char charValue;

		private static final String shortValueName = "shortValue";
		public short shortValue;

		private static final String intValueName = "intValue";
		public int intValue;

		private static final String longValueName = "longValue";
		public long longValue;

		private static final String floatValueName = "floatValue";
		public float floatValue;

		private static final String doubleValueName = "doubleValue";
		public double doubleValue;

		private static final String stringValueName = "stringValue";
		public String stringValue;

		private static final String subObjectName = "subObject";
		public SubObject subObject = new SubObject();

		private static final String booleanValueName2 = "booleanValue2";
		public boolean booleanValue2;

		private static final String byteValueName2 = "byteValue2";
		public byte byteValue2;

		private static final String charValueName2 = "charValue2";
		public char charValue2;

		private static final String shortValueName2 = "shortValue2";
		public short shortValue2;

		private static final String intValueName2 = "intValue2";
		public int intValue2;

		private static final String longValueName2 = "longValue2";
		public long longValue2;

		private static final String floatValueName2 = "floatValue2";
		public float floatValue2;

		private static final String doubleValueName2 = "doubleValue2";
		public double doubleValue2;

		private static final String stringValueName2 = "stringValue2";
		public String stringValue2;

		@Override
		public void serialize(final AbstractSerializer serializer) {
			serializer.putBoolean(MainObject.booleanValueName, this.booleanValue);
			serializer.putByte(MainObject.byteValueName, this.byteValue);
			serializer.putChar(MainObject.charValueName, this.charValue);
			serializer.putShort(MainObject.shortValueName, this.shortValue);
			serializer.putInt(MainObject.intValueName, this.intValue);
			serializer.putLong(MainObject.longValueName, this.longValue);
			serializer.putFloat(MainObject.floatValueName, this.floatValue);
			serializer.putDouble(MainObject.doubleValueName, this.doubleValue);
			serializer.putString(MainObject.stringValueName, this.stringValue);
			serializer.serialize(MainObject.subObjectName, this.subObject);
			serializer.putBoolean(MainObject.booleanValueName2, this.booleanValue2);
			serializer.putByte(MainObject.byteValueName2, this.byteValue2);
			serializer.putChar(MainObject.charValueName2, this.charValue2);
			serializer.putShort(MainObject.shortValueName2, this.shortValue2);
			serializer.putInt(MainObject.intValueName2, this.intValue2);
			serializer.putLong(MainObject.longValueName2, this.longValue2);
			serializer.putFloat(MainObject.floatValueName2, this.floatValue2);
			serializer.putDouble(MainObject.doubleValueName2, this.doubleValue2);
			serializer.putString(MainObject.stringValueName2, this.stringValue2);
		}

		@Override
		public void deserialize(final AbstractSerializer serializer) {
			this.booleanValue = serializer.getBoolean(MainObject.booleanValueName);
			this.byteValue = serializer.getByte(MainObject.byteValueName);
			this.charValue = serializer.getChar(MainObject.charValueName);
			this.shortValue = serializer.getShort(MainObject.shortValueName);
			this.intValue = serializer.getInt(MainObject.intValueName);
			this.longValue = serializer.getLong(MainObject.longValueName);
			this.floatValue = serializer.getFloat(MainObject.floatValueName);
			this.doubleValue = serializer.getDouble(MainObject.doubleValueName);
			this.stringValue = serializer.getString(MainObject.stringValueName);
			serializer.deserialize(MainObject.subObjectName, this.subObject);
			this.booleanValue2 = serializer.getBoolean(MainObject.booleanValueName2);
			this.byteValue2 = serializer.getByte(MainObject.byteValueName2);
			this.charValue2 = serializer.getChar(MainObject.charValueName2);
			this.shortValue2 = serializer.getShort(MainObject.shortValueName2);
			this.intValue2 = serializer.getInt(MainObject.intValueName2);
			this.longValue2 = serializer.getLong(MainObject.longValueName2);
			this.floatValue2 = serializer.getFloat(MainObject.floatValueName2);
			this.doubleValue2 = serializer.getDouble(MainObject.doubleValueName2);
			this.stringValue2 = serializer.getString(MainObject.stringValueName2);
		}
	}

	private static final String MAIN_OBJECT_NAME = "mainObject";
	public MainObject mainObject = new MainObject();

	@Override
	public void serialize(final AbstractSerializer serializer) {
		serializer.serialize(SerializableTestObject.MAIN_OBJECT_NAME, this.mainObject);
	}

	@Override
	public void deserialize(final AbstractSerializer serializer) {
		serializer.deserialize(SerializableTestObject.MAIN_OBJECT_NAME, this.mainObject);
	}
}
