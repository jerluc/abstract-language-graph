package org.jl.alg.lang.types;

import org.jl.alg.lang.Value;

/**
 * @author: jl
 * @date: 5/5/12
 */
public abstract class Type<T> {
    private java.lang.String name;
    
    public Type(java.lang.String name) {
        this.name = name;
    }

    public T cast(Value<T> value) {
        return value.get();
    }

    @Override
    public java.lang.String toString() {
        return name;   
    }
}
