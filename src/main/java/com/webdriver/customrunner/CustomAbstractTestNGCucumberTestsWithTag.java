package com.webdriver.customrunner;

import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomAbstractTestNGCucumberTestsWithTag {
    private TestNGCucumberRunner testNGCucumberRunner;

    public CustomAbstractTestNGCucumberTestsWithTag() {
    }

    @BeforeClass(
            alwaysRun = true
    )
    public void setUpClass() {
        this.testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(
            groups = {"cucumber"},
            description = "Runs Cucumber Scenarios",
            dataProvider = "scenarios"
    )
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        this.testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Iterator<Object[]> scenarios() {
        //Object[][] data = testNGCucumberRunner.provideScenarios();
        //PickleWrapper pickleWrappers= (PickleWrapper) data[0][0];
        //FeatureWrapper featureWrapper= (FeatureWrapper) data[0][1];
        //return this.testNGCucumberRunner == null ? new Object[0][0] : this.testNGCucumberRunner.provideScenarios();
        ArrayList<Object[]> modifiedList = new ArrayList<>();
        if(testNGCucumberRunner ==null)
            return modifiedList.iterator();
        modifiedList= filterTheFeature(testNGCucumberRunner.provideScenarios());
        return modifiedList.iterator();
    }

    //data[0][0] -->PickleWrapper  ---> Gives the information about the scenario and its steps
    //data[0][1] -->FeatureWrapper  ---> Gives the information about feature file


    //Here, we have Object[][] data, it contains all the feature files to be executed
    //Now, we have a list containing the Feature files that we want to execute
    //Hence, we have to filter out the feature file here
    //After that, once we have the filtered list (validated against the data array), we supply this array list in Data Provider above

    private ArrayList<Object[]> filterTheFeature(Object[][] data){
        //List<String> tagList= Arrays.asList("Open Google page");
        String tagValue = System.getProperty("TagName");
        System.out.println(tagValue);

        if(tagValue == null || tagValue.isEmpty()){
            return getFeatureList(data);
        }
        String[] tagList= tagValue.split(",");
        ArrayList<Object[]> modifiedList= new ArrayList<>();
        if(data!=null){
            for (int i=0;i< data.length;i++){
                PickleWrapper pickleWrapper= (PickleWrapper) data[i][0];
                if(!pickleWrapper.getPickle().getTags().isEmpty()){
                    for(String aTag:tagList){
                        if (isTagPresent(aTag, pickleWrapper.getPickle().getTags()))
                            modifiedList.add(data[i]);
                    }
                }
            }
        }
        return modifiedList;
    }

    //Method to check whether tags supplied by user (tagList) is present in tags fetched by PickleWrapper (getTags)
    private boolean isTagPresent(String aTag, List<String>aTagList){
        return aTagList.stream()
                .filter(x -> x.equalsIgnoreCase(aTag))
                .collect(Collectors.toList()).isEmpty();
    }

    private ArrayList<Object[]> getFeatureList(Object[][] data) {
        ArrayList<Object[]> modifiedList = new ArrayList<>();
        if(data != null){
            for (int i = 0; i < data.length; i++) {
                modifiedList.add(data[i]);
            }
        }
        return modifiedList;
    }

    @AfterClass(
            alwaysRun = true
    )
    public void tearDownClass() {
        if (this.testNGCucumberRunner != null) {
            this.testNGCucumberRunner.finish();
        }

    }
}
