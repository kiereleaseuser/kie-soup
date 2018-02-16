/*
 * Copyright 2014 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dashbuilder.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class ComparatorUtilsTest {

    private final Comparator<Object> comparator = (o1, o2) -> ComparatorUtils.compare(o1, o2, -1);

    @Test
    public void testString() throws Exception {
        String[] stringArray = new String[]{"3", "4", "1"};
        List<String> stringList = Arrays.asList(stringArray);
        stringList.sort(comparator);
        assertThat(stringList.get(0)).isEqualTo("4");
        assertThat(stringList.get(1)).isEqualTo("3");
        assertThat(stringList.get(2)).isEqualTo("1");
    }

    @Test
    public void testLong() throws Exception {
        Long a = 3L, b = 2L, c = 4L;
        Long[] longArray = new Long[]{a, b, c};
        List<Long> longList = Arrays.asList(longArray);
        longList.sort(comparator);
        assertThat(longList.get(0)).isEqualTo(c);
        assertThat(longList.get(1)).isEqualTo(a);
        assertThat(longList.get(2)).isEqualTo(b);
    }

    @Test
    public void testBoolean() throws Exception {
        Boolean[] booleanArray = new Boolean[]{Boolean.FALSE, Boolean.TRUE, Boolean.FALSE};
        List<Boolean> booleanList = Arrays.asList(booleanArray);
        booleanList.sort(comparator);
        assertThat(booleanList.get(0)).isEqualTo(Boolean.TRUE);
        assertThat(booleanList.get(1)).isEqualTo(Boolean.FALSE);
        assertThat(booleanList.get(2)).isEqualTo(Boolean.FALSE);
    }

    @Test
    public void testCollection() throws Exception {
        List<String> collection1 = Collections.singletonList("A");
        List<String> collection2 = Collections.singletonList("B");
        int result = comparator.compare(collection1, collection2);
        assertThat(result).isEqualTo(1);
    }
}
