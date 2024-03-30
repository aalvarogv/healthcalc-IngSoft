@tag
Feature: Cálculo Ideal Weight

"As a health calculator user
I want to introduce my height and my gender values
So that I can calculate my ideal weight"

    @tag1
    Scenario Outline: Correct values introduced
        Given I am a health calculator user
        When I introduce my height as <height> and my gender as "<gender>" values correctly
        Then The calculator will calculate my ideal weight as <ideal_weight>

                Examples:
            | height | gender | ideal_weight |
            | 145    | w      | 47           |
            | 190    | m      | 80           |

    @tag2
    Scenario Outline: Inorrect values introduced
        Given I am a health calculator user
        When I introduce my height as <height> and my gender as "<gender>" values incorrectly
        Then The calculator will send me an error message

                Examples:
            | height | gender | error_msg |
            | -5     | w      | True      |
            | 190    | j      | True      |        