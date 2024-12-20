/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.microsphere.lang;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * {@link Deprecation} Test
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy<a/>
 * @see Deprecation
 * @since 1.0.0
 */
public class DeprecationTest {

    private static final String SINCE = "1.0.0";
    private static final String REASON = "No Reason";
    private static final String REPLACEMENT = "No Replacement";
    private static final String LINK = "https://github.com/microsphere-projects/microsphere-java";
    private static Deprecation.Level LEVEL = Deprecation.Level.REMOVAL;

    @Test
    public void test() {
        Deprecation deprecation = Deprecation.of(SINCE, REPLACEMENT, REASON, LINK, LEVEL);

        assertEquals(SINCE, deprecation.getSince());
        assertEquals(REPLACEMENT, deprecation.getReplacement());
        assertEquals(REASON, deprecation.getReason());
        assertEquals(LINK, deprecation.getLink());
        assertEquals(LEVEL, deprecation.getLevel());
        assertNotNull(deprecation.toString());
        assertEquals(deprecation, new Deprecation(deprecation));
        assertEquals(deprecation.hashCode(), new Deprecation(deprecation).hashCode());

        deprecation = Deprecation.of(SINCE, REPLACEMENT, REASON, LINK);
        assertEquals(SINCE, deprecation.getSince());
        assertEquals(REPLACEMENT, deprecation.getReplacement());
        assertEquals(REASON, deprecation.getReason());
        assertEquals(LINK, deprecation.getLink());
        assertEquals(Deprecation.Level.DEFAULT, deprecation.getLevel());
        assertNotNull(deprecation.toString());
        assertEquals(deprecation, new Deprecation(deprecation));
        assertEquals(deprecation.hashCode(), new Deprecation(deprecation).hashCode());

        deprecation = Deprecation.of(SINCE, REPLACEMENT, REASON);
        assertEquals(SINCE, deprecation.getSince());
        assertEquals(REPLACEMENT, deprecation.getReplacement());
        assertEquals(REASON, deprecation.getReason());
        assertNull(deprecation.getLink());
        assertEquals(Deprecation.Level.DEFAULT, deprecation.getLevel());
        assertNotNull(deprecation.toString());
        assertEquals(deprecation, new Deprecation(deprecation));
        assertEquals(deprecation.hashCode(), new Deprecation(deprecation).hashCode());

        deprecation = Deprecation.of(SINCE, REPLACEMENT, REASON);
        assertEquals(SINCE, deprecation.getSince());
        assertEquals(REPLACEMENT, deprecation.getReplacement());
        assertEquals(REASON, deprecation.getReason());
        assertNull(deprecation.getLink());
        assertEquals(Deprecation.Level.DEFAULT, deprecation.getLevel());
        assertNotNull(deprecation.toString());
        assertEquals(deprecation, new Deprecation(deprecation));
        assertEquals(deprecation.hashCode(), new Deprecation(deprecation).hashCode());

        deprecation = Deprecation.of(SINCE, REPLACEMENT);
        assertEquals(SINCE, deprecation.getSince());
        assertEquals(REPLACEMENT, deprecation.getReplacement());
        assertNull(deprecation.getReason());
        assertNull(deprecation.getLink());
        assertEquals(Deprecation.Level.DEFAULT, deprecation.getLevel());
        assertNotNull(deprecation.toString());
        assertEquals(deprecation, new Deprecation(deprecation));
        assertEquals(deprecation.hashCode(), new Deprecation(deprecation).hashCode());

        deprecation = Deprecation.of(SINCE);
        assertEquals(SINCE, deprecation.getSince());
        assertNull(deprecation.getReplacement());
        assertNull(deprecation.getReason());
        assertNull(deprecation.getLink());
        assertEquals(Deprecation.Level.DEFAULT, deprecation.getLevel());
        assertNotNull(deprecation.toString());
        assertEquals(deprecation, new Deprecation(deprecation));
        assertEquals(deprecation.hashCode(), new Deprecation(deprecation).hashCode());

        deprecation = Deprecation.of(null);
        assertNull(deprecation.getSince());
        assertNull(deprecation.getReplacement());
        assertNull(deprecation.getReason());
        assertNull(deprecation.getLink());
        assertEquals(Deprecation.Level.DEFAULT, deprecation.getLevel());
        assertNotNull(deprecation.toString());
        assertEquals(deprecation, new Deprecation(deprecation));
        assertEquals(deprecation.hashCode(), new Deprecation(deprecation).hashCode());

    }
}
