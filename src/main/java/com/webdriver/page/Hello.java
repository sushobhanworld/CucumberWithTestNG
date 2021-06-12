package com.webdriver.page;

public class Hello {
    public static void main(String[] args) {
        System.out.println("\"Optional[Create bug in Bugzilla application]\"");
    }
    private String getFeatureName(String name){
        String featureName= name.replace("Optional[","");
        if(featureName.lastIndexOf("]")!=-1)
            featureName= featureName.substring(0, featureName.lastIndexOf("]"));
        return featureName;
    }
}
