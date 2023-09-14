Feature: To verify manage class page

  Background: Admin logged into LMS portal

  @class_test_01
  Scenario Outline: Validate search box function
    Given Admin is on Manage Class Page
    When Admin enters <Input> into search box
    Then <Result> for <Details>

  Examples:
    | Input                    | Result                                   | Details               |
    | batch id                 | Displays entries with that batch Id      | Batch 101             |
    | non-existing batch id    | Displays empty details in the data table | Batch 999             |
    | class no                 | Displays entries with that class no      | Class 202             |
    | non-existing class no    | Displays empty details in the data table | Class 999             |
    | class topic              | Displays entries with that class topic   | Introduction to Maths |
    | non-existing class topic | Displays empty details in the data table | Advanced Quantum      |
    | staff id                 | Displays entries with that staff id      | Staff 303             |
    | non-existing staff id    | Displays empty details in the data table | Staff 999             |
    | class date               | Displays entries with that class date    | 1st Jan 2023          |
    | invalid class date       | Displays empty details in the data table | 32nd Feb 2023         |
