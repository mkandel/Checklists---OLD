/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists;

import com.mkandel.checklists.utils.categories.UnitTest;
import org.junit.After;
import org.junit.Before;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@Category(UnitTest.class)
//@RunWith(SpringRunner.class)
@RunWith(MockitoJUnitRunner.class)
public abstract class BaseUnitTest {
    @Before
    public void baseSetup() {
    }

    @After
    public void baseTearDown() {
    }
}
