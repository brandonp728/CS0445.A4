package cs445.a4;

/**
 * This abstract data type is a predictive engine for video ratings in a streaming video system. It
 * stores a set of users, a set of videos, and a set of ratings that users have assigned to videos.
 * This collection is unordered and homogeneity via the Video supertype is enforced. It cannot contain
 * duplicate items and there is no limit on the amount of items that this can store.
 */
public interface VideoEngine {


    /**
     * Inserts a video into the system. 
     * 
     * <p>If the video added is null then the method throws a NullPointerException. If the video entered is 
     * already in the system, the method returns false and does not add that video. If the system is full, 
     * the maximum capacity is increased and the video is then added.
     * 
     * @param entry: the video to be added
     * @throws NullPointerException if the video entered is null
     * @return True if the video was added, False if the video was not added
     */
    boolean addVideo(Video entry);
    
    /**
     *  Removes the specific entry from the system. 
     *  
     *  <p>If entry is not null and is in the system then the method removes entry and returns true. If entry is 
     *  not in the system the method returns false. If the entered element is null then the method throws 
     *  a NullPointerException.
     * 
     *  @param entry, the element to be removed
     *  @return True if the entry was successfully removed
     *  @return null, if the system is empty
     *  @throws NullPointerException if entry is null
     */
    boolean removeVideo(Video entry);

    /**
     * Adds an existing television episode to an existing television series. 
     * 
     * <p>If the episode added is null then the method throws a NullPointerException. If the episode entered 
     * is already in the series, the method returns false and does not add that episode. If the system is full,
     * the maximum capacity is increased and the episode is then added.
     * 
     * @param episode: the episode to be added
     * @throws NullPointerException if the episode entered is null
     * @return True if the episode was added
     * @return False if the episode was not added
     */
    boolean addToSeries(TvEpisode episode);

    /**
     *  Removes an episode from the series. 
     *  
     *  <p>If episode is not null and is in the series then the method removes episode and returns true. If episode is 
     *  not in the series the method returns false. If the entered element is null then the method throws 
     *  a NullPointerException.
     * 
     *  @param episode, the element to be removed
     *  @return True, if the episode was successfully removed
     *  @return null, if the series is empty
     *  @throws NullPointerException, if episode is null
     */
    boolean removeFromSeries(TvEpisode episode);
    
    /**
     * Sets a user's rating for a video, as a number of stars from 1 to 5.
     * 
     * <p>If rating passed is less than 1 or greater than 5 the method throws an IllegalArgumentException, and a 
     * NullPointerException if either theUser's value or theVideo's value is null. 
     * 
     * @param rating, the rating the user has assigned to the video
     * @param video, the video to which the user's rating will be applied
     * @param theUser, the user under whom the rating will be applied
     * @throws IllegalArgumentException if rating is less than 1 or greater than 5
     * @throws NullPointerException if theUser is null
     * @throws NullPointerException if theVideo is null
     */
    void rateVideo(int rating, Video theVideo, User theUser);

    /**
     * Clears a user's rating on a video. 
     * 
     * <p>If this user has rated this video and the rating has not
     * already been cleared, then the rating is cleared and the state will appear as if the rating
     * was never made. If this user has not rated this video, or if the rating has already been
     * cleared, then this method will throw an IllegalArgumentException.
     *
     * @param theUser user whose rating should be cleared
     * @param theVideo video from which the user's rating should be cleared
     * @throws IllegalArgumentException if the user does not currently have a rating on record for
     * the video
     * @throws NullPointerException if either the user or the video is null
     */
    public void clearRating(User theUser, Video theVideo);

    /**
     * Predicts the rating a user will assign to a video that they have not yet rated, as a number
     * of stars from 1 to 5.
     * 
     * <p>This method calculates the average rating of theVideo from other users returns it to theUser to let them know
     * if they would enjoy the video or not. If theVideo has not been rated the method returns 0 to theUser. 
     * If theVideo is null, the method throws an NullPointerException. If theUser has already rated theVideo, this method 
     * returns the rating that the user gave to theVideo.
     * 
     * @param theVideo, the video for which this method predicts a rating
     * @param theUser, the user for which this method calculates a rating
     * @throws NullPointerException, if theVideo is null
     * @return 0, if the video has no ratings
     * @return the average rating of the video
     * @return the user's rating for the video, if they have already rated it.
     */
    int predictRating(Video theVideo, User theUser);

    /**
     * Suggests a video for a user (e.g.,based on their predicted ratings).
     * 
     * <p>This method gets a predicted rating and then finds a video with that rating and returns it. If the
     * rating passed is less than 1 or greater than 5 this method throws an IllegalArgumentException. If the rating passed 
     * is 0 then this method returns a video with no rating.  If no videos with that rating are found this method returns null.
     * 
     * @param rating, the predicted rating used to find a video
     * @throws IllegalArgumentException, if the rating entered is less than 1 or more than 5
     * @returns a video with a rating that matches the predicted rating
     * @returns a video with no rating if the predicted rating is 0
     * @returns null if no video with that rating exists
     */
    Video suggestVideo(int rating);


}

