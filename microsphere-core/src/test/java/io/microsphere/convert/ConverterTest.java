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
package io.microsphere.convert;

import io.microsphere.util.ClassLoaderUtils;
import org.junit.jupiter.api.Test;

import static io.microsphere.convert.Converter.convertIfPossible;
import static io.microsphere.convert.Converter.getConverter;
import static io.microsphere.util.ServiceLoaderUtils.loadServicesList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * {@link Converter} Test-Cases
 *
 * @since 1.0.0
 */
public class ConverterTest {

    @Test
    public void testGetConverter() {
        loadServicesList(Converter.class, ClassLoaderUtils.getDefaultClassLoader()).stream().sorted().forEach(converter -> {
            assertSame(converter.getClass(), getConverter(converter.getSourceType(), converter.getTargetType()).getClass());
        });
    }

    @Test
    public void testConvertIfPossible() {
        assertEquals(Integer.valueOf(2), convertIfPossible("2", Integer.class));
        assertEquals(Boolean.FALSE, convertIfPossible("false", Boolean.class));
        assertEquals(Double.valueOf(1), convertIfPossible("1", Double.class));
    }
}
