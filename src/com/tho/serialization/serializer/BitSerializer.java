package com.tho.serialization.serializer;

import java.util.Arrays;

import com.tho.serialization.Serializable;
import com.tho.serialization.buffer.BitBuffer;

public class BitSerializer extends AbstractSerializer {

	private final BitBuffer bitBuffer;

	public BitSerializer(final int bitCapacity) {
		this.bitBuffer = new BitBuffer(bitCapacity);
	}

	@Override
	public void setSerializedData(final String inputData) {
		this.bitBuffer.clear();
		this.bitBuffer.putString(inputData);
		this.bitBuffer.resetBitPosition();
	}

	@Override
	public String getSerializedData() {
		return String.valueOf(Arrays.copyOf(this.bitBuffer.getByteBuffer(), this.bitBuffer.getMaxBytePosition()));
	}

	@Override
	public void prepareToSerialize() {
		this.bitBuffer.clear();
	}

	@Override
	public void prepareToDeserialize() {
		this.bitBuffer.resetBitPosition();
	}

	@Override
	public void serialize(final String name, final Serializable serializable) {
		serializable.serialize(this);
	}

	@Override
	public void deserialize(final String name, final Serializable serializable) {
		serializable.deserialize(this);
	}

	@Override
	public void putBoolean(final String name, final boolean value) {
		this.bitBuffer.putBoolean(value);
	}

	@Override
	public boolean getBoolean(final String name) {
		return this.bitBuffer.getBoolean();
	}

	@Override
	public void putByte(final String name, final byte value) {
		this.bitBuffer.putByte(value);
	}

	@Override
	public byte getByte(final String name) {
		return this.bitBuffer.getByte();
	}

	@Override
	public void putChar(final String name, final char value) {
		this.bitBuffer.putChar(value);
	}

	@Override
	public char getChar(final String name) {
		return this.bitBuffer.getChar();
	}

	@Override
	public void putShort(final String name, final short value) {
		this.bitBuffer.putShort(value);
	}

	@Override
	public short getShort(final String name) {
		return this.bitBuffer.getShort();
	}

	@Override
	public void putLong(final String name, final long value) {
		this.bitBuffer.putLong(value);
	}

	@Override
	public long getLong(final String name) {
		return this.bitBuffer.getLong();
	}

	@Override
	public void putFloat(final String name, final float value) {
		this.bitBuffer.putFloat(value);
	}

	@Override
	public float getFloat(final String name) {
		return this.bitBuffer.getFloat();
	}

	@Override
	public void putDouble(final String name, final double value) {
		this.bitBuffer.putDouble(value);
	}

	@Override
	public double getDouble(final String name) {
		return this.bitBuffer.getDouble();
	}

	@Override
	public void putString(final String name, final String value) {
		this.bitBuffer.putShort((short) value.length());
		this.bitBuffer.putString(value);
	}

	@Override
	public String getString(final String name) {
		return this.bitBuffer.getString(this.bitBuffer.getShort());
	}

	@Override
	public void putInt(final String name, final int value) {
		this.bitBuffer.putInt(value);
	}

	@Override
	public int getInt(final String name) {
		return this.bitBuffer.getInt();
	}
}
