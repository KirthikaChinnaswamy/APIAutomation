@test
Feature: Services API verification

  Background: 
    * url 'http://localhost:3030/services'
    * header Accept = 'application/json'
    * call read ('classpath:src/test/resources/TestData/services.json')

  Scenario: verify valid response for services
    Given def value = payload_valid
    And request value
    When method post
    And status 201
    And match response.name == payload_valid.name
    And match $ contains { id:"#number" }

  Scenario: verify invalid response for services
    Given def value = payload_invalid.input
    And print value
    And request value
    When method post
    And status 400
    And print response
    And match response == payload_invalid.data
