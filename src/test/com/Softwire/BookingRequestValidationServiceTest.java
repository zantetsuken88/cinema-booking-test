package com.Softwire;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingRequestValidationServiceTest {
    private final BookingRequestValidationService underTest = new BookingRequestValidationService();

    @Test
    public void validBookingRequestPassesAllChecks() {
        int[] validStart = new int[] { 2, 0 };
        int[] validEnd = new int[] { 2, 4 };
        boolean[] validRow = new boolean[50];

        assertTrue(underTest.validateRow(validStart[0], validEnd[0]));
        assertTrue(underTest.validateSeats(validStart[1], validEnd[1]));
        assertTrue(underTest.validateSingleGaps(validRow, validStart[1], validEnd[1]));
        assertTrue(underTest.validateExistingBookings(validRow, validStart[1], validEnd[1]));
    }

    @Test
    public void rejectIfNotSameRow() {
        int[] start = new int[] { 2, 0 };
        int[] end = new int[] { 3, 4 };

        assertFalse(underTest.validateRow(start[0], end[0]));
    }

    @Test
    public void rejectIfBookingOver5Seats() {
        int[] start = new int[] { 2, 0 };
        int[] end = new int[] { 2, 5 };

        assertFalse(underTest.validateSeats(start[1], end[1]));
    }

    @Test
    public void rejectIfOutOfBounds() {
        int[] start = new int[] { 100, 46 };
        int[] end = new int[] { 100, 50 };

        assertFalse(underTest.validateSeats(start[1], end[1]));
        assertFalse(underTest.validateRow(start[0], end[0]));
    }

    @Test
    public void rejectIfSeatsTaken() {
        int[] validStart = new int[] { 2, 0 };
        int[] validEnd = new int[] { 2, 4 };
        boolean[] validRow = new boolean[50];
        validRow[3] = true;
        validRow[4] = true;

        assertFalse(underTest.validateExistingBookings(validRow, validStart[1], validEnd[1]));
    }

    @Test
    public void rejectIfSingleGap() {
        int[] validStart = new int[] { 2, 2 };
        int[] validEnd = new int[] { 2, 6 };
        boolean[] validRow = new boolean[50];
        validRow[0] = true;

        assertFalse(underTest.validateSingleGaps(validRow, validStart[1], validEnd[1]));
    }

}
