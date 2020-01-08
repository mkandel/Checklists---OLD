/*
 * Copyright (c) 2020. Marc Kandel
 */

package mkandel;

import mkandel.utils.categories.UnitTest;
import org.junit.After;
import org.junit.Before;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@Category(UnitTest.class)
@RunWith(SpringRunner.class)
public abstract class BaseUnitTest {
    @Before
    public void baseSetup() {
    }

    @After
    public void baseTearDown() {
    }
}
