package com.tho.serialization.serializer;

import java.util.Stack;

import com.tho.serialization.Serializable;

public abstract class AbstractKeyValueSerializer<T> extends AbstractSerializer {

	private final Stack<T> stack;
	protected T currentObject;

	protected AbstractKeyValueSerializer() {
		this.stack = new Stack<>();
		this.currentObject = getNewObject();
	}

	protected abstract T getNewObject();

	protected abstract void put(final String name, final T object);

	protected abstract T get(final String name);

	@Override
	public void serialize(final String name, final Serializable serializable) {
		final T subObject = getNewObject();
		put(name, subObject);
		this.stack.push(this.currentObject);
		this.currentObject = subObject;
		serializable.serialize(this);
		this.currentObject = this.stack.pop();
	}

	@Override
	public void deserialize(final String name, final Serializable serializable) {
		final T subObject = get(name);
		this.stack.push(this.currentObject);
		this.currentObject = subObject;
		serializable.deserialize(this);
		this.currentObject = this.stack.pop();
	}
}
