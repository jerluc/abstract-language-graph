package org.jl.alg.lang;

import org.jl.alg.lang.types.Type;

/**
 * @author: jl
 * @date: 5/5/12
 */
public class Value<T extends Type> {
    private T value;
    public Value(T value) {
        this.value = value;        
    }
    
    public T get() {
        return value;
    }
    
    public T getValueAsType(Type<T> type) {
        return type.cast(this);
    }
}
