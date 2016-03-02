package org.junit.kolokwium.exc1.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   StackGetMaxFromStackCorrectTest.class,
   StackGetMaxFromStackExceptionTest.class,
   StackGetMinFromStackCorrectTest.class,
   StackGetMinFromStackExceptionTest.class,
   StackIsNullTest.class,
   StackPopCorrectTest.class,
   StackPopExceptionTest.class,
   StackPushCorrectTest.class,
   StackPushExceptionTest.class,
   StackTopCorrectTest.class,
   StackTopExceptionTest.class
})
public class SuiteTest {   
}  	