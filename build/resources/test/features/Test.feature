Feature: Test Chorus Broadband Map
  Scenario: Test Chorus Broadband Map
    Given I navigate to broadband map
    When I search for the given address 98 Amesbury Drive, Churton Park, Wellington
    Then the map displays the list of available services at the address
