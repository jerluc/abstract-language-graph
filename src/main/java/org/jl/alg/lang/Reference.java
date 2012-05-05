package org.jl.alg.lang;

import org.jl.alg.lang.types.Type;

/**
 * @author: jl
 * @date: 5/5/12
 */
public class Reference<T extends Type> {
    private Mutability mutability;
    private Visibility visibility;
    private Scope scope;
    private Value<T> target;

    public Reference(Scope scope) {
        this(Visibility.LOCAL, scope);
    }

    public Reference(Visibility visibility, Scope scope) {
        this(Mutability.FINAL, visibility, scope);
    }
    
    public Reference(Mutability mutability, Visibility visibility, Scope scope) {
        this.mutability = mutability;
        this.visibility = visibility;
        this.scope = scope;
    }
    
    public void setTarget(Value<T> newTarget) throws ImmutableReferenceException {
        if (mutability == Mutability.FINAL)
            throw new ImmutableReferenceException("Cannot modify the value of an immutable reference");
        target = newTarget;
    }
    
    public Value<T> getTarget(Scope accessingScope) throws ReferenceOutOfScopeException {
        switch (visibility) {
            case GLOBAL:
                return target;
            case PRIVATE:
                if (accessingScope.equals(scope))
                    return target;
                else
                    throw new ReferenceOutOfScopeException("Cannot access reference out of private scope");
            case PROTECTED:
                if (accessingScope.equals(scope) || scope.contains(accessingScope))
                    return target;
                else
                    throw new ReferenceOutOfScopeException("Cannot access reference out of protected scope");
            case LOCAL:
            default:
                if (accessingScope.equals(scope))
                    return target;
                else
                    throw new ReferenceOutOfScopeException("Cannot access reference out of local/public scope");
        }
    }
}
