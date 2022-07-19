@postPage
Feature: posts under Activity Stream module
  User story: As a user, I should be able to see posts from homepage

  Scenario Outline: Users can like a post
    Given User "<role>" is logged in under "activity stream" module
    When User like a post
    Then User should see a Like icon popup under the Like button
    Examples:
      | role      |
      | hr        |
      | marketing |
      | helpdesk  |

  Scenario Outline: Users can follow a post
    Given User "<role>" is logged in under "activity stream" module
    When User click Follow button under posts
    Then User should see Unfollow text displayed
    Examples:
      | role      |
      | hr        |
      | marketing |
      | helpdesk  |

  Scenario Outline: Users can see the view count
    Given User "<role>" is logged in under "activity stream" module
    Then User should see under a post, how many people viewed a post by the number right next to the View counter icon
    Examples:
      | role      |
      | hr        |
      | marketing |
      | helpdesk  |

  Scenario Outline: Users can save a post as favorite
    Given User "<role>" is logged in under "activity stream" module
    When User click a star icon on the top right of a post
    Then User should see the post as favorite
    Examples:
      | role      |
      | hr        |
      | marketing |
      | helpdesk  |

  Scenario Outline: Users can send the comment
    Given User "<role>" is logged in under "activity stream" module
    When User add comment under a post
    Then User can send the comment
    Examples:
      | role      |
      | hr        |
      | marketing |
      | helpdesk  |

  Scenario Outline: Users cancel the comment
    Given User "<role>" is logged in under "activity stream" module
    When User add comment under a post
    Then User can cancel the comment
    Examples:
      | role      |
      | hr        |
      | marketing |
      | helpdesk  |