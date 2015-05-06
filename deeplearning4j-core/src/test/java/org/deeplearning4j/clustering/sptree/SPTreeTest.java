/*
 *
 *  * Copyright 2015 Skymind,Inc.
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 *
 */

package org.deeplearning4j.clustering.sptree;

import static org.junit.Assert.*;
import static org.junit.Assume.*;

import org.junit.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

/**
 * @author Adam Gibson
 */
public class SPTreeTest {

    @Test
    public void testStructure() {
        INDArray data = Nd4j.create(new double[][]{
                {1,2,3},{4,5,6}
        });

        SpTree tree = new SpTree(data);
        assertEquals(Nd4j.create(new double[]{2.5,3.5,4.5}),tree.getCenterOfMass());
        assertEquals(2, tree.getCumSize());
        assertEquals(8, tree.getNumChildren());
        assertTrue(tree.isCorrect());

    }

    @Test
    public void testLargeTree() {
        int num = 100000;
        INDArray arr = Nd4j.linspace(1,num,num).reshape(num,1);
        SpTree tree = new SpTree(arr);
    }

}
