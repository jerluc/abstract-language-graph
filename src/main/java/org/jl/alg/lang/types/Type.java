package org.jl.alg.lang.types;

/**
 * @author: jl
 * @date: 5/5/12
 */
public abstract class Type {
    private String name;
    
    public Type(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name;   
    }
}
