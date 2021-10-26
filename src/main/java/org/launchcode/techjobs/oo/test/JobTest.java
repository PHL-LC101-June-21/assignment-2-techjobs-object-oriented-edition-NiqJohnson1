package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.util.Objects;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    private Employer employer;
    private String[] actualEmpty;
//    private Job;
//    private String[];

    @Test
    public void testSettingJobId() {
        Job idOne = new Job();
        Job idTwo = new Job();
        Assert.assertNotEquals(idOne, idTwo);

    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job techJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Employer newEmployer = new Employer("ACME");
        Location jobSite = new Location("Desert");
        PositionType position = new PositionType("Quality control");
        CoreCompetency competency = new CoreCompetency("Persistence");

        // Testing the classes
        Assert.assertTrue(techJob instanceof Job);
        Assert.assertTrue(newEmployer instanceof Employer);
        Assert.assertTrue(jobSite instanceof Location);
        Assert.assertTrue(position instanceof PositionType);
        Assert.assertTrue(competency instanceof CoreCompetency);

        // Testing the values

        Assert.assertEquals("Product tester", techJob.getName());
        Assert.assertEquals(newEmployer.getValue(), techJob.getEmployer().getValue());
        Assert.assertEquals(jobSite.getValue(), techJob.getLocation().getValue());
        Assert.assertEquals(position.getValue(), techJob.getPositionType().getValue());
        Assert.assertEquals(competency.getValue(), techJob.getCoreCompetency().getValue());

    }

    @Test
    public void testJobsForEquality() {
        Job jobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Assert.assertFalse(jobOne.equals(jobTwo));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        /* When passed a Job object, it should return a string that contains a
           blank line before and after the job information. */

        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String newJob2 = newJob.toString();

        Assert.assertEquals('\n', newJob.toString().charAt(0));
        Assert.assertEquals('\n', newJob2.toString().charAt(newJob2.toString().length() -1));

        Assert.assertEquals('\n', newJob2.charAt(newJob2.length() - 1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
       /* The string should contain a label for each field, followed by the data stored in that field.
       Each field should be on its own line. */
        Job newJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String [] actual = newJob3.toString().split("\n");

        Assert.assertEquals("ID: 4", actual[1]);
        Assert.assertEquals("Name: Product tester", actual[2]);
        Assert.assertEquals("Employer: ACME", actual[3]);
        Assert.assertEquals("Location: Desert", actual[4]);
        Assert.assertEquals("Position Type: Quality control", actual[5]);
        Assert.assertEquals("Core Competency: Persistence", actual[6]);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job newJobEmptyField = new Job("Product Tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String [] actualEmpty = newJobEmptyField.toString().split("\n");

        Assert.assertEquals("Employer: Data not available", actualEmpty[3]);




    }
}

