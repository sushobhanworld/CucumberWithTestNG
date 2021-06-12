Feature: Create bug in Bugzilla application
  Scenario: Usage of Custom Factory
    Given Bugzilla_I am at the Bugzilla home page
    Then Bugzilla_I click on File a bug link and navigate to login page
    And Bugzilla_The title of login page should be "Log in to Bugzilla"
    Then Bugzilla_I log into the application and navigate to enter bug page
    Then Bugzilla_I navigate to Home page
    Then Bugzilla_I navigate to enter bug page
    And Bugzilla_I enter details as severity as "trivial" hardware as "All" operating system as "Windows" summary as "Bug Summary" and description as "Test Description"
    And Bugzilla_I am at the summary page and I click the logout button