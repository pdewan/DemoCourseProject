package pc.graphics;

import util.models.PropertyListenerRegisterer;

public interface BoundedBuffer<ElementType> extends PropertyListenerRegisterer {
	void put(ElementType element);
	ElementType get();
	
}
