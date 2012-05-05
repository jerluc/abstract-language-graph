package org.jl.alg.lang;

import org.jl.alg.lang.types.Int;
import org.jl.alg.lang.types.Type;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author: jl
 * @date: 5/5/12
 */
public class ReferenceTest {

    private Scope localScope;
    private Scope privateScope;
    private Scope globalScope;
    private Value<Int> integerValue;


    @Before
    public void setUp() throws Exception {
        integerValue = new Value<Int>();


        localScope = new Scope();
        privateScope = new Scope();
        privateScope.addScope(localScope);
        globalScope = new Scope();        
        globalScope.addScope(privateScope);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test (expected = ImmutableReferenceException.class)
    public void testSetTargetOnImmutableReference() throws Exception {
        Reference reference = new Reference(Mutability.FINAL, Visibility.GLOBAL, globalScope);
        reference.setTarget(new Value(new Type()));
    }

    @Test
    public void testSetTargetOnMutableReference() throws Exception {
        Reference reference = new Reference(Mutability.VARIABLE, Visibility.GLOBAL, globalScope);
        reference.setTarget(new Value(new Type()));
    }

    @Test
    public void testGetTarget() throws Exception {

    }
}
