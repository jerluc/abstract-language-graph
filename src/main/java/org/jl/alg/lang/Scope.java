package org.jl.alg.lang;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: jl
 * @date: 5/5/12
 */
public class Scope {
    private Set<Scope> subScopes;

    public Scope() {
        subScopes = new HashSet<Scope>();
    }

    public Boolean contains(Scope accessingScope) {
        if (subScopes.contains(accessingScope))
            return Boolean.TRUE;
        else
            return Boolean.FALSE;
    }
    
    public void addScope(Scope subScope) {
        subScopes.add(subScope);
    }
}
