package com.tho.serialization.serializer;

import com.tho.serialization.Serializable;

public abstract class AbstractSerializer {

	public void serialize(final Serializable serializable) {
		prepareToSerialize();
		serializable.serialize(this);
	}

	public void deserialize(final Serializable serializable) {
		prepareToDeserialize();
		serializable.deserialize(this);
	}

	public abstract void setSerializedData(final String inputData);

	public abstract String getSerializedData();

	public abstract void prepareToSerialize();

	public abstract void prepareToDeserialize();

	public abstract void serialize(final String name, final Serializable serializable);

	public abstract void deserialize(final String name, final Serializable serializable);

	public abstract void putBoolean(final String name, final boolean value);

	public abstract boolean getBoolean(final String name);

	public abstract void putByte(final String name, final byte value);

	public abstract byte getByte(final String name);

	public abstract void putChar(final String name, final char value);

	public abstract char getChar(final String name);

	public abstract void putShort(final String name, final short value);

	public abstract short getShort(final String name);

	public abstract void putLong(final String name, final long value);

	public abstract long getLong(final String name);

	public abstract void putFloat(final String name, final float value);

	public abstract float getFloat(final String name);

	public abstract void putDouble(final String name, final double value);

	public abstract double getDouble(final String name);

	public abstract void putString(final String name, final String value);

	public abstract String getString(final String name);

	public abstract void putInt(final String name, final int value);

	public abstract int getInt(final String name);

	@Override
	public String toString() {
		return getSerializedData();
	}
}