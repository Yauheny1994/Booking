Feature: search on booking.com
  Scenario: Search by city criteria
    Given User is looking for hotel in 'London' city
    When User does search
    Then Hotel 'Nobu Hotel London Portman Square' should be on the first page

 Scenario Outline: Search by cities criteria
    Given User is looking for hotel in '<City>' city
    When User does search
    Then Hotel '<Hotel>' should be on the first page
   Examples:
     |City|Hotel|
     |London    |Nobu Hotel London Portman Square             |
     |Washington|The St Gregory Hotel Dupont Circle Georgetown|
     |Madrid    |Room Mate Alba                               |
