@ui @healthcheck
Feature: E-commerce Project Web Site Health Check

  Scenario: User is able to Open the browser, navigate to the URL and Search for Product
    Given User navigated to the home application url
    When User Search for product "Laptop"
    Then Search Result page is displayed
    
    Scenario: User is click on the Product and check the Product Details
    Given User navigated to the home application url
    And User Search for product "Laptop"
    When User click on any product
    Then Product Description is displayed in new tab
    
     @tt
    Scenario: User is click on the Product and check the Product Details
    Given     User navigated to the home application url
    When      User Search for product "Apple Airpods"
    Then      Search Result page is displayed
    When      User click on any product
    Then      Product Description is displayed in new tab