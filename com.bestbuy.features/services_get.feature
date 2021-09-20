@test
Feature: Services API verification

  Background: 
    * url 'http://localhost:3030/services'
    * header Accept = 'application/json'
    * call read ('classpath:src/test/resources/TestData/services.json')

  Scenario: verify response for services
    Given method get
    When status 200
    And match $ contains { total:"#number" }
    And match $ contains { data: '#[]' }
    Then assert responseStatus == status.code200

  Scenario: verify name by passing valid id
    Given param id = validdata.data[0].id
    When method get
    And status 200
    And match response.data[0].name == validdata.data[0].name
    And match response == validdata

  Scenario: Get id using name
    Given param name = validdata.data[0].name
    When method get
    And status 200
    And match response.data[0].id == validdata.data[0].id

  Scenario: verify zero data with invalid id
    Given param id = zerodata.id
    When method get
    And status 200
    And match $ contains { total:0 }
    And assert response.total == 0
    And match response == zerodata.data

  Scenario: verify 500 response with invalid parameter
    Given param ids = error500.id
    When method get
    And status 500
 		And match response == error500.data
    
  Scenario: verify 404 response with invalid id
    Given path error404.id
    When method get
    And status 404
 		And match response == error404.data    
