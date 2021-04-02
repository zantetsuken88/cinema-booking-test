package com.Softwire;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class RejectedBookingServiceTest {

    @Test
    public void canParseCSVBookingRequest() {
        String[] validBooking = { "2", "61:46", "61:47)" };
        int[] expectedStart = new int[]{61, 46};
        int[] expectedEnd = new int[]{61, 47};
        int[][] parsedBooking = RejectedBookingService.parseBookings(validBooking);
        assertEquals(parsedBooking[0][0], expectedStart[0]);
        assertEquals(parsedBooking[0][1], expectedStart[1]);
        assertEquals(parsedBooking[1][0], expectedEnd[0]);
        assertEquals(parsedBooking[1][1], expectedEnd[1]);
    }

    @Test
    public void sampleRequestYields10Rejections() throws URISyntaxException {
        File sample_requests = RejectedBookingService.getFile("resources/sample_booking_requests");
        int rejections = RejectedBookingService.processFile(sample_requests);
        assertEquals(rejections, 10);
    }
}
