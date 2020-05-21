package com.afourtech.model;

/**
 * Enum to specify the various possible states in the life cycle of a listing PENDING - Listing just
 * entered into our Catalog LISTED - Listing successfully curated and discoverable UNLISTED - Listing
 * no longer by some part of our pipeline DELETED - Listing deleted from our Catalog
 */
public enum ListingState {
  PENDING,
  LISTED,
  UNLISTED,
  DELETED
}
