@tag
Feature: Cálculo Basal Metabolic Rate

"As a health calculator user
I want to introduce my weight, my height, my age and my gender values
So that I can calculate my basal metabolic rate"

    @tag1
    Scenario Outline: Correct values introduced
        Given I am a health calculator user
        When I introduce my weight as <weight>, my height as <height>, my age as <age> and my gender as "<gender>" values correctly
        Then The calculator will calculate my basal metabolic rate as <basal_metabolic_rate>

                Examples:
            | weight | height | age | gender | basal_metabolic_rate |
            | 78     | 184    | 25  | m      | 1810                 |
            | 55     | 160    | 19  | w      | 1460                 |

    @tag2
    Scenario Outline: Inorrect values introduced
        Given I am a health calculator user
        When I introduce my weight as <weight>, my height as <height>, my age as <age> and my gender as "<gender>" values incorrectly
        Then The calculator will send me an error message as "<error_msg>"

                Examples:
            | weight | height | age | gender | error_msg                                    |
            | -12    | 174    | 25  | m      | El peso introducido debe ser > 0             |
            | 55     | -8     | 19  | w      | La altura introducida debe ser > 0           |
            | 85     | 189    | 0   | m      | La edad introducida debe estar entre 0 y 140 |
            | 82     | 180    | 45  | w      | El género introducido no es correcto         |   