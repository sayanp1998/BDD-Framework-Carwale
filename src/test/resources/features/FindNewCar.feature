Feature: Searching New Cars

In order to search new Cars
As a User
I have to anvigate to Carwale.com

  Scenario Outline: Finding new Cars
    Given user navigates to carwale website
    When user mouseover to newcars
    Then user clicks on Findnewcars
    And user clicks on "<carBrand>" car
    And user Validates car title as "<carTitle>"
    Examples:
      | carBrand | carTitle    |
      | Toyota   | Toyota Cars |
      | BMW      | BMW Cars    |
      | Honda    | HondaCars   |
      | Kia      | Kia Cars    |
