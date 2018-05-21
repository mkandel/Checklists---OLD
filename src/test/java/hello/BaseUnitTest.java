/*
 * Copyright (c) 2018. Marc Kandel
 */

package hello;

import hello.utils.categories.UnitTest;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@Category(UnitTest.class)
@RunWith(SpringRunner.class)
public abstract class BaseUnitTest {

}
