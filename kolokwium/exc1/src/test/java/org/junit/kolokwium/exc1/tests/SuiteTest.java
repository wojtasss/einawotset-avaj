package org.junit.kolokwium.exc1.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   StackGetMaxFromStackCorrect.class,
   StackGetMaxFromStackException.class,
   StackGetMinFromStackCorrect.class,
   StackGetMinFromStackException.class,
   StackIsNull.class,
   StackPopCorrect.class,
   StackPopException.class,
   StackPushCorrect.class,
   StackPushException.class,
   StackTopCorrect.class,
   StackTopException.class
})
public class SuiteTest {   
}  	