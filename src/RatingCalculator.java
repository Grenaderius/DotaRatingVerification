
public class RatingCalculator {

    private int rating;

    /*@
      public invariant rating >= 0;
    @*/

    public RatingCalculator(int initialRating) {
        this.rating = initialRating;
    }

    /*@
      public normal_behavior
      requires points > 0;
      requires points <= 1000000;
      requires rating <= 1000000 - points;
      ensures rating == \old(rating) + points;
      assignable rating;
    @*/
    public void applyVictory(int points) {
        rating += points;
    }

    /*@
      public normal_behavior
      requires points > 0;
      requires points <= rating;
      ensures rating == \old(rating) - points;
      ensures rating >= 0;
      assignable rating;
    @*/
    public void applyDefeat(int points) {
        rating -= points;
    }

    /*@
      public normal_behavior
      ensures \result == rating;
      assignable \nothing;
    @*/
    public /*@ pure @*/ int getRating() {
        return rating;
    }
}
