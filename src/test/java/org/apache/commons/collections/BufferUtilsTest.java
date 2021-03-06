/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.collections;

import junit.framework.Test;

import org.apache.commons.collections.buffer.PredicatedBuffer;

/**
 * Tests for BufferUtils.
 *
 * @version $Revision$
 *
 * @author Unknown
 */
public class BufferUtilsTest extends BulkTest {

    public BufferUtilsTest(final String name) {
        super(name);
    }


    public static Test suite() {
        return BulkTest.makeSuite(BufferUtilsTest.class);
    }

    public void testNothing() {
    }

    public void testpredicatedBuffer() {
        final Predicate<Object> predicate = new Predicate<Object>() {
            public boolean evaluate(final Object o) {
                return o instanceof String;
            }
        };
        Buffer<Object> buffer = BufferUtils.predicatedBuffer(new ArrayStack<Object>(), predicate);
        assertTrue("returned object should be a PredicatedBuffer",
            buffer instanceof PredicatedBuffer);
        try {
            buffer = BufferUtils.predicatedBuffer(new ArrayStack<Object>(), null);
            fail("Expecting IllegalArgumentException for null predicate.");
        } catch (final IllegalArgumentException ex) {
            // expected
        }
        try {
            buffer = BufferUtils.predicatedBuffer(null, predicate);
            fail("Expecting IllegalArgumentException for null buffer.");
        } catch (final IllegalArgumentException ex) {
            // expected
        }
    }

}
