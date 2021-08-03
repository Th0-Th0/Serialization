package com.tho.serialization.serializer;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonSimpleSerializer extends AbstractKeyValueSerializer<JSONObject> {

	private final JSONParser parser = new JSONParser();

	@Override
	public void setSerializedData(final String inputData) {
		try {
			this.currentObject = (JSONObject) this.parser.parse(inputData);
		} catch (final ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getSerializedData() {
		return this.currentObject.toJSONString();
	}

	@Override
	public void prepareToSerialize() {
		this.currentObject.clear();
	}

	@Override
	public void prepareToDeserialize() {
		// Nothing to do
	}

	@Override
	protected JSONObject getNewObject() {
		return new JSONObject();
	}

	@Override
	protected void put(final String name, final JSONObject object) {
		this.currentObject.put(name, object);
	}

	@Override
	protected JSONObject get(final String name) {
		return (JSONObject) this.currentObject.get(name);
	}

	@Override
	public void putBoolean(final String name, final boolean value) {
		this.currentObject.put(name, value);
	}

	@Override
	public boolean getBoolean(final String name) {
		return (boolean) this.currentObject.get(name);
	}

	@Override
	public void putByte(final String name, final byte value) {
		this.currentObject.put(name, value);
	}

	@Override
	public byte getByte(final String name) {
		return (byte) this.currentObject.get(name);
	}

	@Override
	public void putChar(final String name, final char value) {
		this.currentObject.put(name, value);
	}

	@Override
	public char getChar(final String name) {
		return (char) this.currentObject.get(name);
	}

	@Override
	public void putShort(final String name, final short value) {
		this.currentObject.put(name, value);
	}

	@Override
	public short getShort(final String name) {
		return (short) this.currentObject.get(name);
	}

	@Override
	public void putLong(final String name, final long value) {
		this.currentObject.put(name, value);
	}

	@Override
	public long getLong(final String name) {
		return (long) this.currentObject.get(name);
	}

	@Override
	public void putFloat(final String name, final float value) {
		this.currentObject.put(name, value);
	}

	@Override
	public float getFloat(final String name) {
		return (float) this.currentObject.get(name);
	}

	@Override
	public void putDouble(final String name, final double value) {
		this.currentObject.put(name, value);
	}

	@Override
	public double getDouble(final String name) {
		return (double) this.currentObject.get(name);
	}

	@Override
	public void putString(final String name, final String value) {
		this.currentObject.put(name, value);
	}

	@Override
	public String getString(final String name) {
		return (String) this.currentObject.get(name);
	}

	@Override
	public void putInt(final String name, final int value) {
		this.currentObject.put(name, value);
	}

	@Override
	public int getInt(final String name) {
		return (int) this.currentObject.get(name);
	}
}
