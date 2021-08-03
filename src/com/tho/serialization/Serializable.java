package com.tho.serialization;

import com.tho.serialization.serializer.AbstractSerializer;

public interface Serializable { 

	public void serialize(final AbstractSerializer serializer);

	public void deserialize(final AbstractSerializer serializer);
}
