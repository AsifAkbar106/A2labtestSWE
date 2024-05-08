package com.example.a2labtest;



import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;


import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void AddVehicleButtonTest(){
        Espresso.onView(withId(R.id.editTextsedan_moto_suv)).perform(typeText("sedan"));
        Espresso.onView(withId(R.id.editTextRed_Green_Blue)).perform(typeText("red"));
        Espresso.onView(withId(R.id.buttonAddVehicle)).perform(click());
        Espresso.onView(withId(R.id.textView3)).check(matches(withText("red and the vehicle name is sedan")));
    }
    @Test
    public void AddPetrolButtonTest(){
        Espresso.onView(withId(R.id.editTextsedan_moto_suv)).perform(typeText("sedan"));
        Espresso.onView(withId(R.id.editTextAddPetrol)).perform(typeText("5"));
        Espresso.pressBack();
        Espresso.onView(withId(R.id.buttonAddPetrol)).perform(click());
        Espresso.onView(withId(R.id.textView3)).check(matches(withText("petrol added 5.0 liters")));
        Espresso.onView(withId(R.id.textView4)).check(matches(withText("Fuel=>5.0")));
    }
    @Test
    public void DriveButtonTest(){
        Espresso.onView(withId(R.id.editTextsedan_moto_suv)).perform(typeText("sedan"));
        Espresso.onView(withId(R.id.editTextAddPetrol)).perform(typeText("5"));
        Espresso.pressBack();
        Espresso.onView(withId(R.id.buttonAddPetrol)).perform(click());
        Espresso.onView(withId(R.id.textView3)).check(matches(withText("petrol added 5.0 liters")));
        Espresso.onView(withId(R.id.textView4)).check(matches(withText("Fuel=>5.0")));
        Espresso.onView(withId(R.id.buttonDrive)).perform(click());
        Espresso.onView(withId(R.id.textView3)).check(matches(withText("ran 5 miles and burnt 2l fuel")));
        Espresso.onView(withId(R.id.textView4)).check(matches(withText("Fuel=>3.0Mileage=>5.0")));
    }

}