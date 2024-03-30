@tag
Feature: Cálculo Basal Metabolic Rate

"As a health calculator user
I want to introduce my weight, my height, my age and my gender values
So that I can calculate my basal metabolic rate"

    @tag1
    Scenario Outline: Correct values introduced
        Given I am another health calculator user
        When I introduce my weight as <weight>, my height as <height>, my gender as "<gender>" and my age as <age> values correctly
        Then The calculator will calculate my basal metabolic rate as <basal_metabolic_rate>

                Examples:
            | weight | height | gender | age | basal_metabolic_rate |
            | 78     | 184    | m      | 25  | 1810                 |
            | 55     | 160    | w      | 19  | 1294                 |

    @tag2
    Scenario Outline: Inorrect values introduced
        Given I am another health calculator user
        When I introduce my weight as <weight>, my height as <height>, my gender as "<gender>" and my age as <age> values incorrectly
        Then The calculator will send me another error message

                Examples:
            | weight | height | gender | age | error_msg |
            | -12    | 174    | m      | 25  | True      |
            | 55     | -8     | w      | 19  | True      |
            | 85     | 189    | m      | 0   | True      |
            | 82     | 180    | k      | 45  | True      |