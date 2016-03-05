package org.junit.kolokwium.exc2.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   KontraktCyfroKradCorrect.class,
   KontraktCyfroKradNull.class,
   KontraktHeheszkiCorrect.class,
   KontraktHeheszkiException.class,
   KontraktHeheszkiZero.class,
   KontraktHultajChochlaCorrectFirstCase.class,
   KontraktHultajChochlaCorrectSecondCase.class,
   KontraktHultajChochlaException.class,
   KontraktNieksztalekCorrect.class,
   KontraktNieksztalekZero.class,
   KontraktTititCorrect.class,
   KontraktTititException.class
})
public class SuiteTest {   
}  	