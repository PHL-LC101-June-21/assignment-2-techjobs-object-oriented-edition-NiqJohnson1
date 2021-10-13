package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job idOne = new Job();
        Job idTwo = new Job();
        Assert.assertNotEquals(idOne, idTwo);

    }

    @Test
    public void testJobConstructorSetsAllFields(){
      Job techJob = new Job("Product tester",new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
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
        Job jobOne = new Job("Product tester",new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobTwo = new Job("Product tester",new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Assert.assertFalse(jobOne.equals(jobTwo));
    }

}
