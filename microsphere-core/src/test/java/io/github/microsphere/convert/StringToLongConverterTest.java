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
package io.github.microsphere.convert;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * {@link StringToLongConverter} Test
 *
 * @since 1.0.0
 */
public class StringToLongConverterTest {

    private StringToLongConverter converter;

    @BeforeEach
    public void init() {
        converter = new StringToLongConverter();
    }

    @Test
    public void testAccept() {
        assertTrue(converter.accept(String.class, Long.class));
    }

    @Test
    public void testConvert() {
        assertEquals(Long.valueOf("1"), converter.convert("1"));
        assertNull(converter.convert(null));
        assertThrows(NumberFormatException.class, () -> {
            converter.convert("ttt");
        });
    }
}
