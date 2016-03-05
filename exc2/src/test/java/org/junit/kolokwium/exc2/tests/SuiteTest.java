package org.junit.kolokwium.exc2.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   KontraktCyfroKradCorrectTest.class,
   KontraktCyfroKradNullTest.class,
   KontraktHeheszkiCorrectTest.class,
   KontraktHeheszkiExceptionTest.class,
   KontraktHeheszkiZeroTest.class,
   KontraktHultajChochlaCorrectFirstCaseTest.class,
   KontraktHultajChochlaCorrectSecondCaseTest.class,
   KontraktHultajChochlaExceptionTest.class,
   KontraktNieksztalekCorrectTest.class,
   KontraktNieksztalekZeroTest.class,
   KontraktTititCorrectTest.class,
   KontraktTititExceptionTest.class
})
public class SuiteTest {   
}  	